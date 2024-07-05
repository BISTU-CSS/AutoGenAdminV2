package com.autogen.dao.entity.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Concent {

    //基础情况
    private String sys_sshy;                         //所属行业
    private String sys_xmlx;                         //系统类型（技术框架）
    //基础情况
    private String sys_name;                         //系统名称
    private String sys_unit;                         //责任单位
    private String sys_dbjb;                         //等保级别
    private String sys_mmzcpt;                         //密码支撑平台

    private String sys_xtjs;                         //系统建设
    private String sys_xtjg;                         //系统架构
    private String sys_mpsc;                         //密评首次
    private String sys_mmzd;                         //密码制度
    private String sys_ysbs;                         //云上部署
    private String sys_rzys;                         //若在云上
    private String sys_dwdz;                         //单位地址
    private String sys_sxsj;                         //上线时间
    private String sys_dbsj;                         //等保时间
    private String sys_cpjg;                         //测评机构
//    private String sys_xtfw;                         //系统服务


    //设备清单
    private List<Product> sbqd;

    //物理和环境安全
    private List<Wlhhj> wlhhjList;                  //改后状况
    private List<Wlhhj> wlhhjRiskList;              //当前状况

    //网络和通信安全
    private List<Wlhtx> wlhtxList;
    private List<Wlhtx> wlhtxRiskList;

    //设备和计算安全
    private List<Sbhjs> sbhjsList;

    //应用和数据安全
    private List<Yyhsj> yyhsjList;
    private List<Yyhsj> yyhsjRiskList;

}
