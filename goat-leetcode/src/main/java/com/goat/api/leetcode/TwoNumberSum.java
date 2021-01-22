package com.goat.api.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和：
 *   给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数,并返回他们的数组下标。
     你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

     示例:

     给定 nums = [2, 7, 11, 15], target = 9

     因为 nums[0] + nums[1] = 2 + 7 = 9
     所以返回 [0, 1]
 */
public class TwoNumberSum {

    public static void main(String[] args) {
        int[] array = {2, 7, 11, 15};
        int[] result = twoSum1(array,9);
        System.out.println(result[0] + "," + result[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0;i < nums.length;++i){
            int temp = nums[i];
            for (int j = 0;j < nums.length;++j){
                if (i == j) continue;
                if (target - temp == nums[j]){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }

    public static int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length;++i){
            int temp = target - nums[i];
            if (map.containsKey(temp)){
                result[0] = map.get(temp);
                result[1] = i;
                return result;
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
