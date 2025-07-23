package com.yy.pojo;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*********************************************************
 ** security所需要的用户实体
 ** <br><br>
 ** @ClassName: CustomUser
 ** @author: yangfeng
 ** @date: 2025/7/23 15:20
 ** @version: 1.0.0
 *********************************************************/
@Data
public class CustomUser extends User implements UserDetails {
    private List<String> roles;

    private List<String> permissions;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.addAll(roles.stream().map(role -> new SimpleGrantedAuthority("ROLE_"+role)).collect(Collectors.toSet()));
        authorities.addAll(permissions.stream().map(permission -> new SimpleGrantedAuthority(permission)).collect(Collectors.toSet()));
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public CustomUser() {
    }

    public CustomUser(String username,String password,List<String> permissions, List<String> roles) {
        this.setUsername(username);
        this.setPassword(password);
        this.permissions = permissions;
        this.roles = roles;
    }
}
