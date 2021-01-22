package com.goat.api.designpattern.behavioralmodel.strategymodel;

public class IntermediateMemberStrategy implements MemberStrategy {
    @Override
    public double calcPrice(double booksPrice) {
        return booksPrice * 0.9;//中级会员的折扣为10%
    }
}
