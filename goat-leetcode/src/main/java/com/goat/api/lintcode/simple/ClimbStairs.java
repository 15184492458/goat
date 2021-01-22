package com.goat.api.lintcode.simple;

/**
 * 爬楼梯:
 * 描述
     假设你正在爬楼梯，需要n步你才能到达顶部。但每次你只能爬一步或者两步，你能有多少种不同的方法爬到楼顶部？

     您在真实的面试中是否遇到过这个题？
     样例
     Example 1:
     Input:  n = 3
     Output: 3

     Explanation:
     1) 1, 1, 1
     2) 1, 2
     3) 2, 1
     total 3.


     Example 2:
     Input:  n = 1
     Output: 1

     Explanation:
     only 1 way.
 */
public class ClimbStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(10));
    }

    /**
     * @param n: An integer
     * @return: An integer
     */
    public static int climbStairs(int n) {
        // write your code here
        //dp[i] = dp[i - 1] + dp[i - 2];
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; ++i){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}
