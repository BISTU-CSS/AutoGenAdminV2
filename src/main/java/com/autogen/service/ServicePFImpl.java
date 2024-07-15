package com.autogen.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.autogen.dao.Mapper.DeviceMapper;
import com.autogen.dao.Mapper.InformationMapper;
import com.autogen.dao.Mapper.ScenceMapper;
import com.autogen.dao.entity.Information;
import com.autogen.dao.entity.ScencePo;
import com.autogen.dao.entity.input.Sbhjs;
import com.autogen.dao.entity.input.Wlhhj;
import com.autogen.dao.entity.input.Wlhtx;
import com.autogen.dao.entity.input.Yyhsj;
import com.autogen.dao.entity.pf._1_WLHHJAQ;
import com.autogen.dao.entity.pf._2_WLHTXAQ;
import com.autogen.dao.entity.pf._3_SBHJSAQ;
import com.autogen.dao.entity.pf._4_YYHSJAQ;
import com.autogen.service.atgInterface.AutoGeneratorImpl;
import com.autogen.util.Convert;
import com.autogen.util.ExcelInfoUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.spire.xls.ExcelVersion;
import com.spire.xls.Workbook;
import com.spire.xls.Worksheet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
@Service
@Slf4j
public class ServicePFImpl implements ServicePF{
    static double  getDAKScore(String []dak){//获取dak分数
        if(dak[0].equals("/")){
            return 0;
        }
        int count =0;
        for(int i =1;i<3;i++){
            if(dak[i].equals("√")){
                count++;
            }
        }
        return  dak[0].equals("×")?0:0.25*(1<<count);
    }
    @Autowired
    ScenceMapper scenceMapper;
    @Autowired
    DeviceMapper deviceMapper;
    @Autowired
    InformationMapper informationMapper;

    @Override
    public List<_1_WLHHJAQ> getWlhhjData(List<Wlhhj> wlhhjlist) {
        List<_1_WLHHJAQ> list = new ArrayList<>();

        for(int i = 0;i<wlhhjlist.size();++i){
            String[] sfjb =  Convert.ConvertStateToScoreStr(scenceMapper.selectOne(new QueryWrapper<ScencePo>().eq("scence",wlhhjlist.get(i).getWlhhj_sfjb())).getCpzb());
            String[] dzmj =  Convert.ConvertStateToScoreStr(scenceMapper.selectOne(new QueryWrapper<ScencePo>().eq("scence",wlhhjlist.get(i).getWlhhj_dzmj())).getCpzb());
            String[] spjk =  Convert.ConvertStateToScoreStr(scenceMapper.selectOne(new QueryWrapper<ScencePo>().eq("scence",wlhhjlist.get(i).getWlhhj_spjk())).getCpzb());
            _1_WLHHJAQ wlhhj = new _1_WLHHJAQ(wlhhjlist.get(i).getWlhhj_jfmc(),sfjb,dzmj,spjk);
            list.add(wlhhj);
        }
        return list;
    }

    @Override
    public List<_2_WLHTXAQ> getWlhtxData(List<Wlhtx> wlhtxList) {
        List<_2_WLHTXAQ> list = new ArrayList<>();
        for(int i = 0;i<wlhtxList.size();++i){


            String[] sfjb = Convert.ConvertStateToScoreStr(scenceMapper.selectOne(new QueryWrapper<ScencePo>().eq("scence",wlhtxList.get(i).getWlhtx_xd().get(0))).getCpzb());
            String[] txsjwzx = Convert.ConvertStateToScoreStr(scenceMapper.selectOne(new QueryWrapper<ScencePo>().eq("scence",wlhtxList.get(i).getWlhtx_xd().get(1))).getCpzb());
            String[] txgcjmx = Convert.ConvertStateToScoreStr(scenceMapper.selectOne(new QueryWrapper<ScencePo>().eq("scence",wlhtxList.get(i).getWlhtx_xd().get(2))).getCpzb());
            String[] wlbjfwkzxxwzx = Convert.ConvertStateToScoreStr(scenceMapper.selectOne(new QueryWrapper<ScencePo>().eq("scence",wlhtxList.get(i).getWlhtx_xd().get(3))).getCpzb());
            String[] aqjrrz = Convert.ConvertStateToScoreStr(scenceMapper.selectOne(new QueryWrapper<ScencePo>().eq("scence",wlhtxList.get(i).getWlhtx_xd().get(4))).getCpzb());
            _2_WLHTXAQ wlhtx = new _2_WLHTXAQ(wlhtxList.get(i).getWlhtx_xdmc(),sfjb,txsjwzx,txgcjmx,wlbjfwkzxxwzx,aqjrrz);
            list.add(wlhtx);
        }
        return list;
    }

