package com.goat.api.lintcode.simple;

/**
 * 字符串查找:
 * 描述
     对于一个给定的 source 字符串和一个 target 字符串，你应该在 source 字符串中找出 target 字符串出现的第一个位置(从0开始)。如果不存在，则返回 -1。

     您在真实的面试中是否遇到过这个题？
     说明
     在面试中我是否需要实现KMP算法？

     不需要，当这种问题出现在面试中时，面试官很可能只是想要测试一下你的基础应用能力。当然你需要先跟面试官确认清楚要怎么实现这个题。
     样例
     样例 1:

     输入: source = "source" ， target = "target"
     输出:-1
     样例解释: 如果source里没有包含target的内容，返回-1
     样例 2:

     输入: source = "abcdabcdefg" ，target = "bcd"
     输出: 1
     样例解释: 如果source里包含target的内容，返回target在source里第一次出现的位置
     挑战
     O(n2)的算法是可以接受的。如果你能用O(n)的算法做出来那更加好。（提示：KMP）
 */
public class StrStr {

    public static void main(String[] args) {
        System.out.println(strStr("abtarget","target"));
    }

    /**
     * @param source:
     * @param target:
     * @return: return the index
     */
    public static int strStr(String source, String target) {
        // Write your code here
        int i = 0;
        int j = 0;
        int slength = source.length();
        int tlength = target.length();
        while (i < slength && j < tlength){
            if (source.charAt(i) == target.charAt(j))
            {
                //①如果当前字符匹配成功（即S[i] == P[j]），则i++，j++
                i++;
                j++;
            }else{
                //②如果失配（即S[i]! = P[j]），令i = i - (j - 1)，j = 0
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == tlength)
            return i - j;
        else
            return -1;
    }
}
