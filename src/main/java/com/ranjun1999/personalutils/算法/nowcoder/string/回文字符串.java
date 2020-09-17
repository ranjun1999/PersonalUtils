package com.ranjun1999.personalutils.算法.nowcoder.string;

import java.util.Scanner;

/**
 *
 * 给出一个长度不超过1000的字符串，判断它是不是回文(顺读，逆读均相同)的
 * @Author: ranjun
 * @Date: 2020/8/7 11:45
 */
public class 回文字符串 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            System.out.println(isPalindrome(str));
        }
    }

    public static String isPalindrome(String str) {
        if (str == null || str.length() <= 0) {
            return "No!";
        }
        int left = 0, right = str.length() - 1;
        while (left <= right) {
            if (str.charAt(left) != str.charAt(right))
                return "No!";
            left ++;
            right --;
        }
        return "Yes!";
    }
}
