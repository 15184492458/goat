package com.goat.api.leetcode.competition.thirtysix;

import java.util.*;

/**
 * 找到处理最多请求的服务器:
 * 你有 k 个服务器，编号为 0 到 k-1 ，它们可以同时处理多个请求组。每个服务器有无穷的计算能力但是 不能同时处理超过一个请求 。请求分配到服务器的规则如下：

     第 i （序号从 0 开始）个请求到达。
     如果所有服务器都已被占据，那么该请求被舍弃（完全不处理）。
     如果第 (i % k) 个服务器空闲，那么对应服务器会处理该请求。
     否则，将请求安排给下一个空闲的服务器（服务器构成一个环，必要的话可能从第 0 个服务器开始继续找下一个空闲的服务器）。比方说，如果第 i 个服务器在忙，那么会查看第 (i+1) 个服务器，第 (i+2) 个服务器等等。
     给你一个 严格递增 的正整数数组 arrival ，表示第 i 个任务的到达时间，和另一个数组 load ，其中 load[i] 表示第 i 个请求的工作量（也就是服务器完成它所需要的时间）。你的任务是找到 最繁忙的服务器 。最繁忙定义为一个服务器处理的请求数是所有服务器里最多的。

     请你返回包含所有 最繁忙服务器 序号的列表，你可以以任意顺序返回这个列表。

     示例 1：

     输入：k = 3, arrival = [1,2,3,4,5], load = [5,2,3,3,3]
     输出：[1]
     解释：
     所有服务器一开始都是空闲的。
     前 3 个请求分别由前 3 台服务器依次处理。
     请求 3 进来的时候，服务器 0 被占据，所以它呗安排到下一台空闲的服务器，也就是服务器 1 。
     请求 4 进来的时候，由于所有服务器都被占据，该请求被舍弃。
     服务器 0 和 2 分别都处理了一个请求，服务器 1 处理了两个请求。所以服务器 1 是最忙的服务器。
     示例 2：

     输入：k = 3, arrival = [1,2,3,4], load = [1,2,1,2]
     输出：[0]
     解释：
     前 3 个请求分别被前 3 个服务器处理。
     请求 3 进来，由于服务器 0 空闲，它被服务器 0 处理。
     服务器 0 处理了两个请求，服务器 1 和 2 分别处理了一个请求。所以服务器 0 是最忙的服务器。
     示例 3：

     输入：k = 3, arrival = [1,2,3], load = [10,12,11]
     输出：[0,1,2]
     解释：每个服务器分别处理了一个请求，所以它们都是最忙的服务器。
     示例 4：

     输入：k = 3, arrival = [1,2,3,4,8,9,10], load = [5,2,10,3,1,2,2]
     输出：[1]
     示例 5：

     输入：k = 1, arrival = [1], load = [1]
     输出：[0]
      
     提示：

     1 <= k <= 105
     1 <= arrival.length, load.length <= 105
     arrival.length == load.length
     1 <= arrival[i], load[i] <= 109
     arrival 保证 严格递增 。
 */
public class BusiestServers {

    //Node类，把服务器编号与运行截止时间绑在一起丢进优先队列，实现排序接口
    private class Node implements Comparable<Node>{
        int server;
        int time;
        Node(int server,int time){
            this.server = server;
            this.time = time;
        }

        @Override
        public int compareTo(Node other) {
            return this.time - other.time;
        }
    }
    //优先队列用于维护运行服务器截止时间，每次插入LogN
    PriorityQueue<Node> queue = new PriorityQueue<Node>();
    //维护空闲服务器，便于查找（每次查找耗时LogN）
    TreeMap<Integer,Integer> treeMap = new TreeMap<>();

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {

        //记录每个服务器接收请求数
        int[] num = new int[k];
        //初始，每个服务器都可用，丢进TreeMap
        for(int i=0;i<k;i++){
            treeMap.put(i,0);
        }

        for(int i=0;i<arrival.length;i++){

            //接收第i个请求时，把已运行截止的请求从优先队列中删掉，并释放对应的服务器（丢进treeMap）
            while(!queue.isEmpty() && queue.peek().time < arrival[i]){
                treeMap.put(queue.peek().server,0);
                queue.poll();
            }

            //找第i%k服务器是否空闲，如果不空闲找它后面的空闲的服务器【treeMap特性，ceilingKey()返回>=i%k最小的空闲服务器号】
            Integer index = treeMap.ceilingKey(i%k);
            //index是包装类，所以找不到时等于null
            if(index == null){
                //如果>=i%k找不到，那么从0开始找
                index = treeMap.ceilingKey(-1);
            }
            //如果还是找不到空闲服务器，则舍弃该请求，所以只需判断index != null的情况
            if(index != null){
                //把该请求的截止时间丢进优先队列，注意load是持续时间，所以要-1
                queue.add(new Node(index,arrival[i]+load[i]-1));
                //index开始运行，那么把index服务器从treeMap中去掉
                treeMap.remove(index);
                //记录第index服务器累计接收请求数+1
                num[index]++;
            }
        }
        //找最大请求数
        int max = 0;
        for(int i=0;i<k;i++){
            max = Math.max(max,num[i]);
        }

        List<Integer> ans = new ArrayList<>();
        //把=最大请求数的服务器编号丢进答案
        for(int i=0;i<k;i++){
            if(num[i] == max){
                ans.add(i);
            }
        }
        return ans;
    }
}
