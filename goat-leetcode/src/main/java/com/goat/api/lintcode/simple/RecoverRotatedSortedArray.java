package com.goat.api.lintcode.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 恢复旋转排序数组
 * 描述
     给定一个旋转排序数组，在原地恢复其排序。（升序）

     您在真实的面试中是否遇到过这个题？
     说明
     什么是旋转数组？

     比如，原始数组为[1,2,3,4], 则其旋转数组可以是[1,2,3,4], [2,3,4,1], [3,4,1,2], [4,1,2,3]
     样例
     Example1:
     [4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]
     Example2:
     [6,8,9,1,2] -> [1,2,6,8,9]

     挑战
     使用O(1)的额外空间和O(n)时间复杂度
 */
public class RecoverRotatedSortedArray {

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, -1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1));
        recoverRotatedSortedArray(nums);
        nums.stream().forEach(System.out::print);
    }

    /**
     * @param nums: An integer array
     * @return: nothing
     */
    public static void recoverRotatedSortedArray(List<Integer> nums) {
        // write your code here
        if (nums == null || nums.size() == 0) return;
        List<Integer> list = new ArrayList<>();
        Iterator<Integer> iterator = nums.iterator();
        while (iterator.hasNext()){
            int next = iterator.next();
            if (list.size() == 0 || next >= list.get(list.size() - 1)){
                list.add(next);
                iterator.remove();
            }else {
                break;
            }
        }
        nums.addAll(list);
    }
}
