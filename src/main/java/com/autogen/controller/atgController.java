package com.autogen.controller;

import com.alibaba.fastjson.JSONObject;
import com.autogen.dao.entity.input.*;
import com.autogen.dao.entity.pf._1_WLHHJAQ;
import com.autogen.dao.entity.pf._2_WLHTXAQ;
import com.autogen.dao.entity.pf._3_SBHJSAQ;
import com.autogen.dao.entity.pf._4_YYHSJAQ;
import com.autogen.service.*;
import com.autogen.util.FileUtil;
import com.autogen.util.JsonResult;
import com.autogen.util.Convert;
import com.autogen.util.MyJSON;
import com.spire.xls.Workbook;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
public class atgController {
    @Autowired
    Service1 service1;
    @Autowired
    ServicePF servicePF;


//    private static QuestionNaire questionNaire = new QuestionNaire();

    @PostMapping("/json")
    public void json(@RequestBody JSONObject data) throws Exception {
        QuestionNaire questionNaire = new QuestionNaire();
        MyJSON.parsingJSON(data, questionNaire);
        Concent concent = Convert.convertToSence(questionNaire);
        service1.BasicTemplate(questionNaire, concent);
        service1.generate(questionNaire);
    }

    @PostMapping("/test")
    public void test(@RequestBody JSONObject data) throws Exception {
        QuestionNaire questionNaire = new QuestionNaire();
        MyJSON.parsingJSON(data, questionNaire);
        Concent concent = Convert.convertToSence(questionNaire);
        service1.BasicTemplate(questionNaire, concent);
        service1.generate(questionNaire);
    }

    //下载密评方案的api
    @RequestMapping("/api/download")
    public ResponseEntity<Object> download(@RequestBody JSONObject data) throws Exception {
        //提供下载的文件的路径
        QuestionNaire questionNaire = new QuestionNaire();
        // 实际上相当于把base_information中的data数据解析到questionNaire中
        MyJSON.parsingJSON(data, questionNaire);
        // 把questionNaire中的数据进一步封装为Concent类型，转换到具体的场景中
        Concent concent = Convert.convertToSence(questionNaire);

        service1.BasicTemplate(questionNaire, concent);
        service1.generate(questionNaire);
        // 先用service生成到example文件中，然后再读取example文件返回

//        FileSystemResource file = new FileSystemResource("/home/ubuntu/Desktop/code_package/complete_example.docx");
//        FileSystemResource file = new FileSystemResource("D:\\桌面\\auto\\AutoGen\\example.docx");
//        FileSystemResource file = new FileSystemResource("/home/ubuntu/fangan/autogen/example.docx");
        String result = new File(Service1Impl.class.getClassLoader().getResource("WordTemplate").toURI()).getParent() + "\\";
        FileSystemResource file = new FileSystemResource(result + "example.docx");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        //这里定制下载文件的名称
        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getFilename()));
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.contentLength())
                .contentType(MediaType.parseMediaType("application/octet-stream"))//以二进制流的形式返回
                .body(new InputStreamResource(file.getInputStream()));
    }
    //下载设备清单的api
    @RequestMapping("/api/SBQDdownload")
    public ResponseEntity<Object> SBQDdownload(@RequestBody JSONObject data) throws Exception {
        //提供下载的文件的路径
        QuestionNaire questionNaire = new QuestionNaire();
        MyJSON.parsingJSON(data,questionNaire);
        informationService.exportSBQD(questionNaire.getSbqd(),questionNaire.getSys_name());
        String result = new File(Service1Impl.class.getClassLoader().getResource("WordTemplate").toURI()).getParent() + "\\";
        FileSystemResource file = new FileSystemResource(result + "sbqd.xlsx");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        //这里定制下载文件的名称
        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getFilename()));
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.contentLength())
                .contentType(MediaType.parseMediaType("application/octet-stream"))//以二进制流的形式返回
                .body(new InputStreamResource(file.getInputStream()));
    }

    @Autowired
    InformationService informationService;

    @PostMapping("/api/createQuestionnaire")
    public JsonResult createQuestionnaire(@RequestBody JSONObject data) throws Exception {
        InputInformation information = new InputInformation();
        MyJSON.parsingJSON(data, information);
        int res = informationService.createQuestionnaire(information);
        if (res == 1) {
            return new JsonResult(null, "error");
        } else {
            return new JsonResult(null, "ok");
        }
    }

    @GetMapping("/api/getQuestionnaireList")
    public JsonResult getQuestionnaireList() {
        try {
            List<InputInformation> list = informationService.getQuestionnaireList();
            return new JsonResult(list, "ok");
        }catch (Exception e){
            return new JsonResult(null, "error");
        }
    }


    @PostMapping("/api/getQuestionnaireResult")
    public JsonResult getQuestionnaireResult(@RequestBody JSONObject data) {
        InputInformation information = new InputInformation();
        MyJSON.parsingJSON(data, information);
        String str = informationService.getQuestionnaireResult(information);
        if (str.equals("error")){
            return new JsonResult(null, "error");
        }else {
            JSONObject res =  JSONObject.parseObject(str);
            return new JsonResult(res, "ok");
        }
    }

    @PostMapping("/api/saveQuestionnaireResult")
    public JsonResult saveQuestionnaireResult(@RequestBody JSONObject data) {
        //**********************************
        /*QuestionNaire questionNaire = new QuestionNaire();
        MyJSON.parsingJSON(data, questionNaire);*/
        //把data转为questionNaire对象了，但是没有用？？？？？
        int res = informationService.saveQuestionnaireResult(data);
        if (res == 1){
            return new JsonResult(null, "error");
        }else {
            return new JsonResult(null, "ok");
        }
    }
