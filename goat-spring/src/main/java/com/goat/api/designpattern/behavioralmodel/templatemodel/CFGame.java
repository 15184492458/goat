package com.goat.api.designpattern.behavioralmodel.templatemodel;

public class CFGame extends Game{


    @Override
    void initialize() {
        System.out.println("CF game initialize");
    }

    @Override
    void start() {
        System.out.println("CF game start");
    }

    @Override
    void end() {
        System.out.println("CF game end");
    }
}
