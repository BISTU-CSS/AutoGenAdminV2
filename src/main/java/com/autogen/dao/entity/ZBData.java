package com.autogen.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZBData {
private List<CPDXData> wlhhjRiskList;
private List<CPDXData> wlhtxRiskList;
private List<CPDXData> sbhjsRiskList;
private List<CPDXData> yyhsjRiskList;
}
