package com.goat.api.designpattern.behavioralmodel.statemodel;

public class Low implements State {

    private int score;

    private ScoreContext context;

    Low(int score, ScoreContext context) {
        this.score = score;
        this.context = context;
        context.setState(this);
    }

    @Override
    public void setScore(int score) {
        StateUtil.modifyState(score, context);
        System.out.println("current score:" + score + " State: " + context.getState().getName());
    }

    @Override
    public String getName() {
        return "low";
    }

    @Override
    public int getScore() {
        return score;
    }
}
