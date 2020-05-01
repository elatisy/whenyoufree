package com.chy.whenyoufree.exception;

public class UnknownException extends BaseException {
    public UnknownException(String message) {
        setCode(5000);
        setMessage(message);
    }
}
