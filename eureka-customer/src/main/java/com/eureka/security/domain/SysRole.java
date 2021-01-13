package com.eureka.security.domain;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

@Data
public class SysRole implements GrantedAuthority {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String roleName;
    private String roleDesc;

    @Override
    public String getAuthority() {
        return roleName;
    }
}
