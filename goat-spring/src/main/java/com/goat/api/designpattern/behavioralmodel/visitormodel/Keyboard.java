package com.goat.api.designpattern.behavioralmodel.visitormodel;

public class Keyboard implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }

    @Override
    public void display() {
        System.out.println("Displaying keyboard");
    }
}
