package edu.bjtu.summer.service;

import edu.bjtu.summer.mapper.UserMapper;
import edu.bjtu.summer.model.User;
import edu.bjtu.summer.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserService {

    public boolean judgeLogin(int user_id, String password){
        SqlSession sqlSession = MybatisUtil.getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.getUserById(user_id);
        return password.equals(user.getPassword());
    }

    public List<User> getUserListWithLimit(int left, int right){
        SqlSession sqlSession = MybatisUtil.getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        return userMapper.getUserListWithLimit(left, right);
    }

    public boolean updateUser(User user){
        SqlSession sqlSession = MybatisUtil.getSession();
        UserMapper  userMapper = sqlSession.getMapper(UserMapper.class);

        boolean result = userMapper.updateUser(user);
        sqlSession.commit();
        sqlSession.close();

        return result;
    }
}
