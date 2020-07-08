package edu.bjtu.summer.service;

import edu.bjtu.summer.mapper.BookMapper;
import edu.bjtu.summer.model.Book;
import edu.bjtu.summer.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BookService {

    public List<Book> getStoreBookList(int store_id, int left, int right){
        SqlSession sqlSession = MybatisUtil.getSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);

        return bookMapper.getBookListByStoreIdWithLimit(store_id, left, right);
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
}
