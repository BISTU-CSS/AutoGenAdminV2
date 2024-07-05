package com.autogen.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FAData {
private List<CPDXData> wlhhjFAList;
private List<CPDXData> wlhtxFAList;
private List<CPDXData> sbhjsFAList;
private List<CPDXData> yyhsjFAList;
}
