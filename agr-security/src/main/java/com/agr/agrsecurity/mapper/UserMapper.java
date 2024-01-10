package com.agr.agrsecurity.mapper;

import com.agr.agrsecurity.entry.VO.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    List<UserVO> getUserVO();

    UserVO getUserVOByLogin(@Param("userName") String userName,@Param("passWord") String passWord);
}
