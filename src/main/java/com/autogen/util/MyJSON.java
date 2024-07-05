package com.autogen.util;

import com.alibaba.fastjson.*;
import com.autogen.dao.entity.Information;
import com.autogen.dao.entity.input.*;

import java.util.ArrayList;
import java.util.List;

// 这个类的作用就是根据data，转为对应的类型
public class MyJSON {
    public static void parsingJSON(JSONObject data, QuestionNaire questionNaire){
        JSONObject jsonObject = data.getJSONObject("data");
        questionNaire.setSys_name(jsonObject.getString("sys_name"));
        questionNaire.setSys_unit(jsonObject.getString("sys_unit"));
        //新增部分
        questionNaire.setSys_xtsfxj(jsonObject.getString("sys_xtsfxj"));
        questionNaire.setSys_jsdwdz(jsonObject.getString("sys_jsdwdz"));
        questionNaire.setSys_ssmmglbm(jsonObject.getString("sys_ssmmglbm"));
        questionNaire.setSys_dwlx(jsonObject.getString("sys_dwlx"));
        questionNaire.setSys_xtsxyxsj(jsonObject.getString("sys_xtsxyxsj"));
        questionNaire.setSys_gjjcsssm(jsonObject.getString("sys_gjjcsssm"));
        questionNaire.setSys_ssaqbhgzbm(jsonObject.getString("sys_ssaqbhgzbm"));
        questionNaire.setSys_dbcp(jsonObject.getString("sys_dbcp"));
        questionNaire.setSys_cpjgmc(jsonObject.getString("sys_cpjgmc"));
        questionNaire.setSys_cpsj(jsonObject.getString("sys_cpsj"));
        questionNaire.setSys_cpjl(jsonObject.getString("sys_cpjl"));
        questionNaire.setSys_mmaqpg(jsonObject.getString("sys_mmaqpg"));
        questionNaire.setSys_mpjgmc(jsonObject.getString("sys_mpjgmc"));
        questionNaire.setSys_pgsj(jsonObject.getString("sys_pgsj"));
        questionNaire.setSys_pgjl(jsonObject.getString("sys_pgjl"));
        questionNaire.setSys_bsqk(jsonObject.getString("sys_bsqk"));
        questionNaire.setSys_yptmc(jsonObject.getString("sys_yptmc"));
        questionNaire.setSys_yptpg(jsonObject.getString("sys_yptpg"));
        questionNaire.setSys_yptmpjgmc(jsonObject.getString("sys_yptmpjgmc"));
        questionNaire.setSys_yptpgsj(jsonObject.getString("sys_yptpgsj"));
        questionNaire.setSys_yptpgjl(jsonObject.getString("sys_yptpgjl"));
        questionNaire.setMmyyglxz(jsonObject.getString("mmyyglxz"));
        questionNaire.setMmaqzddj(jsonObject.getString("mmaqzddj"));
        questionNaire.setMmaqsjfm(jsonObject.getString("mmaqsjfm"));
        questionNaire.setSys_kfyy(jsonObject.getString("sys_kfyy"));
        questionNaire.setSys_kfyy_qt(jsonObject.getString("sys_kfyy_qt"));
        questionNaire.setSys_sjmwcc(jsonObject.getString("sys_sjmwcc"));
        questionNaire.setFwtdtgfwfs(jsonObject.getString("fwtdtgfwfs"));
        questionNaire.setNbyhfwwllx(jsonObject.getString("nbyhfwwllx"));
        questionNaire.setSfyydmyh(jsonObject.getString("sfyydmyh"));
        questionNaire.setYddyhsfjbfs(jsonObject.getString("yddyhsfjbfs"));
        questionNaire.setSys_bljfwfs(jsonObject.getString("sys_bljfwfs"));







        questionNaire.setSys_sshy(jsonObject.getString("sys_sshy"));
        questionNaire.setSys_sshy_qt(jsonObject.getString("sys_sshy_qt"));
        questionNaire.setSys_xmlx(jsonObject.getString("sys_xmlx"));
        questionNaire.setSys_xtjg(jsonObject.getString("sys_xtjg"));
        questionNaire.setSys_xtjs(jsonObject.getString("sys_xtjs"));
        questionNaire.setSys_dbjb(jsonObject.getString("sys_dbjb"));
        questionNaire.setSys_mmzcpt(jsonObject.getString("sys_mmzcpt"));

        questionNaire.setSys_mpsc(jsonObject.getString("sys_mpsc"));
        questionNaire.setSys_mmzd(jsonObject.getString("sys_mmzd"));
        questionNaire.setSys_ysbs(jsonObject.getString("sys_ysbs"));
        questionNaire.setSys_djbh(jsonObject.getString("sys_djbh"));
        questionNaire.setSys_dwdz(jsonObject.getString("sys_dwdz"));
        questionNaire.setSys_sxsj(jsonObject.getString("sys_sxsj"));
        questionNaire.setSys_dbsj(jsonObject.getString("sys_dbsj"));
        questionNaire.setSys_cpjg(jsonObject.getString("sys_cpjg"));
        questionNaire.setSys_rzys(jsonObject.getString("sys_rzys"));
        questionNaire.setMpjb_fwd(jsonObject.getString("mpjb_fwd"));
        questionNaire.setMpjb_ydd(addList(jsonObject,"mpjb_ydd"));
        //****************缺一个dynamicYwyyForm******************
        questionNaire.setInputTable22List(add22List(jsonObject,"sys_xtyh"));
        //物理和环境机房
        questionNaire.setInputTable23List(add23List(jsonObject,"sys_wlhhj"));
        questionNaire.setInputTable24List(add24List(jsonObject,"sys_wlhtx"));
        questionNaire.setInputTable25List(add25List(jsonObject,"sys_fwq"));
        //使用add**List把json格式转为列表格式，然后设置到questionNaire中
        questionNaire.setInputTable26List(add26List(jsonObject,"sys_sbhjs"));
        questionNaire.setInputTable27List(add27List(jsonObject,"sys_ywyy"));
        questionNaire.setInputTable28List(add28List(jsonObject,"sys_zysj"));
        questionNaire.setSbqd(addProduct(jsonObject,"sbqd"));

        //*******************下面这些没看见发的数据中有**************************
        questionNaire.setMpjb_sfrz(addList(jsonObject,"mpjb_sfrz"));
        questionNaire.setMpjb_fwfs(addList(jsonObject,"mpjb_fwfs"));
        questionNaire.setMpjb_yjzd(jsonObject.getString("mpjb_yjzd"));
        questionNaire.setMpjb_sjk(jsonObject.getString("mpjb_sjk"));
        questionNaire.setMpjb_sslvpn(jsonObject.getString("mpjb_sslvpn"));
        questionNaire.setMpjb_ipsecvpn(jsonObject.getString("mpjb_ipsecvpn"));
        questionNaire.setMpjb_blj(jsonObject.getString("mpjb_blj"));
        questionNaire.setMpjb_bkfr(jsonObject.getString("mpjb_bkfr"));
        questionNaire.setMpjb_dzqz(jsonObject.getString("mpjb_dzqz"));
        questionNaire.setMpjb_cssjl(jsonObject.getString("mpjb_cssjl"));
        questionNaire.setMpjb_ccsjl(jsonObject.getString("mpjb_ccsjl"));


    }

