package com.chy.whenyoufree.exception.general;

import com.chy.whenyoufree.exception.BaseException;
import org.springframework.validation.BindingResult;

public class FormValidateException extends BaseException {
    public FormValidateException(BindingResult bindingResult) {
        setCode(10002);
        setMessage(
                "表单验证错误: "
                        + bindingResult.getFieldError().getField()
                        + bindingResult.getFieldError().getDefaultMessage()
        );
    }

    public FormValidateException(String message) {
        setCode(10002);
        setMessage(message);
    }
}
