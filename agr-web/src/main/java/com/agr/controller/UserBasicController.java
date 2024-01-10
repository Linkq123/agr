package com.agr.controller;

import com.agr.agrsecurity.entry.RestResponse;
import com.agr.agrsecurity.service.UserService;
import com.agr.agrsecurity.entry.query.UserLoginQuery;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author linkq
 * @create 2024/1/10
 */
@RestController
@RequestMapping("/api/userBasic/v1")
public class UserBasicController {


    @Resource
    private UserService userService;

    @PostMapping("login")
    public RestResponse<?> login(@RequestBody UserLoginQuery query){
        return RestResponse.success(userService.login(query));
    }




}
