package com.autogen.dao.entity.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Table512 {
    private int id;            //序号
    private String name;       // 密钥名称
    private String sf;   //算法
    private String yt;   //用途
    private String location;        //部署位置
}
