package edu.bjtu.summer.mapper;

import edu.bjtu.summer.model.Store;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StoreMapper {

    @Select("SELECT * FROM store LIMIT #{left}, #{right}")
    List<Store> getStoreListWithLimit(@Param("left") int left, @Param("right") int right);

    @Select("SELECT MAX(store_id) FROM store")
    int getMaxStoreId();

    @Insert("INSERT INTO store " +
            "(store_id, store_manager_id, store_phone_num, " +
            "store_telephone, store_name, store_position) " +
            "VALUES" +
            "(#{store_id}, #{store_manager_id}, #{store_phone_num}, " +
            "#{store_telephone}, #{store_name}, #{store_position})")
    boolean insertStore(Store store);

    @Update("UPDATE store SET " +
            "store_manager_id=#{store_manager_id}, store_phone_num=#{store_phone_num}," +
            "store_telephone=#{store_telephone}, store_name=#{store_name}, store_position=#{store_position} " +
            "WHERE store_id = #{store_id}")
    boolean updateStore(Store store);

    @Delete("DELETE FROM store WHERE store_id = #{store_id}")
    boolean deleteStore(int store_id);
}
