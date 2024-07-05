package com.autogen.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: TableTest
 * Package: com.autogen.pojo
 * Description:
 *
 * @Author 周钰尧
 * @Create 2024/6/25 11:34
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableTest {
    private String index;   //序号
    private String yymc;    //应用名称
    private String lb;      //类别
    private String jtbhdx;  //具体保护对象
    private String aqxq;    //安全需求
}
