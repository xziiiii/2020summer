package edu.bjtu.summer.mapper;

import edu.bjtu.summer.model.Book;
import edu.bjtu.summer.model.BookCategory;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BookMapper {

    @Select("SELECT * FROM book_info WHERE store_id=#{store_id} LIMIT #{left}, #{right}")
    List<Book> getBookListByStoreIdWithLimit(@Param("store_id") int store_id,
                                             @Param("left") int left, @Param("right") int right);

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

    @Delete("DELETE FROM book_info WHERE book_id = #{book_id}")
    boolean deleteBook(long book_id);

    @Select("SELECT * FROM book_category")
    List<BookCategory> getBookCategoryList();

    @Select("SELECT * FROM book_info WHERE book_category_id=#{cate_id} " +
            "LIMIT #{left}, #{right}")
    List<Book> getBookListByCategoryIdWithLimit(@Param("cate_id") int cate_id,
                                                @Param("left") int left, @Param("right") int right);
}
