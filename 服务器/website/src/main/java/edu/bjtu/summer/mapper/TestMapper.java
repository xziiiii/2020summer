package edu.bjtu.summer.mapper;

import edu.bjtu.summer.model.User;
import edu.bjtu.summer.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class TestMapper {

    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtil.getSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);

        List<Map<String, String>> map = bookMapper.getBookRankListByRatingWithLimit(1, 5);

        System.out.println("");
    }
}
