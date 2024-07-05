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
@TableName("user_info")
public class User {
    @TableId(value = "id",type =  IdType.AUTO)
    private int id;
    private String loginName;  //用户名
    private String userName;   //姓名
    private String password;   //口令
    private String authority;  //权限
    private String teacher;    //负责老师
}
