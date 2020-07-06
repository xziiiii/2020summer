package edu.bjtu.summer.service;

import edu.bjtu.summer.mapper.RoleMapper;
import edu.bjtu.summer.model.Role;
import edu.bjtu.summer.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

public class RoleService {

    public Role getRoleByUserId(int user_id){
        SqlSession sqlSession = MybatisUtil.getSession();
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);

        return roleMapper.getRoleByUserId(user_id);
    }
}
