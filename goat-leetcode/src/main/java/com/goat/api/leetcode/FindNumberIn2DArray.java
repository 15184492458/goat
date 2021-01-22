package com.goat.api.leetcode;

/**
 * 二维数组中查找是否存在目标值：
 * 题目：
    在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
    请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
    示例:
     现有矩阵 matrix 如下：
     [
     [1,   4,  7, 11, 15],
     [2,   5,  8, 12, 19],
     [3,   6,  9, 16, 22],
     [10, 13, 14, 17, 24],
     [18, 21, 23, 26, 30]
     ]
     给定 target = 5，返回 true。

     给定 target = 20，返回 false。

     限制：
     0 <= n <= 1000

     0 <= m <= 1000

     class Solution {
     public boolean findNumberIn2DArray(int[][] matrix, int target) {
     }
     }
 */
public class FindNumberIn2DArray {


    public static void main(String[] args) {

        int[][] array = {{1,2,3,4,5},
                         {6,7,8,9,10},
                         {11,12,13,14,15},
                         {16,17,18,19,20},
                         {21,22,23,24,25}};
        int[][] array1 = {{1,3,5,7,9},
                          {2,4,6,8,10},
                          {11,13,15,17,19},
                          {12,14,16,18,20},
                          {21,22,23,24,25}};
        System.out.println(findNumberIn2DArray1(array1 ,11));
    }

    public static boolean findNumberIn2DArray1(int[][] matrix, int target) {
        if (matrix ==null || matrix.length <= 0 || matrix[0].length <= 0) return false;
        int rowLength = matrix.length, colLength = matrix[0].length;
        int row = 0, col = colLength - 1;
        while(row < rowLength && col >= 0){
            int number = matrix[row][col];
            if ( number> target){
                col--;
            }else if (number < target){
                row++;
            }else{
                return true;
            }
        }
        return false;
    }

    public static boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if (matrix ==null || matrix.length <= 0 || matrix[0].length <= 0) return false;
        int rowLength = matrix.length, colLength = matrix[0].length;
        for (int i = 0;i < rowLength;i++){
            for (int j = 0;j < colLength;j++){
                if (matrix[i][j] == target) return true;
            }
        }
        return false;
    }

    public static boolean findNumberIn2DArray3(int[][] matrix, int target) {
        if (matrix ==null || matrix.length <= 0 || matrix[0].length <= 0) return false;
        int num = 0;
        for (int i = 0;i < matrix.length && i < matrix[0].length; i++){
            if (matrix[i][i] == target) return true;
            if (matrix[i][i] > target){
                num = i - 1 > 0 ? i - 1 : 0;
                break;
            }
        }
        for (int i = num;i < matrix.length; i++){
            for (int j = 0;j < matrix[0].length; j++){
                if (matrix[i][j] == target) return true;
            }
        }
        for (int i = 0;i <= num; i++){
            for (int j = num;j < matrix[0].length; j++){
                if (matrix[i][j] == target) return true;
            }
        }
        return false;
    }
}
