package com.goat.api.leetcode;

import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Stream;

/**
 * 给定任意一个字符串，求出现次数最多的字符。
 */
public class FindMaxCharFromStr {

    public static void main(String[] args) {
        char c = findMaxCharFromStr("123222633333336");
        System.out.println(c);
    }

    public static char findMaxCharFromStr (String str) {
        if (str == null || str.length() < 1) return ' ';
        Map<Character,Integer> map = new HashMap();
        char[] chars = str.toCharArray();
        for (char c : chars){
            Integer tmp = map.get(c);
            if (tmp == null){
                map.put(c,0);
            }else {
                map.put(c,++tmp);
            }
        }
        Set<Map.Entry<Character,Integer>> set = map.entrySet();
        Integer maxValue = 0;
        Character result = ' ';
        for (Map.Entry<Character,Integer> entry : set){
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }

    public static char findMaxCharFromStr1 (String str) {
        if (StringUtils.isEmpty(str)) return ' ';
        char[] chars = str.toCharArray();
        int[] numbers = new int[200];
        for (char c : chars){
            numbers[c] = numbers[c] + 1;
        }
        int max = numbers[0];
        char result = ' ';
        for (char c : chars){
            if (numbers[c] > max) {
                result = c;
                max = numbers[c];
            }
        }
        return result;
    }
}
