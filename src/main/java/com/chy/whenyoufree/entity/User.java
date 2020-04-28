package com.chy.whenyoufree.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User implements Model {

    private Long id;

    // 用户名
    private String nick;

    // 真实姓名
    private String realName;

    private String phone;

    private String email;

    private String avatarUrl;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
