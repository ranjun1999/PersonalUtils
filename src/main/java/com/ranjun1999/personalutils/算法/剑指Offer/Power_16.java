package com.ranjun1999.personalutils.算法.剑指Offer;

import org.springframework.http.converter.json.GsonBuilderUtils;

import java.math.BigDecimal;

/**
 * @Author: ranjun
 * @Date: 2020/9/10 17:03
 */
public class Power_16 {

    /**
     * 实现函数pow(double base, int exponent)
     * @param base
     * @param exponent
     * @return
     */
    public static double power(double base, int exponent) {
        BigDecimal decimal = new BigDecimal(base);
        if (decimal.equals(0) && exponent < 0) {
            throw new RuntimeException("0不能求倒");
        }
        int absExponent = Math.abs(exponent);
        double result = pow(base, absExponent);
        if (exponent < 0)
            result = 1.0 / result;
        return result;
    }
    private static double pow(double base, int absExponent) {
        if (absExponent == 0)
            return 1;
        if (absExponent == 1)
            return base;
        double result = pow(base,absExponent >> 1);
        result *= result;
        //判断指数是否为奇数
        if ((absExponent & 0x1) == 1)
            result *= base;
        return result;
    }

    public static void main(String[] args) {
        double base = 0.0;
        System.out.println(base == 0);
    }
}
