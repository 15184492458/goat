package com.goat.api.lintcode.general;

/**
 * 样例 1：
     输入：
     n = 1, nums = [1,3,4,2]
     输出：
     4

     样例 2：
     输入：
     n = 3, nums = [9,3,2,4,8]
     输出：
     4
 */
public class KthLargestElement {

    public static void main(String[] args) {
        int[] array = {3,4,3,8,9,7,1,3,4,6};
        System.out.println(kthLargestElement(3,array));
    }

    public static int kthLargestElement1(int k, int[] nums) {
        int high = nums.length - 1;
        for (int i = 0;i < nums.length;++i){
            for (int j = 0; j < high;++j){
                if (nums[j] > nums[high]){
                    swap(nums,j,high);
                }else {

                }
            }
            if (i == k - 1){
                return nums[high];
            }
            --high;
        }
        return -1;
    }

    public static int kthLargestElement(int k, int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low <= high){
            int index = low - 1;
            for (int i = low;i < high; ++i){
                if (nums[i] > nums[high]) {
                    swap(nums, i, ++index);
                }
            }
            swap(nums, ++index, high);
            if (index == k - 1){
                return nums[index];
            }
            if (index < k - 1){
                low = index + 1;
            }else {
                high = index - 1;
            }
        }
        return -1;
    }

    private static void swap(int[] nums, int i, int i1) {
        int tmp = nums[i];
        nums[i] = nums[i1];
        nums[i1] = tmp;
    }
}
