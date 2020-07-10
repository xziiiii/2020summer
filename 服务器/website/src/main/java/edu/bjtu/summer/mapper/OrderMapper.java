package edu.bjtu.summer.mapper;

import edu.bjtu.summer.model.Order;
import edu.bjtu.summer.model.OrderDetail;
import edu.bjtu.summer.model.OrderShipping;
import edu.bjtu.summer.model.User;
import org.apache.ibatis.annotations.Insert;
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
    User getUserByOrderId(@Param("order_id") String order_id);

    @Select("SELECT * FROM order_shipping WHERE order_id = #{order_id}")
    OrderShipping getShippingByOrderId(String order_id);

    @Select("SELECT * FROM orders WHERE user_id = #{user_id} LIMIT #{left}, #{right}")
    List<Order> getOrderListByUserIdWithLimit(@Param("user_id") int user_id,
                                              @Param("left") int left, @Param("right") int right);

    @Select("SELECT * FROM order_detail WHERE order_id = #{order_id}")
    List<OrderDetail> getOrderDetailListByOrderId(String order_id);

    @Select("SELECT MAX(order_id) FROM orders")
    long getMaxOrderId();

    @Insert("INSERT INTO orders (order_id, user_id, payment) " +
            "VALUES (#{order_id}, #{user_id}, #{payment})")
    void insertOrder(@Param("order_id") long order_id, @Param("user_id") int user_id, @Param("payment") double payment);

    @Insert("INSERT INTO order_detail " +
            "(order_id, book_id, store_id, mount, unit_price, total_price, image_url, book_name)" +
            "VALUES (#{order_id},#{book_id},#{store_id},#{mount},#{unit_price}," +
            "#{total_price},#{image_url},#{book_name})")
    void insertOrderDetail(OrderDetail orderDetail);

    @Insert("INSERT INTO order_shipping " +
            "(order_id, receiver_name, receiver_phone, receiver_mobile, receiver_state," +
            "receiver_city, receiver_district, receiver_address, receiver_zip) " +
            "VALUES (#{order_id}, #{receiver_name},#{receiver_phone},#{receiver_mobile}," +
            "#{receiver_state},#{receiver_city},#{receiver_district},#{receiver_address},#{receiver_zip})")
    boolean insertOrderShipping(OrderShipping orderShipping);
}
