package edu.bjtu.summer.mapper;

import edu.bjtu.summer.model.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface BookMapper {

    @Select("SELECT MAX(book_id) FROM book_info")
    long getMaxBookId();

    @Insert("INSERT INTO book_info" +
            "(book_id, book_category_id, store_id, name, outline, detail, press, publish_date, size, version," +
            "author, translator, isbn, price, pages, catalog, market_price, member_price, deal_mount, look_mount," +
            "discount, image_url, store_mount, store_time, pack_style, is_shelf, cname, description, cata, content) " +
            "VALUES " +
            "(#{book_id},#{book_category_id},#{store_id},#{name},#{outline},#{detail},#{press},#{publish_date}," +
            "#{size},#{version},#{author},#{translator},#{isbn},#{price},#{pages},#{catalog},#{market_price}," +
            "#{member_price},#{deal_mount},#{look_mount},#{discount},#{image_url},#{store_mount},#{store_time}," +
            "#{pack_style},#{is_shelf},#{cname},#{description},#{cata},#{content})")
    boolean insertBook(Book book);
}
