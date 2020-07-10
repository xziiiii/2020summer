package edu.bjtu.summer.mapper;

import edu.bjtu.summer.model.Order;
import edu.bjtu.summer.model.OrderDetail;
import edu.bjtu.summer.model.OrderShipping;
import edu.bjtu.summer.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {

    @Select("SELECT * FROM order_detail WHERE store_id = #{store_id} LIMIT #{left}, #{right}")
    List<OrderDetail> getOrderDetailByStoreIdWithLimit(@Param("store_id") int store_id,
                                                       @Param("left") int left,
                                                       @Param("right") int right);

    @Select("SELECT u.username, u.nickname, u.gender FROM user u, orders o " +
            "WHERE u.user_id = o.user_id AND o.order_id = #{order_id}")
    User getUserByOrderId(String order_id);

    @Select("SELECT * FROM order_shipping WHERE order_id = #{order_id}")
    OrderShipping getShippingByOrderId(String order_id);

    @Select("SELECT * FROM orders WHERE user_id = #{user_id} LIMIT #{left}, #{right}")
    List<Order> getOrderListByUserIdWithLimit(@Param("user_id") int user_id,
                                              @Param("left") int left, @Param("right") int right);

    @Select("SELECT * FROM order_detail WHERE order_id = #{order_id}")
    List<OrderDetail> getOrderDetailListByOrderId(String order_id);
}
