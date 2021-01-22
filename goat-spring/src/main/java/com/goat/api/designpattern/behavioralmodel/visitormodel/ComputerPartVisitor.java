package com.goat.api.designpattern.behavioralmodel.visitormodel;

/**
 * 定义一个表示访问者的接口。
 */
public interface ComputerPartVisitor {

    public void visit(ComputerPart computer);
}
