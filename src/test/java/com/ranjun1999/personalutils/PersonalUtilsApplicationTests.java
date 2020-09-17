package com.ranjun1999.personalutils;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ranjun1999.personalutils.mqtt.MqttPushClient;
import com.ranjun1999.personalutils.constant.ExcelFileEnum;
import com.ranjun1999.personalutils.dao.UserDao;
import com.ranjun1999.personalutils.model.User;
import com.ranjun1999.personalutils.service.DeviceService;
import com.ranjun1999.personalutils.service.ExcelLoadService;
import com.ranjun1999.personalutils.service.UserService;
import com.ranjun1999.personalutils.utils.FileUtil;
import com.ranjun1999.personalutils.utils.HttpUtils;
import com.ranjun1999.personalutils.utils.PrintUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonalUtilsApplicationTests {

    @Autowired
    DeviceService deviceService;

    @Autowired
    UserService userService;

    @Autowired
    ExcelLoadService excelLoadService;

    @Resource
    UserDao userDao;

    @Autowired
    MqttPushClient mqttPushClient;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testHttp() {
//        String url = "http://localhost:8081/api/user/login";
        String url = "http://localhost:8081/api/excel2/upload/bai/test";
        Map<String,String> params = new HashMap<>();
        params.put("name","13000000000");
        params.put("value","cisdi@123456");

        Map<String, String> properties = new HashMap<>();
        properties.put("accessToken","Bearer 58166470-c27f-4b7c-834d-f4a66a7fa039");

        JSONObject json = new JSONObject();
        json.put("name","垃圾桶_1");
        json.put("code","code_001");
        try {
            System.out.println(HttpUtils.sendPost(url,params,properties));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Test
    public void testExcelLoad(){
        FileUtil.excelImport(ExcelFileEnum.DOOR_MJ_DATA.getFilePath());
    }

    @Test
    public void noModelExcelRead(){
        excelLoadService.deviceLoad(FileUtil.URL);
    }

    @Test
    public void testInsert(){
        User user = new User();
        user.setUserId("5");
        userService.addUser(user);
    }

    @Test
    public void MyBatisPlusTest(){
        //分页查询
//        IPage<User> userIPage = new Page<>(1,3);
//        userIPage = userDao.selectPage(userIPage, null);
//        List<User> users = userIPage.getRecords();
//        PrintUtil.pringList(users);

//        LambdaQueryWrapper<User> lam = new LambdaQueryWrapper<>();
//        lam.eq(User::getUserId,"1").select(User::getUserId,User::getUserName);
//        List<User> lis = userDao.selectList(lam);
//        PrintUtil.pringList(lis);

//        IPage<User> userIPage  = userService.selectUserPage(new Page<User>(2,3));
//        PrintUtil.pringList(userIPage.getRecords());
//        Map<String,Object> cloumns = new HashMap<>();
//        cloumns.put("user_id","1");
//        cloumns.put("user_name","rj");
//        cloumns.put("password","1234");
//        cloumns.put("age",null);
//        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.ne("user_id","1").orderByDesc("user_name");
//        System.out.println(userDao.selectList(queryWrapper));


        PrintUtil.pringList(userService.selectUserPage(new Page<>(1,4)).getRecords());

    }

    @Test
    public void testMQTTPush(){

        List<User> users = new LinkedList<User>();
        for (int i = 0; i < 1000; i++) {
            User user = new User();
            user.setUserId(i + "8281u912e1");
            user.setUserName("zhanhsan");
            user.setAge(20);
            user.setBirth(new Date());
            users.add(user);
        }
        mqttPushClient.publish("test",JSONObject.toJSONString(users));
    }

    @Test
    public void testMQTTSubscribe(){
        mqttPushClient.subscribe("game");
    }

    @Test
    public void testJSONOnject(){
        User user = new User();
        user.setUserId("8281u912e1");
        user.setUserName("zhanhsan");
        user.setAge(20);
        user.setBirth(new Date());
//        JSONObject json = new JSONObject();
        JSONObject object = (JSONObject) JSONObject.toJSON(user);
        for (int i = 0; i < 10000; i++) {
            user.setUserName("test-" + i);
            mqttPushClient.publish("book",JSONObject.toJSONString(user));
        }
    }
}
