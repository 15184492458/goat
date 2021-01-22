package com.goat.api.lintcode.simple;

import java.util.Arrays;

/**
 * 旋转字符串
 * 描述
     给定一个字符串（以字符数组的形式给出）和一个偏移量，根据偏移量原地旋转字符串(从左向右旋转)。

     offset >= 0
     str的长度 >= 0

     您在真实的面试中是否遇到过这个题？
     说明
     原地旋转意味着你要在s本身进行修改。你不需要返回任何东西。

     样例
     样例 1:

     输入:  str="abcdefg", offset = 3
     输出:  str = "efgabcd"
     样例解释:  注意是原地旋转，即str旋转后为"efgabcd"
     样例 2:

     输入: str="abcdefg", offset = 0
     输出: str = "abcdefg"
     样例解释: 注意是原地旋转，即str旋转后为"abcdefg"
     样例 3:

     输入: str="abcdefg", offset = 1
     输出: str = "gabcdef"
     样例解释: 注意是原地旋转，即str旋转后为"gabcdef"
     样例 4:

     输入: str="abcdefg", offset =2
     输出: str = "fgabcde"
     样例解释: 注意是原地旋转，即str旋转后为"fgabcde"
     样例 5:

     输入: str="abcdefg", offset = 10
     输出: str = "efgabcd"
     样例解释: 注意是原地旋转，即str旋转后为"efgabcd"
     挑战
     在数组上原地旋转，使用O(1)的额外空间
 */
public class RotateString {

    public static void main(String[] args) {
//        int[] t = {1, 3, 2, 8, 4, 9};
//        int fee = 2;
//        System.out.println(maxProfit(t,fee));
        char[] a = {'a','b','c','d','e','f','g'};
        int offset = 3;
        rotateString1(a,offset);
        for (char x : a){
            System.out.print(x + ",");
        }
    }

    /**
     * @param str: an array of char
     * @param offset: an integer
     * @return: nothing
     */
    public static void rotateString1(char[] str, int offset) {
        // write your code here
        int left = 0, right = str.length - 1;
        if(str != null && str.length != 0){
            offset = offset % (right + 1);
            char[] tmp = new char[offset];
            int index = 0;
            for (int i = right - offset + 1; i < str.length; ++i) {
                tmp[index] = str[i];
                index++;
            }
            for (int i = right - offset; i >= 0; --i) {
                str[i + offset] = str[i];
            }
            for (int i = 0; i < offset; ++i) {
                str[i] = tmp[i];
            }
        }
    }

    /**
     * @param str: an array of char
     * @param offset: an integer
     * @return: nothing
     */
    public static void rotateString(char[] str, int offset) {
        // write your code here
        int left = 0, right = str.length-1;
        if(str != null && str.length != 0){
            offset = offset % (right + 1);
            rotateStr(str,0,right - offset);
            rotateStr(str,right - offset+1,right);
            rotateStr(str,0,right);

        }
    }
    public static void rotateStr(char[] str,int left,int right){
        char tmp;
        while(left < right){
            tmp = str[left];
            str[left] = str[right];
            str[right] = tmp;
            ++left;
            --right;
        }
    }

    public static int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        for (int i = 0; i < dp.length; ++i){
            System.out.print(dp[i][0] + "   ");
        }
        System.out.println();
        for (int i = 0; i < dp.length; ++i){
            System.out.print(dp[i][1] + "   ");
        }
        return dp[n - 1][0];
    }

}
