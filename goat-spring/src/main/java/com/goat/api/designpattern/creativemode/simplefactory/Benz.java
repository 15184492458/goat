package com.goat.api.designpattern.creativemode.simplefactory;

public class Benz implements Car {
    @Override
    public void run() {
        System.out.println("Benz car run");
    }

    @Override
    public void stop() {
        System.out.println("Benz car stop");
    }
}
