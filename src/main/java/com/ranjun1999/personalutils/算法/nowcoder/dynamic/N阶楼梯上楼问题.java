package com.ranjun1999.personalutils.算法.nowcoder.dynamic;

import java.util.Scanner;

/**
 * N阶楼梯上楼问题：一次可以走两阶或一阶，问有多少种上楼方式。（要求采用非递归）
 * @Author: ranjun
 * @Date: 2020/8/7 11:37
 */
public class N阶楼梯上楼问题 {

    public static int floor(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        return floor(n -1) + floor(n-2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(floor(n));
    }
}
