package com.goat.api.lintcode.simple;

/**
 * 最大子数组
 * 描述
     给定一个整数数组，找到一个具有最大和的子数组，返回其最大和。

     子数组最少包含一个数

     您在真实的面试中是否遇到过这个题？
     样例
     样例1:

     输入：[−2,2,−3,4,−1,2,1,−5,3]
     输出：6
     解释：符合要求的子数组为[4,−1,2,1]，其最大和为 6。
     样例2:

     输入：[1,2,3,4]
     输出：10
     解释：符合要求的子数组为[1,2,3,4]，其最大和为 10。
     挑战
     要求时间复杂度为O(n)
 */
public class MaxSubArray {

    /**
     * 优化，直接在原数组中操作，不需要新建数组
     * int[] dp = new int[nums.length];//dp[i] 表示以nums[i]结尾的子串的最大值。
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
        // write your code here
        int max = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            nums[i] = Math.max(nums[i - 1] + nums[i],nums[i]);
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code here
        int[] dp = new int[nums.length];//dp[i] 表示以nums[i]结尾的子串的最大值。
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            dp[i] = Math.max(dp[i - 1] + nums[i],nums[i]);
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
}
