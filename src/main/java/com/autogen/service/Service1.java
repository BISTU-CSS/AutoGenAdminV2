package com.autogen.service;
//生成逻辑
import com.alibaba.fastjson.JSONObject;
import com.autogen.dao.entity.input.*;
import com.autogen.dao.entity.pf._1_WLHHJAQ;
import com.autogen.dao.entity.pf._2_WLHTXAQ;
import com.autogen.dao.entity.pf._3_SBHJSAQ;
import com.autogen.dao.entity.pf._4_YYHSJAQ;
import com.autogen.dao.entity.table.Table59Util;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface Service1 {
    /**
     * 生成整个文档所需要的变量
     *
     * @param questionNaire     调研表/网页传回的JSON
     * @param concent 对应的场景
     */
    void BasicTemplate(QuestionNaire questionNaire, Concent concent);

    /**
     * 从数据库查询相应的描述
     *
     * @param questionNaire 调研表/网页传回的JSON
     * @return map保存键值对，通配符-对应描述
     */
    Map<String, Object> selectDes(QuestionNaire questionNaire,Concent concent);

    /**
     * 合并各个章的文档
     *
     * @throws Exception
     */
    void generate(QuestionNaire questionNaire) throws Exception;

    /**
     * 生成第二章用到的内容
     *
     * @param map
     * @param questionNaire
     */
    void cp2Des(Map<String, Object> map, QuestionNaire questionNaire);

    /**
     * 生成第三章用到的内容
     *
     * @param map
     * @param questionNaire
     */
    void cp3Des(Map<String, Object> map, QuestionNaire questionNaire,Concent concent);

    /**
     * 生成第五章用到的内容
     * @param map
     * @param concent
     */
    void cp5Des(Map<String, Object> map, Concent concent);

    /**
     *初始化第三章物理和环境安全表格的数组
     * @param table23 一条物理和环境数据
     * @param zbList 指标列表
     * @param yqList 要求列表
     * @param fxdjList 风险等级列表
     * @param syqkList 适用情况列表
     * @param xtxzList 系统现状列表
     * @param jlList 结论列表
     */
    void table32Init(InputTable23 table23, List<String> zbList, List<String> yqList, List<String> fxdjList, List<String> syqkList, List<String> xtxzList, List<String> jlList);

    /**
     *初始化第三章网络和通信安全表格的数组
     * @param table24 一条网络和通信数据
     * @param zbList 指标列表
     * @param yqList 要求列表
     * @param fxdjList 风险等级列表
     * @param syqkList 适用情况列表
     * @param xtxzList 系统现状列表
     * @param jlList 结论列表
     */
    void table34Init(InputTable24 table24, List<String> zbList, List<String> yqList, List<String> fxdjList, List<String> syqkList, List<String> xtxzList, List<String> jlList);

    /**
     *初始化第三章设备和计算安全表格的数组
     * @param table25 一条设备和计算数据
     * @param zbList 指标列表
     * @param yqList 要求列表
     * @param fxdjList 风险等级列表
     * @param syqkList 适用情况列表
     * @param xtxzList 系统现状列表
     * @param jlList 结论列表
     */
    void table36Init(InputTable25 table25, List<String> zbList, List<String> yqList, List<String> fxdjList, List<String> syqkList, List<String> xtxzList, List<String> jlList);

    /**
     *初始化第三章设备和计算安全表格的数组
     * @param table26 一条设备和计算数据
     * @param zbList 指标列表
     * @param yqList 要求列表
     * @param fxdjList 风险等级列表
     * @param syqkList 适用情况列表
     * @param xtxzList 系统现状列表
     * @param jlList 结论列表
     */
    void table36Init(InputTable26 table26, List<String> zbList, List<String> yqList, List<String> fxdjList, List<String> syqkList, List<String> xtxzList, List<String> jlList);
    /**
     *初始化第三章设备和计算安全表格的数组
     * @param concent 一条设备清单数据
     * @param zbList 指标列表
     * @param yqList 要求列表
     * @param fxdjList 风险等级列表
     * @param syqkList 适用情况列表
     * @param xtxzList 系统现状列表
     * @param jlList 结论列表
     */
    void table36Init(Concent concent, List<String> zbList, List<String> yqList, List<String> fxdjList, List<String> syqkList, List<String> xtxzList, List<String> jlList);

    /**
     *初始化第三章应用和数据安全表格的数组
     * @param questionNaire 一条应用和数据安全的数据
     * @param zbList 指标列表
     * @param yqList 要求列表
     * @param fxdjList 风险等级列表
     * @param syqkList 适用情况列表
     * @param xtxzList 系统现状列表
     * @param jlList 结论列表
     */
    void table38Init(QuestionNaire questionNaire, int i,List<String> zbList, List<String> yqList, List<String> fxdjList, List<String> syqkList, List<String> xtxzList, List<String> jlList);

    /**
     * 初始化第五章物理和环境安全表格的数组
     * @param concent 场景编号集合
     * @param zbList 指标列表
     * @param cpList 产品组合列表
     * @param msList 解决方案描述列表
     * @param jlList 结论列表
     */
    void table51Init(Concent concent, List<String> zbList, List<String> cpList, List<String> msList, List<String> jlList,int i);
    /**
     * 初始化第五章网络和通信安全表格的数组
     * @param concent 场景编号集合
     * @param zbList 指标列表
     * @param cpList 产品组合列表
     * @param msList 解决方案描述列表
     * @param jlList 结论列表
     */
    void table52Init(Concent concent, List<String> zbList, List<String> cpList, List<String> msList, List<String> jlList,int i);
    /**
     * 初始化第五章设备和计算安全表格的数组
     * @param concent 场景编号集合
     * @param zbList 指标列表
     * @param cpList 产品组合列表
     * @param msList 解决方案描述列表
     * @param jlList 结论列表
     */
    void table53Init(Concent concent, List<String> zbList, List<String> cpList, List<String> msList, List<String> jlList,int i);
    /**
     * 初始化第五章应用和数据安全表格的数组
     * @param concent 场景编号集合
     * @param zbList 指标列表
     * @param cpList 产品组合列表
     * @param msList 解决方案描述列表
     * @param jlList 结论列表
     */
    void table54Init(Concent concent, List<String> zbList, List<String> cpList, List<String> msList, List<String> jlList,int i);

    /**
     * 初始化物理和环境合规性表格的数组
     * @param concent 场景编号集合
     * @param zbList  指标列表
     * @param cpzbList 测评指标结果列表
     * @param dycpList 单元测评结果列表
     */
    void table58Init(Concent concent, List<String> zbList, List<String> cpzbList, List<String> dycpList,int i);
    /**
     * 初始化网络和通信合规性表格的数组
     * @param concent 场景编号集合
     * @param zbList  指标列表
     * @param cpzbList 测评指标结果列表
     * @param dycpList 单元测评结果列表
     */
    void table59Init(Concent concent, List<String> zbList, List<String> cpzbList, List<String> dycpList,int i);
    /**
     * 初始化设备和计算合规性表格的数组
     * @param concent 场景编号集合
     * @param zbList  指标列表
     * @param cpzbList 测评指标结果列表
     * @param dycpList 单元测评结果列表
     */
    void table510Init(Concent concent, List<String> zbList, List<String> cpzbList, List<String> dycpList,int i);
    /**
     * 初始化应用和数据合规性表格的数组
     * @param concent 场景编号集合
     * @param zbList  指标列表
     * @param cpzbList 测评指标结果列表
     * @param dycpList 单元测评结果列表
     */
    void table511Init(Concent concent, List<String> zbList, List<String> cpzbList, List<String> dycpList,int i);

    /**
     * 评估方案分数
     * @param cpzbListList 用于保存四个层面每个测评指标的结果，例如物理和环境身份鉴别中包含机房一、机房二
     * @param concent 用于计算各个层面测评对象数量
     * @return 返回方案整体评估分数
     */
     String calculateScore(List<List<Table59Util>> cpzbListList, Concent concent);

     String getScore(Map<String, Object> map);
}
