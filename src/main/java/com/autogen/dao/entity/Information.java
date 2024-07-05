package com.autogen.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
@TableName("basic_information")
public class Information {
    @TableId(value = "id",type =  IdType.AUTO)
    private int id;
    private String cjr;
    private String zdls;
    private String xmmc;
    private String xmsm;
    private String date;
    private String data;
    private String xgsj;
    private String score;
    private int  archive;
}
