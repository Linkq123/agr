package com.agr.agrsecurity.service.impl;

import com.agr.agrsecurity.component.AuthenticationContextHolder;
import com.agr.agrsecurity.entry.LoginUser;
import com.agr.agrsecurity.entry.VO.SysUserVO;
import com.agr.agrsecurity.entry.VO.UserVO;
import com.agr.agrsecurity.entry.query.UserLoginQuery;
import com.agr.agrsecurity.mapper.UserMapper;
import com.agr.agrsecurity.service.TokenService;
import com.agr.agrsecurity.service.UserService;
import com.agr.agrsecurity.util.DateUtils;
import com.agr.agrsecurity.util.IpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author linkq
 * @create 2024/1/10
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;


    @Autowired
    private TokenService tokenService;

    @Resource
    private AuthenticationManager authenticationManager;

    @Override
    public List<UserVO> getUserVO() {
//        return userMapper.getUserVO();
        return null;
    }

    @Override
    public UserVO getUserOne() {
        return null;
    }


    @Override
    public Object login(UserLoginQuery query) {
        String userName = query.getUserName();
        String passWord = query.getPassWord();

        // 用户验证
        Authentication authentication = null;
        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userName, passWord);
            AuthenticationContextHolder.setContext(authenticationToken);
            // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
            authentication = authenticationManager.authenticate(authenticationToken);
        }catch (Exception e){

        }finally {
            AuthenticationContextHolder.clearContext();
        }

        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        recordLoginInfo(loginUser.getUserId());

        return tokenService.createToken(loginUser);
    }



    @Override
    public SysUserVO selectUserByUserName(String UserName) {
        return userMapper.selectUserByUserName(UserName);
    }


    /**
     * 记录登录信息
     *
     * @param userId 用户ID
     */
    public void recordLoginInfo(Long userId)
    {
        SysUserVO sysUser = new SysUserVO();
        sysUser.setUserId(userId);
        sysUser.setLoginIp(IpUtils.getIpAddr());
        sysUser.setLoginDate(DateUtils.getNowDate());
        //userService.updateUserProfile(sysUser);
    }
}
