package com.goat.api.lintcode.simple;

/**
 * 145. 大小写转换
         将一个字符由小写字母转换为大写字母

         样例
         样例 1:

         输入: 'a'
         输出: 'A'
         样例 2:

         输入: 'b'
         输出: 'B'
 */
public class LowercaseToUppercase {

    public static void main(String[] args) {
        lowercaseToUppercase(1,2);
    }

    public static int lowercaseToUppercase(int a,int b) {
        int result = a | b;
        return 0;
    }
}
