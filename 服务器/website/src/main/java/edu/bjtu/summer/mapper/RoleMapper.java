package edu.bjtu.summer.mapper;

import edu.bjtu.summer.model.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RoleMapper {

    @Select("SELECT r.role_id, r.name, r.code, r.description FROM role r, user_role u " +
            "WHERE r.role_id = u.role_id AND u.user_id = #{user_id}")
    Role getRoleByUserId(int user_id);

    @Select("SELECT * FROM role")
    List<Role> getAllRole();

    @Select("SELECT MAX(role_id) FROM role")
    int getMaxRoleId();

    @Insert("INSERT INTO role (role_id, name, code, description)" +
            "VALUES (#{role_id}, #{name}, #{code}, #{description})")
    boolean insertRole(Role role);

    @Insert("INSERT INTO user_role (user_id, role_id) VALUES (#{user_id}, #{role_id})")
    boolean setUserRole(@Param("user_id") int user_id, @Param("role_id") int role_id);

    @Update("UPDATE user_role SET role_id = #{role_id} WHERE user_id = #{user_id}")
    boolean updateUserRole(@Param("user_id") int user_id, @Param("role_id") int role_id);

    @Update("UPDATE role SET name=#{name}, code=#{code}, description=#{description} " +
            "WHERE role_id = #{role_id}")
    boolean updateRole(Role role);

    @Delete("DELETE FROM role WHERE role_id = #{role_id}")
    boolean deleteRole(int role_id);
}
