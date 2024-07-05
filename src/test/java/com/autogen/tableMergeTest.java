package com.autogen;

import com.autogen.pojo.TableTest;
import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;
import com.deepoove.poi.data.*;
import com.deepoove.poi.plugin.table.LoopRowTableRenderPolicy;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.junit.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVMerge;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STMerge;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * ClassName: tableMergeTest
 * Package: com.autogen
 * Description:
 *
 * @Author 周钰尧
 * @Create 2024/6/25 11:13
 * @Version 1.0
 */
@SpringBootTest
public class tableMergeTest {
    @Test
    public void test() throws IOException {
        LoopRowTableRenderPolicy policy1 = new LoopRowTableRenderPolicy();
        Configure config = Configure.builder()
                .bind("tableTest",policy1).build();
        ArrayList<TableTest> arrayList = new ArrayList<>();
        arrayList.add(new TableTest("[index]","[yymc]", "[lb]","[jtbhdx]","[aqxq]"));
        arrayList.add(new TableTest("1","*****系统", "应用用户","系统管理员","真实性"));
        arrayList.add(new TableTest("","","","****员","真实性"));
        arrayList.add(new TableTest("","","","****员","真实性"));
        arrayList.add(new TableTest("","","重要数据","鉴别数据","☑传输机密性\n"+"☑传输完整性\n"+"☑存储机密性\n" +"☑存储完整性"));
        arrayList.add(new TableTest("","","","业务数据（****）","□传输机密性\n"+"☑传输完整性\n"+"☑存储机密性\n"+"☑存储完整性"));
        arrayList.add(new TableTest("","","","日志数据（用户登录、退出、操作日志等）","□传输机密性\n"+"□传输完整性\n"+"□存储机密性\n"+"☑存储完整性"));
        arrayList.add(new TableTest("","","关键操作","****行为","不可否认性"));
        arrayList.add(new TableTest("","","","****行为","不可否认性"));
        /*List<RowRenderData> rows = new ArrayList<>();
        rows.add(Rows.create("","*****系统", "应用用户","系统管理员","真实性"));
        rows.add(Rows.create("","","","****员","真实性"));
        rows.add(Rows.create("","","","****员","真实性"));
        rows.add(Rows.create("","","重要数据","鉴别数据","R传输机密性\n"+"R传输完整性\n"+"R存储机密性\n" +"R存储完整性\n"));
        rows.add(Rows.create("","","","业务数据（****）","£传输机密性\n"+"R传输完整性\n"+"R存储机密性\n"+"R存储完整性\n"));
        rows.add(Rows.create("","","","日志数据（用户登录、退出、操作日志等）","£传输机密性\n"+"£传输完整性\n"+"£存储机密性\n"+"R存储完整性\n"));
        rows.add(Rows.create("","","关键操作","****行为","不可否认性"));
        rows.add(Rows.create("","","","****行为","不可否认性"));*/


        /*TableRenderData tableRenderData = Tables
                .of(rows.get(0), rows.get(1), rows.get(1), rows.get(3), rows.get(4), rows.get(5), rows.get(6), rows.get(7))
                .mergeRule(rule).create();*/
        XWPFTemplate template = XWPFTemplate
                .compile(tableMergeTest.class.getClassLoader().getResource("WordTemplate/2.docx").getFile(),config)
                .render(new HashMap<String, Object>() {{
                    put("tableTest",arrayList);
                }});
        template.writeToFile("tableTest.docx");
        FileInputStream in = new FileInputStream("tableTest.docx");
        XWPFDocument document = new XWPFDocument(in);

        // 获取文档中的第一个表格
        XWPFTable table = document.getTables().get(3);

        // 合并第一列的第一个单元格到第四个单元格
        mergeCellsVertically(table, 0, 2, 9);
        mergeCellsVertically(table, 1, 2, 9);
        mergeCellsVertically(table, 2, 2, 4);
        mergeCellsVertically(table, 2, 5, 7);
        mergeCellsVertically(table, 2, 8, 9);
        /*MergeCellRule rule = MergeCellRule.builder()
                .map(MergeCellRule.Grid.of(1, 0), MergeCellRule.Grid.of(8, 0))
                .map(MergeCellRule.Grid.of(1, 1), MergeCellRule.Grid.of(8, 1))
                .map(MergeCellRule.Grid.of(1, 2), MergeCellRule.Grid.of(3, 2))
                .map(MergeCellRule.Grid.of(4, 2), MergeCellRule.Grid.of(6, 2))
                .map(MergeCellRule.Grid.of(7, 2), MergeCellRule.Grid.of(8, 2))
                .build();*/

        // 保存修改后的文档
        FileOutputStream out = new FileOutputStream("tableTest.docx");
        document.write(out);
        out.close();
        document.close();
        in.close();
    }

    public static void mergeCellsVertically(XWPFTable table, int col, int fromRow, int toRow) {
        for (int rowIndex = fromRow; rowIndex <= toRow; rowIndex++) {
            XWPFTableCell cell = table.getRow(rowIndex).getCell(col);
            CTVMerge vmerge = CTVMerge.Factory.newInstance();
            if (rowIndex == fromRow) {
                // 设置为重启合并
                vmerge.setVal(STMerge.RESTART);
            } else {
                // 设置为继续合并
                vmerge.setVal(STMerge.CONTINUE);
            }
            // 应用合并设置
            cell.getCTTc().addNewTcPr().setVMerge(vmerge);
        }
    }
}