    @Override
    public List<_3_SBHJSAQ> getSbhjsData(List<Sbhjs> sbhjsList) {
        List<_3_SBHJSAQ> list = new ArrayList<>();
        for(int i = 0;i<sbhjsList.size();++i){
            String[] sfjb = Convert.ConvertStateToScoreStr(scenceMapper.selectOne(new QueryWrapper<ScencePo>().eq("scence",sbhjsList.get(i).getSbhjs_sfjb())).getCpzb());
            String[] ycgltdaq = Convert.ConvertStateToScoreStr(scenceMapper.selectOne(new QueryWrapper<ScencePo>().eq("scence",sbhjsList.get(i).getSbhjs_ycgl())).getCpzb());
            String[] xtzyfwkzxxwzx = Convert.ConvertStateToScoreStr(scenceMapper.selectOne(new QueryWrapper<ScencePo>().eq("scence",sbhjsList.get(i).getSbhjs_xtzy())).getCpzb());
            String[] zyxxzyaqbjwzx = Convert.ConvertStateToScoreStr(scenceMapper.selectOne(new QueryWrapper<ScencePo>().eq("scence",sbhjsList.get(i).getSbhjs_zyxx())).getCpzb());
            String[] rzjlwzx = Convert.ConvertStateToScoreStr(scenceMapper.selectOne(new QueryWrapper<ScencePo>().eq("scence",sbhjsList.get(i).getSbhjs_rzjl())).getCpzb());
            String[] zykzxcx = Convert.ConvertStateToScoreStr(scenceMapper.selectOne(new QueryWrapper<ScencePo>().eq("scence",sbhjsList.get(i).getSbhjs_zykz())).getCpzb());
            _3_SBHJSAQ sbhjs = new _3_SBHJSAQ(sbhjsList.get(i).getSbhjs_sbmc(),sfjb,ycgltdaq,xtzyfwkzxxwzx,zyxxzyaqbjwzx,rzjlwzx,zykzxcx);
            list.add(sbhjs);
        }
        return list;
    }

    @Override
    public List<_4_YYHSJAQ> getYyhsjData(List<Yyhsj> yyhsjList) {
        List<_4_YYHSJAQ> list = new ArrayList<>();

        for (int i = 0;i<yyhsjList.size();++i){
            String[] sfjb = Convert.ConvertStateToScoreStr(scenceMapper.selectOne(new QueryWrapper<ScencePo>().eq("scence",yyhsjList.get(i).getYyhsj_sfjb().get(0))).getCpzb());
            String[] fwkz = Convert.ConvertStateToScoreStr(scenceMapper.selectOne(new QueryWrapper<ScencePo>().eq("scence",yyhsjList.get(i).getYyhsj_fwkz())).getCpzb());
            String[] xxzy = Convert.ConvertStateToScoreStr(scenceMapper.selectOne(new QueryWrapper<ScencePo>().eq("scence",yyhsjList.get(i).getYyhsj_xxzy())).getCpzb());;
            String[] csjmx = Convert.ConvertStateToScoreStr(scenceMapper.selectOne(new QueryWrapper<ScencePo>().eq("scence",yyhsjList.get(i).getYyhsj_csjmx())).getCpzb());;
            String[] ccjmx = Convert.ConvertStateToScoreStr(scenceMapper.selectOne(new QueryWrapper<ScencePo>().eq("scence",yyhsjList.get(i).getYyhsj_ccjmx())).getCpzb());;
            String[] cswzx = Convert.ConvertStateToScoreStr(scenceMapper.selectOne(new QueryWrapper<ScencePo>().eq("scence",yyhsjList.get(i).getYyhsj_cswzx())).getCpzb());;
            String[] ccwzx = Convert.ConvertStateToScoreStr(scenceMapper.selectOne(new QueryWrapper<ScencePo>().eq("scence",yyhsjList.get(i).getYyhsj_ccwzx())).getCpzb());;
            String[] bkfr = Convert.ConvertStateToScoreStr(scenceMapper.selectOne(new QueryWrapper<ScencePo>().eq("scence",yyhsjList.get(i).getYyhsj_bkfr())).getCpzb());;
            _4_YYHSJAQ yyhsj = new _4_YYHSJAQ(yyhsjList.get(i).getYyhsj_ywmc(),sfjb,fwkz,xxzy,csjmx,ccjmx,cswzx,ccwzx,bkfr);
            list.add(yyhsj);
        }

        return list;
    }

