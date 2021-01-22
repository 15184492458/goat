package com.goat.api.lintcode.simple;

import java.util.List;

/**
 * 最小子数组
 * 描述
     给定一个整数数组，找到一个具有最小和的连续子数组。返回其最小和。

     子数组最少包含一个数字

     您在真实的面试中是否遇到过这个题？
     样例
     样例 1

     输入：[1, -1, -2, 1]
     输出：-3
     样例 2

     输入：[1, -1, -2, 1, -4]
     输出：-6
 */
public class MinSubArray {

    /*
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     * 定义动态转移方程：
     *      int[] dp = new int[nums.length];//dp[i] 表示以nums[i]结尾的子串的最小值。
     *      直接将原数组作为动态转移方程中的数组，不用新建
     */
    public int minSubArray(List<Integer> nums) {
        // write your code here
        int min = nums.get(0);
        for (int i = 1; i < nums.size(); ++i) {
            nums.set(i,Math.min(nums.get(i - 1) + nums.get(i),nums.get(i)));
            if (min > nums.get(i)){
                min = nums.get(i);
            }
        }
        return min;
    }
}
