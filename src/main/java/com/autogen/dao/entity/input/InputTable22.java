package com.autogen.dao.entity.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InputTable22 {
    private String ywyy;        //业务应用（系统名）
    private String yh;          //用户
    private List<String> dlfs;  //登录方式
    private List<String> sfrz;  //身份认证方式
    private List<String> szwl;  //所在网络
    private String sl;          //数量
}
