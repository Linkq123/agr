package com.agr.agrsecurity.entry;

import com.agr.agrsecurity.entry.VO.UserVO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;

/**
 * @author linkq
 * @create 2024/1/10
 */
public class LoginUser implements UserDetails {


    private UserVO userVO;

    private String ip;

    private LocalDateTime time;

    private String passWord;

    public LoginUser(UserVO userVO, String ip, LocalDateTime time, String passWord) {
        this.userVO = userVO;
        this.ip = ip;
        this.time = time;
        this.passWord = passWord;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

}
