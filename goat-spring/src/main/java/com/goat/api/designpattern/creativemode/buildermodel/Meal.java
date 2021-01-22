package com.goat.api.designpattern.creativemode.buildermodel;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建一个 Meal 类，带有上面定义的 Item 对象。
 */
public class Meal {

    private List<Item> items = new ArrayList<>();

    /**
     * 添加Item
     * @param item
     */
    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * 获取所有Item价钱
     * @return
     */
    public float getPrice(){
        float cost = 0.0f;
        for (Item item : items) {
            cost += item.price();
        }
        return cost;
    }

    /**
     * 打印Items
     */
    public void showItems(){
        for (Item item : items) {
            System.out.print("Item : " + item.name());
            System.out.print(", Packing : " + item.packing().pack());
            System.out.println(", Price : " + item.price());
        }
    }
}
