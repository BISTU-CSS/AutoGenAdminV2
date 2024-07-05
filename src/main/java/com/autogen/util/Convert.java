package com.autogen.util;

import com.autogen.dao.entity.input.*;
import org.apache.batik.gvt.CompositeGraphicsNode;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class Convert {
    // 这个函数的作用就是把编号转为文字
    public static void convertToText(QuestionNaire questionNaire) {
        // 所属行业
        List<String> sys_sshy = new ArrayList<String>() {{
            add("公安");
            add("医疗");
            add("电信");
            add("金融");
            add("能源");
            add("教育");
            add("交通");
            add("政务");
            add("工控");
        }};
        // 项目类型
        List<String> sys_xmlx = new ArrayList<String>() {{
            add("非云平台");
            add("云平台过密评");
            add("云租户过密评");

//            add("单系统模式");
//            add("多系统模式");
//            add("云租户模式");
//            add("云租户+云平台模式");
        }};
//        List<String> sys_xtjg = new ArrayList<String>() {{
//            add("C/S架构");
//            add("B/S架构");
//        }};
//        List<String> sys_xtjs = new ArrayList<String>() {{
//            add("未建设");
//            add("正在建设");
//            add("已上线");
//        }};
        List<String> sys_dbjb = new ArrayList<String>() {{
            add("二级");
            add("三级");
        }};
        List<String> sys_mmzcpt = new ArrayList<String>() {{
            add("密码应用中间件方式");
            add("密码设备方式");
        }};
//        List<String> sys_mpsc = new ArrayList<String>() {{
//            add("首次");
//            add("做过,未通过");
//            add("做过,已通过");
//        }};
//        List<String> sys_mmzd = new ArrayList<String>() {{
//            add("未建设");
//            add("已建设");
//        }};
//        List<String> sys_ysbs = new ArrayList<String>() {{
//            add("在云上");
//            add("不在云上");
//        }};
//        List<String> sys_rzys = new ArrayList<String>() {{
//            add("云平台已过密评");
//            add("云平台尚未过密评");
//            add("");
//        }};
//        List<String> mpjb_fwd = new ArrayList<String>() {{
//            add("HTTPS");
//            add("HTTP");
//            add("其他");
//        }};
//        List<String> mpjb_ydd = new ArrayList<String>() {{
//            add("无");
//            add("手机APP");
//            add("微信小程序");
//        }};
        List<String> mpjb_sfrz = new ArrayList<String>() {{
            add("人工登记");
            add("IC卡");
            add("生物技术");
            add("口令");
            add("手机短信");
        }};
        List<String> mpjb_fwfs = new ArrayList<String>() {{
            add("不支持");
            add("PC浏览器");
            add("手机APP");
            add("公众号");
            add("微信小程序");
        }};
        List<String> mpjb_yjzd = new ArrayList<String>() {{
            add("无");
            add("视频摄像头");
            add("传感器");
            add("手持办公设备");
        }};
        List<String> mpjb_sjk = new ArrayList<String>() {{
            add("Oracle");
            add("SQL Server");
            add("MySQL");
        }};
        List<String> wu = new ArrayList<String>() {{
            add("无");
        }};
        List<String> ywxq = new ArrayList<String>() {{
            add("无需求");
            add("有需求");
        }};
        List<String> sys_xtyh_yh = new ArrayList<String>() {{
            add("运维人员");
            add("系统管理员");
            add("普通用户");
            add("公众用户");
        }};
        List<String> sys_xtyh_dlfs = new ArrayList<String>() {{
            add("PC浏览器");
            add("PC客户端");
            add("手机APP");
            add("微信小程序");
            add("SSH后台登录");
        }};
        List<String> sys_xtyh_sfrz = new ArrayList<String>() {{
            add("U盘证书");
            add("用户名+口令");
            add("手机短信");
            add("邮箱验证");
            add("直接访问，无需认证");
        }};
        List<String> sys_xtyh_szwl = new ArrayList<String>() {{
            add("互联网");
            add("政务外网");
            add("专网");
            add("内网");
        }};
//        List<String> sys_wlhhj_jflx = new ArrayList<String>() {{
//            add("新机房");
//            add("旧机房");
//            add("租机房");
//        }};
        List<String> sys_wlhhj_mj = new ArrayList<String>() {{
            add("国密电子");
            add("非国密电子（缓解）");
            add("非国密电子（改造）");
        }};
        List<String> sys_wlhhj_sfrz = new ArrayList<String>() {{
            add("用户名+口令");
            add("IC卡");
            add("U盘证书");
            add("手机短信");
            add("生物技术");
            add("人工登记");
        }};
        List<String> sys_wlhhj_spjk = new ArrayList<String>() {{
            add("国密");
            add("非国密（缓解）");
            add("非国密（改造）");
        }};
        List<String> sys_wlhtx_txzt = new ArrayList<String>() {{
            add("运维人员");
            add("PC浏览器");
            add("PC-客户端");
            add("移动APP");
            add("微信小程序");
        }};
        List<String> sys_wlhtx_sfrz = new ArrayList<String>() {{
            add("U盘证书");
            add("用户名+口令");
            add("手机短信");
            add("邮箱验证");
            add("直接访问，无需认证");
            add("服务器证书");
            add("设备证书");
        }};
        List<String> sys_fwq_czxt = new ArrayList<String>() {{
            add("Linux");
            add("Windows");
            add("UNIX");
        }};
        List<String> sys_fwq_sjk = new ArrayList<String>() {{
            add("Oracle");
            add("MySQL");
            add("SQL Server");
            add("MongoDB");
            add("DB2");
            add("PostgreSQL");
            add("无");
        }};
        List<String> sys_sfrz = new ArrayList<String>() {{
            add("用户名+口令");
            add("U盘证书");
            add("手机短信");
            add("生物技术");
        }};
        List<String> sf = new ArrayList<String>() {{
            add("是");
            add("否");
        }};
        List<String> sys_ywyy_bkfr = new ArrayList<String>() {{
            add("没有需求");
            add("有需求&未做");
            add("有需求&已做");
        }};
        List<String> sys_ywyy_ccjm = new ArrayList<String>() {{
            add("国密");
            add("非国密");
            add("未加密");
        }};
        List<String> sys_ywyy_csjm = new ArrayList<String>() {{
            add("不涉及");
            add("国密");
            add("非国密");
            add("未加密");
        }};
        List<String> sys_ywyy_sjlx = new ArrayList<String>() {{
            add("鉴别数据");
            add("重要业务数据");
            add("重要审计数据");
            add("个人敏感信息");
            add("法律法规规定的其他重要数");
            add("访问控制信息");
        }};
        // 10代表其他行业，然后设置所属行业为对应的值
        if ("10".equals(questionNaire.getSys_sshy())) {
            questionNaire.setSys_sshy(questionNaire.getSys_sshy_qt());
        } else {
            questionNaire.setSys_sshy(setString(questionNaire.getSys_sshy(), sys_sshy));
        }
        // 由于前端传的都是编号，所以后端需要把编号转为对应的文字
        questionNaire.setSys_xmlx(setString(questionNaire.getSys_xmlx(), sys_xmlx));
//        questionNaire.setSys_xtjg(setString(questionNaire.getSys_xtjg(), sys_xtjg));
//        questionNaire.setSys_xtjs(setString(questionNaire.getSys_xtjs(), sys_xtjs));
        questionNaire.setSys_dbjb(setString(questionNaire.getSys_dbjb(), sys_dbjb));
        questionNaire.setSys_mmzcpt(setString(questionNaire.getSys_mmzcpt(),sys_mmzcpt));
//        questionNaire.setSys_mpsc(setString(questionNaire.getSys_mpsc(), sys_mpsc));
//        questionNaire.setSys_mmzd(setString(questionNaire.getSys_mmzd(), sys_mmzd));
//        questionNaire.setSys_ysbs(setString(questionNaire.getSys_ysbs(), sys_ysbs));
//        questionNaire.setSys_rzys(setString(questionNaire.getSys_rzys(), sys_rzys));
//        questionNaire.setMpjb_fwd(setString(questionNaire.getMpjb_fwd(), mpjb_fwd));
//        questionNaire.setMpjb_ydd(setList(questionNaire.getMpjb_ydd(), mpjb_ydd));


        List<InputTable22> table22List = new ArrayList<>();
        for (int i = 0; i < questionNaire.getInputTable22List().size(); i++) {
            InputTable22 table22 = new InputTable22();
            table22.setYwyy(questionNaire.getInputTable22List().get(i).getYwyy());
            table22.setYh(setString(questionNaire.getInputTable22List().get(i).getYh(), sys_xtyh_yh));
            table22.setDlfs(setList(questionNaire.getInputTable22List().get(i).getDlfs(), sys_xtyh_dlfs));
            table22.setSfrz(setList(questionNaire.getInputTable22List().get(i).getSfrz(), sys_xtyh_sfrz));
            table22.setSzwl(setList(questionNaire.getInputTable22List().get(i).getSzwl(), sys_xtyh_szwl));
            table22.setSl(questionNaire.getInputTable22List().get(i).getSl());
            table22List.add(table22);
        }
        questionNaire.setInputTable22List(table22List);


        List<InputTable23> table23List = new ArrayList<>();
        for (int i = 0; i < questionNaire.getInputTable23List().size(); i++) {
            InputTable23 table23 = new InputTable23();
            table23.setJfmc(questionNaire.getInputTable23List().get(i).getJfmc());
            table23.setJfdz(questionNaire.getInputTable23List().get(i).getJfdz());
            table23.setJfzrztdw(questionNaire.getInputTable23List().get(i).getJfzrztdw());
//            table23.setJflx(setString(questionNaire.getInputTable23List().get(i).getJflx(), sys_wlhhj_jflx));
            table23.setMj(setString(questionNaire.getInputTable23List().get(i).getMj(), sys_wlhhj_mj));
            table23.setSfrz(setList(questionNaire.getInputTable23List().get(i).getSfrz(), sys_wlhhj_sfrz));
            table23.setSpjk(setString(questionNaire.getInputTable23List().get(i).getSpjk(), sys_wlhhj_spjk));
//            table23.setZjsb(setString(questionNaire.getInputTable23List().get(i).getZjsb(), sf));
            table23List.add(table23);
        }
        questionNaire.setInputTable23List(table23List);
        List<InputTable24> table24List = new ArrayList<>();
        for (int i = 0; i < questionNaire.getInputTable24List().size(); i++) {
            InputTable24 table24 = new InputTable24();
            table24.setType(questionNaire.getInputTable24List().get(i).getType());
            table24.setTxzt(setString(questionNaire.getInputTable24List().get(i).getTxzt(), sys_wlhtx_txzt));
            table24.setSfrz(setList(questionNaire.getInputTable24List().get(i).getSfrz(), sys_wlhtx_sfrz));
//            table24.setZysj(setString(questionNaire.getInputTable24List().get(i).getZysj(), sf));
            table24.setSl(questionNaire.getInputTable24List().get(i).getSl());
//            table24.setSm(questionNaire.getInputTable24List().get(i).getSm());
            table24.setCpdx(questionNaire.getInputTable24List().get(i).getCpdx());
            table24List.add(table24);
        }
        questionNaire.setInputTable24List(table24List);
        List<InputTable25> table25List = new ArrayList<>();
        for (int i = 0; i < questionNaire.getInputTable25List().size(); i++) {
            InputTable25 table25 = new InputTable25();
            table25.setSbmc(questionNaire.getInputTable25List().get(i).getSbmc());
            table25.setPpxh(questionNaire.getInputTable25List().get(i).getPpxh());
            table25.setSl(questionNaire.getInputTable25List().get(i).getSl());
            table25.setCzxt(setString(questionNaire.getInputTable25List().get(i).getCzxt(), sys_fwq_czxt));
            table25.setSjk(setString(questionNaire.getInputTable25List().get(i).getSjk(), sys_fwq_sjk));
            table25.setYcyw(setString(questionNaire.getInputTable25List().get(i).getYcyw(), sf));
            table25.setSfrz(setList(questionNaire.getInputTable25List().get(i).getSfrz(), sys_sfrz));
            table25.setBlj(setString(questionNaire.getInputTable25List().get(i).getBlj(), sf));
            table25List.add(table25);
        }
        questionNaire.setInputTable25List(table25List);
        List<InputTable26> table26List = new ArrayList<>();
        for (int i = 0; i < questionNaire.getInputTable26List().size(); i++) {
            InputTable26 table26 = new InputTable26();
            table26.setType(questionNaire.getInputTable26List().get(i).getType());
            table26.setSbmc(questionNaire.getInputTable26List().get(i).getSbmc());
            table26.setPpxh(questionNaire.getInputTable26List().get(i).getPpxh());
            table26.setSl(questionNaire.getInputTable26List().get(i).getSl());
            table26.setGmsf(setString(questionNaire.getInputTable26List().get(i).getGmsf(), sf));
            table26.setSmzs(setString(questionNaire.getInputTable26List().get(i).getSmzs(), sf));
            table26.setYcyw(setString(questionNaire.getInputTable26List().get(i).getYcyw(), sf));
            table26.setSfrz(setList(questionNaire.getInputTable26List().get(i).getSfrz(), sys_sfrz));
            table26.setBlj(setString(questionNaire.getInputTable26List().get(i).getBlj(), sf));
            table26List.add(table26);
        }
        questionNaire.setInputTable26List(table26List);
        List<InputTable27> table27List = new ArrayList<>();
        for (int i = 0; i < questionNaire.getInputTable27List().size(); i++) {
            InputTable27 table27 = new InputTable27();
            table27.setYwyy(questionNaire.getInputTable27List().get(i).getYwyy());
            table27.setGnms(questionNaire.getInputTable27List().get(i).getGnms());
//            table27.setFwfs(setString(questionNaire.getInputTable27List().get(i).getFwfs(), mpjb_fwd));
            table27.setBkfr(setString(questionNaire.getInputTable27List().get(i).getBkfr(), sys_ywyy_bkfr));
            table27.setJtqk1(questionNaire.getInputTable27List().get(i).getJtqk1());
            table27.setDzqm(setString(questionNaire.getInputTable27List().get(i).getDzqm(), sys_ywyy_bkfr));
            table27.setJtqk2(questionNaire.getInputTable27List().get(i).getJtqk2());
            table27List.add(table27);
        }
        questionNaire.setInputTable27List(table27List);
        List<InputTable28> table28List = new ArrayList<>();
        for (int i = 0; i < questionNaire.getInputTable28List().size(); i++) {
            InputTable28 table28 = new InputTable28();
            table28.setYwyy(questionNaire.getInputTable28List().get(i).getYwyy());
            table28.setSjlx(setString(questionNaire.getInputTable28List().get(i).getSjlx(), sys_ywyy_sjlx));
            table28.setSjnr(questionNaire.getInputTable28List().get(i).getSjnr());
            table28.setBhxq(questionNaire.getInputTable28List().get(i).getBhxq());
            table28.setCcjm(setString(questionNaire.getInputTable28List().get(i).getCcjm(), sys_ywyy_ccjm));
            table28.setSjl(questionNaire.getInputTable28List().get(i).getSjl());
            table28.setCsjm(setString(questionNaire.getInputTable28List().get(i).getCsjm(), sys_ywyy_csjm));
            table28.setLl(questionNaire.getInputTable28List().get(i).getLl());
            table28List.add(table28);
        }
        questionNaire.setInputTable28List(table28List);
    }

    /**
     * 把str转为int类型，然后从list中取int位置的数据并返回
     * @param str   索引的String类型
     * @param list  列表
     * @return      返回列表中的某个值
     */
    public static String setString(String str, List<String> list) {
        if (StringUtils.isNumeric(str)) {
            str = list.get(Integer.parseInt(str) - 1);
        }
        return str;
    }

    /**
     *
     * @param strList   strList中放的是索引列表，但是是string类型
     * @param list      根据strList中的值，从list中取数据，然后返回
     * @return
     */
    public static List<String> setList(List<String> strList, List<String> list) {
        List<String> resList = new ArrayList<>();
        for (int i = 0; i < strList.size(); i++) {
            String str = strList.get(i);
            if (StringUtils.isNumeric(str)) {
                resList.add(list.get(Integer.parseInt(str) - 1));
            } else {
                resList.add(strList.get(i));
            }
        }
        return resList;
    }

    // 把questionNaire类型转为Concent类型
    public static Concent convertToSence(QuestionNaire questionNaire) {
        Concent concent = new Concent();
        concent.setSys_sshy(questionNaire.getSys_sshy());
        concent.setSys_xmlx(questionNaire.getSys_xmlx());
        concent.setSys_xtjg(questionNaire.getSys_xtjg());
        concent.setSys_name(questionNaire.getSys_name());
        concent.setSys_unit(questionNaire.getSys_unit());
        concent.setSys_dbjb(questionNaire.getSys_dbjb());
        concent.setSys_mmzcpt(questionNaire.getSys_mmzcpt());
        concent.setSys_xtjs(questionNaire.getSys_xtjs());
        concent.setSys_mpsc(questionNaire.getSys_mpsc());
        concent.setSys_mmzd(questionNaire.getSys_mmzd());
        concent.setSys_ysbs(questionNaire.getSys_ysbs());
        concent.setSys_dwdz(questionNaire.getSys_dwdz());
        concent.setSys_sxsj(questionNaire.getSys_sxsj());
        concent.setSys_dbsj(questionNaire.getSys_dbsj());
        concent.setSys_cpjg(questionNaire.getSys_cpjg());
        List<Product> sbqdList = new ArrayList<>();
        List<Wlhhj> wlhhjList = new ArrayList<>();
        List<Wlhtx> wlhtxList = new ArrayList<>();
        List<Sbhjs> sbhjsList = new ArrayList<>();
        List<Yyhsj> yyhsjList = new ArrayList<>();
        List<Wlhhj> wlhhjRiskList = new ArrayList<>();
        List<Wlhtx> wlhtxRiskList = new ArrayList<>();
        List<Sbhjs> sbhjsRiskList = new ArrayList<>();
        List<Yyhsj> yyhsjRiskList = new ArrayList<>();
        for (int i = 0; i < questionNaire.getSbqd().size(); i++) {
            Product product = questionNaire.getSbqd().get(i);
            if (!"0".equals(product.getNum())) {
                sbqdList.add(product);
            }
        }
        //Risk指的是目前系统现状的情况，没有Risk指的是应该怎样的
        //convert***方法的作用是转换为具体的场景标识码
        convertWlhhj(questionNaire, wlhhjRiskList, wlhhjList, sbqdList);
        convertWlhtx(questionNaire, wlhtxRiskList, wlhtxList, sbqdList);
        convertSbhjx(questionNaire, sbhjsList, sbqdList);
        convertYyhsj(questionNaire, yyhsjRiskList, yyhsjList, sbqdList);
        concent.setWlhhjList(wlhhjList);
        concent.setWlhhjRiskList(wlhhjRiskList);
        concent.setWlhtxList(wlhtxList);
        concent.setWlhtxRiskList(wlhtxRiskList);
        concent.setSbhjsList(sbhjsList);
        concent.setYyhsjList(yyhsjList);
        concent.setYyhsjRiskList(yyhsjRiskList);
        concent.setSbqd(sbqdList);
        return concent;
    }

    private static void convertWlhhj(QuestionNaire questionNaire, List<Wlhhj> wlhhjRiskList, List<Wlhhj> wlhhjList, List<Product> sbqdList) {
        List<String> sbqdStrList = new ArrayList<>();
        for (int i = 0; i < sbqdList.size(); i++) {
            sbqdStrList.add(sbqdList.get(i).getName());
        }
        for (int i = 0; i < questionNaire.getInputTable23List().size(); i++) {
            Wlhhj wlhhj = new Wlhhj();
            Wlhhj wlhhjRisk = new Wlhhj();
            InputTable23 table23 = questionNaire.getInputTable23List().get(i);
            wlhhj.setWlhhj_jfmc(table23.getJfmc());
            wlhhjRisk.setWlhhj_jfmc(table23.getJfmc());
            if (table23.getMj().equals("1")) {
                //现用国密门禁，场景一
                wlhhjRisk.setWlhhj_sfjb("10-00-1");
                wlhhjRisk.setWlhhj_dzmj("11-00-1");
                wlhhj.setWlhhj_sfjb("50-00-1");
                wlhhj.setWlhhj_dzmj("51-00-1");
            } else if (table23.getMj().equals("2")) {
                //非国密缓解，场景二
                wlhhjRisk.setWlhhj_sfjb("10-02-1");
                wlhhjRisk.setWlhhj_dzmj("11-02-1");
                wlhhj.setWlhhj_sfjb("50-01-1");
                wlhhj.setWlhhj_dzmj("51-01-1");
            }else {

                //非国密改造，场景三
                wlhhjRisk.setWlhhj_sfjb("10-02-1");
                wlhhjRisk.setWlhhj_dzmj("11-02-1");
                wlhhj.setWlhhj_sfjb("50-02-1");
                wlhhj.setWlhhj_dzmj("51-02-1");
            }
            if (table23.getSpjk().equals("1")) {
                //现用国密电子监控系统，场景一
                wlhhjRisk.setWlhhj_spjk("12-00-1");
                wlhhj.setWlhhj_spjk("52-00-1");

            }else if (table23.getSpjk().equals("2")) {
                //现用非国密电子监控系统缓解，场景二
                wlhhjRisk.setWlhhj_spjk("12-02-1");
                wlhhj.setWlhhj_spjk("52-01-1");
            } else {

                //非国密监控改造 场景三
                wlhhjRisk.setWlhhj_spjk("12-02-1");
                wlhhj.setWlhhj_spjk("52-02-1");
            }
            wlhhjRiskList.add(wlhhjRisk);
            wlhhjList.add(wlhhj);
        }
    }

    private static void convertWlhtx(QuestionNaire questionNaire, List<Wlhtx> wlhtxRiskList, List<Wlhtx> wlhtxList, List<Product> sbqdList) {
        List<String> sbqdStrList = new ArrayList<>();
        for (int i = 0; i < sbqdList.size(); i++) {
            sbqdStrList.add(sbqdList.get(i).getName());
        }
        boolean flag = false;
        for (int i = 0; i < questionNaire.getInputTable26List().size(); i++) {
            InputTable26 table26 = questionNaire.getInputTable26List().get(i);
            if (table26.getSbmc().contains("SSL VPN") && table26.getSmzs().equals("1")) {
                flag = true;
            }
        }
        for (int i = 0; i < questionNaire.getInputTable24List().size(); i++) {
            InputTable24 table24 = questionNaire.getInputTable24List().get(i);
            Wlhtx wlhtx = new Wlhtx();
            Wlhtx wlhtxRisk = new Wlhtx();
            List<String> list = new ArrayList<>();
            List<String> riskList = new ArrayList<>();
            //风险分析
            wlhtxRisk.setWlhtx_xdmc(table24.getCpdx());

            if (table24.getSfrz().contains("1")) {
                riskList.add("20-01-1");
                if (flag) {
                    riskList.add("21-01-1");
                    riskList.add("22-01-1");
                    riskList.add("23-01-1");
                    riskList.add("24-00-1");
                } else {
                    riskList.add("21-00-1");
                    riskList.add("22-00-1");
                    riskList.add("23-00-1");
                    riskList.add("24-00-1");
                }
            } else {
                riskList.add("20-00-1");
                if (flag) {
                    riskList.add("21-01-1");
                    riskList.add("22-01-1");
                    riskList.add("23-01-1");
                    riskList.add("24-00-1");
                } else {
                    riskList.add("21-00-1");
                    riskList.add("22-00-1");
                    riskList.add("23-00-1");
                    riskList.add("24-00-1");
                }
            }
            wlhtxRisk.setWlhtx_xd(riskList);

            //解决方案
            if (table24.getTxzt().contains("系统") || table24.getTxzt().contains("机房")) {
                wlhtx.setWlhtx_xdmc(table24.getCpdx());
                list.add("60-00-1");
                list.add("61-00-1");
                list.add("62-00-1");
                list.add("63-00-1");
                list.add("64-00-1");
            } else if ("1".equals(table24.getTxzt())) {
                wlhtx.setWlhtx_xdmc(table24.getCpdx());
                list.add("60-01-1");
                list.add("61-01-1");
                list.add("62-01-1");
                list.add("63-01-1");
                list.add("64-01-1");
            } else if ("2".equals(table24.getTxzt())) {
                wlhtx.setWlhtx_xdmc(table24.getCpdx());
                if (sbqdStrList.contains("可信浏览器")){
                    list.add("60-01-1");
                    list.add("61-01-1");
                    list.add("62-01-1");
                    list.add("63-01-1");
                    list.add("64-01-1");
                }else {
                    list.add("60-03-1");
                    list.add("61-03-1");
                    list.add("62-03-1");
                    list.add("63-03-1");
                    list.add("64-03-1");
                }

            }else if ("3".equals(table24.getTxzt())) {
                wlhtx.setWlhtx_xdmc(table24.getCpdx());
                list.add("60-02-1");
                list.add("61-02-1");
                list.add("62-02-1");
                list.add("63-02-1");
                list.add("64-02-1");
            }else if ("4".equals(table24.getTxzt())||"5".equals(table24.getTxzt())) {
                wlhtx.setWlhtx_xdmc(table24.getCpdx());
                list.add("60-04-1");
                list.add("61-04-1");
                list.add("62-04-1");
                list.add("63-04-1");
                list.add("64-04-1");
            }else {
                wlhtx.setWlhtx_xdmc("此通道映射存在问题");
                list.add("60-01-1");
                list.add("61-01-1");
                list.add("62-01-1");
                list.add("63-01-1");
                list.add("64-01-1");
            }
            wlhtx.setWlhtx_xd(list);
            wlhtxList.add(wlhtx);
            wlhtxRiskList.add(wlhtxRisk);
        }
    }

    private static void convertSbhjx(QuestionNaire questionNaire, List<Sbhjs> sbhjsList, List<Product> sbqdList) {
        List<String> sbqdStrList = new ArrayList<>();
        for (int i = 0; i < sbqdList.size(); i++) {
            sbqdStrList.add(sbqdList.get(i).getName());
        }
        for (int i = 0; i < questionNaire.getInputTable25List().size(); i++) {
            Sbhjs sbhjs = new Sbhjs();
            InputTable25 table25 = questionNaire.getInputTable25List().get(i);
            sbhjs.setSbhjs_sbmc(table25.getSbmc());
            sbhjs.setSbhjs_sfjb("70-01-1");
            sbhjs.setSbhjs_ycgl("71-01-1");
            sbhjs.setSbhjs_xtzy("72-01-1");
            sbhjs.setSbhjs_zyxx("73-01-1");
            sbhjs.setSbhjs_rzjl("74-01-1");
            sbhjs.setSbhjs_zykz("75-01-1");
            sbhjsList.add(sbhjs);
        }
        for (int i = 0; i < questionNaire.getInputTable26List().size(); i++) {
            InputTable26 table26 = questionNaire.getInputTable26List().get(i);
            Sbhjs sbhjs = new Sbhjs();
            if (table26.getSbmc().equals("SSL VPN") || table26.getSbmc().equals("IPSec VPN")) {
                sbhjs.setSbhjs_sbmc(table26.getSbmc());
                sbhjs.setSbhjs_sfjb("70-02-1");
                sbhjs.setSbhjs_ycgl("71-02-1");
                sbhjs.setSbhjs_xtzy("72-02-1");
                sbhjs.setSbhjs_zyxx("73-02-1");
                sbhjs.setSbhjs_rzjl("74-02-1");
                sbhjs.setSbhjs_zykz("75-02-1");
                sbhjsList.add(sbhjs);
            } else if (table26.getSbmc().equals("堡垒机")) {
                sbhjs.setSbhjs_sbmc(table26.getSbmc());
                sbhjs.setSbhjs_sfjb("70-00-1");
                sbhjs.setSbhjs_ycgl("71-00-1");
                sbhjs.setSbhjs_xtzy("72-00-1");
                sbhjs.setSbhjs_zyxx("73-00-1");
                sbhjs.setSbhjs_rzjl("74-00-1");
                sbhjs.setSbhjs_zykz("75-00-1");
                sbhjsList.add(sbhjs);
            }
        }
        //循环设备清单
        for (int i = 0; i < sbqdStrList.size(); i++) {
            Sbhjs sbhjs = new Sbhjs();
            sbhjs.setSbhjs_sbmc(sbqdStrList.get(i));
            if (sbhjs.getSbhjs_sbmc().equals("国密安全密码应用中间件") || sbhjs.getSbhjs_sbmc().equals("国密数字证书")
                    || sbhjs.getSbhjs_sbmc().equals("智能密码钥匙") || sbhjs.getSbhjs_sbmc().equals("可信浏览器")
                    || sbhjs.getSbhjs_sbmc().equals("国密设备证书") || sbhjs.getSbhjs_sbmc().equals("云安全管理平台（CSMP）")
                    || sbhjs.getSbhjs_sbmc().equals("国密电子监控系统") || sbhjs.getSbhjs_sbmc().equals("国密门禁系统")
                    || sbhjs.getSbhjs_sbmc().equals("密码应用技术服务") || sbhjs.getSbhjs_sbmc().equals("国密SSL证书")) {
                continue;
            }
            if (sbhjs.getSbhjs_sbmc().equals("国密堡垒机")) {
                sbhjs.setSbhjs_sfjb("70-00-1");
                sbhjs.setSbhjs_ycgl("71-00-1");
                sbhjs.setSbhjs_xtzy("72-00-1");
                sbhjs.setSbhjs_zyxx("73-00-1");
                sbhjs.setSbhjs_rzjl("74-00-1");
                sbhjs.setSbhjs_zykz("75-00-1");
            }
            if (sbhjs.getSbhjs_sbmc().equals("服务器密码机") || sbhjs.getSbhjs_sbmc().equals("签名验签服务器") ||
                    sbhjs.getSbhjs_sbmc().equals("SSL VPN安全网关") || sbhjs.getSbhjs_sbmc().equals("时间戳服务器") ||
                    sbhjs.getSbhjs_sbmc().equals("IPSec VPN安全网关") || sbhjs.getSbhjs_sbmc().equals("云服务器密码机")) {
                sbhjs.setSbhjs_sfjb("70-02-1");
                sbhjs.setSbhjs_ycgl("71-02-1");
                sbhjs.setSbhjs_xtzy("72-02-1");
                sbhjs.setSbhjs_zyxx("73-02-1");
                sbhjs.setSbhjs_rzjl("74-02-1");
                sbhjs.setSbhjs_zykz("75-02-1");
            }
            if (sbhjs.getSbhjs_sbmc().equals("协同签名系统") ||sbhjs.getSbhjs_sbmc().equals("密钥管理系统")|| sbhjs.getSbhjs_sbmc().equals("安全电子签章系统") || sbhjs.getSbhjs_sbmc().equals("数字证书认证系统")) {
                sbhjs.setSbhjs_sfjb("70-03-1");
                sbhjs.setSbhjs_ycgl("71-03-1");
                sbhjs.setSbhjs_xtzy("72-03-1");
                sbhjs.setSbhjs_zyxx("73-03-1");
                sbhjs.setSbhjs_rzjl("74-03-1");
                sbhjs.setSbhjs_zykz("75-03-1");
            }
            sbhjsList.add(sbhjs);
        }
    }

    private static void convertYyhsj(QuestionNaire questionNaire, List<Yyhsj> yyhsjRiskList, List<Yyhsj> yyhsjList, List<Product> sbqdList) {
        List<String> sbqdStrList = new ArrayList<>();
        for (int i = 0; i < sbqdList.size(); i++) {
            sbqdStrList.add(sbqdList.get(i).getName());
        }
        for (int i = 0; i < questionNaire.getInputTable27List().size(); i++) {
            List<String> sfjbList = new ArrayList<>();
            List<String> zysjList = new ArrayList<>();
            Map<String, String> map = new HashMap<>();
            map.put("sfjb0", "null");
            map.put("sfjb1", "null");
            map.put("sfjb2", "null");
            map.put("sfjb3", "null");
            Yyhsj yyhsj = new Yyhsj();
            Yyhsj yyhsjRisk = new Yyhsj();
            InputTable27 table27 = questionNaire.getInputTable27List().get(i);
            yyhsj.setYyhsj_ywmc(table27.getYwyy());
            yyhsjRisk.setYyhsj_ywmc(table27.getYwyy());
            for (int j = 0; j < questionNaire.getInputTable22List().size(); j++) {
                if (table27.getYwyy().equals(questionNaire.getInputTable22List().get(j).getYwyy())) {
                    InputTable22 table22 = questionNaire.getInputTable22List().get(j);
                    if (table22.getYh().equals("4")) {
                        map.put("sfjb3", "80-03-1");
                    }
                    if (table22.getDlfs().contains("1")) {
                        map.put("sfjb1", "80-01-1");
                    }
                    if (table22.getDlfs().contains("2")) {
                        map.put("sfjb0", "80-00-1");
                    }
                    if (table22.getDlfs().contains("3") || table22.getDlfs().contains("4")) {
                        map.put("sfjb2", "80-02-1");
                    }
                }

            }
            if (!map.get("sfjb0").equals("null")) {
                sfjbList.add(map.get("sfjb0"));
            }
            if (!map.get("sfjb1").equals("null")) {
                sfjbList.add(map.get("sfjb1"));
            }
            if (!map.get("sfjb2").equals("null")) {
                sfjbList.add(map.get("sfjb2"));
            }
            if (!map.get("sfjb3").equals("null")) {
                sfjbList.add(map.get("sfjb3"));
            }
            yyhsj.setYyhsj_sfjb(sfjbList);
            for (int j = 0; j < questionNaire.getInputTable28List().size(); j++) {
                InputTable28 table28 = questionNaire.getInputTable28List().get(j);
                if (table27.getYwyy().equals(table28.getYwyy())) {
                    if ("6".equals(table28.getSjlx())) {
                        if ("1".equals(table28.getCcjm())) {
                            yyhsj.setYyhsj_fwkz("81-01-1");
                            yyhsjRisk.setYyhsj_fwkz("41-01-1");
                        } else {
                            yyhsj.setYyhsj_fwkz("81-00-1");
                            yyhsjRisk.setYyhsj_fwkz("41-00-1");
                        }
                    }
                }
            }
            yyhsj.setYyhsj_xxzy("82-00-1");
            yyhsj.setYyhsj_csjmx("83-00-1");
            yyhsj.setYyhsj_cswzx("85-00-2");
            yyhsj.setYyhsj_ccjmx("84-01-1");
            yyhsj.setYyhsj_ccwzx("86-00-1");
            if (table27.getBkfr().equals("1")) {
                yyhsj.setYyhsj_bkfr("87-00-1");
                yyhsjRisk.setYyhsj_bkfr("47-02-1");
            } else if (table27.getBkfr().equals("2")) {
                yyhsj.setYyhsj_bkfr("87-01-1");
                yyhsjRisk.setYyhsj_bkfr("47-00-1");
            } else {
                yyhsj.setYyhsj_bkfr("87-02-1");
                yyhsjRisk.setYyhsj_bkfr("47-01-1");
            }
            yyhsjRisk.setYyhsj_sfjb(Arrays.asList("40-00-1"));
            yyhsjRisk.setYyhsj_xxzy("42-00-1");
            yyhsjRisk.setYyhsj_csjmx("43-00-1");
            yyhsjRisk.setYyhsj_cswzx("45-00-1");
            yyhsjRisk.setYyhsj_ccjmx("44-00-1");
            yyhsjRisk.setYyhsj_ccwzx("46-00-1");
            yyhsjRiskList.add(yyhsjRisk);
            yyhsjList.add(yyhsj);
        }
    }
    //ck根据符合、不符和、部分符合、不适用返回
    public static String[]  ConvertStateToScoreStr(String str){
        String[] res;
        if(str.equals("符合")){
            res= new String[]{"√", "√", "√"};
        } else if (str.equals("不符合，缓解")) {
            res= new String[]{"√", "√", "×"};
        } else if (str.equals("不符合")) {
            res= new String[]{"×", "×", "×"};
        } else if (str.equals("不适用")) {
            res= new String[]{"/", "/", "/"};
        } else if (str.equals("部分符合")) {
            res= new String[]{"√", "×", "×"};
        } else{
            res = new String[]{"?", "?", "?"};
        }

        return res;
    }

}
