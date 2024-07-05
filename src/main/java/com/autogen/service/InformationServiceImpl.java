package com.autogen.service;

import com.alibaba.fastjson.JSONObject;
import com.autogen.dao.Mapper.DeviceMapper;
import com.autogen.dao.Mapper.InformationMapper;
import com.autogen.dao.entity.Device;
import com.autogen.dao.entity.Information;
import com.autogen.dao.entity.input.Concent;
import com.autogen.dao.entity.input.InputInformation;
import com.autogen.dao.entity.input.Product;
import com.autogen.dao.entity.table.Table59Util;
import com.autogen.service.officeapi.ExportDevice;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.ls.LSException;

import javax.swing.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.nio.file.CopyOption;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Slf4j
public class InformationServiceImpl implements InformationService {
    @Autowired
    InformationMapper informationMapper;
    @Autowired
    DeviceMapper deviceMapper;

    @Override
    @Transactional
    public int createQuestionnaire(InputInformation inputInformation) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Information information = informationMapper.selectOne(new QueryWrapper<Information>().eq("xmmc", inputInformation.getXmmc()));
        if (information != null) {
            return 1;
        } else {
            information = new Information();
            information.setDate(sdf.format(new Date()));
            information.setXgsj(sdf.format(new Date()));
            information.setCjr(inputInformation.getCjr());
            information.setXmmc(inputInformation.getXmmc());
            information.setXmsm(inputInformation.getXmsm());
            information.setZdls(inputInformation.getZdls());
            informationMapper.insert(information);
            return 0;
        }
    }

    @Override
    @Transactional
    public List<InputInformation> getQuestionnaireList() {
        List<InputInformation> resList = new ArrayList<>();
        List<Information> informationList = informationMapper.selectList(new QueryWrapper<Information>().orderByDesc("xgsj"));
        for (int i = 0; i < informationList.size(); i++) {
            InputInformation inputInformation = new InputInformation();
            inputInformation.setCjr(informationList.get(i).getCjr());
            inputInformation.setXmmc(informationList.get(i).getXmmc());
            inputInformation.setZdls(informationList.get(i).getZdls());
            inputInformation.setXmsm(informationList.get(i).getXmsm());
            inputInformation.setDate(informationList.get(i).getDate());
            inputInformation.setXgsj(informationList.get(i).getXgsj());
            inputInformation.setScore(informationList.get(i).getScore());
            resList.add(inputInformation);
        }
        return resList;
    }

    @Override
    @Transactional
    public String getQuestionnaireResult(InputInformation inputInformation) {
        Information information = informationMapper.selectOne(new QueryWrapper<Information>().eq("xmmc", inputInformation.getXmmc()));
        String str = information.getData();
        if (str == null) {
            return "error";
        } else {
            return information.getData();
        }
    }

    @Override
    @Transactional
    public int saveQuestionnaireResult(JSONObject data) {
        JSONObject jsonObject = data.getJSONObject("data");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 查询information表中项目名称xmmc列中，值为jsonObject.getString("sys_name")的对象
        Information information = informationMapper.selectOne(
                new QueryWrapper<Information>().
                        eq("xmmc", jsonObject.getString("sys_name"))
        );
        if (information != null) {
            informationMapper.update(
                    null,
                    new UpdateWrapper<Information>() //改变修改时间，并更新json内容
                            .set("xgsj", sdf.format(new Date()))
                            .set("data", jsonObject.toString())
                            .eq("xmmc", jsonObject.getString("sys_name"))
            );
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    @Transactional
    public void exportSBQD(List<Product> productList, String name) {
        List<Device> deviceList = new ArrayList<>();

        for (int i = 0; i < productList.size(); i++) {
            if (!"0".equals(productList.get(i).getNum())) {
                Device device = null;
                if (productList.get(i).getName().equals("服务器密码机")||productList.get(i).getName().equals("签名验签服务器")||productList.get(i).getName().equals("云服务器密码机")){
                    device = deviceMapper.selectOne(new QueryWrapper<Device>().eq("name", productList.get(i).getName()).eq("model",productList.get(i).getJbxh()));
                }else {
                    device = deviceMapper.selectOne(new QueryWrapper<Device>().eq("name", productList.get(i).getName()));
                }
                if (device != null) {
                    if ("9999".equals(productList.get(i).getNum())) {
                        device.setNum("按需");
                    } else {
                        device.setNum(productList.get(i).getNum());
                    }
                    device.setRemark(productList.get(i).getRemark());
                    deviceList.add(device);
                }
            }
        }
        ExportDevice.exportExcel(deviceList, name);
    }



}
