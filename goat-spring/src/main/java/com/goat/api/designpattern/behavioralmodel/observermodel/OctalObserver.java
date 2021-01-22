package com.goat.api.designpattern.behavioralmodel.observermodel;

public class OctalObserver extends Observer {

    OctalObserver(Subject subject){
        this.subject = subject;
        subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Octal String: " + Integer.toOctalString( subject.getState() ) );
    }
}
