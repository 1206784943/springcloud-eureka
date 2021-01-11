package com.eureka.security.mapper;

import com.eureka.security.domain.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RoleMapper {

    @Select("select * from sys_role where role_name = #{roleName}")
    public SysRole findByName(String roleName);
}
