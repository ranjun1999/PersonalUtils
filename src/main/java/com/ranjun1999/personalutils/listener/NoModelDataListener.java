package com.ranjun1999.personalutils.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.exception.ExcelDataConvertException;
import com.alibaba.excel.metadata.CellExtra;
import com.ranjun1999.personalutils.model.User;
import com.ranjun1999.personalutils.service.ExcelLoadService;
import com.ranjun1999.personalutils.service.UserService;
import com.ranjun1999.personalutils.utils.PrintUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: ranjun
 * @Date: 2020/7/21 10:11
 *
 * 直接使用Map接收数据
 */
public class NoModelDataListener extends AnalysisEventListener<Map<Integer,String>> {
    private static final Logger LOGGER = LoggerFactory.getLogger(NoModelDataListener.class);

    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 10;

    List<Map<Integer,String>> list = new ArrayList<Map<Integer,String>>();

    private ExcelLoadService excelLoadService;

    public List<Map<Integer,String>> getList() {
        return list;
    }

    public NoModelDataListener(){
    }

    public NoModelDataListener(ExcelLoadService excelLoadService) {
        this.excelLoadService = excelLoadService;
    }

    /**
     * 这个每一条数据解析都会来调用
     * @param data
     * @param context
     */
    @Override
    public void invoke(Map<Integer,String> data, AnalysisContext context) {
        LOGGER.info("解析到一条数据:{}", data);
        list.add(data);

        if (list.size() >= BATCH_COUNT) {
            saveData();
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        LOGGER.info("所有数据解析完成！");
        saveData();
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
        LOGGER.info("{}条数据，开始存储数据库！", list.size());
        excelLoadService.saveParkData(list);
        LOGGER.info("存储数据库成功！");
    }

    /**
     * 在转换异常 获取其他异常下会调用本接口。抛出异常则停止读取。如果这里不抛出异常则 继续读取下一行。
     * @param exception
     * @param context
     * @throws Exception
     */
    @Override
    public void onException(Exception exception, AnalysisContext context) throws Exception {
//        LOGGER.error("解析失败，但是继续解析下一行:{}", exception.getMessage());
        // 如果是某一个单元格的转换异常 能获取到具体行号
        // 如果要获取头的信息 配合invokeHeadMap使用
        if (exception instanceof ExcelDataConvertException) {
            ExcelDataConvertException excelDataConvertException = (ExcelDataConvertException)exception;
            LOGGER.error("第{}行，第{}列解析异常", excelDataConvertException.getRowIndex(),
                    excelDataConvertException.getColumnIndex());
        }
    }


}
