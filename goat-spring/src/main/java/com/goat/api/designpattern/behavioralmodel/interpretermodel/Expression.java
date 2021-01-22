package com.goat.api.designpattern.behavioralmodel.interpretermodel;

/**
 * 抽象表达式角色
 */
public interface Expression {

    /**
     * 以环境为准，本方法解释给定的任何一个表达式
     * @param ctx
     * @return
     */
    boolean interpret(Context ctx);

    /**
     * 检验两个表达式在结构上是否相同
     * @param obj
     * @return
     */
    boolean equals(Object obj);

    /**
     * 返回表达式的hash code
     * @return
     */
    int hashCode();

    /**
     * 将表达式转换成字符串
     * @return
     */
    String toString();
}
