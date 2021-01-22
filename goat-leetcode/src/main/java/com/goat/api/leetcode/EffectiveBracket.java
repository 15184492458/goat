package com.goat.api.leetcode;

import java.util.Stack;
import java.util.function.Predicate;

/**
 * 有效括号：
 *  给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

     有效字符串需满足：

     左括号必须用相同类型的右括号闭合。
     左括号必须以正确的顺序闭合。
     注意空字符串可被认为是有效字符串。

     示例 1:

     输入: "()"
     输出: true
     示例 2:

     输入: "()[]{}"
     输出: true
     示例 3:

     输入: "(]"
     输出: false
     示例 4:

     输入: "([)]"
     输出: false
     示例 5:

     输入: "{[]}"
     输出: true
 */
public class EffectiveBracket {

    public static void main(String[] args) {
        String str = "({])[]";
        System.out.println(effective(str));
    }

    public static boolean effective(String str){
        if (str == null) return false;
        char[] chars = str.toCharArray();
        Stack<Character> stack = new Stack();
        for (int i = 0;i < chars.length;++i){
            Character character = stack.empty() ? ' ' : stack.peek();
            Predicate<Character> predicate = c -> '(' == character && ')' == c;
            boolean effective = predicate.or(c -> '{' == character && '}' == c)
                    .or(c -> '[' == character && ']' == c)
                    .test(chars[i]);
            if (effective){
                stack.pop();
            }else{
                stack.push(chars[i]);
            }
        }
        return stack.empty() ? true : false;
    }
}
