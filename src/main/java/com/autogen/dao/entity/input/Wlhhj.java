package com.autogen.dao.entity.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Wlhhj {
    //物理和环境安全
    public String wlhhj_jfmc;       //机房名称
    public String wlhhj_sfjb;       //身份鉴别
    public String wlhhj_dzmj;       //电子门禁记录数据存储完整性
    public String wlhhj_spjk;       //视频监控记录数据存储完整性
}
