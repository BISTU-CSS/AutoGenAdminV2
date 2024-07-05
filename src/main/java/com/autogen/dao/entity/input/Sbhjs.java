package com.autogen.dao.entity.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sbhjs {
    public String sbhjs_sbmc;       //设备名称
    public String sbhjs_sfjb;       //身份鉴别
    public String sbhjs_ycgl;       //远程管理通道安全
    public String sbhjs_xtzy;       //系统资源访问控制信息完整性
    public String sbhjs_zyxx;       //重要信息资源安全标记完整性
    public String sbhjs_rzjl;       //日志记录完整性
    public String sbhjs_zykz;       //重要可执行程序完整性、重要可执行程序来源真实性
}
