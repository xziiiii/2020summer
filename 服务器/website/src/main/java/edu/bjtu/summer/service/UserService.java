package edu.bjtu.summer.service;

import edu.bjtu.summer.mapper.UserMapper;
import edu.bjtu.summer.model.User;
import edu.bjtu.summer.util.JsonTemplate;
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

    public int addUser(User user){

        SqlSession sqlSession = MybatisUtil.getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        int user_id = userMapper.getMaxUserId() + 1;
        user.setUser_id(user_id);

        boolean result = userMapper.insertUser(user);
        sqlSession.commit();
        sqlSession.close();

        if (result){
            return user_id;
        }else {
            return -1;
        }
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

    public boolean deleteUser(int user_id){
        SqlSession sqlSession = MybatisUtil.getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        boolean result = userMapper.deleteUser(user_id);
        sqlSession.commit();
        sqlSession.close();

        return result;
    }
}
