package com.chy.whenyoufree.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UserRegisterRequest {

    @NotBlank
    private String nick;

    @NotBlank
    private String password;

    private String realName;
}
