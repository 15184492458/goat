package com.goat.api.lintcode.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * 列表扁平化
 *
 * 描述
     给定一个列表，该列表中的每个元素要么是个列表，要么是整数。将其变成一个只包含整数的简单列表。

     如果给定的列表中的要素本身也是一个列表，那么它也可以包含列表。

     样例
     样例  1:
     输入: [[1,1],2,[1,1]]
     输出:[1,1,2,1,1]

     样例解释:
     将其变成一个只包含整数的简单列表。

     样例 2:
     输入: [1,2,[1,2]]
     输出:[1,2,1,2]

     样例解释:
     将其变成一个只包含整数的简单列表。

     样例 3:
     输入:[4,[3,[2,[1]]]]
     输出:[4,3,2,1]

     样例解释:
     将其变成一个只包含整数的简单列表。
 */
public class Flatten {

    // @param nestedList a list of NestedInteger
    // @return a list of integer
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        // Write your code here
        List<Integer> ret = new ArrayList<Integer>();
        this.addAll(ret, nestedList);
        return ret;
    }

    private void addAll(List<Integer> ret, List<NestedInteger> nestedList) {
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                ret.add(nestedInteger.getInteger());
            } else {
                this.addAll(ret, nestedInteger.getList());
            }
        }
    }

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    interface NestedInteger {
        // @return true if this NestedInteger holds a single integer,
        // rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds,
        // if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds,
        // if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
}


