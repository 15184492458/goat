package com.goat.api.designpattern.creativemode.abstractfactory;

public class ShapeFactory implements AbstractFactory {
    @Override
    public Color getColor(String color) {
        return null;
    }

    @Override
    public Shape getShape(String shape) {
        if(shape == null) return null;
        if(shape.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shape.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shape.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
}