package com.goat.api.lintcode.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数n. 从 1 到 n 按照下面的规则打印每个数：

     如果这个数被3整除，打印fizz.
     如果这个数被5整除，打印buzz.
     如果这个数能同时被3和5整除，打印fizz buzz.
     如果这个数既不能被 3 整除也不能被 5 整除，打印数字本身。
 */
public class FizzBuzz {


    /**
     * @param n: An integer
     * @return: A list of strings.
     */
    public List<String> fizzBuzz(int n) {
        // write your code here
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; ++i){
            int mod = 0;
            mod+=(i % 3 == 0 ? 0 : 1);
            mod+=(i % 5 == 0 ? 0 : 2);
            switch (mod){
                case 0 : list.add("fizz buzz");
                case 1 : list.add("buzz");
                case 2 : list.add("fizz");
                case 3 : list.add(String.valueOf(i));
            }
        }
        return list;
    }
}
