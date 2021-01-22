package com.goat.api.designpattern.behavioralmodel.templatemodel;

public abstract class Game {

    abstract void initialize();

    abstract void start();

    abstract void end();

    /* 模板方法 */
    public final void play(){
        //初始化
        initialize();
        //开始游戏
        start();
        //结束游戏
        end();
    }

}