    public static void parsingJSON(JSONObject data, Concent concent){
        JSONObject jsonObject = data.getJSONObject("data");
//        questionNaire.setSys_name(jsonObject.getString("sys_name"));
//        questionNaire.setSys_ywyy(jsonObject.getString("sys_ywyy"));
//        questionNaire.setSys_ywsjk(jsonObject.getString("sys_ywsjk"));
//        questionNaire.setSys_ywczxt(jsonObject.getString("sys_ywczxt"));
//        questionNaire.setInputTable213List(add213List(jsonObject,"sys_xtyh"));
//        questionNaire.setInputTable25List(add25List(jsonObject,"sys_yhyjqdb"));
//        questionNaire.setSys_glzd(jsonObject.getString("sys_glzd"));
//        questionNaire.setSys_mmyyjskj(jsonObject.getString("sys_mmyyjskj"));
        concent.setWlhhjList(addWuli(jsonObject,"wlhhj"));
        concent.setWlhtxList(addWangluo(jsonObject,"wlhtx"));
        concent.setSbhjsList(addShebei(jsonObject,"sbhjs"));
        concent.setYyhsjList(addYingyong(jsonObject,"yyhsj"));
        concent.setSbqd(addProduct(jsonObject,"sbqd"));
    }

    public static void parsingJSON(JSONObject data, InputInformation information){

        information.setXmmc(data.getString("xmmc"));
        information.setCjr(data.getString("cjr"));
        information.setZdls(data.getString("zdls"));
        information.setXmsm(data.getString("xmsm"));
        information.setDate(data.getString("date"));
    }


    public static List<Wlhhj> addWuli(JSONObject jsonObject, String str){
        List<Wlhhj>wlhhjList = new ArrayList<>();
        JSONArray jsonArray = jsonObject.getJSONArray(str);
        String js = JSONObject.toJSONString(jsonArray);
        wlhhjList = JSONObject.parseArray(js,Wlhhj.class);
        return wlhhjList;
    }

