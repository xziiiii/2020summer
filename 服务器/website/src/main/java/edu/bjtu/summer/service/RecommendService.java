package edu.bjtu.summer.service;

import edu.bjtu.summer.mapper.BookMapper;
import edu.bjtu.summer.model.Book;
import edu.bjtu.summer.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class RecommendService {

    public List<Book> getRecommendBookList(int user_id){
        SqlSession sqlSession = MybatisUtil.getSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);

        return bookMapper.getBookListByStoreIdWithLimit(1, 10, 10);
    }
}
