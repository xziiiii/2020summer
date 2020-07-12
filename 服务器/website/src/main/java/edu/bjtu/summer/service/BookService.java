package edu.bjtu.summer.service;

import edu.bjtu.summer.mapper.BookMapper;
import edu.bjtu.summer.model.Book;
import edu.bjtu.summer.model.BookCategory;
import edu.bjtu.summer.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class BookService {

    public List<Book> getStoreBookList(int store_id, int left, int right){
        SqlSession sqlSession = MybatisUtil.getSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);

        return bookMapper.getBookListByStoreIdWithLimit(store_id, left, right - left + 1);
    }

    public long addBook(Book book){
        SqlSession sqlSession = MybatisUtil.getSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);

        long book_id = bookMapper.getMaxBookId() + 1;
        book.setBook_id(book_id);

        boolean result = bookMapper.insertBook(book);
        sqlSession.commit();
        sqlSession.close();

        if (result){
            return book_id;
        }else{
            return -1;
        }
    }

    public boolean deleteBook(long book_id){
        SqlSession sqlSession = MybatisUtil.getSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);

        return bookMapper.deleteBook(book_id);
    }

    public List<BookCategory> getBookCategoryList(){
        SqlSession sqlSession = MybatisUtil.getSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);

        return bookMapper.getBookCategoryList();
    }

    public List<Book> getCategoryBookListWithLimit(int cate_id, int left, int right){
        SqlSession sqlSession = MybatisUtil.getSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);

        return bookMapper.getBookListByCategoryIdWithLimit(cate_id, left, right - left + 1);
    }

    public List<Book> getBookListByKeywordWithLimit(String keyword, int left, int right){
        SqlSession sqlSession = MybatisUtil.getSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);

        return bookMapper.getBookListByKeywordWithLimit(keyword, left, right - left + 1);
    }

    public Map<String, String> getBookAverageRating(long book_id){
        SqlSession sqlSession = MybatisUtil.getSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);

        Map<String, String> map = bookMapper.getBookAverageRating(book_id);
        if (!map.containsKey("rating")){
            map.put("rating", "null");
        }

        return map;
    }

    public List<Map<String, String>> getBookRankListByRatingWithLimit(int left, int right){
        SqlSession sqlSession = MybatisUtil.getSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);

        return bookMapper.getBookRankListByRatingWithLimit(left, right - left + 1);
    }

    public Book getBookByBookId(long book_id){
        SqlSession sqlSession = MybatisUtil.getSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);

        return bookMapper.getBookByBookId(book_id);
    }
}
