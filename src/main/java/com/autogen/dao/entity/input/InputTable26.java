package com.autogen.dao.entity.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InputTable26 {
    //设备和计算（专用设备）
    private String type;
    private String sbmc;
    private String ppxh;
    private String sl;
    private String gmsf;
    private String smzs;
    private String ycyw;
    private List<String> sfrz;
    private String blj;

}
