package com.ruge.方法引用于构造方法引用;

import org.junit.Test;

import java.util.function.Function;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 武健
 * \* Date: 2018/2/5
 * \* Time: 21:55
 * \* To change this template use File | Settings | File Templates.
 * \* Description:数组引用
 * \            格式:Type::new
 */
public class 数组引用 {
    @Test
    public void test1() {
        Function<Integer, String[]> function = (x) -> new String[x];
        String[] apply = function.apply(2);
        System.out.println(apply.length);

        Function<Integer, String[]> function1 = String[]::new;
        String[] apply1 = function.apply(2);
        System.out.println(apply1.length);

    }
}