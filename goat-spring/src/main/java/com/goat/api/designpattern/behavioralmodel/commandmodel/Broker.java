package com.goat.api.designpattern.behavioralmodel.commandmodel;

import java.util.ArrayList;
import java.util.List;

/**
 * 命令调用类
 */
public class Broker {

    private List<Order> orderList = new ArrayList<Order>();

    /**
     * 新增命令(发布命令)
     * @param order
     */
    public void takeOrder(Order order){
        orderList.add(order);
    }

    /**
     * 执行命令，而后删除已经执行的命令
     */
    public void placeOrders(){
        for (Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    }
}
