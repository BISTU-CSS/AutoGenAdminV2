package com.autogen.dao.entity.pf;

//2-网络和通信安全
public class _2_WLHTXAQ {
    public String cpdx;                 //测评对象
    public String[] sfjb;               //身份鉴别
    public String[] txsjwzx;            //通信数据完整性
    public String[] txgczzysjdjmx;      //通信过程中重要数据的机密性
    public String[] wlbjfwkzxxdwzx;     //网络边界访问控制信息的完整性
    public String[] aqjrrz;             //安全接入认证

    public _2_WLHTXAQ() {
    }

    public _2_WLHTXAQ(String cpdx, String[] sfjb, String[] txsjwzx, String[] txgczzysjdjmx, String[] wlbjfwkzxxdwzx, String[] aqjrrz) {
        this.cpdx = cpdx;
        this.sfjb = sfjb;
        this.txsjwzx = txsjwzx;
        this.txgczzysjdjmx = txgczzysjdjmx;
        this.wlbjfwkzxxdwzx = wlbjfwkzxxdwzx;
        this.aqjrrz = aqjrrz;
    }
    //不适用判断
    public int[] bsyRes(String[] sfjb, String[] txsjwzx, String[] txgczzysjdjmx, String[] wlbjfwkzxxdwzx, String[] aqjrrz){
        int[] res = new int[5];
        for(int i = 0;i < 5;i++){
            res[i] = 1;
        }
        if(sfjb[0].equals("/")){
            res[0] = 0;
        }
        if(txsjwzx[0].equals("/")){
            res[1] = 0;
        }
        if(txgczzysjdjmx[0].equals("/")){
            res[2] = 0;
        }
        if(wlbjfwkzxxdwzx[0].equals("/")){
            res[3] = 0;
        }
        if(aqjrrz[0].equals("/")){
            res[4] = 0;
        }
        return res;
    }
}
