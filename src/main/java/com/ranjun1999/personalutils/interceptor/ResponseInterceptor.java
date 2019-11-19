package com.ranjun1999.personalutils.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * create by tanwt
 * 2018/5/9 0009 19:45
 **/

/**
 * 解决跨越问题,和返回编码问题
 */
public class ResponseInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String origin = httpServletRequest.getHeader("Origin");
//        httpServletResponse.setHeader("ContentType","text/html;charset=UTF-8");

        httpServletRequest.setCharacterEncoding("UTF-8");
        //orrigin如果是已知的域名，最好设置成已知的被允许的域名
        httpServletResponse.setHeader("Access-Control-Allow-Origin", origin);
        httpServletResponse.addHeader("Access-Control-Allow-Credentials", "true");
        httpServletResponse.setCharacterEncoding("UTF-8");
        //IE下为了能跨域ajax中写入cookie，还需要加入一个HttpHeader：
        httpServletResponse.setHeader("P3P", "CP=CAO PSA OUR");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
