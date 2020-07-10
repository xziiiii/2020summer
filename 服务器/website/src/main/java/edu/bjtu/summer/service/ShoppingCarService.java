package edu.bjtu.summer.service;

import edu.bjtu.summer.mapper.ShoppingCarMapper;
import edu.bjtu.summer.model.ShoppingCarDetail;
import edu.bjtu.summer.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

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
}
