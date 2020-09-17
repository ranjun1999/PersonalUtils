package com.ranjun1999.personalutils.utils;


import com.alibaba.excel.util.StringUtils;
import com.ranjun1999.personalutils.model.Device;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.format.CellFormatType;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: ranjun
 * @Date: 2020/7/20 10:41
 */
@Slf4j
public class FileUtil {

    public static final String URL = "D:\\cisdi\\新建两车场（米兰春天、优品城邦）静态信息.xlsx";

    public static void excelImport(String path) {
        //excel文件路径
        String excelPath = path;     //"C:\\Geek\\service_number\\test.xlsx";

        File excel = new File(excelPath);

        Workbook wb = null;
        try {
            wb = WorkbookFactory.create(excel);
        } catch (IOException e) {
            log.error(e.getMessage(),e);
        } catch (InvalidFormatException e) {
            log.error(e.getMessage(),e);
        }

        //开始解析
        Sheet sheet = wb.getSheetAt(0);     //读取sheet 0
        int firstRowIndex = sheet.getFirstRowNum() + 1;   //第一行是列名，所以不读
        int lastRowIndex = sheet.getLastRowNum();
        log.info(path +"---------共导入：" +lastRowIndex + "行" );
        int total  = 0;
        for (int rowIndex = 2; rowIndex <= lastRowIndex; rowIndex++) {
            Row row = sheet.getRow(rowIndex);
            log.info("-------------解析第" + rowIndex + "行");
            if (row != null) {
                int firstCellIndex = row.getFirstCellNum();
                int lastCellIndex = row.getLastCellNum();
                System.out.print(firstCellIndex + "-"+ lastCellIndex +"\n[");
                for (int cIndex = firstCellIndex; cIndex < lastCellIndex; cIndex++) {   //遍历列
                    String val = getStringCellValue(row.getCell(cIndex));
                    if (StringUtils.isEmpty(val)) {
                        System.out.print("empty val");
                    }else System.out.print(val);

                    if (cIndex + 1 < lastCellIndex) {
                        System.out.print(",");
                    }
                }
                System.out.println("]");
            }
            total ++;
            log.info("----------第" + rowIndex + "行解析完成");
        }
        log.info("-----------导入完成，共导入" +total + "行");
    }

    public static List<Device> excelRead(String url){


        //excel文件路径
        String excelPath = url;     //"C:\\Geek\\service_number\\test.xlsx";

        File excel = new File(excelPath);

        List<Device> devices = null;

        if (excel.isFile() && excel.exists()) {   //判断文件是否存在
            String[] split = excel.getName().split("\\.");  //.是特殊字符，需要转义！！！！！
            Workbook wb = null;
            try {
                wb = WorkbookFactory.create(new FileInputStream(excel));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InvalidFormatException e) {
                e.printStackTrace();
            }

//            try {
//                //根据文件后缀（xls/xlsx）进行判断
//                if ("xls".equals(split[1])) {
//                    FileInputStream fis = new FileInputStream(excel);   //文件流对象
//                    wb = new HSSFWorkbook(fis);
//                }
//                else if ("xlsx".equals(split[1])) {
//                    wb = new XSSFWorkbook(excel);
//                } else {
//                    System.out.println("文件类型错误!");
//                    return devices;
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            } catch (InvalidFormatException e) {
//                e.printStackTrace();
//            }

            devices = new ArrayList<>();

            //开始解析
            Sheet sheet = wb.getSheetAt(0);     //读取sheet 0

            int firstRowIndex = sheet.getFirstRowNum() + 1;   //第一行是列名，所以不读
            int lastRowIndex = sheet.getLastRowNum();
            System.out.println("firstRowIndex: " + firstRowIndex);
            System.out.println("lastRowIndex: " + lastRowIndex);

            for (int rIndex = firstRowIndex; rIndex <= lastRowIndex; rIndex++) {   //遍历行
                Row row = sheet.getRow(rIndex);
                if (row != null) {
                    int firstCellIndex = row.getFirstCellNum();
                    int lastCellIndex = row.getLastCellNum();
                    Device device = new Device();
                    List<Field> fields = getAllFieldsList(device);
                    for (int cIndex = firstCellIndex; cIndex < lastCellIndex; cIndex++) {   //遍历列
                        Cell cell = row.getCell(cIndex);
                        Field field = fields.get(cIndex);
                        field.setAccessible(true);
                        try {
                            field.set(device, cell.getStringCellValue());
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
//                    System.out.println(device.toString());
                    devices.add(device);
                }
            }
            return devices;
        } else {
            System.out.println("找不到指定的文件");
            return devices;
        }

    }

    //获取对象的所有属性列表
    private static List<Field> getAllFieldsList(Object object) {
        Class clazz = object.getClass();
        List<Field> fieldList = new ArrayList<>();
        while (clazz != null) {
            fieldList.addAll(new ArrayList<>(Arrays.asList(clazz.getDeclaredFields())));
            clazz = clazz.getSuperclass();
        }
        return fieldList;
    }
    /**
     * 获取单元格数据
     * @param cell Excel单元格
     * @return String 单元格数据内容
     */
    private static String getStringCellValue(Cell cell) {
        String strCell = "";
        switch (cell.getCellTypeEnum()) {
            case STRING:strCell = cell.getStringCellValue().trim();break;
            case NUMERIC:strCell = String.valueOf((int)cell.getNumericCellValue());
                System.out.print("NumbericCellValue Value:" + cell.getNumericCellValue() + "--> ");
//                log.info(cell.getRowIndex() + "," + cell.getColumnIndex() +"---------numValue:" + strCell);
                break;
            default:break;
        }
        return strCell;
    }

}
