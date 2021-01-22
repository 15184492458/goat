package com.goat.api.designpattern.behavioralmodel.statemodel;

public class ScoreContext {

    private State state;

    public ScoreContext() {
        this.state = new Low(0, this);
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setScore(int score) {
        state.setScore(score);
    }
}
