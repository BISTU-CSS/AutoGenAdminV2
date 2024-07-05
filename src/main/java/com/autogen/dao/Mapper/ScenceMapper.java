package com.autogen.dao.Mapper;

import com.autogen.dao.entity.ScencePo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ScenceMapper extends BaseMapper<ScencePo> {

}
