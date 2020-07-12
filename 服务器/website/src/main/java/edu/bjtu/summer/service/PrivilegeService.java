package edu.bjtu.summer.service;

import edu.bjtu.summer.mapper.PrivilegeMapper;
import edu.bjtu.summer.model.Privilege;
import edu.bjtu.summer.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class PrivilegeService {

    public List<Privilege> getPrivilegeListWithLimit(int left, int right){
        SqlSession sqlSession = MybatisUtil.getSession();
        PrivilegeMapper mapper = sqlSession.getMapper(PrivilegeMapper.class);

        return mapper.getPrivilegeListWithLimit(left, right - left + 1);
    }

    public List<Privilege> getRolePrivilege(int role_id){
        SqlSession sqlSession = MybatisUtil.getSession();
        PrivilegeMapper mapper = sqlSession.getMapper(PrivilegeMapper.class);

        return mapper.getRolePrivilege(role_id);
    }
}
