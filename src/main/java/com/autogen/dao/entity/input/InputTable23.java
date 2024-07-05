package com.autogen.dao.entity.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InputTable23 {
    private String jfmc;                //机房名称
    //*********新增********
    private String jfdz;                //机房地址
    private String jfzrztdw;            //机房责任主体单位





    private String jflx;                //机房类型
    private String mj;                  //门禁
    private List<String> sfrz;          //身份认证
    private String spjk;                //视频监控
    private String zjsb;                //是否允许增加设备


}
