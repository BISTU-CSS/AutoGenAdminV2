package com.autogen.dao.entity.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    public int id;
    private String name;
    private String jbxh;
    private String lb;
    private String num;
    private String remark;

}
