package com.autogen.dao.entity.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Yyhsj {
    public String yyhsj_ywmc;       //业务名称
    public List<String> yyhsj_sfjb;       //身份鉴别 （多选）
    public String yyhsj_fwkz;       //访问控制信息完整性
    public String yyhsj_xxzy;       //重要信息资源安全标记完整性
    public String yyhsj_csjmx;      //重要数据传输机密性
    public String yyhsj_ccjmx;      //重要数据存储机密性
    public String yyhsj_cswzx;      //重要数据传输完整性
    public String yyhsj_ccwzx;      //重要数据存储完整性
    public String yyhsj_bkfr;       //不可否认性
}
