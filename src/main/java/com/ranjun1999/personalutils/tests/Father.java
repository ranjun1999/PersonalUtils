package com.ranjun1999.personalutils.tests;

/**
 * @Author: ranjun
 * @Date: 2019/12/11 16:33
 */
public class Father {
    int a = 0;

    public void plus(){
        a++;
    }

    public static void main(String[] args) {
        Son son = new Son();
        son.plus();
        System.out.println(son.getA());
    }
}

class Son extends Father {

    int a =100;

    public int getA(){
        return super.a;
    }

    public void miner(){
        a--;
    }


}
