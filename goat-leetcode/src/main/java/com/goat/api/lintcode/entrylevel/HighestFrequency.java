package com.goat.api.lintcode.entrylevel;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 最高频率的IP
 *
 * 描述
     给定一个字符串数组lines, 每一个元素代表一个IP地址，找到出现频率最高的IP。

     给定数据只有一个频率最高的IP

     样例
     样例1:

     输入 = ["192.168.1.1","192.118.2.1","192.168.1.1"]
     输出  "192.168.1.1"
     样例2:

     输入 = ["192.168.1.1","192.118.2.1","192.168.1.1","192.118.2.1","192.118.2.1"]
     输出 "192.118.2.1"
 */
public class HighestFrequency {

    public static void main(String[] args) {
        String[] strs = {"192.168.1.1","192.118.2.1","192.168.1.1"};
        System.out.println(highestFrequency(strs));
    }

    /**
     * @param ipLines: ip  address
     * @return: return highestFrequency ip address
     */
    public static String highestFrequency(String[] ipLines) {
        // Write your code here
        Map<String, Integer> map = new HashMap<>();
        for (String str : ipLines) {
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            }else {
                map.put(str, 1);
            }
        }
        Set<Map.Entry<String,Integer>> set = map.entrySet();
        String maxIp = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : set) {
            if (entry.getValue() > maxCount) {
                maxIp = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        return maxIp;
    }
}
