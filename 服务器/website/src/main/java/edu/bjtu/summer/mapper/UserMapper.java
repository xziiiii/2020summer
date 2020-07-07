package edu.bjtu.summer.mapper;

import edu.bjtu.summer.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Select("SELECT * FROM user WHERE user_id = #{user_id}")
    User getUserById(int user_id);

    @Select("SELECT * FROM user LIMIT #{left}, #{right}")
    List<User> getUserListWithLimit(@Param("left") int left, @Param("right") int right);

    @Select("SELECT MAX(user_id) FROM user")
    int getMaxUserId();

    @Insert("INSERT INTO user (user_id, username, nickname, password, gender, email, phone, " +
            "zip_code, location, age, country, detail_address, identity, code)" +
            "VALUES (#{user_id}, #{username}, #{nickname}, #{password}, #{gender}, #{email}, #{phone}," +
            "#{zip_code}, #{location}, #{age}, #{country}, #{detail_address}, #{identity}, #{code})")
    boolean insertUser(User user);

    @Update("UPDATE user SET nickname=#{nickname}, password=#{password}, gender=#{gender}," +
            "email=#{email}, phone=#{phone}, zip_code=#{zip_code}, location=#{location}," +
            "age=#{age}, country=#{country}, detail_address=#{detail_address}, identity=#{identity}," +
            "code=#{code} WHERE user_id=#{user_id}")
    boolean updateUser(User user);

    @Delete("DELETE FROM user WHERE user_id = #{user_id}")
    boolean deleteUser(int user_id);
}
