package com.goat.api.leetcode;

public class ShortestPalindrome {

    public static void main(String[] args) {
        shortestPalindrome("abacd");
    }

    public static String shortestPalindrome(String s) {
        char start = s.charAt(0);
        int length = s.length();
        flag:
        for (int i = 0;i < length; i++){
            for (int j = length -i - 1; j > 0; j--){
                if (s.charAt(i) == s.charAt(j)){
                    break flag;
                }
            }
        }
        return "";
    }
}
