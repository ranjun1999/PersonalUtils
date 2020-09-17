package com.ranjun1999.personalutils.算法.剑指Offer;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排列，每一列都按照从上到下递增的顺序排列。
 * 现在完成一个函数，输入这样一个二维数组和一个整数，判断数组中是否有这个整数
 *
 * 二维数组形如
 * 1    2   8   9
 * 2    4   9   12
 * 4    7   10  13
 * 6    8   11  15
 *
 * @Author: ranjun
 * @Date: 2020/7/30 15:01
 */
public class 二维数组中的查找_4 {

    /**
     * 首先选取数组中右上角的数字。如果该数字等于要查找的数字，则查找过程结束；
     * 如果该数字大于要查找的数字，则剔除这个数字所在的列；
     * 如果该数字小于要查找的数字，则剔除这个数字所在的行；
     *
     * @param matrix
     * @param num
     * @return
     */
    static boolean findNum(int[][] matrix, int num) {
        int rows = matrix.length, columns = matrix[0].length;
        if (matrix !=  null && rows > 0 && columns > 0) {
            int row = 0;
            int col = columns - 1;
            while (row < rows && col >= 0) {
                if (matrix[row][col] == num) {
                    return true;
                } else if (matrix[row][col] > num) {
                    col--;
                }else row ++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(findNum(matrix,123));
    }
}
