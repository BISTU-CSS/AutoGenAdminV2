package com.autogen.dao.entity;
//按文件名查询后返回list

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class SearchFileByName {
    private String path;
    private int size;
    private String mtime;
    private String type;

}
