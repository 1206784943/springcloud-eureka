package com.eureka.security.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.eureka.security.domain.SysUser;
import com.eureka.security.mapper.UserMapper;
import com.eureka.security.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        log.info("password:{}", passwordEncoder.encode(s));
        boolean matches = this.passwordEncoder.matches("123456", passwordEncoder.encode(s));
        log.info("matches:{}", matches);
        SysUser sysUser = userMapper.findByName(s);
        log.info("sysUser:{}", JSONObject.toJSONString(sysUser));
        return sysUser;
    }
}
