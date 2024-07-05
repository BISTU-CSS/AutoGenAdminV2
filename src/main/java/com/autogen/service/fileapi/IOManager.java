package com.autogen.service.fileapi;

import com.deepoove.poi.xwpf.NiceXWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.xmlbeans.ResourceLoader;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOManager {
    ResourceLoader loader;
    /**
     *
     * @param path  Windows形式。例子："F:\\test\\table2.docx"
     * @return
     * @throws IOException
     */
    static public XWPFDocument readFile(String path) throws IOException {
//        ClassPathResource classPathResource = new ClassPathResource(path);
//        File file = classPathResource.getFile();
        FileInputStream in = new FileInputStream(path);
        return new NiceXWPFDocument(in);
    }

    /**
     *
     * @param doc
     * @param path  Windows形式。例子："F:\\test\\new_doc.docx"
     * @throws IOException
     */
    static public void writeFile(XWPFDocument doc,String path) throws IOException {
        FileOutputStream out = new FileOutputStream(path);
        doc.write(out);
        out.close();
    }

    /**
     *
     * @param doc1  第一章文件
     * @param doc2  第二章文件
     * @param doc3  第三章文件
     * @param doc4  第四章文件
     * @param doc5  第五章文件
     * @param doc6  第六章文件
     * @param doc7  第七章文件
     * @return NiceXWPFDocument
     * @throws Exception
     */
    static public NiceXWPFDocument mergeFile(NiceXWPFDocument doc1,NiceXWPFDocument doc2,NiceXWPFDocument doc3,NiceXWPFDocument doc4,NiceXWPFDocument doc5,NiceXWPFDocument doc6,NiceXWPFDocument doc7,NiceXWPFDocument doc8) throws Exception {
        return  doc1.merge(doc2).merge(doc3).merge(doc4).merge(doc5).merge(doc6).merge(doc7).merge(doc8);
    }
}
