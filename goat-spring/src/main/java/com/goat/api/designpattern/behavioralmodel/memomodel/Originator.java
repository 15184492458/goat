package com.goat.api.designpattern.behavioralmodel.memomodel;

/**
 * 创建者
 */
public class Originator {

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    /**
     * 存储state至备忘录
     * @return
     */
    public Memento saveStateToMemento(){
        return new Memento(state);
    }

    /**
     * 从备忘录中回写state
     * @param memento
     */
    public void  getStateFromMemento(Memento memento){
        this.state = memento.getState();
    }
}
