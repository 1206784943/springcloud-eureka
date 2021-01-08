package com.eureka.provider.mapper;

import com.eureka.provider.domain.SysRole;
import org.apache.ibatis.annotations.Select;

public interface RoleMapper {

    @Select("select * from sys_role where role_name = #{roleName}")
    public SysRole findByName(String roleName);
}
