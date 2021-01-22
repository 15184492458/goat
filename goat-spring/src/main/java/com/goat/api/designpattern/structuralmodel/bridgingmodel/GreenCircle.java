package com.goat.api.designpattern.structuralmodel.bridgingmodel;

public class GreenCircle implements DrawAPI {
    @Override
    public void draw(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: green, radius: " + radius +", x: " +x+", "+ y +"]");
    }
}
