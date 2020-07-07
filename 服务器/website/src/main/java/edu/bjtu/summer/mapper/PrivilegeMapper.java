package edu.bjtu.summer.mapper;

import edu.bjtu.summer.model.Privilege;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PrivilegeMapper {

    @Select("SELECT * FROM privilege LIMIT #{left}, #{right}")
    List<Privilege> getPrivilegeListWithLimit(@Param("left") int left, @Param("right") int right);

    @Select("SELECT p.priv_id, p.name, p.code, p.url, p.parent_id, p.created, p.updated, p.is_parent" +
            " FROM privilege p, role_privilege r " +
            "WHERE p.priv_id = r.privilege_id AND r.role_id = #{role_id}")
    List<Privilege> getRolePrivilege(int role_id);
}
