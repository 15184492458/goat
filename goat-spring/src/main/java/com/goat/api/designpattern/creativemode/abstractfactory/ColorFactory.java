package com.goat.api.designpattern.creativemode.abstractfactory;

public class ColorFactory implements AbstractFactory {
    @Override
    public Color getColor(String color) {
        if(color == null) return null;
        if(color.equalsIgnoreCase("RED")){
            return new Red();
        } else if(color.equalsIgnoreCase("GREEN")){
            return new Green();
        } else if(color.equalsIgnoreCase("BLUE")){
            return new Blue();
        }
        return null;
    }

    @Override
    public Shape getShape(String shape) {
        return null;
    }
}
