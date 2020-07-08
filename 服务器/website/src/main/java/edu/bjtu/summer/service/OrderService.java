package edu.bjtu.summer.service;

import edu.bjtu.summer.mapper.OrderMapper;
import edu.bjtu.summer.model.OrderDetail;
import edu.bjtu.summer.model.OrderShipping;
import edu.bjtu.summer.model.User;
import edu.bjtu.summer.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class OrderService {

    public List<OrderDetail> getStoreOrderListWithLimit(int store_id, int left, int right){
        SqlSession sqlSession = MybatisUtil.getSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

        return orderMapper.getOrderDetailByStoreIdWithLimit(store_id, left, right);
    }

    public User getOrderUser(String order_id){
        SqlSession sqlSession = MybatisUtil.getSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

        return orderMapper.getUserByOrderId(order_id);
    }

    public OrderShipping getOrderShipping(String order_id){
        SqlSession sqlSession = MybatisUtil.getSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

        return orderMapper.getShippingByOrderId(order_id);
    }
}
