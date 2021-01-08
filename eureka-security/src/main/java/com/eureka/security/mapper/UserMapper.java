package com.eureka.security.mapper;

import com.eureka.security.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from sys_user where user_name = #{sysName}")
    public SysUser findByName(String sysName);
}
