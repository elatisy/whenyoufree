package com.chy.whenyoufree.controller;


import com.chy.whenyoufree.common.Response;
import com.chy.whenyoufree.dto.request.UserRegisterRequest;
import com.chy.whenyoufree.entity.User;
import com.chy.whenyoufree.exception.BaseException;
import com.chy.whenyoufree.exception.general.FormValidateException;
import com.chy.whenyoufree.mapper.UserMapper;
import com.chy.whenyoufree.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;

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
    ) throws BaseException {
        if(bindingResult.hasErrors()) {
            throw new FormValidateException(bindingResult);
        }

        User user = new User();
        user.setNick(userRegisterRequest.getNick());
        user.setPassword(userRegisterRequest.getPassword());

        UserService userService = new UserService();
        userService.register(user);
        return new Response(0, user.getId());
    }
}
