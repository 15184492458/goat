package com.goat.api.designpattern.creativemode.buildermodel;

/**
 * 纸包装
 * 创建实现包装Packing 接口的实体类
 */
public class Wrapper implements Packing{
    @Override
    public String pack() {
        return "Wrapper";
    }
}
