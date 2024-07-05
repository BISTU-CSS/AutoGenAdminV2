package com.autogen.dao.entity.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Table513 {
    private int id;            //序号
    private String name;       // 密钥名称
    private String production;   //生产
    private String storage;   //存储
    private String ff;        //分发
    private String drhdc;        //导入和导出
    private String use;        //使用
    private String bfhhf;        //备份和恢复
    private String gd;        //归档
    private String xh;        //销毁
}
