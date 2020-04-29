package com.chy.whenyoufree.common;

public class Response {
    private int code;
    private Object data;

    public Response(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public Response() {}

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
