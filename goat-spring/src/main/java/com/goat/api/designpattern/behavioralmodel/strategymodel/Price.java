package com.goat.api.designpattern.behavioralmodel.strategymodel;

public class Price {

    MemberStrategy strategy;

    Price(MemberStrategy strategy){
        this.strategy = strategy;
    }

    public double cal(double price){
        return strategy.calcPrice(price);
    }
}
