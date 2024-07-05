package com.autogen.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class SelectUserPage {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String loginName;
    private String userName;
    @JsonIgnore
    private String password;
    private String authority;
    private String teacher;
    private int count;
}

