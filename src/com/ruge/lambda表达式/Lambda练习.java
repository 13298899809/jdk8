package com.ruge.lambda表达式;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 武健
 * \* Date: 2018/2/4
 * \* Time: 19:25
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class Lambda练习 {
    /**
     * 1 调用Collections.sort(),通过定制排序比较两个User对象(年龄,工资),使用Lambda作为参数传递
     */
    List<User> users = Arrays.asList(
            new User("刘一", "11", "11"),
            new User("陈二", "11", "2"),
            new User("张三", "3", "3"),
            new User("李四", "4", "4"),
            new User("王五", "5", "5"),
            new User("赵六", "6", "6"),
            new User("孙七", "7", "7"),
            new User("周八", "8", "8"),
            new User("吴九", "9", "9"),
            new User("郑十", "10", "10")
    );

    @Test
    public void test1() {
        /**
         * jdk8 之前集合的遍历
         */
        for (User u:users
             ) {
            System.out.println(u.getName());
        }
        System.out.println("-----------------------------");
        /**
         * jdk 8 集合的遍历
         */
        users.forEach(e-> System.out.println(e.getName()));
    }
}