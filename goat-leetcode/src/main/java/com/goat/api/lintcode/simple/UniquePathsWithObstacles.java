package com.goat.api.lintcode.simple;

/**
 * 不同的路径 II
 * 描述
     "不同的路径" 的跟进问题：

     现在考虑网格中有障碍物，那样将会有多少条不同的路径？

     网格中的障碍和空位置分别用 1 和 0 来表示。

     m 和 n 均不超过100

     您在真实的面试中是否遇到过这个题？
     样例
     Example 1:
     Input: [[0]]
     Output: 1


     Example 2:
     Input:  [[0,0,0],[0,1,0],[0,0,0]]
     Output: 2

     Explanation:
     Only 2 different path.
 */
public class UniquePathsWithObstacles {

    private static int CAN_THROUGH = 0;

    private static int CAN_NOT_THROUGH = 1;

    public static void main(String[] args) {
        //[[0,0],[0,0],[0,0],[1,0],[0,0]]
        //[[0,0,1,0,0,0],[0,0,0,0,0,0],[0,0,0,0,0,0],[0,0,0,0,0,0],[0,0,0,0,0,0],[0,0,0,0,0,0],[0,0,0,0,0,0]]
        int[][] obstacleGrid = {{0,0,1,0,0,0},
                                {0,0,0,0,0,0},
                                {0,0,0,0,0,0},
                                {0,0,0,0,0,0},
                                {0,0,0,0,0,0},
                                {0,0,0,0,0,0}};
        /*
        {1,1,0,0,0,0},
        {1,2,2,2,2,2},
        {1,3,5,7,9,11},
        {1,4,9,16,25,36},
        {1,5,14,30,55,91},
        {1,6,20,50,105,196}
         */
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }

    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        if (obstacleGrid == null || obstacleGrid.length == 0) return 0;
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; ++i){
            for (int j = 0; j < col; ++j){
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                }else {
                    if (i == 0 || j == 0) {
                        if ((i - 1) >= 0){
                            dp[i][j] = dp[i - 1][j];
                        }else if ((j - 1) >= 0){
                            dp[i][j] = dp[i][j - 1];
                        }else {
                            dp[i][j] = 1;
                        }
                    }else {
                        dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                    }
                }
            }
        }
        return dp[row - 1][col - 1];
    }
}
