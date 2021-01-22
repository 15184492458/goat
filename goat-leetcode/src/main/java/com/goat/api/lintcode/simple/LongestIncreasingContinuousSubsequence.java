package com.goat.api.lintcode.simple;

/**
 * 最长上升连续子序列
 * 描述
     给定一个整数数组（下标从 0 到 n-1， n 表示整个数组的规模），请找出该数组中的最长上升连续子序列。（最长上升连续子序列可以定义为从右到左或从左到右的序列。）

     您在真实的面试中是否遇到过这个题？
     样例
     样例 1：

     输入：[5, 4, 2, 1, 3]
     输出：4
     解释：
     给定 [5, 4, 2, 1, 3]，其最长上升连续子序列（LICS）为 [5, 4, 2, 1]，返回 4。
     样例 2：

     输入：[5, 1, 2, 3, 4]
     输出：4
     解释：
     给定 [5, 1, 2, 3, 4]，其最长上升连续子序列（LICS）为 [1, 2, 3, 4]，返回 4。
     挑战
     使用 O(n) 时间和 O(1) 额外空间来解决
 */
public class LongestIncreasingContinuousSubsequence {

    public static void main(String[] args) {
        int[] array = {5,1,2,3,4};
        System.out.println(longestIncreasingContinuousSubsequence1(array));
    }

    public static int longestIncreasingContinuousSubsequence1(int[] A) {
        // Write your code here
        if (A == null || A.length < 1) return 0;
        if (A.length == 1) return 1;
        int length = A.length;
        int res1 = 0,res2 = 0;
        int[] dp1 = new int[length];
        int[] dp2 = new int[length];
        for (int i = 0;i < length;++i){
            dp1[i] = 1;
            dp2[i] = 1;
        }
        for(int i = 0;i < length - 1;++i){
            if(A[i] < A[i + 1]){
                dp1[i + 1] = dp1[i] + 1;
                res1 = Math.max(res1, dp1[i + 1]);
            }
            if(A[i] > A[i + 1]){
                dp2[i + 1] = dp2[i] + 1;
                res2 = Math.max(res2,dp2[i + 1]);
            }
        }
        return Math.max(res1,res2);
    }

    /**
     * @param A: An array of Integer
     * @return: an integer
     */
    public static int longestIncreasingContinuousSubsequence(int[] A) {
        // write your code here
        if (A == null || A.length < 1) return 0;
        int length = A.length;
        int[] dp = new int[length];
        dp[0] = 1;
        int maxLeft = dp[0];
        for (int i = 1; i < length; i++) {
            if (A[i] > A[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }else {
                dp[i] = 1;
            }
            maxLeft = Math.max(maxLeft, dp[i]);
        }
        dp[length - 1] = 1;
        int maxRight = dp[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) {
                dp[i] = dp[i + 1] + 1;
            }else {
                dp[i] = 1;
            }
            maxRight = Math.max(maxRight, dp[i]);
        }
        return Math.max(maxLeft, maxRight);
    }
}
