package com.autogen.service;

import com.autogen.dao.entity.SelectUserPage;
import com.autogen.dao.entity.UserInfo;

import java.util.List;
import java.util.Map;

public interface UserInfoService {



    public int addOrUpdate(UserInfo userInfo);
    /**
     * 根据id判断是新增还是更新
     * @param: 用户信息
     * @return: 0：失败，1：成功
     */

    public int delete(Integer id);
    /**
     * 根据id删除用户信息
     * @param: id
     * @return:
     */

    public Map<String,Object> findPage(Integer pageNum, Integer pageSize, String user_name);

    /**
     * 分页查询
     * @param: pageNum：第几页；pageSize：每页多大
     * @return:
     */


    public List<SelectUserPage> groupCount();
}
