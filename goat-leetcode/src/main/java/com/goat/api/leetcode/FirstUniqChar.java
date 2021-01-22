package com.goat.api.leetcode;

import org.springframework.util.StringUtils;

import java.util.*;

/**
 * 第一个只出现一次的字符:
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。

     示例:

     s = "abaccdeff"
     返回 "b"

     s = ""
     返回 " "
      
     限制：

     0 <= s 的长度 <= 50000
 */
public class FirstUniqChar {

    public static void main(String[] args) {
        System.out.println(firstUniqChar(""));
    }

    public static char firstUniqChar (String s) {
        char[] chars = s.toCharArray();
        int[] nums = new int[256];
        for (char c : chars){
            nums[c] = nums[c] + 1;
        }
        for (char c : chars) {
            if (nums[c] == 1) return c;
        }
        return ' ';
    }

    public static char firstUniqChar1 (String s) {
        Map<Character, Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c));
        for(char c : sc)
            if(dic.get(c)) return c;
        return ' ';
    }

    public static char firstUniqChar2(String s) {
        Map<Character, Boolean> dic = new LinkedHashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c));
        for(Map.Entry<Character, Boolean> d : dic.entrySet()){
            if(d.getValue()) return d.getKey();
        }
        return ' ';
    }


}
