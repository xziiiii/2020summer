package edu.bjtu.summer.mapper;

import edu.bjtu.summer.model.ShoppingCarDetail;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface ShoppingCarMapper {

    @Select("SELECT * FROM shopping_car_detail WHERE user_id = #{user_id}")
    List<ShoppingCarDetail> getCarDetailByUserId(int user_id);

    @Select("SELECT b.book_id, b.name, b.image_url, s.amount, s.unit_price " +
            "FROM shopping_car_detail s, book_info b " +
            "WHERE b.book_id = s.book_id AND s.user_id = #{user_id}")
    List<Map<String, String>> getCarDetailAndBookInfoByUserId(int user_id);

    @Select("SELECT * FROM shopping_car_detail WHERE user_id = #{user_id} AND book_id = #{book_id}")
    ShoppingCarDetail getCarDetailByUserIdAndBookId(@Param("user_id") int user_id, @Param("book_id") long book_id);

    @Insert("INSERT INTO shopping_car_detail (user_id, book_id, amount, unit_price) " +
            "VALUES (#{user_id}, #{book_id}, #{amount}, #{unit_price})")
    boolean insertCarDetail(@Param("user_id") int user_id, @Param("book_id") long book_id,
                            @Param("amount") int amount, @Param("unit_price") double unit_price);

    @Update("UPDATE shopping_car_detail SET amount = #{amount}, unit_price = #{unit_price} " +
            "WHERE user_id = #{user_id} AND book_id = #{book_id}")
    boolean updateCarDetail(@Param("user_id") int user_id, @Param("book_id") long book_id,
                            @Param("amount") int amount, @Param("unit_price") double unit_price);

    @Delete("DELETE FROM shopping_car_detail WHERE user_id = #{user_id} AND book_id = #{book_id}")
    boolean deleteCarDetailByUIdAndBId(@Param("user_id") int user_id, @Param("book_id") long book_id);

    @Delete("DELETE FROM shopping_car_detail WHERE user_id = #{user_id}")
    boolean deleteCarDetailByUId(@Param("user_id") int user_id);

}
