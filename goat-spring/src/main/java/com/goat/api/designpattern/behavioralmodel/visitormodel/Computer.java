package com.goat.api.designpattern.behavioralmodel.visitormodel;

public class Computer implements ComputerPart {

    ComputerPart[] parts;

    Computer(){
        parts = new ComputerPart[] {new Mouse(), new Keyboard(), new Monitor()};
    }

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        for (int i = 0; i < parts.length; i++) {
            parts[i].accept(computerPartVisitor);
        }
        computerPartVisitor.visit(this);
    }

    @Override
    public void display() {
        System.out.println("Displaying Computer");
    }
}
