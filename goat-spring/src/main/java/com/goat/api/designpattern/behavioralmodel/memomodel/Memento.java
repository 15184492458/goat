package com.goat.api.designpattern.behavioralmodel.memomodel;

/**
 * 备忘录
 */
public class Memento {

    private String state;

    Memento(String state){
        this.state = state;
    }

    String getState(){
        return state;
    }
}
