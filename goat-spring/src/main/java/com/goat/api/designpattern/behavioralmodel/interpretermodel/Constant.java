package com.goat.api.designpattern.behavioralmodel.interpretermodel;

/**
 * 常量
 * 一个Constant对象代表一个布尔常量
 */
public class Constant implements Expression {

    private boolean value;

    Constant(boolean value){
        this.value = value;
    }

    @Override
    public boolean interpret(Context ctx) {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj != null && obj instanceof Constant){
            return this.value == ((Constant)obj).value;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public String toString() {
        return new Boolean(value).toString();
    }
}
