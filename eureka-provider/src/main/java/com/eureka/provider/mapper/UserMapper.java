package com.eureka.provider.mapper;

import com.eureka.provider.domain.SysUser;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Select("select * from sys_user where user_name = #{sysName}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "sysRoleList", column = "id", javaType = List.class, 
                    many = @Many(select = "com.eureka.provider.mapper.RoleMapper.findByName"))
    })
    public SysUser findByName(String sysName);
}
