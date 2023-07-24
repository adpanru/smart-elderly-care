package com.kuang.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用返回结果，服务端响应的数据最终都会封装成此对象
 * @param <T>
 */
@Data
public class R<T> {

    private Integer code; //编码：1成功，0和其它数字为失败

    private String msg; //提示信息

    private T data; //数据

    private Map map = new HashMap(); //动态数据

    private boolean flag;//标记符

    public R() {
    }

    public R(Integer code, String msg, T data, Map map, boolean flag) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.map = map;
        this.flag = flag;
    }

    public static <T> R<T> success(T object) {
        R<T> r = new R<T>();
        r.data = object;
        r.code = 200;
        r.flag = true;
        return r;
    }
    public static <T> R<T> success(String msg) {
        R<T> r = new R<T>();
        r.code = 200;
        r.msg = msg;
        r.flag = true;
        return r;
    }

    public static <T> R<T> error(String msg) {
        R r = new R();
        r.msg = msg;
        r.code = 300;
        r.flag = false;
        return r;
    }


    public R<T> add(String key, Object value) {
        this.map.put(key, value);
        return this;
    }


}
