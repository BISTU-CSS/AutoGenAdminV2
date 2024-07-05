package com.autogen.dao.entity.input;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class InputInformation {
    private String cjr;
    private String zdls;
    private String xmmc;
    private String xmsm;
    private String date;
    private String xgsj;
    private String score;
}
