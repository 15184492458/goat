package com.goat.api.leetcode;

import org.springframework.util.StringUtils;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。

     字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
    （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。

     进阶：

     如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？

     示例 1：

     输入：s = "abc", t = "ahbgdc"
     输出：true
     示例 2：

     输入：s = "axc", t = "ahbgdc"
     输出：false
      
     提示：

     0 <= s.length <= 100
     0 <= t.length <= 10^4
     两个字符串都只由小写字符组成。
 */
public class IsSubsequence {

    public static void main(String[] args) {
        System.out.println(isSubsequence1("abc","ahbgdcabc"));
    }

    public static boolean isSubsequence(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() == 0) return true;
        if (s.length() > t.length()) return false;
        int tmp = 0;
        int index = 0;
        for (int j = 0;j < t.length();j++){
            if (t.charAt(j) == s.charAt(index)){
                if (++index >= s.length()) return true;
            }
        }
        return false;
    }

    public static boolean isSubsequence1 (String s, String t) {
        int n = s.length(), m = t.length();
        int[][] f = new int[m + 1][26];
        for (int i = 0; i < 26; i++) {
            f[m][i] = m;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a')
                    f[i][j] = i;
                else
                    f[i][j] = f[i + 1][j];
            }
        }
        int add = 0;
        for (int i = 0; i < n; i++) {
            if (f[add][s.charAt(i) - 'a'] == m)
                return false;
            add = f[add][s.charAt(i) - 'a'] + 1;
        }
        for (int i = 0;i < f.length;i++){
            for (int j = 0; j < f[0].length; j++){
                if (j == f[0].length - 1) {
                    System.out.println(f[i][j] + "  ");
                }else {
                    System.out.print(f[i][j] + "    ");
                }
            }
        }
        return true;
    }
}
