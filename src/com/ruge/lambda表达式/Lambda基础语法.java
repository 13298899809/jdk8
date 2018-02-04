package com.ruge.lambda表达式;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 武健
 * \* Date: 2018/2/4
 * \* Time: 17:09
 * \* To change this template use File | Settings | File Templates.
 * \* Description:Lambda基础语法
 * \
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * 一 : lambda基础语法:java8 中引入了一个全新的操作符 "->" 该操作符称之为箭头操作符或Lambda操作符
 * 箭头操作符 Lambda 将表达式拆分成两部分
 * 左侧:Lambda 表达式的参数列表
 * 右侧:Lambda 表达式中所需执行的功能, 即 Lambda 体
 * <p>
 * 二 : Lambda 表达式需要"函数式接口" 的支持
 * 函数式接口:接口中只有一个抽象方法的接口,称为函数式接口.
 */

public class Lambda基础语法 {
    /**
     * 语法格式一:无参数 无返回值
     * () ->
     */
    @Test
    public void Lambda1() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World");
            }
        };
        runnable.run();
        System.out.println("---------------------------------------");
        Runnable runnable1 = () -> System.out.println("Hello Lambda");
        runnable1.run();
    }

    /**
     * 语法格式二:有参数 无返回值
     * () ->
     */
    @Test
    public void Lambda2() {
        Consumer<String> consumer = (e) -> System.out.println("===" + e);
        consumer.accept("张三");
    }

    /**
     * 语法格式三:有参数 无返回值
     */
    @Test
    public void Lambda3() {
        Consumer<String> consumer = e -> System.out.println(e);
        consumer.accept("李四");
    }

    /**
     * 语法格式四:有两个以上参数 并且Lambda体中有多条语句 , 有返回值
     * Comparator<Integer> comparator = (x,y) -> {
     * System.out.println("函数式接口");
     * return Integer.compare(x,y);
     * };
     */
    @Test
    public void Lambda4() {
        Comparator<Integer> comparator = (x, y) -> {
            System.out.println("函数式接口");
            System.out.println(Integer.compare(x, y));
            return Integer.compare(x, y);
        };
        comparator.compare(1, 2);
    }

    /**
     * 语法格式五:若Lambda中只有一条语句, return 和 {} 都可以省略
     */
    @Test
    public void Lambda5() {
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
        int compare1 = comparator.compare(11, 21);
        int compare2 = comparator.compare(22, 22);
        int compare3 = comparator.compare(21, 11);
        System.out.println(compare1);
        System.out.println(compare2);
        System.out.println(compare3);
    }

    /**
     * 语法格式六:Lambda  参数列表的数据类型可以省略可以不写,因为JVM编译器通过上下文推断出数据类型,即"类型推断"
     */
    @Test
    public void Lambda6() {
        Comparator<Integer> comparator = (Integer x, Integer y) -> Integer.compare(x, y);
        int compare1 = comparator.compare(11, 21);
        int compare2 = comparator.compare(22, 22);
        int compare3 = comparator.compare(21, 11);
        System.out.println(compare1);
        System.out.println(compare2);
        System.out.println(compare3);
        System.out.println("====================================================");
        /**
         * 类型推断
         */
        String[] arr = {"1", "2", "aaa"};
        /**
         *不使用类型推断会挂掉
         */
        String[] aee1;
        //aee1 = ["1","2"];
        /**
         * 类型推断
         */
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<String>();
    }

    /**
     * 需求:对一个数进行运算
     */
    @Test
    public void Test1() {
        Integer operation = operation(100, (x) -> x * x);
        System.out.println(operation);
        Integer operation1 = operation(200, x -> x + 30);
        System.out.println(operation1);
    }

    public Integer operation(Integer num, MyFunction myFunction) {
        return myFunction.getValue(num);
    }
}