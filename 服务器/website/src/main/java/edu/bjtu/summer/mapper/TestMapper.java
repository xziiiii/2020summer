package edu.bjtu.summer.mapper;

import edu.bjtu.summer.model.User;
import edu.bjtu.summer.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

public class TestMapper {

    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtil.getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setNickname("123456");
        userMapper.updateUser(user);

        sqlSession.commit();
        sqlSession.close();
    }
}
