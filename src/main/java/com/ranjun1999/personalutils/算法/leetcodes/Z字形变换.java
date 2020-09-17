package com.ranjun1999.personalutils.算法.leetcodes;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L     C     I     R
 * E  T  O  E  S  I  I  G
 * E     D     H     N
 *
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * @Author: ranjun
 * @Date: 2019/11/25 19:45
 */
public class Z字形变换 {

    /**
     * 1. 按行排序  时间复杂度 O(n)
     * 通过从左到右迭代字符串，定位s的字符位于Z字图形的哪一行。
     * 可以使用当前行和当前方向这两个变量对合适的行进行跟踪。
     * 只有当我们向上移动到最上面的行或向下移动到最下面的行时，当前方向才会发生改变。
     * @param s
     * @param numsRows
     * @return
     */
    public String convert(String s, int numsRows) {
        //只有一行时，直接返回
        if (numsRows == 1) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        //保存每行的字符
        for (int i = 0; i < Math.min(numsRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        //当前行
        int corRow = 0;
        //当前方向
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            //将字符添加进当前行
            rows.get(corRow).append(c);
            //当前行移动到最上面的行或者最下面的行时，要改变行的移动方向
            if (corRow == 0 || corRow == (numsRows -1)){
                goingDown = !goingDown;
            }
            //移动当前行
            corRow += goingDown ? 1 : -1;
        }

        //添加每一行的字符
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }

    /**
     * 2.按行访问
     * 首先访问第一行的数据，然后访问第二行，...依次类推
     * 对于所有整数 k：
     *      行0中的字符位于索引 k(2⋅numRows−2)  处;
     *      行0中的字符位于索引 k(2⋅numRows−2) + numRows-1 处;
     *      内部的 行 i中的字符位于索引 k(2⋅numRows−2)+i 以及 (k+1)(2⋅numRows−2)−i 处;
     * @param s
     * @param numRows
     * @return
     */
    public String convert_2(String s, int numRows) {

        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }


}
