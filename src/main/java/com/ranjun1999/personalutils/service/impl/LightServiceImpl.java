package com.ranjun1999.personalutils.service.impl;

import com.ranjun1999.personalutils.model.Light;
import com.ranjun1999.personalutils.service.LightService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author: ranjun
 * @Date: 2020/8/10 15:05
 */
@Service
@Slf4j
public class LightServiceImpl implements LightService {

    @Override
    public void saveLightInfo(Light light) {
        log.info("----------保存电灯信息：" + light);
    }
}
