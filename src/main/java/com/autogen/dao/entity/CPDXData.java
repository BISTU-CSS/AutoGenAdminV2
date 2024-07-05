package com.autogen.dao.entity;

import com.deepoove.poi.data.NumberingRenderData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CPDXData {

    private int index;                          //测评对象的序号
    private String name;                        //测评对象的名称
    private NumberingRenderData description;    //测评对象的具体描述，是个编号列表
}
