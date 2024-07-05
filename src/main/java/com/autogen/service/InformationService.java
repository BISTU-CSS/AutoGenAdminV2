package com.autogen.service;

import com.alibaba.fastjson.JSONObject;
import com.autogen.dao.entity.Device;
import com.autogen.dao.entity.Information;
import com.autogen.dao.entity.input.Concent;
import com.autogen.dao.entity.input.InputInformation;
import com.autogen.dao.entity.input.Product;
import com.autogen.dao.entity.table.Table59Util;

import java.util.List;

public interface InformationService {
    /**
     * 创建一个问卷表
     * @param information
     * @return 已存在项目返回1，不存在则存入项目信息并返回0
     */
    public int createQuestionnaire(InputInformation information);

    /**
     * 获取问卷简要信息
     * @return 返回数据库中所有项目信息
     */
    public List<InputInformation> getQuestionnaireList();

    /**
     * 获取问卷填写（存档）信息
     * @return 问卷JSON格式
     */
    public String getQuestionnaireResult(InputInformation inputInformation);

    /**
     * 保存问卷情况
     * @return 成功返回0，失败返回1
     */
    public int saveQuestionnaireResult(JSONObject data);

    /**
     * 导出设备清单
     * @param productList 传入的调研表中设备清单
     * @param name 项目名称
     */
    public void exportSBQD(List<Product> productList,String name);




}
