package com.goat.api.leetcode;

import com.sun.deploy.util.StringUtils;

import java.util.Arrays;

public class ReplaceSpace {

    public static void main(String[] args) {
        System.out.println(replaceSpace3("We are happy."));
    }

    public static String replaceSpace3(String s) {
        if (s == null || s.length() <= 0) return s;
        String string = s.replaceAll(" ", "%20");
        return string;
    }

    public static String replaceSpace2(String s){
        if (s == null || s.length() <= 0) return s;
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == ' '){
                string.append("%20");
            } else {
                string.append(c);
            }

        }
        return string.toString();
    }

    public static String replaceSpace1(String s){
        if (s == null || s.length() <= 0) return s;
        char[] newChars = new char[s.length()*3];
        int num = 0, newNum = 0;
        while (num < s.length()){
            char c = s.charAt(num);
            if (c == ' '){
                newChars[newNum++] = '%';
                newChars[newNum++] = '2';
                newChars[newNum++] = '0';
            }else {
                newChars[newNum++] = c;
            }
            num++;
        }
        String result = new String(newChars, 0, newNum);
        return result;
    }
}
