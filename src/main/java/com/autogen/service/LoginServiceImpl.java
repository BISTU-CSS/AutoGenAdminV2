package com.autogen.service;

import com.autogen.dao.Mapper.UserMapper;
import com.autogen.dao.entity.input.LoginVO;
import com.autogen.util.JsonResult;
import com.autogen.dao.entity.User;
import com.autogen.dao.entity.input.LoginDTO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserMapper userMapper;

    @Override
    public JsonResult login(LoginDTO loginDTO) {
        if (StringUtils.isEmpty(loginDTO.getLoginName())){
            return new JsonResult(null,"账号不能为空");
        }
        if (StringUtils.isEmpty(loginDTO.getPassword())){
            return new JsonResult(null,"密码不能为空");
        }
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("login_name",loginDTO.getLoginName()));
        if (user!=null&&user.getPassword().equals(loginDTO.getPassword())){
            LoginVO loginVO=new LoginVO();
            loginVO.setId(user.getId());
            //这里token直接用一个uuid
            //使用jwt的情况下，会生成一个jwt token,jwt token里会包含用户的信息
            loginVO.setToken(UUID.randomUUID().toString());
            loginVO.setUser(user);
            return new JsonResult(loginVO,"ok");
        }
//        System.out.println("查无此人");
        return new JsonResult(null,"查无此人");
    }


}