//    @RequestMapping("/api/SBQDdownload")
//    public ResponseEntity<Object> SBQDdownload(@RequestBody JSONObject data) throws Exception {
//        //提供下载的文件的路径
//        QuestionNaire questionNaire = new QuestionNaire();
//        MyJSON.parsingJSON(data,questionNaire);
//        informationService.exportSBQD(questionNaire.getSbqd(),questionNaire.getSys_name());
////        FileSystemResource file = new FileSystemResource("/home/ubuntu/Desktop/code_package/sbqd.xlsx");
//        FileSystemResource file = new FileSystemResource("D:\\IDEA\\AutoGen\\sbqd.xlsx");
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
//        //这里定制下载文件的名称
//        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getFilename()));
//        headers.add("Pragma", "no-cache");
//        headers.add("Expires", "0");
//        return ResponseEntity.ok()
//                .headers(headers)
//                .contentLength(file.contentLength())
//                .contentType(MediaType.parseMediaType("application/octet-stream"))//以二进制流的形式返回
//                .body(new InputStreamResource(file.getInputStream()));
//    }
    // 根据json生成评分excel
    @PostMapping("/api/culate")
    public ResponseEntity<Object> culateScore(@RequestBody JSONObject xmmc) throws Exception{
        String sysname = xmmc.getString("xmmc");
        JSONObject data = servicePF.getJSONData(sysname);
        QuestionNaire questionNaire = new QuestionNaire();
        MyJSON.parsingJSON(data, questionNaire);
        Concent concent = Convert.convertToSence(questionNaire);
        List<Wlhhj> wlhhjlist = concent.getWlhhjList();
        List<_1_WLHHJAQ> wlhhj = servicePF.getWlhhjData(wlhhjlist);
        List<Wlhtx> wlhtxlist = concent.getWlhtxList();
        List<_2_WLHTXAQ> wlhtx = servicePF.getWlhtxData(wlhtxlist);
        List<Sbhjs> sbhjslist = concent.getSbhjsList();
        List<_3_SBHJSAQ> sbhjs = servicePF.getSbhjsData(sbhjslist);
        List<Yyhsj> yyhsjlist = concent.getYyhsjList();
        List<_4_YYHSJAQ> yyhsj = servicePF.getYyhsjData(yyhsjlist);
        String dbjb = concent.getSys_dbjb();
        //生成excel的方法，默认放在这里：ReplaceData.xlsx
        servicePF.genExcel(wlhhj,wlhtx,sbhjs,yyhsj,dbjb);
        //将这个文件上传回二进制流
        String result = new File(Service1Impl.class.getClassLoader().getResource("WordTemplate").toURI()).getParent() + "\\";
        FileSystemResource file = new FileSystemResource(result + "pingfen.xlsx");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        //这里定制下载文件的名称
        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getFilename()));
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.contentLength())
                .contentType(MediaType.parseMediaType("application/octet-stream"))//以二进制流的形式返回
                .body(new InputStreamResource(file.getInputStream()));
    }


    @Autowired
    FileService fileService;

    //fileupload
    @PostMapping("/api/upload")
    public JsonResult upload(@RequestParam("xmmc") String xmmc, @RequestParam("file") MultipartFile file) throws IOException {
        // MultipartFile 转 File
        File resultFile = FileUtil.MultipartFileToFile(file);
        //System.out.println(getFileNameNoEx(resultFile.getName()));

        boolean flag = fileService.upload(resultFile, xmmc);
        resultFile.delete();
        if (flag) {
            return new JsonResult(null, "ok");
        }
        return new JsonResult(null, "error");
    }

    //filesearch
    @PostMapping("/api/search")
    public JsonResult search(String xmmc) {
        List<String> list=new ArrayList<>();
        try {
            //搜索所有文件，从未归档里搜，“.”在这里为通配符用来查找所有文件
            Map<String,String> map = fileService.searchFile(0, ".");
            for (Map.Entry<String,String> entry:map.entrySet()){
                list.add(entry.getKey());
            }
            return new JsonResult(list,"ok");
        }catch (Exception e){
            return new JsonResult(null, "error");
        }
    }










    /**
     * 根据上传的Excel文件，得到最后的评分细节表格
     * @apiNote 参考的是https://blog.csdn.net/qq_57390446/article/details/127797971的api例
     * @param file Excel文件（需要由getPointExcel获得）
     * @return 文件的下载链接
     * @throws IOException
     */
    @PostMapping("/api/FSdownload")
    public JsonResult getPointFile(@RequestParam("xmmc") String xmmc, @RequestParam("file") MultipartFile file) throws IOException {   //传入应该是一个文件，参数未定
//      测试MultipartFile
//        File excelFile = new File("D:\\pingfen.xlsx");
        File excelFile = FileUtil.MultipartFileToFile(file);
        FileItemFactory factory = new DiskFileItemFactory(16, null);
        FileItem item = factory.createItem("fieldName", "text/plain", true, excelFile.getName());
        int bytesRead = 0;
        byte[] buffer = new byte[8192];
        try {
            FileInputStream fis = new FileInputStream(excelFile);
            OutputStream os = item.getOutputStream();
            while ((bytesRead = fis.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        MultipartFile m = new CommonsMultipartFile(item);



        //记得改路径
        String realPath = "D:\\下载\\Documents\\";

        File folder=new File(realPath);
        if(!folder.isDirectory()){
            folder.mkdirs();
        }
        String oldname = m.getOriginalFilename();
        String newname = "/home/ubuntu/autoGen/genExcel.xlsx";
        System.out.println(realPath+newname);
        //将multipartfile转为excel文件
        m.transferTo(new File(folder, newname));

        //get excel file
        FileSystemResource fs_file = null;
        //根据excel文件得到评分
        double[] score = servicePF.gen_PF(realPath+"\\"+newname);     //分数文件
        //System.out.println(score);
        return new JsonResult(score, "ok");
    }

}
