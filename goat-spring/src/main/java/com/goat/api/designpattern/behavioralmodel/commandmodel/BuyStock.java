package com.goat.api.designpattern.behavioralmodel.commandmodel;

public class BuyStock implements Order {

    private Stock stock;

    BuyStock(Stock stock){
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.buy();
    }
}
