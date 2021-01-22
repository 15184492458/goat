package com.goat.api.designpattern.behavioralmodel.strategymodel;

public class PrimaryMemberStrategy implements MemberStrategy {
    @Override
    public double calcPrice(double booksPrice) {
        return booksPrice; //初级会员的没有折扣
    }
}
