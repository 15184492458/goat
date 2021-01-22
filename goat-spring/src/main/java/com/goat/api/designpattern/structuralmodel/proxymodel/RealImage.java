package com.goat.api.designpattern.structuralmodel.proxymodel;

public class RealImage implements Image {

    private String fileName;

    RealImage(String fileName){
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    private void loadFromDisk(String fileName) {
        System.out.println("Loading " + fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }
}
