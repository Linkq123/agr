package com.agr.agrsecurity.service.impl;

import com.agr.agrsecurity.entry.VO.SysUserVO;
import com.agr.agrsecurity.entry.VO.UserVO;
import com.agr.agrsecurity.entry.query.UserLoginQuery;
import com.agr.agrsecurity.mapper.UserMapper;
import com.agr.agrsecurity.service.UserService;
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
    public UserVO login(UserLoginQuery query) {
        return userMapper.getUserVOByLogin(query.getUserName(),query.getPassWord());
    }



    @Override
    public SysUserVO selectUserByUserName(String UserName) {
        return userMapper.selectUserByUserName(UserName);
    }
}
