package com.ranjun1999.personalutils.算法.剑指Offer;

/**
 * @Author: ranjun
 * @Date: 2020/9/10 11:33
 */
public class MatrixHasPath_12 {

    /**
     * 判断一个矩阵中是否存在一条包含某字符串所有字符的路径
     * 路径可以从矩阵中向左、右、上、下移动一格；如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子
     * @return
     */
    public static boolean hasPath(char[][] matrix,String str) {
        if (matrix == null || str == null)
            return false;
        int rows = matrix.length,cols = matrix[0].length;
        if (rows < 1 || cols < 1)
            return false;
        //标识路径是否已经进入了每个格子
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                visited[i][j] = false;
            }
        }
        int pathLength = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPathCore(matrix, rows, cols, i, j, str, pathLength, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasPathCore(char[][] matrix, int rows, int cols, int row, int col, String str, int pathLength, boolean[][] visited) {

        if (pathLength == str.length())
            return true;
        boolean hasPath = false;
        //如果当前位置与路径第i个字符相同，继续到相邻的格子寻找第 i + 1个字符
        if (row >= 0 && row < rows && col >= 0 && col < cols
                && matrix[row][col] == str.charAt(pathLength) && !visited[row][col]) {
            pathLength++;
            visited[row][col] = true;
            hasPath = hasPathCore(matrix, rows, cols, row, col - 1, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row - 1, col, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row, col + 1, str, pathLength, visited)
                    || hasPathCore(matrix,rows,cols,row + 1,col ,str,pathLength,visited);
            //若周围格子没有找到第 n + 1个字符，则回到第 n - 1个字符，重新定位第 n 个字符
            if (!hasPath) {
                visited[row][col] = false;
            }
        }
        return hasPath;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'a','b','t','g'},{'c','f','c','g'},{'j','d','e','h'}};
        System.out.println(hasPath(matrix,"acjtg"));
    }
}
