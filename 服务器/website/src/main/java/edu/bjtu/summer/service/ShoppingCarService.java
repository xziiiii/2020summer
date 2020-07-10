package edu.bjtu.summer.service;

import edu.bjtu.summer.mapper.BookMapper;
import edu.bjtu.summer.mapper.OrderMapper;
import edu.bjtu.summer.mapper.ShoppingCarMapper;
import edu.bjtu.summer.model.Book;
import edu.bjtu.summer.model.OrderDetail;
import edu.bjtu.summer.model.OrderShipping;
import edu.bjtu.summer.model.ShoppingCarDetail;
import edu.bjtu.summer.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ShoppingCarService {

    public List<ShoppingCarDetail> getUserCarInfo(int user_id){
        SqlSession sqlSession = MybatisUtil.getSession();
        ShoppingCarMapper mapper = sqlSession.getMapper(ShoppingCarMapper.class);

        return mapper.getCarDetailByUserId(user_id);
    }

    public boolean addBook(int user_id, long book_id, int amount, double unit_price){
        SqlSession sqlSession = MybatisUtil.getSession();
        ShoppingCarMapper mapper = sqlSession.getMapper(ShoppingCarMapper.class);

        ShoppingCarDetail carDetail = mapper.getCarDetailByUserIdAndBookId(user_id, book_id);
        boolean result;
        if (carDetail == null){
            result = mapper.insertCarDetail(user_id, book_id, amount, unit_price);
        }else{
            result = mapper.updateCarDetail(user_id, book_id, amount, unit_price);
        }

        sqlSession.commit();
        sqlSession.close();

        return result;
    }

    public boolean deleteBook(int user_id, long book_id){
        SqlSession sqlSession = MybatisUtil.getSession();
        ShoppingCarMapper carMapper = sqlSession.getMapper(ShoppingCarMapper.class);

        boolean result = carMapper.deleteCarDetailByUIdAndBId(user_id, book_id);
        sqlSession.commit();
        sqlSession.close();

        return result;
    }

    public boolean clearCar(int user_id){
        SqlSession sqlSession = MybatisUtil.getSession();
        ShoppingCarMapper carMapper = sqlSession.getMapper(ShoppingCarMapper.class);

        boolean result = carMapper.deleteCarDetailByUId(user_id);
        sqlSession.commit();
        sqlSession.close();

        return result;
    }

    public Map<String, Object> toOrder(int user_id){
        SqlSession sqlSession = MybatisUtil.getSession();
        ShoppingCarMapper carMapper = sqlSession.getMapper(ShoppingCarMapper.class);
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);

        List<ShoppingCarDetail> carDetailList = carMapper.getCarDetailByUserId(user_id);
        long order_id = orderMapper.getMaxOrderId() + 1;

        // 计算总价
        double total_price = 0;
        for (ShoppingCarDetail carDetail: carDetailList){
            OrderDetail orderDetail = new OrderDetail();

            Book book = bookMapper.getBookByBookId(carDetail.getBook_id());

            orderDetail.setOrder_id(String.valueOf(order_id));
            orderDetail.setBook_id(book.getBook_id());
            orderDetail.setStore_id(book.getStore_id());
            orderDetail.setBook_name(book.getName());
            orderDetail.setMount(carDetail.getAmount());
            orderDetail.setUnit_price(carDetail.getUnit_price());
            double temp_total = carDetail.getUnit_price() * carDetail.getAmount();
            orderDetail.setTotal_price(temp_total);
            orderDetail.setImage_url(book.getImage_url());

            total_price += temp_total;

            orderMapper.insertOrderDetail(orderDetail);
        }

        orderMapper.insertOrder(order_id, user_id, total_price);
        carMapper.deleteCarDetailByUId(user_id);

        sqlSession.commit();
        sqlSession.close();

        Map<String, Object> map = new HashMap<>();
        map.put("total_price", total_price);
        map.put("order_id", order_id);

        return map;
    }

    public boolean setOrderShipping(OrderShipping orderShipping){
        SqlSession sqlSession = MybatisUtil.getSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

        boolean result = orderMapper.insertOrderShipping(orderShipping);
        sqlSession.commit();
        sqlSession.close();

        return result;
    }
}
