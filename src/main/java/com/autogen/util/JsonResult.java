package com.autogen.util;

import lombok.Data;

@Data
public class JsonResult {
    private Object data;        //任意类型数据
    private String retcode;     //错误消息

    public JsonResult(Object data, String retcode) {
        this.data = data;
        this.retcode = retcode;
    }
}
