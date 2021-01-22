package com.goat.api.designpattern.structuralmodel.proxymodel;

public class ProxyImage implements Image {

    private RealImage realImage;

    private String fileName;

    ProxyImage(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(this.fileName);
        }
        realImage.display();
    }
}
