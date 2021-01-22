package com.goat.api.lintcode.simple;

/**
 * 最小路径和:
 * 描述
     给定一个只含非负整数的m*n网格，找到一条从左上角到右下角的可以使数字和最小的路径。

     你在同一时间只能向下或者向右移动一步

     您在真实的面试中是否遇到过这个题？
     样例
     样例 1:
     输入:  [[1,3,1],[1,5,1],[4,2,1]]
     输出: 7

     样例解释：
     路线为： 1 -> 3 -> 1 -> 1 -> 1。

     样例 2:
     输入:  [[1,3,2]]
     输出:  6

     解释:
     路线是： 1 -> 3 -> 2
 */
public class MinPathSum {

    public static void main(String[] args) {
        //[[7,4,8,7,9,3,7,5,0],[1,8,2,2,7,1,4,5,7],[4,6,4,7,7,4,8,2,1],[1,9,6,9,8,2,9,7,2],[5,5,7,5,8,7,9,1,4],[0,7,9,9,1,5,3,9,4]]
        int[][] grid = {{7,4,8,7,9,3,7,5,0},
                        {1,8,2,2,7,1,4,5,7},
                        {4,6,4,7,7,4,8,2,1},
                        {1,9,6,9,8,2,9,7,2},
                        {5,5,7,5,8,7,9,1,4},
                        {0,7,9,9,1,5,3,9,4}};
        System.out.println(minPathSum(grid));
    }

    /**
     * @param grid: a list of lists of integers
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public static int minPathSum(int[][] grid) {
        // write your code here
        int row = grid.length;
        int cow = grid[0].length;
        int[][] dp = new int[row + 1][cow + 1];
        for (int i = 0; i <= row; ++i){
            dp[i][0] = Integer.MAX_VALUE;
        }
        for (int i = 0; i <= cow; ++i){
            dp[0][i] = Integer.MAX_VALUE;
        }
        dp[1][1] = grid[0][0];
        for (int i = 1; i < row + 1; ++i){
            for (int j = 1; j < cow + 1; ++j){
                if (i == 1 && j == 1) continue;
                dp[i][j] = Math.min(dp[i][j - 1],dp[i - 1][j]) + grid[i - 1][j - 1];
            }
        }
        for (int i = 0; i < row; ++i){
            System.out.println();
            for (int j = 0; j < cow; ++j){
                System.out.print(dp[i][j] + " ");
            }
        }
        return dp[row][cow ];
    }
}
