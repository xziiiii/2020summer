package edu.bjtu.summer.mapper;

import edu.bjtu.summer.model.Role;
import org.apache.ibatis.annotations.Select;

public interface RoleMapper {

    @Select("SELECT r.role_id, r.name, r.code, r.description FROM role r, user_role u " +
            "WHERE r.role_id = u.role_id AND u.user_id = #{user_id}")
    Role getRoleByUserId(int user_id);
}
