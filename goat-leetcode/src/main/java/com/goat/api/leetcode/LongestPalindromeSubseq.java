package com.goat.api.leetcode;

/**
 * 最长回文子序列：
 * 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。

     示例 1:
     输入:

     "bbbab"
     输出:

     4
     一个可能的最长回文子序列为 "bbbb"。

     示例 2:
     输入:

     "cbbd"
     输出:

     2
     一个可能的最长回文子序列为 "bb"。

     提示：

     1 <= s.length <= 1000
     s 只包含小写英文字母
 */
public class LongestPalindromeSubseq {

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq1("euazbipzncptldueeuechubrcourfpftcebikrxhybkymimgvldiwqvkszfycvqyvtiwfckexmowcxztkfyzqovbtmzpxojfofbvwnncajvrvdbvjhcrameamcfmcoxryjukhpljwszknhiypvyskmsujkuggpztltpgoczafmfelahqwjbhxtjmebnymdyxoeodqmvkxittxjnlltmoobsgzdfhismogqfpfhvqnxeuosjqqalvwhsidgiavcatjjgeztrjuoixxxoznklcxolgpuktirmduxdywwlbikaqkqajzbsjvdgjcnbtfksqhquiwnwflkldgdrqrnwmshdpykicozfowmumzeuznolmgjlltypyufpzjpuvucmesnnrwppheizkapovoloneaxpfinaontwtdqsdvzmqlgkdxlbeguackbdkftzbnynmcejtwudocemcfnuzbttcoew"));
    }

    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public static int longestPalindromeSubseq1(String s) {
        int[][] array = new int[s.length()][s.length()];
        return longestPalindromeSubseq(s,0,s.length()-1, array);
    }

    private static int longestPalindromeSubseq(String s,int start, int end, int[][] array) {
        if (array[start][end] != 0) return array[start][end];
        if (start == end) return 1;
        if (start > end) return 0;
        if (s.charAt(start) == s.charAt(end)){
            array[start][end] = longestPalindromeSubseq(s,start + 1, end - 1, array) + 2;
        }else {
            array[start][end] = Math.max(longestPalindromeSubseq(s,start, end - 1, array), longestPalindromeSubseq(s,start + 1, end, array));
        }
        return array[start][end];
    }
}
