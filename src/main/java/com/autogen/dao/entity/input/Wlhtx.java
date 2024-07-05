package com.autogen.dao.entity.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Wlhtx {
    public String wlhtx_xdmc;          //信道名称
    public List<String> wlhtx_xd;       //信道 （多选）

}
