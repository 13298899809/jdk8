package com.ruge.方法引用于构造方法引用;

import com.ruge.lambda表达式.User;
import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 武健
 * \* Date: 2018/2/5
 * \* Time: 20:13
 * \* To change this template use File | Settings | File Templates.
 * \* Description: 方法引用:若Lambda体中的内容有方法已经实现,我们使用"方法引用"(可以理解为Lambda表达式的另一种表现形式)
 * \
 */
public class 方法引用 {
    /**
     * 一 对象::实例方法名
     */
    @Test
    public void test1() {
        Consumer<String> consumer = (x) -> System.out.println(x);
        consumer.accept("千年之恋");
        Consumer<String> consumer1 = System.out::println;
        consumer1.accept("谁在悬崖沏一壶茶");
    }

    @Test
    public void test2() {
        User user = new User();
        user.setName("张三");
        Supplier<String> supplier = () -> user.getName();
        Supplier<String> supplier1 = user::getName;
        String s = supplier.get();
        String s1 = supplier1.get();
        System.out.println("s:" + s);
        System.out.println("s1:" + s1);
    }

    /**
     * 二 类::静态方法名
     */
    @Test
    public void test3() {
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
        int compare = comparator.compare(2, 4);
        System.out.println(compare);

        Comparator<Integer> comparator1 = Integer::compare;
        int compare1 = comparator1.compare(2, 4);
        System.out.println(compare1);
    }

    /**
     * 三 类::实例方法名
     */
    @Test
    public void test4() {
        BiPredicate<String, String> biPredicate = (x, y) -> x.equals(y);
        boolean test = biPredicate.test("1", "1");
        System.out.println(test);
        BiPredicate<String, String> biPredicate1 = String::equals;
        boolean test1 = biPredicate1.test("1", "1");
        System.out.println(test1);
    }

}