package com.goat.api.designpattern.behavioralmodel.responsibilitychainmodel;

public class ErrorLogger extends AbstractLogger {

    ErrorLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}
