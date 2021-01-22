package com.goat.api.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LargeGroupPositions {

    public List<List<Integer>> largeGroupPositions(String s) {
        List result = new ArrayList<>();
        char tmpChar = s.charAt(0);
        int tmpCharCount = 0;
        for (int i = 0;i < s.length();++i){
            if (s.charAt(i) == tmpChar){
                ++tmpCharCount;
                if (tmpCharCount >= 3 && (i + 1) < s.length() && s.charAt(i + 1) != tmpChar){
                    List<Integer> list = new ArrayList();
                    list.add(tmpCharCount - i);
                }
            }else {

            }

        }

        return null;
    }
}
