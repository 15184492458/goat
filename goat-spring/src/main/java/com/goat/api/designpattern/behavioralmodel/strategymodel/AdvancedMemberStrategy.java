package com.goat.api.designpattern.behavioralmodel.strategymodel;

public class AdvancedMemberStrategy implements MemberStrategy{
    @Override
    public double calcPrice(double booksPrice) {
        return booksPrice * 0.8;//高级会员的折扣为20%
    }
}
