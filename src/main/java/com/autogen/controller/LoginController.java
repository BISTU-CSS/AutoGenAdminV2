package com.autogen.controller;

import com.autogen.util.JsonResult;
import com.autogen.dao.entity.input.LoginDTO;
import com.autogen.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    @PostMapping(value = "/api/login")
    @CrossOrigin       //后端跨域
    public JsonResult login(@RequestBody LoginDTO loginDTO) {
        return loginService.login(loginDTO);
    }
}
