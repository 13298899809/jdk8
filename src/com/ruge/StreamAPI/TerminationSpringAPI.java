package com.ruge.StreamAPI;

import com.ruge.lambda表达式.User;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 武健
 * \* Date: 2018/2/6
 * \* Time: 23:16
 * \* To change this template use File | Settings | File Templates.
 * \* Description:终止操作
 * allMatch——检查是否匹配所有元素
 * anyMatch——检查是否至少匹配一个元素
 * noneMatch——检查是否没有匹配的元素
 * findFirst——返回第一个元素
 * findAny——返回当前流中的任意元素
 * count——返回流中元素的总个数
 * max——返回流中最大值
 * min——返回流中最小值
 * \
 */
public class TerminationSpringAPI {
    List<User> users = Arrays.asList(
            new User("刘一", "1", "1", "1"),
            new User("陈二", "2", "2", "1"),
            new User("张三", "3", "3", "1"),
            new User("李四", "4", "4", "1"),
            new User("王五", "5", "5", "1"),
            new User("赵六", "6", "6", "1"),
            new User("孙七", "7", "7", "1"),
            new User("周八", "8", "8", "1"),
            new User("吴九", "9", "9", "1"),
            new User("郑十", "10", "10", "2")
    );

    @Test
    public void test1() {
        boolean b = users.stream().allMatch((e) -> e.getSex().equals("1"));
        boolean b1 = users.stream().anyMatch((e) -> e.getSex().equals("1"));
        boolean b2 = users.stream().noneMatch((e) -> e.getSex().equals("1"));
        System.out.println(b);
        System.out.println(b1);
        System.out.println(b2);
        Optional<User> first = users.stream().findFirst();
        System.out.println(first);
        Optional<User> any = users.stream().filter((e) -> e.getSex().equals("1")).findAny();
        System.out.println(any);
        Optional<User> any1 = users.parallelStream().filter((e) -> e.getSex().equals("1")).findAny();
        System.out.println(any1);
        long count = users.stream().count();
        System.out.println(count);
        Optional<User> max = users.stream().max((e1, e2) -> Integer.valueOf(e1.getSale()).compareTo(Integer.valueOf(e2.getSale())));
        System.out.println(max);
    }

    /**
     * 规约
     * reduce() 可以将元素反复结合起来,得到一个值
     */
    @Test
    public void test2() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        /**
         * 0作为起始值,  x=0 y=1 x+y=1
         *             x=1 y=2 x+y=3
         *             x=3 y=3 x+y=6
         */
        Integer reduce = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(reduce);
    }

    /**
     * 收集
     * collect 将流转换成其他形式 接收一个Collector接口的实现 用于给Stream中元素做汇总的方法
     * 需求:获取用户下的用户姓名 并封装给一个新的list集合
     */
    @Test
    public void test3() {
        List<String> collect = users.stream()
                .map(e -> (e.getName()))
                .collect(Collectors.toList());
        collect.forEach(System.out::println);

    }
}