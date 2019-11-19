package com.ranjun1999.personalutils.config;

/**
 * @Author: ranjun
 * @Date: 2019/9/30 16:53
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * 开启Redis Http Session
 */
@Configuration
@EnableRedisHttpSession
public class RedisHttpSessionConfiguration {
}
