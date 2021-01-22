package com.goat.api.designpattern.behavioralmodel.commandmodel;

public class SellStock implements Order {

    private Stock stock;

    SellStock(Stock stock) {
        this.stock = stock;
    }
    @Override
    public void execute() {
        stock.sell();
    }
}
