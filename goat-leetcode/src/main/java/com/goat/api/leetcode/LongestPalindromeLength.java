package com.goat.api.leetcode;

/**
 * 构成最长回文子串的长度：
 *   给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。

     在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。

     注意:
     假设字符串的长度不会超过 1010。

     示例 1:

     输入:
     "abccccdd"

     输出:
     7

     解释:
     我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 */
public class LongestPalindromeLength {

    public static void main(String[] args) {
        System.out.println(longestPalindromeLength("abccccdd"));
    }


    public static int longestPalindromeLength(String s) {
        if (s == null || s.isEmpty()) return 0;
        int[] countArray = new int[58];
        for (char c : s.toCharArray()) {
            countArray[c - 65] += 1;
        }
        int number = 0;
        for (int x: countArray) {
            if (x % 2 == 0){
                number += x;
            }else{
                number += x - 1;
            }
        }
        return number < s.length() ? number + 1 : number;
    }
}
