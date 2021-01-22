package com.goat.api.core.config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class Test {

    public static void main(String[] args) {
        int[] array = {2, 7, 11, 15};
        int[] result = twoSum1(array,9);
        System.out.println(result[0] + "," + result[1]);

    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0;i < nums.length;++i){
            int temp = nums[i];
            for (int j = 0;j < nums.length;++j){
                if (i == j) continue;
                if (target - temp == nums[j]){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }

    public static int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length;++i){
            int temp = target - nums[i];
            if (map.containsKey(temp)){
                result[0] = map.get(temp);
                result[1] = i;
                return result;
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
