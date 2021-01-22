package com.goat.api.designpattern.structuralmodel.appearancemodel;

public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Square::draw()");
    }
}
