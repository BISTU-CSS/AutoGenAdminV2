package com.autogen;

import com.autogen.dao.entity.CPDXData;
import com.autogen.dao.entity.ZBData;
import com.autogen.service.fileapi.IOManager;
import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.data.*;
import com.deepoove.poi.data.style.CellStyle;
import com.deepoove.poi.data.style.RowStyle;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class ApplicationTests {

    @Test
    public void test1() throws IOException {
        String path = "D:\\IDEA\\AutoGen\\src\\main\\resources\\WordTemplate\\";
        XWPFDocument doc = IOManager.readFile(path + "aaa.docx");
        XWPFTemplate template = XWPFTemplate.compile(doc).render(
                new HashMap<String, Object>() {{
                    put("title", "Hi, poi-tl Word模板引擎");
                    RowRenderData row0 = Rows.of("层面", "测评对象", "测评对象", "测评指标").center().bgColor("4472C4").create();
                    RowRenderData row1 = Rows.of("没有数据", null, null, null).center().create();
                    RowRenderData row2 = Rows.of("物理和环境安全", "机房一", "身份鉴别", "描述").center().create();
                    RowRenderData row3 = Rows.of(null, null, "电子门禁", "描述").center().create();
                    RowRenderData row4 = Rows.of(null, null, "视频监控", "描述").center().create();
                    RowRenderData row5 = Rows.of(null, "机房二", "身份鉴别", "描述").center().create();
                    RowRenderData row6 = Rows.of(null, null, "电子门禁", "描述").center().create();
                    RowRenderData row7 = Rows.of(null, null, "视频监控", "描述").center().create();
                    MergeCellRule rule = MergeCellRule.builder()
                            .map(MergeCellRule.Grid.of(1, 0), MergeCellRule.Grid.of(1, 2))
                            .map(MergeCellRule.Grid.of(2, 0), MergeCellRule.Grid.of(7, 0))
                            .map(MergeCellRule.Grid.of(2, 1), MergeCellRule.Grid.of(4, 1))
                            .map(MergeCellRule.Grid.of(5, 1), MergeCellRule.Grid.of(7, 1))
                            .build();
                    put("table", Tables.of(row0, row1, row2, row3, row4, row5, row6, row7).mergeRule(rule).create());

                }});
        IOManager.writeFile(template.getXWPFDocument(), "bbb.docx");
    }

    ;

    @Test
    public void test2() throws IOException {
        String path = "D:\\IDEA\\AutoGen\\src\\main\\resources\\WordTemplate\\";
        XWPFDocument doc = IOManager.readFile(path + "aaa.docx");

        List<CPDXData> cpdxDataList = new ArrayList<>();
        CPDXData cpdxData = new CPDXData();
        cpdxData.setIndex(1);
        cpdxData.setName("机房一");
        String str = "身份鉴别描述";
        TextRenderData textRenderData = new TextRenderData("身份鉴别" + str);
        str = "电子门禁描述";
        TextRenderData textRenderData2 = new TextRenderData("电子门禁记录" + str);
        System.out.println(textRenderData);
        cpdxData.setDescription(Numberings.of(textRenderData, textRenderData2).create());
        cpdxDataList.add(cpdxData);
        cpdxData.setIndex(2);
        cpdxData.setName("机房二");
        cpdxDataList.add(cpdxData);
        ZBData zbData = new ZBData();
//        zbData.setWlhtxRiskList(cpdxDataList);



        System.out.println(cpdxDataList);
        System.out.println(zbData);

        XWPFTemplate template = XWPFTemplate.compile(doc).render(zbData);
        IOManager.writeFile(template.getXWPFDocument(), "bbb.docx");
    }

    @Test
    public void test3(){
        String s1="Programming";
        String s2= new String("Programming");
        String s3="Program";
        String s4="ming";
        String s5="program” +“ming";
        String s6= s3+s4;
        System.out.println(s1==s2);
        System.out.println(s1==s5);
        System.out.println(s1==s6);
    }


}
