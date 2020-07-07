package edu.bjtu.summer.service;

import edu.bjtu.summer.mapper.BookMapper;
import edu.bjtu.summer.model.Book;
import edu.bjtu.summer.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

public class BookService {

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
}
