package edu.bjtu.summer.mapper;

import edu.bjtu.summer.model.User;
import edu.bjtu.summer.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class TestMapper {

    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtil.getSession();
        ShoppingCarMapper carMapper = sqlSession.getMapper(ShoppingCarMapper.class);

        carMapper.deleteCarDetailByBookId(100);
        sqlSession.commit();
        sqlSession.close();

        System.out.println("");
    }
}
