package com.goat.api.designpattern.behavioralmodel.visitormodel;

/**
 * 创建实现了类的实体访问者。
 */
public class ComputerPartDisplayVisitor implements ComputerPartVisitor{

    @Override
    public void visit(ComputerPart computer) {
        computer.display();
    }
}
