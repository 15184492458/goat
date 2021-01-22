package com.goat.api.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 寻找重复数:
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。

     示例 1:

     输入: [1,3,4,2,2]
     输出: 2
     示例 2:

     输入: [3,1,3,4,2]
     输出: 3
     说明：

     不能更改原数组（假设数组是只读的）。
     只能使用额外的 O(1) 的空间。
     时间复杂度小于 O(n2) 。
     数组中只有一个重复的数字，但它可能不止重复出现一次。
     通过次数103,895提交次数157,519
 */
public class FindDuplicate {

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println(findDuplicate2(nums));
    }

    public int findDuplicate4(int[] nums) {
        int slow = nums[0];//从0开始
        int fast = nums[nums[0]];//相当于慢指针走一步，快指针走两步
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int begin= 0;
        int meet= slow;
        while(begin != meet){
            begin= nums[begin];
            meet= nums[meet];
        }
        return meet;
    }

    private static int findDuplicate3(int[] nums){
        int[] newnNums = new int[nums.length];
        int i = 0;
        while(i < nums.length){
            i = nums[i];
            if (newnNums[i] != 1) newnNums[i] = 1;
            else return i;
        }
        return -1;
    }

    private static int findDuplicate2(int[] nums){
        Set set = new HashSet<>();
        for (int num : nums){
            if (!set.add(num)){
                return num;
            }
        }
        return -1;
    }

    private static int findDuplicate1(int[] nums){
        int length = nums.length;
        int tmp = 0;
        for (int i = 0;i < length; i++){
            tmp = nums[i];
            for (int j = i + 1;j < length; j++){
                if (tmp == nums[j]){
                    return tmp;
                }
            }
        }
        return -1;
    }
}
