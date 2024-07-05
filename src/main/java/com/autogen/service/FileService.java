package com.autogen.service;

import java.io.File;
import java.util.Map;

import okhttp3.OkHttpClient;

public interface FileService {

    /**
     * 测试服务状态
     *
     * @param client
     * @return
     */
    String ping(OkHttpClient client);

    //seafile的组织方式："/"+是否归档+"/"+项目名+"/"+项目相关文件.xx

    /**
     * 归档一个项目文件夹（把一个项目移动到归档的文件夹中）
     * @param name 项目文件夹名
     * @return 0：失败，1：成功
     */
    public boolean archive(String name);

    /**
     * 把一个归档后的文件夹移动到未归档中
     * @param name 项目文件夹名
     * @return 0：失败，1：成功
     */
    public boolean unarchive(String name);

    /**
     * 搜索全部文件中的某个文件
     * @param archive 是否归档，0：未归档，1：已归档，2：全部          //搜索全部搜不出来
     * @param name 文件名（模糊查询），可查询出相似的所有版本
     * @return key:文件名，value:path_name
     */
    public Map<String,String> searchFile(int archive, String name);

    /**
     * 上传文件
     * @param file 文件（文件名需正确）
     * @param dirName 项目文件夹的名字    如果用file.getName的话每次上传的文件不一样都会建一个新的文件夹
     * @return 0：失败，1：成功
     */
    public boolean upload(File file, String dirName);

    /**
     * 下载
     * @param id 是否归档，0：未归档，1：已归档
     * @param path_name 路径 示例：/项目名/文件名.文件后缀
     * @return 下载链接，null为失败
     */
    public String download(int id, String path_name);

    /**
     * 删除某个文件
     * @param type 0:文件夹，1:文件       //改成String  dir:文件夹   file:文件
     * @param path_name 路径，当为文件夹路径时"/项目名"时删除整个文件夹，"/项目名/文件名.文件后缀"表示删除单个文件
     * @return 0：失败，1：成功
     */
    public boolean delete(String type, String path_name);
}
