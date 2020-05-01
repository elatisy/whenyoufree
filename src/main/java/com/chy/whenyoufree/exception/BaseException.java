package com.chy.whenyoufree.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class BaseException extends Exception {
    private int code;
    private String message;
}
