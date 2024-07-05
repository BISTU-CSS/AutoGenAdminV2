package com.autogen.dao.entity.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 调研表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionNaire {


    private String sys_sshy;                         //所属行业
    private String sys_sshy_qt;                      //其他所属行业
    private String sys_xmlx;                         //系统类型（技术框架）
    //基础情况
    private String sys_name;                         //系统名称
    private String sys_unit;                         //责任单位
    //********新增部分*********
    private String sys_xtsfxj;                       //系统是否新建
    private String sys_jsdwdz;                       //建设单位地址
    private String sys_ssmmglbm;                     //所属密码管理部门
    private String sys_dwlx;                         //单位类型
    private String sys_xtsxyxsj;                     //系统上线运行时间
    private String sys_gjjcsssm;                    //关键基础设施说明
    private String sys_ssaqbhgzbm;                  //所属安全保护工作部门
    private String sys_dbcp;                         //等保测评
    private String sys_cpjgmc;                       //测评机构名称
    private String sys_cpsj;                         //测评时间
    private String sys_cpjl;                         //测评结论
    private String sys_mmaqpg;                       //密码安全评估
    private String sys_mpjgmc;                       //密评机构名称
    private String sys_pgsj;                         //评估时间
    private String sys_pgjl;                         //评估结论
    private String sys_bsqk;                         //部署情况
    private String sys_yptmc;                        //云平台名称
    private String sys_yptpg;                        //云平台评估
    private String sys_yptmpjgmc;                    //云平台密评机构名称
    private String sys_yptpgsj;                      //云平台评估时间
    private String sys_yptpgjl;                      //云平台评估结论
    private String mmyyglxz;                         //密码应用管理现状
    private String mmaqzddj;                         //密码全制度等级
    private String mmaqsjfm;                         //密码安全涉及方面
    private String sys_kfyy;                           //系统开发语言
    private String sys_kfyy_qt;                        //系统开发语言--其他
    private String sys_sjmwcc;                         //数据库数据是否明文存储
    private String fwtdtgfwfs;                          //服务通道提供服务方式
    private String nbyhfwwllx;                          //内部用户访问网络类型
    private String sfyydmyh;                             //是否有移动端用户
    private String yddyhsfjbfs;                          //移动端用户身份鉴别方式
    private String sys_bljfwfs;                            //堡垒机访问方式







    private String sys_dbjb;                         //等保级别
    private String sys_mmzcpt;                       //密码支撑平台
    private String sys_xtjg;                         //系统架构
    private String sys_xtjs;                         //系统建设
    private String sys_mpsc;                         //密评首次
    private String sys_mmzd;                         //密码制度
    private String sys_ysbs;                         //云上部署
    private String sys_rzys;                         //若在云上
    private String sys_djbh;                         //定级编号
    private String sys_dwdz;                         //单位地址
    private String sys_sxsj;                         //上线时间
    private String sys_dbsj;                         //等保时间
    private String sys_cpjg;                         //测评机构

    //密评简表
    private String mpjb_fwd;                          //服务端
    private List<String> mpjb_ydd;                    //移动端
    private List<String> mpjb_sfrz;                   //门禁身份认证
    private List<String> mpjb_fwfs;                   //公众用户访问方式
    private String mpjb_yjzd;                         //硬件终端
    private String mpjb_sjk;                          //数据库
    private String mpjb_sslvpn;                       //SSL VPN
    private String mpjb_ipsecvpn;                     //IPSec VPN
    private String mpjb_blj;                          //堡垒机
    private String mpjb_bkfr;                         //不可否认性
    private String mpjb_dzqz;                         //电子签章
    private String mpjb_cssjl;                        //传输数据量
    private String mpjb_ccsjl;                        //存储数据量


//    private String sys_mmyyjskj;                     //密码应用技术框架
    private List<InputTable22> inputTable22List;     //系统用户表
    private List<InputTable23> inputTable23List;     //物理和环境调查表
    private List<InputTable24> inputTable24List;     //网络和通信调查表
    private List<InputTable25> inputTable25List;     //服务器调查表
    private List<InputTable26> inputTable26List;     //设备和计算调查表
    private List<InputTable27> inputTable27List;     //业务应用调查表
    private List<InputTable28> inputTable28List;     //重要数据调查表


    private List<Product> sbqd;

    //物理和环境安全
    private List<Wlhhj> wlhhjList;

    //网络和通信安全
    private List<Wlhtx> wlhtxList;

    //设备和计算安全
    private List<Sbhjs> sbhjsList;

    //应用和数据安全
    private List<Yyhsj> yyhsjList;

}
