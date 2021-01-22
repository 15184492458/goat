package com.goat.api.designpattern.creativemode.buildermodel;

/**
 * 创建一个 MealBuilder 类，实际的 builder 类负责创建 Meal 对象。
 */
public class MealBuilder {

    public Meal prepareVegMeal(){
        Meal vegMeal = new Meal();
        vegMeal.addItem(new VegBurger());
        vegMeal.addItem(new Coke());
        return vegMeal;
    }

    public Meal prepareNonVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}
