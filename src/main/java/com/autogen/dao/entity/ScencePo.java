package com.autogen.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
@TableName("scence_des")
public class ScencePo {

    @TableId(value = "id",type =  IdType.AUTO)
    private int id;
    private String scence;      //场景
    private String cpzh;        //产品组合
    private String jl;          //结论
    private String description; //描述
    private String cpzb;        //测评指标
    private String dycp;        //单元测评


}
