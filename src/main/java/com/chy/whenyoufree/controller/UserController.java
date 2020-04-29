package com.chy.whenyoufree.controller;


import com.chy.whenyoufree.common.Response;
import com.chy.whenyoufree.dto.request.UserRegisterRequest;
import com.chy.whenyoufree.entity.User;
import com.chy.whenyoufree.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @PostMapping("register")
    public Response register(
            @RequestBody @Valid
            UserRegisterRequest userRegisterRequest,

            BindingResult bindingResult
    ) {
        User user = new User();
        user.setNick(userRegisterRequest.getNick());
        user.setPassword(userRegisterRequest.getPassword());

//        TODO:完成注册逻辑
        return new Response(0, user.getId());
    }
}
