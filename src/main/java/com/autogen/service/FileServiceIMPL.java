package com.autogen.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.autogen.util.PublicParams;
import com.autogen.dao.entity.SearchFileByName;

import lombok.NoArgsConstructor;
import okhttp3.*;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class FileServiceIMPL implements FileService {

    private String SERVER_URL;
    private String FILE_SERVER_ROOT;

    public FileServiceIMPL(String SERVER_URL, String FILE_SERVER_ROOT) {
        this.SERVER_URL = SERVER_URL;
        this.FILE_SERVER_ROOT = FILE_SERVER_ROOT;
    }

    @Override
    public String ping(OkHttpClient client) {
        Request request = new Request.Builder()
                .get()
                .url(PublicParams.SERVER_URL + "/api2/ping/")
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return response.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean archive(String name) {
        // TODO Auto-generated method stub

        OkHttpClient client = new OkHttpClient();

        RequestBody body =new FormBody.Builder()
                .add("src_repo_id", PublicParams.unarchive_id)
                .add("src_parent_dir", "/")
                .add("dst_parent_dir", "/")
                .add("dst_repo_id", PublicParams.archive_id)
                .add("src_dirent_name", name)
                .build();

        Request request = new Request.Builder()
                .url(SERVER_URL + "/api/v2.1/move-folder-merge/")
                .header("Authorization", "Token " + PublicParams.TOKEN)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("Accept", "application/json")
                .header("indent", "4")
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()){
            if(response.isSuccessful()) {
                return true;
            }else {
                System.out.println(response.code());
                System.out.println(response.body().string());
            }
        }catch(IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean unarchive(String name) {
        // TODO Auto-generated method stub

        OkHttpClient client = new OkHttpClient();

        RequestBody body =new FormBody.Builder()
                .add("src_repo_id", PublicParams.archive_id)
                .add("src_parent_dir", "/")
                .add("dst_parent_dir", "/")
                .add("dst_repo_id", PublicParams.unarchive_id)
                .add("src_dirent_name", name)
                .build();

        Request request = new Request.Builder()
                .url(SERVER_URL + "/api/v2.1/move-folder-merge/")
                .header("Authorization", "Token " + PublicParams.TOKEN)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("Accept", "application/json")
                .header("indent", "4")
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()){
            if(response.isSuccessful()) {
                return true;
            }else {
                System.out.println(response.code());
                System.out.println(response.body().string());
            }
        }catch(IOException e) {
            e.printStackTrace();
        }

        return false;
    }
    @Override
    public Map<String, String> searchFile(int archive, String name) {
        OkHttpClient client = new OkHttpClient();
        Map<String, String> map= new HashMap<>();
        if(archive==0) {
            Request request = new Request.Builder()
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .header("Authorization", "Token " + PublicParams.TOKEN)
                    .header("Accept", "application/json")
                    .header("indent", "4")
                    .get()
                    .url(PublicParams.SERVER_URL + "/api/v2.1/search-file/?repo_id=" + PublicParams.unarchive_id + "&q=" + name)
                    .build();
            try (Response response = client.newCall(request).execute()) {

                List<SearchFileByName> list = JSONObject.parseArray(JSON.parseObject(response.body().string(), Feature.AutoCloseSource).getString("data"), SearchFileByName.class);

                for(int i=0;i<list.size();i++) {
                    if(list.get(i).getType().equals("file"))
                    {
                        String path_name=list.get(i).getPath();
                        String f1=path_name.substring(path_name.indexOf('/')+1);
                        String f2=f1.substring(f1.indexOf('/')+1);
                        String fileName=f2.substring(0, f2.indexOf('.'));
                        map.put(fileName,path_name);
                    }

                }

                return map;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(archive==1) {
            Request request = new Request.Builder()
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .header("Authorization", "Token " + PublicParams.TOKEN)
                    .header("Accept", "application/json")
                    .header("indent", "4")
                    .get()
                    .url(PublicParams.SERVER_URL + "/api/v2.1/search-file/?repo_id=" + PublicParams.archive_id + "&q=" + name)
                    .build();
            try (Response response = client.newCall(request).execute()) {

                List<SearchFileByName> list = JSONObject.parseArray(JSON.parseObject(response.body().string(), Feature.AutoCloseSource).getString("data"), SearchFileByName.class);

                for(int i=0;i<list.size();i++) {
                    if(list.get(i).getType().equals("file"))
                    {
                        String path_name=list.get(i).getPath();
                        String f1=path_name.substring(path_name.indexOf('/')+1);
                        String f2=f1.substring(f1.indexOf('/')+1);
                        String fileName=f2.substring(0, f2.indexOf('.'));
                        map.put(fileName,path_name);
                    }

                }

                return map;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            Request request1 = new Request.Builder()
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .header("Authorization", "Token " + PublicParams.TOKEN)
                    .header("Accept", "application/json")
                    .header("indent", "4")
                    .get()
                    .url(PublicParams.SERVER_URL + "/api/v2.1/search-file/?repo_id=" + PublicParams.unarchive_id + "&q=" + name)
                    .build();
            try (Response response = client.newCall(request1).execute()) {

                List<SearchFileByName> list1 = JSONObject.parseArray(JSON.parseObject(response.body().string(), Feature.AutoCloseSource).getString("data"), SearchFileByName.class);

                for(int i=0;i<list1.size();i++) {
                    if(list1.get(i).getType().equals("file"))
                    {
                        String path_name=list1.get(i).getPath();
                        String f1=path_name.substring(path_name.indexOf('/')+1);
                        String f2=f1.substring(f1.indexOf('/')+1);
                        String fileName=f2.substring(0, f2.indexOf('.'));
                        map.put(fileName,path_name);
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            Request request2 = new Request.Builder()
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .header("Authorization", "Token " + PublicParams.TOKEN)
                    .header("Accept", "application/json")
                    .header("indent", "4")
                    .get()
                    .url(PublicParams.SERVER_URL + "/api/v2.1/search-file/?repo_id=" + PublicParams.archive_id + "&q=" + name)
                    .build();
            try (Response response = client.newCall(request2).execute()) {

                List<SearchFileByName> list2 = JSONObject.parseArray(JSON.parseObject(response.body().string(), Feature.AutoCloseSource).getString("data"), SearchFileByName.class);

                for(int i=0;i<list2.size();i++) {
                    if(list2.get(i).getType().equals("file"))
                    {
                        String path_name=list2.get(i).getPath();
                        String f1=path_name.substring(path_name.indexOf('/')+1);
                        String f2=f1.substring(f1.indexOf('/')+1);
                        String fileName=f2.substring(0, f2.indexOf('.'));
                        map.put(fileName,path_name);
                    }

                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            return map;
        }

        return null;
    }


    //上传文件
    @Override
    public boolean upload(File file, String dirName) {
        String uploadLink = null;
        OkHttpClient client = new OkHttpClient();
        Request request1 = new Request.Builder()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("Authorization", "Token " + PublicParams.TOKEN)
                .url(PublicParams.SERVER_URL + "/api2/repos/" + PublicParams.unarchive_id + "/upload-link/?p=" + "/")
                .get()
                .build();
        try (Response response = client.newCall(request1).execute()) {
            if (response.isSuccessful()) {
                uploadLink= response.body().string().replaceAll("\"", "");
            } else {
                System.out.println(response.code());
                System.out.println(response.body().string());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);

        builder.addFormDataPart("file", file.getName(), RequestBody.create(MediaType.parse("application/octet-stream"), file));
        builder.addFormDataPart("parent_dir", "/");
        builder.addFormDataPart("relative_path", dirName);
        builder.addFormDataPart("replace", "1");         //文件相同有更新就替换到历史版本中去啦!!!
        RequestBody body = builder.build();

        Request request2 = new Request.Builder()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("Authorization", "Token " + PublicParams.TOKEN)
                .post(body)
                .url(uploadLink + "?ret-json=1")
                .build();
        try (Response response = client.newCall(request2).execute()) {
            if (response.isSuccessful()) {
                return true;
            } else {
                System.out.println(response.code());
                System.out.println(response.body().string());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String download(int id,String path_name) {
        String repo_id = PublicParams.archive_id;
        if(id==0)
            repo_id=PublicParams.unarchive_id;

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("Authorization", "Token " + PublicParams.TOKEN)
                .header("Accept", "application/json")
                .header("indent", "4")
                .get()
                .url(PublicParams.SERVER_URL + "/api2/repos/" + repo_id + "/file/?p=" + path_name + "&reuse=1")
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return response.body().string();
            } else {
                System.out.println(response.code());
                System.out.println(response.body().string());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean delete(String type, String path_name) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("Authorization", "Token " + PublicParams.TOKEN)
                .header("Accept", "application/json")
                .header("indent", "4")
                .url(PublicParams.SERVER_URL + "/api2/repos/" + PublicParams.unarchive_id + "/"+type+"/?p=" + path_name)
                .delete()
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return true;
            } else {
                System.out.println(response.code());
                System.out.println(response.body().string());
                return false;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
