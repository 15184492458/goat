package com.goat.api.designpattern.creativemode.abstractfactory;

public interface AbstractFactory {

    public abstract Color getColor(String color);

    public abstract Shape getShape(String shape);
}