    public static List<Wlhtx> addWangluo(JSONObject jsonObject, String str){
        List<Wlhtx> wlhtxList = new ArrayList<>();
        JSONArray jsonArray = jsonObject.getJSONArray(str);
        String js = JSONObject.toJSONString(jsonArray);
        wlhtxList = JSONObject.parseArray(js,Wlhtx.class);
        return wlhtxList;
    }

    public static List<Sbhjs> addShebei(JSONObject jsonObject, String str){
        List<Sbhjs> sbhjsList = new ArrayList<>();
        JSONArray jsonArray = jsonObject.getJSONArray(str);
        String js = JSONObject.toJSONString(jsonArray);
        sbhjsList = JSONObject.parseArray(js,Sbhjs.class);
        return sbhjsList;
    }

    public static List<Yyhsj> addYingyong(JSONObject jsonObject, String str){
        List<Yyhsj> yyhsjList = new ArrayList<>();
        JSONArray jsonArray = jsonObject.getJSONArray(str);
        String js = JSONObject.toJSONString(jsonArray);
        yyhsjList = JSONObject.parseArray(js,Yyhsj.class);
        return yyhsjList;
    }

    public static List<Product> addProduct(JSONObject jsonObject, String str){
        List<Product> productList = new ArrayList<>();
        JSONArray jsonArray = jsonObject.getJSONArray(str);
        String js = JSONObject.toJSONString(jsonArray);
        productList = JSONObject.parseArray(js, Product.class);
        return productList;
    }

    public static List<String> addList(JSONObject jsonObject, String str){
        List<String> list = new ArrayList<>();
        JSONArray jsonArray = jsonObject.getJSONArray(str);
        String js = JSONObject.toJSONString(jsonArray);
        list = JSONObject.parseArray(js, String.class);
        return list;
    }

    public static List<InputTable22> add22List(JSONObject jsonObject, String str){
        List<InputTable22> list = new ArrayList<>();
        JSONArray jsonArray = jsonObject.getJSONArray(str);
        String js = JSONObject.toJSONString(jsonArray);
        list = JSONObject.parseArray(js, InputTable22.class);
        return list;
    }

    public static List<InputTable23> add23List(JSONObject jsonObject, String str){
        List<InputTable23> list = new ArrayList<>();
        JSONArray jsonArray = jsonObject.getJSONArray(str);
        String js = JSONObject.toJSONString(jsonArray);
        list = JSONObject.parseArray(js, InputTable23.class);
        return list;
    }

    public static List<InputTable24> add24List(JSONObject jsonObject, String str){
        List<InputTable24> list = new ArrayList<>();
        JSONArray jsonArray = jsonObject.getJSONArray(str);
        String js = JSONObject.toJSONString(jsonArray);
        list = JSONObject.parseArray(js, InputTable24.class);
        return list;
    }

    public static List<InputTable25> add25List(JSONObject jsonObject, String str){
        List<InputTable25> list = new ArrayList<>();
        JSONArray jsonArray = jsonObject.getJSONArray(str);
        String js = JSONObject.toJSONString(jsonArray);
        list = JSONObject.parseArray(js, InputTable25.class);
        return list;
    }

    public static List<InputTable26> add26List(JSONObject jsonObject, String str){
        List<InputTable26> list = new ArrayList<>();
        //jsonObject.getJSONArray方法会从json字符串中取出对应列表字符串
        JSONArray jsonArray = jsonObject.getJSONArray(str);
        //JSONObject.toJSONString方法会把jsonArray转为string类型
        String js = JSONObject.toJSONString(jsonArray);
        //然后把转换后的string类型列表，使用JSONObject.parseArray转为对应种类的列表
        list = JSONObject.parseArray(js, InputTable26.class);
        return list;
    }

    public static List<InputTable27> add27List(JSONObject jsonObject, String str){
        List<InputTable27> list = new ArrayList<>();
        JSONArray jsonArray = jsonObject.getJSONArray(str);
        String js = JSONObject.toJSONString(jsonArray);
        list = JSONObject.parseArray(js, InputTable27.class);
        return list;
    }

    public static List<InputTable28> add28List(JSONObject jsonObject, String str){
        List<InputTable28> list = new ArrayList<>();
        JSONArray jsonArray = jsonObject.getJSONArray(str);
        String js = JSONObject.toJSONString(jsonArray);
        list = JSONObject.parseArray(js, InputTable28.class);
        return list;
    }





}
