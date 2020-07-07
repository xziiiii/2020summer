package edu.bjtu.summer.service;

import edu.bjtu.summer.mapper.RoleMapper;
import edu.bjtu.summer.model.Role;
import edu.bjtu.summer.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class RoleService {

    public Role getRoleByUserId(int user_id){
        SqlSession sqlSession = MybatisUtil.getSession();
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);

        return roleMapper.getRoleByUserId(user_id);
    }

    public List<Role> getAllRole(){
        SqlSession sqlSession = MybatisUtil.getSession();
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);

        return roleMapper.getAllRole();
    }

    public int addRole(Role role){
        SqlSession sqlSession = MybatisUtil.getSession();
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);

        int role_id = roleMapper.getMaxRoleId() + 1;
        role.setRole_id(role_id);

        boolean result = roleMapper.insertRole(role);
        sqlSession.commit();
        sqlSession.close();

        if (result){
            return role_id;
        }else{
            return -1;
        }
    }

    public boolean updateRole(Role role){
        SqlSession sqlSession = MybatisUtil.getSession();
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);

        boolean result = roleMapper.updateRole(role);
        sqlSession.commit();
        sqlSession.close();

        return result;
    }

    public boolean deleteRole(int role_id){
        SqlSession sqlSession = MybatisUtil.getSession();
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);

        boolean result = roleMapper.deleteRole(role_id);
        sqlSession.commit();
        sqlSession.close();

        return result;
    }
}
