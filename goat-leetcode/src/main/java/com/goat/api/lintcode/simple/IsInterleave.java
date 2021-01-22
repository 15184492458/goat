package com.goat.api.lintcode.simple;

/**
 * 交叉字符串:
 * 描述
     给出三个字符串:s1、s2、s3，判断s3是否由s1和s2交叉构成。

     您在真实的面试中是否遇到过这个题？
     样例
     样例 1：

     输入:
     "aabcc"
     "dbbca"
     "aadbbcbcac"
     输出:
     true
     样例 2：

     输入:
     ""
     ""
     "1"
     输出:
     false
     样例 3：

     输入:
     "aabcc"
     "dbbca"
     "aadbbbaccc"
     输出:
     false
     挑战
     要求时间复杂度为O(n2)或者更好
 */
public class IsInterleave {


    /**
     * @param s1: A string
     * @param s2: A string
     * @param s3: A string
     * @return: Determine whether s3 is formed by interleaving of s1 and s2
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        //dp[i][j]表示s3的前i + j可以由s1的前i个和s2前j个组成。
        int s1len = s1.length(), s2len = s2.length(),s3len = s3.length();
        if (s1len + s2len != s3len) return false;
        if(s1len == 0) return s2 == s3;
        if(s2len == 0) return s1 == s3;
        boolean[][] dp = new boolean[s1len + 1][s2len + 1];
        dp[0][0] = true;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char[] c3 = s3.toCharArray();
        for (int i = 1; i <= s1len; i++) {
            dp[i][0] = dp[i - 1][0] && c1[i - 1] == c3[i - 1];
        }
        for (int i = 1; i <= s2len; i++) {
            dp[0][i] = dp[0][i - 1] && c2[i - 1] == c3[i - 1];
        }
        for (int i = 1; i <= s1len; i++) {
            for (int j = 1; j <= s2len; j++) {
                dp[i][j] = false;
                if (c1[i - 1] == c3[i + j - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j];
                }
                if (c2[j - 1] == c3[i + j - 1]) {
                    dp[i][j] = dp[i][j] || dp[i][j - 1];
                }
            }
        }

        return dp[s1len][s2len];
    }
}
