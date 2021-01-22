package com.goat.api.designpattern.behavioralmodel.intermediarymodel;

public class User {

    private String name;

    User(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sendMessage(String message){
        ChatRoom.showMessage(this,message);
    }
}
