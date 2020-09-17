package com.ranjun1999.personalutils.service;

import java.util.List;
import java.util.Map;

/**
 * @Author: ranjun
 * @Date: 2020/7/21 13:38
 */
public interface ExcelLoadService {

    void deviceLoad(String filePath);

    void insertExcelData(List<Map<Integer, String>> list);

    public void saveParkData(List<Map<Integer,String>> list);
}
