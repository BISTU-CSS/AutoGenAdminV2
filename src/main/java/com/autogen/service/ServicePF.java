package com.autogen.service;

import com.alibaba.fastjson.JSONObject;
import com.autogen.dao.entity.input.Sbhjs;
import com.autogen.dao.entity.input.Wlhhj;
import com.autogen.dao.entity.input.Wlhtx;
import com.autogen.dao.entity.input.Yyhsj;
import com.autogen.dao.entity.pf._1_WLHHJAQ;
import com.autogen.dao.entity.pf._2_WLHTXAQ;
import com.autogen.dao.entity.pf._3_SBHJSAQ;
import com.autogen.dao.entity.pf._4_YYHSJAQ;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ServicePF {

    List<_1_WLHHJAQ> getWlhhjData(List<Wlhhj> wlhhjlist);

    //生成表格所需数据-网络
    List<_2_WLHTXAQ> getWlhtxData(List<Wlhtx> wlhtxList);

    //生成表格所需数据-设备
    List<_3_SBHJSAQ> getSbhjsData(List<Sbhjs> sbhjsList);

    //生成表格所需数据-应用
    List<_4_YYHSJAQ> getYyhsjData(List<Yyhsj> yyhsjList);

    void genExcel(List<_1_WLHHJAQ> wlhhj,List<_2_WLHTXAQ> wlhtx,List<_3_SBHJSAQ> sbhjs,List<_4_YYHSJAQ> yyhsj,String dbjb);

    JSONObject getJSONData(String sysname);

    /**
     * （前端接口）根据用户上传的excel文件，生成对应的评分单
     * @param name 项目名
     * @return 评分单，格式未定
     */
    double[] gen_PF(String name);
}
