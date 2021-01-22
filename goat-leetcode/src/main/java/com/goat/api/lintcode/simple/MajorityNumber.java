package com.goat.api.lintcode.simple;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 主元素
 * 描述
     给定一个整型数组，找出主元素，它在数组中的出现次数严格大于数组元素个数的二分之一。

     你可以假设数组非空，且数组中总是存在主元素。

     您在真实的面试中是否遇到过这个题？
     样例
     样例 1:

     输入: [1, 1, 1, 1, 2, 2, 2]
     输出: 1
     样例 2:

     输入: [1, 1, 1, 2, 2, 2, 2]
     输出: 2
     挑战
     要求时间复杂度为O(n)，空间复杂度为O(1)
 */
public class MajorityNumber {

    public int majorityNumber2(List<Integer> nums) {
        if (nums == null || nums.size() == 0) return -1;
        int temp = nums.get(0),count = 1;
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) == temp) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                temp = nums.get(i);
                count = 1;
            }
        }

        // 验证是否满足要求
        int t = nums.size() / 2 + 1;
        count = 0;
        for (int num : nums) {
            if (num == temp) count++;
            if (count == t) return temp;
        }
        return -1;
    }

    /**
     * 一般思维
     * @param nums
     * @return
     */
    public int majorityNumber1(List<Integer> nums) {
        if (nums == null || nums.size() == 0) return -1;
        int max = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (Integer i : nums) {
            if (map.containsKey(i)){
                map.put(i,map.get(i) + 1);
            }else {
                map.put(i,1);
            }
            max = Math.max(max,map.get(i));
            if (max > nums.size() / 2) return i;
        }
        return -1;
    }

    /*
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(List<Integer> nums) {
        // write your code here
        if (nums == null || nums.size() == 0) return -1;
        int size = nums.size();
        if(size == 0) return -1;
        int num = nums.get(0), cnt = 1;
        for(int i = 1;i < size; ++i) {
            if(nums.get(i) == num){
                cnt++;
            }
            else --cnt;
            if(cnt == -1){
                num = nums.get(i);
                cnt = 1;
            }
        }
        return cnt > 0 ? num : -1;
    }
}
