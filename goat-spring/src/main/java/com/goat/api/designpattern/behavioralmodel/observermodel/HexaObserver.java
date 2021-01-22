package com.goat.api.designpattern.behavioralmodel.observermodel;

public class HexaObserver extends Observer {

    HexaObserver(Subject subject){
        this.subject = subject;
        subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Hex String: " + Integer.toHexString(subject.getState()).toUpperCase());
    }
}
