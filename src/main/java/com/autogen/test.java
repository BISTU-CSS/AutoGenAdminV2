package com.autogen;

import java.io.File;

/**
 * ClassName: test
 * Package: com.autogen
 * Description:
 *
 * @Author 周钰尧
 * @Create 2024/7/15 9:40
 * @Version 1.0
 */
public class test {
    public static void main(String[] args) throws Exception {
        String baseURL = new File(test.class.getClassLoader().getResource("WordTemplate").toURI()).getParent();
        String subUrl = "/1.docx";
        String integrateUrl = new File(baseURL, subUrl).getPath();
        String s = baseURL + "1.docx";
//        String path = test.class.getClassLoader().getResource("WordTemplate/1.docx").getFile().getgetPath();
        System.out.println(baseURL);
        System.out.println(integrateUrl);
        System.out.println(s);
    }
}
