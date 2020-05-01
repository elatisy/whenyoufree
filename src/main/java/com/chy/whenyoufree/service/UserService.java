package com.chy.whenyoufree.service;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.chy.whenyoufree.common.Encrypt;
import com.chy.whenyoufree.entity.User;
import com.chy.whenyoufree.exception.BaseException;
import com.chy.whenyoufree.exception.general.ResourceExistException;
import com.chy.whenyoufree.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public boolean register(User user) throws BaseException {
        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("phone", user.getPhone());
        List<User> check = userMapper.selectByMap(columnMap);
        if(!check.isEmpty()) {
            throw new ResourceExistException("手机号");
        }

        user.setPassword(Encrypt.encrypt(user.getPassword()));
        userMapper.insert(user);
        return true;
    }
}
