package com.goat.api.leetcode;

import org.springframework.util.StringUtils;

import java.sql.Connection;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 最大子序和：
 *   给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

     示例:

     输入: [-2,1,-3,4,-1,2,1,-5,4]
     输出: 6
     解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     进阶:

     如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int[] nums = {-1,-2,-3,-4};
        System.out.println(maxSubArray2(nums));
    }

    /**
     * 动态规划解：
     *      动态转移方程：
     *          dp[i] = max(dp[i - 1] + nums[i],nums[i])
     *          dp[i] 表示以nums[i]结尾的子串的最大值。
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = nums[0];
        for(int i = 1;i < length;++i){
            dp[i] = Math.max(dp[i - 1] + nums[i],nums[i]);
        }
        Arrays.sort(dp);
        return dp[length - 1];
    }

    private static int maxSubArray(int[] nums){
        int max = nums[0];
//        int begin = 0;//记录起始下标
//        int end = 0;
        for (int i = 0;i < nums.length;++i){
            int tmp = nums[i];
            for (int j = i;j < nums.length;++j){
                if (i != j){
                    tmp = tmp + nums[j];
                }
//                begin = i;
//                end = j;
                max = Math.max(tmp,max);
            }
        }
        return max;
    }

    private static int maxSubArray1(int[] nums){
        int maxSum = nums[0];
        int preSum = 0;
        int minSum = 0;
        for (int num : nums) {
            // prefix Sum
            preSum += num;
            // update maxSum
            maxSum = Math.max(maxSum, preSum - minSum);
            // update minSum
            minSum = Math.min(minSum, preSum);
        }
        return maxSum;
    }
}
