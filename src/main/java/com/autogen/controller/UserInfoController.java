package com.autogen.controller;

import com.autogen.dao.entity.SelectUserPage;
import com.autogen.dao.entity.UserInfo;
import com.autogen.service.UserInfoService;
import com.autogen.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
public class UserInfoController {

    @Autowired
    private  UserInfoService userInfoService;



    @PostMapping("/api/user/addOrUpdate")
    public JsonResult addOrUpdate(@RequestBody UserInfo userInfo){
                int res = userInfoService.addOrUpdate(userInfo);
                if(res == 0){
                    return new JsonResult(null,"error");
                }else{
                    return new JsonResult(null,"ok");
        }
    }

    @DeleteMapping("/api/{id}")
    public JsonResult delete(@PathVariable Integer id){
        int res =  userInfoService.delete(id);
        if(res == 0){
            return new JsonResult(null,"error");
        }else {
            return new JsonResult(null, "ok");
        }
    }

    //分页查询用户信息
    @GetMapping("/api/user/page")
    public JsonResult findPage(@RequestParam Integer pageNum,
                                       @RequestParam Integer pageSize,
                                       @RequestParam String user_name) {
        try{
            Map<String,Object> res =  userInfoService.findPage(pageNum,pageSize,user_name);
            return new JsonResult(res, "ok");
        }catch (Exception e){
            return new JsonResult(null, "error");
        }
    }

    //查询每组完成的方案数
    @GetMapping("/api/user/group")
    public JsonResult groupCount(){
        try {
            List<SelectUserPage> count =  userInfoService.groupCount();
            return new JsonResult(count, "ok");
        }catch (Exception e){
            return new JsonResult(null, "error");
        }
    }
}
