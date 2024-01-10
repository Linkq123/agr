package com.agr.agrsecurity.component;

import com.agr.agrsecurity.entry.LoginUser;
import com.agr.agrsecurity.service.UserService;
import com.agr.agrsecurity.entry.VO.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author linkq
 * @create 2024/1/10
 */
@Slf4j
@Component
public class DefaultUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username == null || username.isEmpty()) {
            log.info("登录用户：{} 不存在", username);
            throw new UsernameNotFoundException("登录用户：" + username + " 不存在");
        }

        // 查出密码
        UserVO userVO = userService.getUserOne();
        if (userVO == null) {
            log.info("登录用户：{} 不存在", username);
            throw new UsernameNotFoundException("登录用户：" + username + " 不存在");
        }
        return new LoginUser(userVO, "ip", LocalDateTime.now(), "password");
    }
}
