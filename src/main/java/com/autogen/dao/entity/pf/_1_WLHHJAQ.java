package com.autogen.dao.entity.pf;

import java.util.ArrayList;

//1-物理和环境安全
public class _1_WLHHJAQ {
    public String cpdx;                 //测评对象
    public String[] sfjb;             //身份鉴别
    public String[] dzmjjlsjdccwzx;     //电子门禁记录数据的存储完整性
    public String[] spjkjlsjdccwzx;     //视频监控记录数据的存储完整性

    public _1_WLHHJAQ() {
    }

    public _1_WLHHJAQ(String cpdx, String[] sfjb, String[] dzmjjlsjdccwzx, String[] spjkjlsjdccwzx) {
        this.cpdx = cpdx;
        this.sfjb = sfjb;
        this.dzmjjlsjdccwzx = dzmjjlsjdccwzx;
        this.spjkjlsjdccwzx = spjkjlsjdccwzx;
    }
    public String[] getDAKListByOrder(){
        String[] str = new String[9];
        for(int i = 0;i<3;i++){
            str[i] = this.sfjb[i];
            str[3+i] = this.dzmjjlsjdccwzx[i];
            str[6+i] = this.spjkjlsjdccwzx[i];
        }
        return str;
    }
    public int[] bsyRes(String[] sfjb, String[] dzmjjlsjdccwzx, String[] spjkjlsjdccwzx){
        int[] res = new int[3];
        for(int i = 0;i < 3;i++){
            res[i] = 1;
        }
        if(sfjb[0].equals("/")){
            res[0] = 0;
        }
        if(dzmjjlsjdccwzx[0].equals("/")){
            res[1] = 0;
        }
        if(spjkjlsjdccwzx[0].equals("/")){
            res[2] = 0;
        }

        return res;
    }
}
