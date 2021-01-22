package com.goat.api.designpattern.behavioralmodel.templatemodel;

public class CSGame extends Game {
    @Override
    void initialize() {
        System.out.println("CS game initialize");
    }

    @Override
    void start() {
        System.out.println("CS game start");
    }

    @Override
    void end() {
        System.out.println("CS game end");
    }
}
