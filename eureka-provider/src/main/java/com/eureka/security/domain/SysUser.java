package com.eureka.security.domain;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
public class SysUser implements UserDetails {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String username;
    private String password;
    private Integer status;
    private List<SysRole> sysRoleList;

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return sysRoleList;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }
}
