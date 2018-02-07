package com.ruge.StreamAPI;

import com.ruge.lambda表达式.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 武健
 * \* Date: 2018/2/6
 * \* Time: 21:51
 * \* To change this template use File | Settings | File Templates.
 * \* Description:StreamAPI中间操作
 * \
 */
public class MiddleStreamAPI {
    List<User> users = Arrays.asList(
            new User("刘一", "1", "1"),
            new User("陈二", "2", "2"),
            new User("张三", "3", "3"),
            new User("李四", "4", "4"),
            new User("王五", "5", "5"),
            new User("赵六", "6", "6"),
            new User("孙七", "7", "7"),
            new User("周八", "8", "8"),
            new User("吴九", "9", "9"),
            new User("郑十", "10", "10")
    );
    /**
     * 筛选与切片
     *      filter——接收 Lambda ， 从流中排除某些元素。
     *      limit——截断流，使其元素不超过给定数量。
     *      skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n)
     *      distinct——筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
     */
    /**
     * 内部迭代 由StreamAPI完成
     */
    @Test
    public void test1() {
        /**
         * 只有当做终止操作时，所有的中间操作会一次性的全部执行，称为“惰性求值”
         */
        users.stream()
                .filter((e) -> Integer.valueOf(e.getAge()) > 5)
                .filter((e) -> Integer.valueOf(e.getSale()) > 5)
                .filter((e) -> {
                    System.out.print("");
                    return true;
                })
                .forEach(System.out::println);

    }


    /**
     * 外部迭代
     */
    @Test
    public void test2() {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     * 跳过第一个满足条件的数据
     */
    @Test
    public void test3() {
        users.stream()
                .filter((e) -> Integer.valueOf(e.getAge()) > 5)
                .skip(1)
                .forEach(System.out::println);
    }

    /**
     * 映射
     * map——接收 Lambda ， 将元素转换成其他形式或提取信息。
     * 接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
     * flatMap——接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
     */
    @Test
    public void test4() {
        List<String> list = Arrays.asList("aaa", "qqq", "www");
        list.stream()
                .map((s) -> s.toUpperCase())
                .forEach(System.out::println);
        users.stream()
                .map((e) -> e.getName())
                .forEach(System.out::println);
        list.stream()
                .map(MiddleStreamAPI::filterCharacter)
                .forEach((e) -> e.forEach(System.out::println));
        list.stream()
                .map((e) -> e.toUpperCase())
                .flatMap(MiddleStreamAPI::filterCharacter)
                .forEach(System.out::println);
    }

    public static Stream<Character> filterCharacter(String str) {
        char[] charArray = str.toCharArray();
        List<Character> list = new ArrayList<>();
        for (Character chr : charArray) {
            list.add(chr);
        }
        return list.stream();
    }

    /**
     * sorted()——自然排序
     * sorted(Comparator com)——定制排序
     */
    @Test
    public void test5() {
        List<Integer> list = Arrays.asList(1, 2, 9, 8, 7, 6, 5, 4, 3);
        list.stream()
                .sorted()
                .forEach(System.out::println);
        users.stream()
                .sorted((e1, e2) -> {
                            return Integer.valueOf(e1.getAge()).compareTo(Integer.valueOf(e2.getAge()));
                        }
                ).forEach(System.out::println);
    }


}