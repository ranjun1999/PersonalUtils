package com.ranjun1999.personalutils.constant;

/**
 * Excel文件路径
 * @Author: ranjun
 * @Date: 2020/7/23 13:44
 */
public enum ExcelFileEnum {

    NEW_PARK_URL("D:\\cisdi\\新建两车场（米兰春天、优品城邦）静态信息.xlsx"),
    CAR_DATA("D:\\cisdi\\车辆数据.xls"),
    DRIVER_DATA("D:\\cisdi\\驾驶员信息.xls"),
    DOOR_DEVICE_DATA("D:\\cisdi\\白沙楼栋信息.xls"),
    DOOR_MJ_DATA("D:\\cisdi\\云城尚设备信息表-终表.xlsx");;

    private ExcelFileEnum(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    private String filePath;


}