    @Override
    public void genExcel(List<_1_WLHHJAQ> wlhhj, List<_2_WLHTXAQ> wlhtx, List<_3_SBHJSAQ> sbhjs, List<_4_YYHSJAQ> yyhsj,String dbjb) {
        //1.获取文件中的相关信息
        Workbook workbook = new Workbook();

        String result = null;
        ClassLoader classLoader = AutoGeneratorImpl.class.getClassLoader();
        URL resourceURL = classLoader.getResource("WordTemplate");
        try {
            result = new File(resourceURL.toURI()).getParent() + "\\";
        }catch (Exception e){
            e.printStackTrace();
        }
        workbook.loadFromFile(result + "MergeCells.xlsx");
        Worksheet worksheet = workbook.getWorksheets().get(0);
        //设置等保级别
        if (dbjb.equals("0")){
            worksheet.getRange().get("D1").setText("第一级");
            worksheet.getRange().get("D7").setText("第一级");
            worksheet.getRange().get("D15").setText("第一级");
            worksheet.getRange().get("D24").setText("第一级");
        } else if (dbjb.equals("1")) {
            worksheet.getRange().get("D1").setText("第二级");
            worksheet.getRange().get("D7").setText("第二级");
            worksheet.getRange().get("D15").setText("第二级");
            worksheet.getRange().get("D24").setText("第二级");
        } else if (dbjb.equals("2")) {
            worksheet.getRange().get("D1").setText("第三级");
            worksheet.getRange().get("D7").setText("第三级");
            worksheet.getRange().get("D15").setText("第三级");
            worksheet.getRange().get("D24").setText("第三级");
        } else if (dbjb.equals("3")) {
            worksheet.getRange().get("D1").setText("第四级");
            worksheet.getRange().get("D7").setText("第四级");
            worksheet.getRange().get("D15").setText("第四级");
            worksheet.getRange().get("D24").setText("第四级");
        }
        //物理表格
        for(int i = 0;i<wlhhj.size();i++){
            worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+4]+"2").setText(wlhhj.get(i).cpdx);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+4]+"4").setText(wlhhj.get(i).sfjb[0]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+5]+"4").setText(wlhhj.get(i).sfjb[1]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+6]+"4").setText(wlhhj.get(i).sfjb[2]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+4]+"5").setText(wlhhj.get(i).dzmjjlsjdccwzx[0]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+5]+"5").setText(wlhhj.get(i).dzmjjlsjdccwzx[1]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+6]+"5").setText(wlhhj.get(i).dzmjjlsjdccwzx[2]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+4]+"6").setText(wlhhj.get(i).spjkjlsjdccwzx[0]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+5]+"6").setText(wlhhj.get(i).spjkjlsjdccwzx[1]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+6]+"6").setText(wlhhj.get(i).spjkjlsjdccwzx[2]);
        }
        //网络表格
        for(int i = 0; i < wlhtx.size(); ++i){
            worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+4]+"8").setText(wlhtx.get(i).cpdx);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+4]+"10").setText(wlhtx.get(i).sfjb[0]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+5]+"10").setText(wlhtx.get(i).sfjb[1]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+6]+"10").setText(wlhtx.get(i).sfjb[2]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+4]+"11").setText(wlhtx.get(i).txsjwzx[0]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+5]+"11").setText(wlhtx.get(i).txsjwzx[1]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+6]+"11").setText(wlhtx.get(i).txsjwzx[2]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+4]+"12").setText(wlhtx.get(i).txgczzysjdjmx[0]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+5]+"12").setText(wlhtx.get(i).txgczzysjdjmx[1]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+6]+"12").setText(wlhtx.get(i).txgczzysjdjmx[2]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+4]+"13").setText(wlhtx.get(i).wlbjfwkzxxdwzx[0]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+5]+"13").setText(wlhtx.get(i).wlbjfwkzxxdwzx[1]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+6]+"13").setText(wlhtx.get(i).wlbjfwkzxxdwzx[2]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+4]+"14").setText(wlhtx.get(i).aqjrrz[0]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+5]+"14").setText(wlhtx.get(i).aqjrrz[1]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+6]+"14").setText(wlhtx.get(i).aqjrrz[2]);
        }
        //设备
        for(int i = 0; i < sbhjs.size(); ++i){
            worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+4]+"16").setText(sbhjs.get(i).cpdx);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+4]+"18").setText(sbhjs.get(i).sfjb[0]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+5]+"18").setText(sbhjs.get(i).sfjb[1]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+6]+"18").setText(sbhjs.get(i).sfjb[2]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+4]+"19").setText(sbhjs.get(i).ycgltdaq[0]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+5]+"19").setText(sbhjs.get(i).ycgltdaq[1]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+6]+"19").setText(sbhjs.get(i).ycgltdaq[2]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+4]+"20").setText(sbhjs.get(i).xtzyfwkzxxwzx[0]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+5]+"20").setText(sbhjs.get(i).xtzyfwkzxxwzx[1]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+6]+"20").setText(sbhjs.get(i).xtzyfwkzxxwzx[2]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+4]+"21").setText(sbhjs.get(i).zyxxzyaqbjwzx[0]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+5]+"21").setText(sbhjs.get(i).zyxxzyaqbjwzx[1]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+6]+"21").setText(sbhjs.get(i).zyxxzyaqbjwzx[2]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+4]+"22").setText(sbhjs.get(i).rzjlwzx[0]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+5]+"22").setText(sbhjs.get(i).rzjlwzx[1]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+6]+"22").setText(sbhjs.get(i).rzjlwzx[2]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+4]+"23").setText(sbhjs.get(i).zykzxcx[0]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+5]+"23").setText(sbhjs.get(i).zykzxcx[1]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+6]+"23").setText(sbhjs.get(i).zykzxcx[2]);
        }
        //应用
        //设备
        for(int i = 0; i < yyhsj.size(); ++i){
            worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+4]+"25").setText(yyhsj.get(i).cpdx);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+4]+"27").setText(yyhsj.get(i).sfjb[0]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+5]+"27").setText(yyhsj.get(i).sfjb[1]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+6]+"27").setText(yyhsj.get(i).sfjb[2]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+4]+"28").setText(yyhsj.get(i).fwkzxxwzx[0]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+5]+"28").setText(yyhsj.get(i).fwkzxxwzx[1]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+6]+"28").setText(yyhsj.get(i).fwkzxxwzx[2]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+4]+"29").setText(yyhsj.get(i).zyxxzyaqbjwzx[0]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+5]+"29").setText(yyhsj.get(i).zyxxzyaqbjwzx[1]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+6]+"29").setText(yyhsj.get(i).zyxxzyaqbjwzx[2]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+4]+"30").setText(yyhsj.get(i).zysjcsjmx[0]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+5]+"30").setText(yyhsj.get(i).zysjcsjmx[1]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+6]+"30").setText(yyhsj.get(i).zysjcsjmx[2]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+4]+"31").setText(yyhsj.get(i).zysjccjmx[0]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+5]+"31").setText(yyhsj.get(i).zysjccjmx[1]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+6]+"31").setText(yyhsj.get(i).zysjccjmx[2]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+4]+"32").setText(yyhsj.get(i).zysjcswzx[0]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+5]+"32").setText(yyhsj.get(i).zysjcswzx[1]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+6]+"32").setText(yyhsj.get(i).zysjcswzx[2]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+4]+"33").setText(yyhsj.get(i).zysjccwzx[0]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+5]+"33").setText(yyhsj.get(i).zysjccwzx[1]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+6]+"33").setText(yyhsj.get(i).zysjccwzx[2]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+4]+"34").setText(yyhsj.get(i).bkfrx[0]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+5]+"34").setText(yyhsj.get(i).bkfrx[1]);
            worksheet.getRange().get( ExcelInfoUtil.COLUMN_RANGE_ARRAY[i*3+6]+"34").setText(yyhsj.get(i).bkfrx[2]);

        }

        workbook.saveToFile("pingfen.xlsx", ExcelVersion.Version2016);
    }

    @Override
    public JSONObject getJSONData(String sysname) {
        Information information = informationMapper.selectOne(new QueryWrapper<Information>().eq("xmmc",sysname));
        String json = "{\"data\":"+information.getData() + "}";
        return JSONObject.parseObject(json);
    }

    @Override
    public double[] gen_PF(String name) {
        //1.获取文件中的相关信息
        Workbook workbook = new Workbook();
//
        workbook.loadFromFile(name);
        Worksheet worksheet = workbook.getWorksheets().get(0);
        //目前计算等级三的分数
        //获取等保级别
        String dbjb = worksheet.getRange().get("D1").getText();
        //默认为3级
        int dbjbIdex = 2;
        if(dbjb.equals("第一级")){
            dbjbIdex =0;
        } else if (dbjb.equals("第二级")) {
            dbjbIdex =1;
        } else if (dbjb.equals("第三级")) {
            dbjbIdex =2;
        } else if (dbjb.equals("第四级")) {
            dbjbIdex =3;
        }

        //物理层面计算分数

        //存储不同密评等级的物理环境层面的测评单元的权值
        double []wlhhjWeigth3 =  ExcelInfoUtil.CPZB_weight_ARRAY[dbjbIdex][0];
        int cpdxCount = 0;
        //获取测评对象个数，i=4从e开始取
        for(int i = 4; !(worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[i]+"2").getText().isEmpty()); i=i+3){
            cpdxCount++;
        }
        List<_1_WLHHJAQ> wlhhjList = new ArrayList<>();
        double sfjbScore=0;
        double dzmjwzxScore=0;
        double spjkjlwzxScore=0;

        //按照测评对象取数据
        //每次循环取一个对象
        for(int i=0;i<cpdxCount;++i){
            int target = 3*i+4;
            //读取excel数据
            String cpdxName = worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target]+"2").getText();
            String []sfjb = new String[]{worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target]+"4").getNumberText(),worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target+1]+"4").getNumberText(),worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target+2]+"4").getNumberText()};
            String []dzmjwzx = new String[]{worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target]+"5").getNumberText(),worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target+1]+"5").getNumberText(),worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target+2]+"5").getNumberText()};
            String []spjkjlwzx = new String[]{worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target]+"6").getNumberText(),worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target+1]+"6").getNumberText(),worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target+2]+"6").getNumberText()};
            _1_WLHHJAQ wlhhj = new _1_WLHHJAQ(cpdxName,sfjb,dzmjwzx,spjkjlwzx);
            //计算每个测评指标的dak分数 得到S（i,j,k）的分值并累加
            sfjbScore +=getDAKScore(sfjb);
            dzmjwzxScore += getDAKScore(dzmjwzx);
            spjkjlwzxScore += getDAKScore(spjkjlwzx);
            wlhhjList.add(wlhhj);
            int[] res=wlhhj.bsyRes(sfjb,dzmjwzx,spjkjlwzx);
            for(int j = 0;j<3;j++){
                if(res[j]==0){
                    wlhhjWeigth3[j] = 0;
                }
            }

        }
        //将S（i,j,k）的分值累加结果除以测评对象个数算出Si，j
        sfjbScore/=cpdxCount;
        dzmjwzxScore/=cpdxCount;
        spjkjlwzxScore/=cpdxCount;
        double []wlhhjCpzbScore = {sfjbScore,dzmjwzxScore,spjkjlwzxScore};
        double wlhhjScore =0;
        double weight = 0;

        //根据权值计算物理层面总分
        for(int i =0;i<wlhhjWeigth3.length;i++){
            wlhhjScore= wlhhjCpzbScore[i]*wlhhjWeigth3[i]+wlhhjScore;
            weight += wlhhjWeigth3[i];
        }
        //物理和环境层面的分数
        wlhhjScore = wlhhjScore/weight*10;


        //网络层面计算分数

        //权重值
        double []wlhtxWeigth3 =  ExcelInfoUtil.CPZB_weight_ARRAY[dbjbIdex][1];
        cpdxCount = 0;
        //获取测评对象个数，i=4从e开始取
        for(int i = 4; !(worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[i]+"8").getText().isEmpty()); i=i+3){
            cpdxCount++;
        }

        List<_2_WLHTXAQ> wlhtxList = new ArrayList<>();
        double wlSfjbScore = 0;
        double wlTxsjwzxScore = 0;
        double wlTxjmxScore = 0;
        double wlFfkzxxwzxScore = 0;
        double wlAqjrrzScore = 0;
        //按照测评对象取数据
        //每次循环取一个对象
        for(int i=0;i<cpdxCount;++i){
            int target = 3*i+4;
            //读取excel数据
            String cpdxName = worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target]+"8").getText();
            String []Sfjb = new String[]{worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target]+"10").getNumberText(),worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target+1]+"10").getNumberText(),worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target+2]+"10").getNumberText()};
            String []Txsjwzx = new String[]{worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target]+"11").getNumberText(),worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target+1]+"11").getNumberText(),worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target+2]+"11").getNumberText()};
            String []Txjmx = new String[]{worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target]+"12").getNumberText(),worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target+1]+"12").getNumberText(),worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target+2]+"12").getNumberText()};
            String []Ffkzxxwzx = new String[]{worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target]+"13").getNumberText(),worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target+1]+"13").getNumberText(),worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target+2]+"13").getNumberText()};;
            String []Aqjrrz = new String[]{worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target]+"14").getNumberText(),worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target+1]+"14").getNumberText(),worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target+2]+"14").getNumberText()};;

            _2_WLHTXAQ wlhtx = new _2_WLHTXAQ(cpdxName,Sfjb,Txsjwzx,Txjmx,Ffkzxxwzx,Aqjrrz);
            //计算每个测评指标的dak分数 得到S（i,j,k）的分值并累加
            wlSfjbScore +=getDAKScore(Sfjb);
            wlTxsjwzxScore += getDAKScore(Txsjwzx);
            wlTxjmxScore += getDAKScore(Txjmx);
            wlFfkzxxwzxScore += getDAKScore(Ffkzxxwzx);
            wlAqjrrzScore += getDAKScore(Aqjrrz);
            wlhtxList.add(wlhtx);
            //检查不适用的测评指标，将权重置为0
            int[] res=wlhtx.bsyRes(Sfjb,Txsjwzx,Txjmx,Ffkzxxwzx,Aqjrrz);
            for(int j = 0;j<5;j++){
                if(res[j]==0){
                    wlhtxWeigth3[j] = 0;
                }
            }

        }
        //将S（i,j,k）的分值累加结果除以测评对象个数算出Si，j
        wlSfjbScore/=cpdxCount;
        wlTxsjwzxScore/=cpdxCount;
        wlTxjmxScore/=cpdxCount;
        wlFfkzxxwzxScore/=cpdxCount;
        wlAqjrrzScore/=cpdxCount;


        double []wlhtxCpzbScore = {wlSfjbScore,wlTxsjwzxScore,wlTxjmxScore,wlFfkzxxwzxScore,wlAqjrrzScore};
        double wlhtxScore =0;
        weight = 0;
        //存储不同密评等级的网络层面的测评单元的权值


        //根据权值计算网络层面总分

        for(int i =0;i<wlhtxWeigth3.length;i++){
            wlhtxScore= wlhtxCpzbScore[i]*wlhtxWeigth3[i]+wlhtxScore;
            weight += wlhtxWeigth3[i];
        }
        //网络和通信层面的分数
        wlhtxScore = wlhtxScore/weight*20;



        //设备层面计算分数
        cpdxCount = 0;

        //存储不同密评等级的设备层面的测评单元的权值
        double []sbhjsWeigth3 =  ExcelInfoUtil.CPZB_weight_ARRAY[dbjbIdex][2];
        //获取测评对象个数，i=4从e开始取
        for(int i = 4; !(worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[i]+"16").getText().isEmpty()); i=i+3){
            cpdxCount++;
        }
        List<_3_SBHJSAQ> sbhjsList = new ArrayList<>();
        double sbSfjbScore = 0;
        double sbYcgltdScore = 0;
        double sbFfkzxxwzxScore = 0;
        double sbZyxxzyaqbjScore = 0;
        double sbRzjlwzxScore = 0;
        double sbZzkzxcxScore = 0;
        //按照测评对象取数据
        //每次循环取一个对象
        for(int i=0;i<cpdxCount;++i){
            int target = 3*i+4;
            //读取excel数据
            String cpdxName = worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target]+"16").getText();
            String []Sfjb = new String[]{worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target]+"18").getNumberText(),worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target+1]+"18").getNumberText(),worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target+2]+"18").getNumberText()};
            String []Ycgltd = new String[]{worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target]+"19").getNumberText(),worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target+1]+"19").getNumberText(),worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target+2]+"19").getNumberText()};
            String []Ffkzxxwzx = new String[]{worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target]+"20").getNumberText(),worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target+1]+"20").getNumberText(),worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target+2]+"20").getNumberText()};
            String []Zyxxzyaqbj = new String[]{worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target]+"21").getNumberText(),worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target+1]+"21").getNumberText(),worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target+2]+"21").getNumberText()};;
            String []Rzjlwzx = new String[]{worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target]+"22").getNumberText(),worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target+1]+"22").getNumberText(),worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target+2]+"22").getNumberText()};;
            String []Zzkzxcx = new String[]{worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target]+"23").getNumberText(),worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target+1]+"23").getNumberText(),worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target+2]+"23").getNumberText()};;

            _3_SBHJSAQ sbhjs = new _3_SBHJSAQ(cpdxName,Sfjb,Ycgltd,Ffkzxxwzx,Zyxxzyaqbj,Rzjlwzx,Zzkzxcx);
            //计算每个测评指标的dak分数 得到S（i,j,k）的分值并累加
            sbSfjbScore +=getDAKScore(Sfjb);
            sbYcgltdScore += getDAKScore(Ycgltd);
            sbFfkzxxwzxScore += getDAKScore(Ffkzxxwzx);
            sbZyxxzyaqbjScore += getDAKScore(Zyxxzyaqbj);
            sbRzjlwzxScore += getDAKScore(Rzjlwzx);
            sbZzkzxcxScore += getDAKScore(Zzkzxcx);

            sbhjsList.add(sbhjs);
            int[] res=sbhjs.bsyRes(Sfjb,Ycgltd,Ffkzxxwzx,Zyxxzyaqbj,Rzjlwzx,Zzkzxcx);
            for(int j = 0;j<6;j++){
                if(res[j]==0){
                    sbhjsWeigth3[j] = 0;
                }
            }

        }
        //将S（i,j,k）的分值累加结果除以测评对象个数算出Si，j
        sbSfjbScore/=cpdxCount;
        sbYcgltdScore/=cpdxCount;
        sbFfkzxxwzxScore/=cpdxCount;
        sbZyxxzyaqbjScore/=cpdxCount;
        sbRzjlwzxScore/=cpdxCount;
        sbZzkzxcxScore/=cpdxCount;



        double []sbhjsCpzbScore = {sbSfjbScore,sbYcgltdScore,sbFfkzxxwzxScore,sbZyxxzyaqbjScore,sbRzjlwzxScore,sbZzkzxcxScore};
        double sbhjsScore =0;
        weight = 0;

        //根据权值计算设备层面总分
        for(int i =0;i<sbhjsWeigth3.length;i++){
            sbhjsScore= sbhjsCpzbScore[i]*sbhjsWeigth3[i]+sbhjsScore;
            weight += sbhjsWeigth3[i];
        }
        //设备层面的分数
        sbhjsScore = sbhjsScore/weight*10;



        //应用层面计算分数
        cpdxCount = 0;

        //存储不同密评等级的应用层面的测评单元的权值
        double []yyhsjWeigth3 =  ExcelInfoUtil.CPZB_weight_ARRAY[dbjbIdex][3];
        //获取测评对象个数，i=4从e开始取
        for(int i = 4; !(worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[i]+"25").getText().isEmpty()); i=i+3){
            cpdxCount++;
        }
        List<_4_YYHSJAQ> yyhsjList = new ArrayList<>();
        double yySfjbScore = 0;

        double yyFfkzxxwzxScore = 0;
        double yyzyxxzyaqbjScore = 0;

        double yycsjmxScore = 0;
        double yyccjmxScore = 0;
        double yycswzxScore = 0;
        double yyccwzxScore = 0;
        double yybkfrxScore = 0;

        //按照测评对象取数据
        //每次循环取一个对象
        for(int i=0;i<cpdxCount;++i){
            int target = 3*i+4;

            String cpdxName = worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target]+"25").getText();
            String []Sfjb = new String[]{worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target]+"27").getNumberText(),worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target+1]+"27").getNumberText(),worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target+2]+"27").getNumberText()};
            String []Ffkzxxwzx = new String[]{worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target]+"28").getNumberText(),worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target+1]+"28").getNumberText(),worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target+2]+"28").getNumberText()};
            String []zyxxzyaqbj = new String[]{worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target]+"29").getNumberText(),worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target+1]+"29").getNumberText(),worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target+2]+"29").getNumberText()};
            String []csjmx = new String[]{worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target]+"30").getNumberText(),worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target+1]+"30").getNumberText(),worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target+2]+"30").getNumberText()};;
            String []ccjmx = new String[]{worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target]+"31").getNumberText(),worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target+1]+"31").getNumberText(),worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target+2]+"31").getNumberText()};;
            String []cswzx = new String[]{worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target]+"32").getNumberText(),worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target+1]+"32").getNumberText(),worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target+2]+"32").getNumberText()};;
            String []ccwzx = new String[]{worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target]+"33").getNumberText(),worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target+1]+"33").getNumberText(),worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target+2]+"33").getNumberText()};;
            String []bkfrx = new String[]{worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target]+"34").getNumberText(),worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target+1]+"34").getNumberText(),worksheet.getRange().get(ExcelInfoUtil.COLUMN_RANGE_ARRAY[target+2]+"34").getNumberText()};;
            _4_YYHSJAQ yyhsj = new _4_YYHSJAQ(cpdxName,Sfjb,Ffkzxxwzx,zyxxzyaqbj,csjmx,ccjmx,cswzx,ccwzx,bkfrx);
            //计算每个测评指标的dak分数 得到S（i,j,k）的分值并累加
            yySfjbScore +=getDAKScore(Sfjb);
            yyFfkzxxwzxScore += getDAKScore(Ffkzxxwzx);
            yyzyxxzyaqbjScore += getDAKScore(zyxxzyaqbj);
            yycsjmxScore += getDAKScore(csjmx);
            yyccjmxScore += getDAKScore(ccjmx);
            yycswzxScore += getDAKScore(cswzx);
            yyccwzxScore += getDAKScore(ccwzx);
            yybkfrxScore += getDAKScore(bkfrx);

            yyhsjList.add(yyhsj);

            int[] res=yyhsj.bsyRes(Sfjb,Ffkzxxwzx,zyxxzyaqbj,csjmx,ccjmx,cswzx,ccwzx,bkfrx);
            for(int j = 0;j<8;j++){
                if(res[j]==0){
                    yyhsjWeigth3[j] = 0;
                }
            }

        }
        //将S（i,j,k）的分值累加结果除以测评对象个数算出Si，j
        yySfjbScore /=cpdxCount;
        yyFfkzxxwzxScore /=cpdxCount;
        yyzyxxzyaqbjScore /=cpdxCount;
        yycsjmxScore /=cpdxCount;
        yyccjmxScore /=cpdxCount;
        yycswzxScore /=cpdxCount;
        yyccwzxScore /=cpdxCount;
        yybkfrxScore /=cpdxCount;




        double []yyhsjCpzbScore = {yySfjbScore,yyFfkzxxwzxScore,yyzyxxzyaqbjScore,yycsjmxScore,yyccjmxScore,yycswzxScore,yyccwzxScore,yybkfrxScore};
        double yyhsjScore =0;
        weight = 0;


        //根据权值计算应用层面总分
        for(int i =0;i<yyhsjWeigth3.length;i++){
            yyhsjScore= yyhsjCpzbScore[i]*yyhsjWeigth3[i]+yyhsjScore;
            weight += yyhsjWeigth3[i];
        }

        //应用层面的分数
        yyhsjScore = yyhsjScore/weight*30;

        //double Score = wlhhjScore+wlhtxScore+sbhjsScore+yyhsjScore;
        //System.out.println(wlhhjScore+wlhtxScore+sbhjsScore+yyhsjScore);
        double[] score=new double[4];
        score[0]=wlhhjScore;
        score[1]=wlhtxScore;
        score[2]=sbhjsScore;
        score[3]=yyhsjScore;

        return score;
    }
}
