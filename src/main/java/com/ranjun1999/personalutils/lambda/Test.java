package com.ranjun1999.personalutils.lambda;

import javax.swing.*;

/**
 * @Author: ranjun
 * @Date: 2019/12/4 20:03
 */
public class Test {

    public static void main(String[] args) {

        Convert convert = from -> Integer.valueOf(from);
        //引用类方法，函数式接口中被实现方法的全部参数传给该类方法作为参数
        Convert convert_1 = Integer::valueOf;

        Convert convert1 = from -> "fkit.org".indexOf(from);
        //引用特定对象的实例方法：函数式接口中被实现方法的所有参数传给该方法作为参数
        Convert convert1_1 = "fkit.org" :: indexOf;

        MyTest myTest = (a, b, c) ->a.substring(b,c);
        //引用某类对象的实例方法，后面的参数全部传给该方法作为参数
        MyTest myTest_1 = String :: substring;

        SecondTest secondTest = (String a) ->  new JFrame(a);
        //构造器引用代替Lambada表达式，函数式接口中被实现方法的所有参数传给构造器作为参数
        SecondTest secondTest_1 = JFrame::new;


        System.out.println(convert_1.convert("2"));
        System.out.println(convert1_1.convert("it"));
        System.out.println(myTest_1.test("mylover",0,1));
        System.out.println(secondTest_1.win("我的窗口"));

    }
}
