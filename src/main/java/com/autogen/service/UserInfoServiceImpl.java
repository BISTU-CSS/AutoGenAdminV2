package com.autogen.service;

import com.autogen.dao.Mapper.UserInfoMapper;
import com.autogen.dao.entity.SelectUserPage;
import com.autogen.dao.entity.UserInfo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class UserInfoServiceImpl implements UserInfoService{

    @Autowired
    UserInfoMapper userInfoMapper;


    @Override
    @Transactional
    public int addOrUpdate(UserInfo userInfo){
        //System.out.println(userInfo);
        if(userInfo.getId() == null){ //UserInfo没有id，表示新增
            return userInfoMapper.insert(userInfo);
        } else {
            return userInfoMapper.updateById(userInfo);
        }
    }

    @Override
    @Transactional
    public Map<String,Object> findPage(Integer pageNum, Integer pageSize, String user_name){
        Page<SelectUserPage> page = new Page<>(pageNum,pageSize);
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("user_name",user_name);
        Map<String,Object> res = new HashMap<>();
        Long total = userInfoMapper.selectCount(queryWrapper);
        IPage<SelectUserPage> data = userInfoMapper.selectUserPage(page,user_name);
        res.put("data",data);
        res.put("total",total);
        return res;
    }

    @Override
    @Transactional
    public int delete(Integer id){
        return  userInfoMapper.deleteById(id);
    }


    @Override
    @Transactional
    public List<SelectUserPage> groupCount(){
        return userInfoMapper.groupCount();
    }
}
