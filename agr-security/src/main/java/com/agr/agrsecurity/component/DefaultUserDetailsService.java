package com.agr.agrsecurity.component;

import com.agr.agrsecurity.entry.LoginUser;
import com.agr.agrsecurity.entry.VO.SysUserVO;
import com.agr.agrsecurity.entry.euns.UserStatus;
import com.agr.agrsecurity.service.SysPermissionService;
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


    @Autowired
    private SysPermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("-----------");
        SysUserVO sysUserVO = userService.selectUserByUserName(username);
        if (sysUserVO == null) {
            log.info("登录用户：{} 不存在", username);
            throw new UsernameNotFoundException("登录用户：" + username + " 不存在");
        }else if (sysUserVO != null && sysUserVO.getStatus().equals(UserStatus.DISABLE.getCode())){
            log.info("登录用户：{} 不存在", username);
            throw new UsernameNotFoundException("登录用户：" + username + " 已经停用");
        }

        return createLoginUser(sysUserVO);
    }

    public UserDetails createLoginUser(SysUserVO user)
    {
        return new LoginUser(user.getUserId(), user.getDeptId(), user, permissionService.getMenuPermission(user));
    }
}
