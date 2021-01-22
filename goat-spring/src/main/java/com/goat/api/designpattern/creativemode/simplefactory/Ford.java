package com.goat.api.designpattern.creativemode.simplefactory;

public class Ford implements Car{
    @Override
    public void run() {
        System.out.println("Ford car run");
    }

    @Override
    public void stop() {
        System.out.println("Ford car stop");
    }
}
