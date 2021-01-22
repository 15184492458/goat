package com.goat.api.leetcode;

import java.util.*;

/**
 * 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

     示例 1：

     输入: "babad"
     输出: "bab"
     注意: "aba" 也是一个有效答案。
     示例 2：

     输入: "cbbd"
     输出: "bb"
 */
public class LongestPalindromeStr {

    public static void main(String[] args) {
        System.out.println(longestPalindromeStr("ac"));
    }

    public static String longestPalindromeStr(String s) {
        if (s == null || s.length() < 2) return s;
        int length = s.length();
        char[] chars = s.toCharArray();
        int maxLength = 1,start = 0, end = 0;
        for (int i = 0; i < length - 1;i++){
            for (int j = i + 1;j < length;j++){
                if (j - i + 1 > maxLength && judgePalindromeString(chars,i,j)){
                    maxLength = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLength);
    }

    private static boolean judgePalindromeString(char[] chars, int start, int end){
        while (start < end) {
            if (chars[start] != chars[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static String longestPalindromeStr1(String s) {
        char[] result = new char[s.length()];
        int[][] tmpArray = new int[s.length()][s.length()];
        for (int n = 0; n < s.length(); n++){
            tmpArray[n][n] = 1;
        }
        longestPalindromeStr(s,0,s.length() - 1,result,tmpArray);
        return new String(result,0,result.length - 1);
    }

    public static void longestPalindromeStr(String s, int start, int end, char[] result, int[][] tmp) {
        if (tmp[start][end] == 1){
            result[start] = s.charAt(start);
            result[end] = s.charAt(end);
        }else{
            if (s.charAt(start) == s.charAt(end)) {
                tmp[start][end] = 1;
                result[start] = s.charAt(start);
                result[end] = s.charAt(end);
                longestPalindromeStr(s,start + 1,end - 1,result,tmp);
            }else {
                char[] result1 = new char[s.length()];
                longestPalindromeStr(s,start + 1,end,result1,tmp);
                char[] result2 = new char[s.length()];
                longestPalindromeStr(s,start,end - 1,result2,tmp);
                int result1L = 0, result2L = 0;
                for (int i = 0;i < result1.length;i++){
                    if (result1[i] == ' '){
                        result1L = i;
                    }
                }
                for (int j = 0;j < result2.length;j++){
                    if (result1[j] == ' '){
                        result2L = j;
                    }
                }
                result = result1L > result2L ? result1 : result2;
            }
        }
    }
}
