package com.goat.api.designpattern.creativemode.prototypemodel;

/**
 * 创建一个实现了 Cloneable 接口的抽象类。
 */
public abstract class Phone implements Cloneable {

    private String id;

    protected String type;

    abstract void call();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object clone(){
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
