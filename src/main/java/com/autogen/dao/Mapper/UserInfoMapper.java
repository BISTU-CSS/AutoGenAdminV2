package com.autogen.dao.Mapper;


import com.autogen.dao.entity.SelectUserPage;
import com.autogen.dao.entity.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserInfoMapper extends BaseMapper<UserInfo> {

//    @Select("select * from user_info limit #{pageNum},#{pageSize};")
//    List<UserInfo> selectPage(Integer pageNum, Integer pageSize);
    IPage<SelectUserPage> selectUserPage(Page<SelectUserPage> page, String user_name);

    List<SelectUserPage> groupCount();
}
