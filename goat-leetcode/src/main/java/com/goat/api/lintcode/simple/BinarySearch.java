package com.goat.api.lintcode.simple;

public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {1,4,4,7,7,7,8,9,9,10};
        int target = 7;
        System.out.println(binarySearch1(nums,target));
    }

    public static int binarySearch1(int[] nums, int target) {
        int low = 0, high = nums.length;
        while (high >= low){
            int mid = (low + high) / 2;
            if (nums[mid] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        if(target == nums[low]){
            return low;
        }else{
            return -1;
        }
    }

    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public static int binarySearch(int[] nums, int target) {
        // write your code here
        int low = 0;
        int high = nums.length;
        return binarySearch(nums,low,high,target);

    }

    public static int binarySearch(int[] nums,int low,int high,int target){
        if (low > high) return -1;
        int middle = (low + high) / 2;
        if (nums[middle] == target) {
            return middle;
        }
        if (nums[middle] > target) {
            return binarySearch(nums,low,middle - 1,target);
        }else{
            return binarySearch(nums,middle + 1,high,target);
        }
    }
}
