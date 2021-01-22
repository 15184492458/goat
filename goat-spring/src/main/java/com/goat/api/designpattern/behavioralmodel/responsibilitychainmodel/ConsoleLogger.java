package com.goat.api.designpattern.behavioralmodel.responsibilitychainmodel;

/**
 * 创建扩展了该记录器类的实体类。
 */
public class ConsoleLogger extends AbstractLogger{

    ConsoleLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}
