package com.ranjun1999.personalutils.算法.leetcodes;

import java.util.HashMap;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 *示例 1:
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 *
 * 输入:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 *
 *
 *
 * @Author: ranjun
 * @Date: 2019/12/15 12:09
 */
public class _36_有效的数独 {

    /**
     * 1. 两次遍历 时间复杂度O(n)
     * @param board
     * @return
     */
    public static boolean isValidSudoku(char[][] board) {

        //确保行中没有重复的数字，和子数独中没有重复的数字
        for (int i = 0; i < 9; i++) {
            HashMap<Character,Integer> row = new HashMap<>();

            for (int j = 0; j < 9; j++) {
                if (i % 3 == 0 && j % 3 == 0) {
                    HashMap<Character,Integer> threeThree = new HashMap<>();
                    for (int m = 0; m < 3; m++) {
                        for (int n = 0; n < 3; n++) {
                            Character c2 = board[i+m][j+n];
                            if (c2 != '.') {
                                if (threeThree.getOrDefault(c2, 0) > 0) {
                                    return false;
                                }else threeThree.put(c2,1);
                            }
                        }
                    }
                }

                Character c = board[i][j];
                if (c != '.') {
                    if (row.getOrDefault(c,0) > 0) {
                        return false;
                    } else row.put(c, 1);
                }
            }
        }

        //确保列中没有重复的数字
        for (int i = 0; i < 9; i++) {
            HashMap<Character,Integer> clow = new HashMap<>();
            for (int i1 = 0; i1 < 9; i1++) {
                Character c = board[i1][i];

                if (c != '.') {
                    if (clow.getOrDefault(c, 0) > 0) {
                        return false;
                    }else clow.put(c,1);
                }
            }
        }

        return true;
    }

    /**
     * 2. 一次遍历  时间复杂度O(1)
     *
     * 使用 box_index = (row / 3) * 3 + columns / 3，枚举子数独
     * @param board
     * @return
     */
    public boolean isValidSudoku_2(char[][] board) {
        // init data
        HashMap<Integer, Integer> [] rows = new HashMap[9];
        HashMap<Integer, Integer> [] columns = new HashMap[9];
        HashMap<Integer, Integer> [] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];

                if (num != '.') {
                    int n = num;
                    int boxIndex = (i/3)*3 + j/3;
                    rows[i].put(n, rows[i].getOrDefault(n,0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n,0) + 1);
                    boxes[boxIndex].put(n,boxes[boxIndex].getOrDefault(n,0) + 1);

                    // check if this value has been already seen before
                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[boxIndex].get(n) > 1)
                        return false;

                }

            }
        }

        return true;
    }



    public static void main(String[] args) {

//        System.out.println(c == 'c');
    }
}
