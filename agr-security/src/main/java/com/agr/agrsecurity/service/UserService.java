package com.agr.agrsecurity.service;

import com.agr.agrsecurity.entry.VO.SysUserVO;
import com.agr.agrsecurity.entry.VO.UserVO;
import com.agr.agrsecurity.entry.query.UserLoginQuery;

import java.util.List;

public interface UserService {

    List<UserVO> getUserVO();

    UserVO getUserOne();

    Object login(UserLoginQuery query);

    SysUserVO selectUserByUserName(String UserName);
}
