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
@TableName("device")
public class Device {
    @TableId(value = "id",type =  IdType.AUTO)
    private int id;         //索引
    private String name;    //产品名称
    private String brand;      //品牌
    private String model;  //产品参考型号
    private String gnsm;    //功能说明
    private String type;      //类别
    private String bsyq;    //部署要求
    private String configure;      //配置
    private String num;         //数量
    private String unit;      //单位
    private String dj;      //单价
    private String zj;      //总价
    private String wb;      //维保
    private String remark;      //备注
    private String yt;//用途
    private String ms;//描述
    private String location;//部署位置

}
