package com.goat.api.lintcode.simple;

/**
 * 搜索二维矩阵
 * 描述
     写出一个高效的算法来搜索 m × n矩阵中的值。

     这个矩阵具有以下特性：

     每行中的整数从左到右是排序的。
     每行的第一个数大于上一行的最后一个整数。
     样例
     样例  1:
     输入: [[5]],2
     输出: false

     样例解释:
     没有包含，返回false。

     样例 2:
     输入:
     [
     [1, 3, 5, 7],
     [10, 11, 16, 20],
     [23, 30, 34, 50]
     ],3
     输出: true

     样例解释:
     包含则返回true。

     挑战
     O(log(n) + log(m)) 时间复杂度
 */
public class SearchMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1,4,5},{6,7,8}};
        System.out.println(searchMatrix(matrix, 8));
    }

    /**
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        for (int i = 0; i < matrix.length; ++i) {
            if (matrix[i][0] <= target && matrix[i][matrix[i].length - 1] >= target){
                return searchByHalf(matrix[i], 0, matrix[i].length - 1, target);
            }
        }
        return false;
    }

    public static boolean searchByHalf(int[] array, int start, int end, int target){
        if (end >= start){
            int middle = (start + end) / 2;
            if (array[middle] > target){
                return searchByHalf(array, start,middle - 1, target);
            }else if (array[middle] < target){
                return searchByHalf(array, middle + 1, end, target);
            }else {
                return true;
            }
        }
        return false;
    }
}
