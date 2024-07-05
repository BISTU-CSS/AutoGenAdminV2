package com.autogen.service.officeapi;

import com.autogen.dao.entity.Device;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ExportDevice {
    public static void exportExcel(List<Device> deviceList,String name) {
        // 1. 创建工作簿
        XSSFWorkbook workbook = new XSSFWorkbook();
        // 2. 创建工作表
        XSSFSheet sheet = workbook.createSheet("DeviceList");
        //列宽
        sheet.setColumnWidth(1, 18 * 256);
        sheet.setColumnWidth(4, 70 * 256);
        sheet.setColumnWidth(6, 25 * 256);
        sheet.setColumnWidth(7, 25 * 256);
        //style title 1
        XSSFCellStyle styleTitle1 = workbook.createCellStyle();
        styleTitle1.setAlignment(HorizontalAlignment.CENTER);
        styleTitle1.setBorderBottom(BorderStyle.THIN);
        styleTitle1.setBorderLeft(BorderStyle.THIN);
        styleTitle1.setBorderRight(BorderStyle.THIN);
        styleTitle1.setBorderTop(BorderStyle.THIN);
        XSSFFont fontTitle1 = workbook.createFont();
        fontTitle1.setFontName("黑体");
        fontTitle1.setFontHeightInPoints((short) 20);//设置字体大小
        fontTitle1.setBold(true);
        styleTitle1.setFont(fontTitle1);
        //style title 2
        XSSFCellStyle styleTitle2 = workbook.createCellStyle();
        styleTitle2.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        styleTitle2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        styleTitle2.setAlignment(HorizontalAlignment.CENTER);
        styleTitle2.setBorderBottom(BorderStyle.THIN);
        styleTitle2.setBorderLeft(BorderStyle.THIN);
        styleTitle2.setBorderRight(BorderStyle.THIN);
        styleTitle2.setBorderTop(BorderStyle.THIN);
        XSSFFont fontTitle2 = workbook.createFont();
        fontTitle2.setFontName("黑体");
        fontTitle2.setFontHeightInPoints((short) 12);//设置字体大小
        fontTitle2.setBold(true);
        styleTitle2.setFont(fontTitle2);
        //style endTitle
        XSSFCellStyle styleEndTitle = workbook.createCellStyle();
        styleEndTitle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        styleEndTitle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        styleEndTitle.setBorderBottom(BorderStyle.THIN);
        styleEndTitle.setBorderLeft(BorderStyle.THIN);
        styleEndTitle.setBorderRight(BorderStyle.THIN);
        styleEndTitle.setBorderTop(BorderStyle.THIN);
        styleEndTitle.setVerticalAlignment(VerticalAlignment.TOP);
        styleEndTitle.setWrapText(true);
        XSSFFont fontEndTitle = workbook.createFont();
        fontEndTitle.setFontName("黑体");
        fontEndTitle.setFontHeightInPoints((short) 12);//设置字体大小
        fontEndTitle.setBold(true);
        styleEndTitle.setFont(fontEndTitle);
        //style text
        XSSFCellStyle styleText = workbook.createCellStyle();
        styleText.setAlignment(HorizontalAlignment.LEFT);
        styleText.setVerticalAlignment(VerticalAlignment.CENTER);
        styleText.setBorderBottom(BorderStyle.THIN);
        styleText.setBorderLeft(BorderStyle.THIN);
        styleText.setBorderRight(BorderStyle.THIN);
        styleText.setBorderTop(BorderStyle.THIN);
        styleText.setWrapText(true);
        XSSFFont fontText = workbook.createFont();
        fontText.setFontName("宋体");
        fontText.setFontHeightInPoints((short) 11);//设置字体大小
        styleText.setFont(fontText);
        //style text2 居中
        XSSFCellStyle styleText2 = workbook.createCellStyle();
        styleText2.setAlignment(HorizontalAlignment.LEFT);
        styleText2.setVerticalAlignment(VerticalAlignment.CENTER);
        styleText2.setAlignment(HorizontalAlignment.CENTER);
        styleText2.setBorderBottom(BorderStyle.THIN);
        styleText2.setBorderLeft(BorderStyle.THIN);
        styleText2.setBorderRight(BorderStyle.THIN);
        styleText2.setBorderTop(BorderStyle.THIN);
        styleText2.setWrapText(true);
        styleText2.setFont(fontText);

        //表头
        Row row0 = sheet.createRow(0);
        Cell cell0 = row0.createCell(0);
        cell0.setCellValue(name+"密码应用方案设备清单");
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 13));
        cell0.setCellStyle(styleTitle1);
        addMergeCellBorder(new CellRangeAddress(0, 0, 0, 13), sheet);
        Row row1 = sheet.createRow(1);
        Cell cell1 = row1.createCell(0);
        cell1.setCellValue("重要说明：\n" +
                "1、硬件设备部署时一般要求一主一备，但如果预算紧张，可以先建设一台，基本符合密评要求，但存在单点故障风险;\n" +
                "2、产品支持远程免费部署，如果需要现场支持联系产线下实施费用。");
        cell1.setCellStyle(styleEndTitle);
        row1.setHeight((short) (6 * 256));
        sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 13));
        //冻结第一行的十四列
        sheet.createFreezePane(1,1);
        sheet.createFreezePane(1,2);
        sheet.createFreezePane(14,3);

        Row row2 = sheet.createRow(2);
        String[] title = {"序号", "名称", "推荐品牌", "型号", "功能说明", "形态", "部署要求", "配置", "数量", "单位", "单价(万元)", "总价(万元)", "维保", "备注"};
        for (int i = 0; i < title.length; i++) {
            Cell cell2 = row2.createCell(i);
            cell2.setCellValue(title[i]);
            cell2.setCellStyle(styleTitle2);
        }
        //从第二行开始创建
        int rowNum = 3;

        for (int i = 0; i < deviceList.size(); i++) {
            Row row = sheet.createRow(rowNum++);
            Device device = deviceList.get(i);
            List<String> list = new ArrayList<>();
            list.add(String.valueOf(i + 1));
            list.add(device.getName());
            list.add(device.getBrand());
            list.add(device.getModel());
            list.add(device.getGnsm());
            list.add(device.getType());
            list.add(device.getBsyq());
            list.add(device.getConfigure());
            list.add(String.valueOf(device.getNum()));
            list.add(device.getUnit());
            list.add(device.getDj());
            list.add(device.getZj());
            list.add(device.getWb());
            list.add(device.getRemark());
            for (int j = 0; j < list.size(); j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(list.get(j));
                if (j == 0 || j == 2 || j == 3 || j == 5 || j == 8 || j == 9) {
                    cell.setCellStyle(styleText2);
                } else {
                    cell.setCellStyle(styleText);
                }
            }
        }
        Row rowEnd = sheet.createRow(deviceList.size() + 3);
        Cell cellEnd = rowEnd.createCell(0);
        cellEnd.setCellValue("合计");
        sheet.addMergedRegion(new CellRangeAddress(deviceList.size() + 3, deviceList.size() + 3, 0, 12));
        Cell cell = rowEnd.getCell(0);
        cell.setCellStyle(styleEndTitle);
        addMergeCellBorder(new CellRangeAddress(deviceList.size() + 3, deviceList.size() + 3, 0, 12), sheet);
        rowEnd.createCell(11).setCellStyle(styleTitle2);

        rowEnd = sheet.createRow(deviceList.size() + 4);
//        rowEnd.setHeight((short) (6 * 256));
        cellEnd = rowEnd.createCell(0);

        cellEnd.setCellValue("备注：");
        sheet.addMergedRegion(new CellRangeAddress(deviceList.size() + 4, deviceList.size() + 4, 0, 13));
        cell = rowEnd.getCell(0);
        cell.setCellStyle(styleEndTitle);
        addMergeCellBorder(new CellRangeAddress(deviceList.size() + 4, deviceList.size() + 4, 0, 13), sheet);

        try {
//            File file = new File("/home/ubuntu/Desktop/code_package/sbqd.xlsx");
            File file = new File("sbqd.xlsx");
            FileOutputStream out = new FileOutputStream(file);
            workbook.write(out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 添加边框线
     *
     * @param cra   区域
     * @param sheet 页
     */
    private static void addMergeCellBorder(CellRangeAddress cra, Sheet sheet) {
        RegionUtil.setBorderTop(BorderStyle.THIN, cra, sheet);
        RegionUtil.setBorderBottom(BorderStyle.THIN, cra, sheet);
        RegionUtil.setBorderLeft(BorderStyle.THIN, cra, sheet);
        RegionUtil.setBorderRight(BorderStyle.THIN, cra, sheet);
    }

}


