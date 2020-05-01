package com.chy.whenyoufree.exception.general;

import com.chy.whenyoufree.exception.BaseException;

public class ResourceExistException extends BaseException {
    public ResourceExistException(String resource) {
        setCode(10001);
        setMessage(resource + "已存在");
    }
}
