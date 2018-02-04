package com.ruge.lambda表达式;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 武健
 * \* Date: 2018/2/4
 * \* Time: 19:12
 * \* To change this template use File | Settings | File Templates.
 * \* Description:函数式接口
 * \
 */
@FunctionalInterface
public interface MyFunction<T> {
    public Integer getValue(Integer num);
}
