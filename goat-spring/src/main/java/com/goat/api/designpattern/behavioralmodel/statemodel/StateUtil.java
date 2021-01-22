package com.goat.api.designpattern.behavioralmodel.statemodel;

public class StateUtil {

    public static void modifyState(int score, ScoreContext context) {
        if (score >= 60 && score < 80) {
            new Middle(score, context);
        } else if (score >= 80) {
            new High(score, context);
        } else {
            new Low(score, context);
        }
    }
}
