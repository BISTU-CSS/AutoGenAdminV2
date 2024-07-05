package com.autogen.service;

import com.autogen.util.JsonResult;
import com.autogen.dao.entity.input.LoginDTO;

public interface LoginService {
    JsonResult login(LoginDTO loginDTO);
}
