package com.ruge.lambda表达式;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 武健
 * \* Date: 2018/2/5
 * \* Time: 18:44
 * \* To change this template use File | Settings | File Templates.
 * \* Description:java8 中 内置的四大核心函数式接口
 * \
 */
public class java核心接口 {
    /**
     * Consumer<T> : 消费型接口
     * void accept(T t);
     */
    public void happy(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    @Test
    public void Test1() {
        happy(100, (t) -> System.out.println("出去玩 花了" + t + "元"));
    }

    /**
     * Supplier<T> : 供给型接口
     * T get();
     * 需求:产生指定个数的整数,并放入集合中
     */
    public List<Integer> getNumList(int num, Supplier<Integer> supplier) {
        List list = new ArrayList();
        for (int i = 0; i < num; i++) {
            Integer integer = supplier.get();
            list.add(integer);
        }
        return list;
    }
    @Test
    public void Test2() {
        List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));
        numList.forEach(System.out::print);
    }
    /**
     *  Function<T,R> : 函数型接口
     *      R apply(T t);
     */
    public String handleStr(String str,Function<String, String> function){
        String apply = function.apply(str);
        return apply;
    }
    @Test
    public void Test3(){
        String abc = handleStr("abc", t -> t.substring(0, 1));
        System.out.println(abc);
    }
    /**
     * Predicate<T> : 断言型接口
     *      boolean test (T t);
     *      需求: 将满足条件的字符串添加到集合中
     */
    public List<String> finterStr(List<String> list, Predicate<String> predicate){
        List arrayList = new ArrayList();

        for (int i = 0; i < list.size();i++) {
            if (predicate.test(list.get(i))){
                 arrayList.add(list.get(i));
            }
        }
        return arrayList;
    }
    @Test
    public void Test4(){
        List list = Arrays.asList("122222","21111","3111","411","51");
        List<String> stringList = finterStr(list, (e) -> e.length()>2);
        stringList.forEach(System.out::println);

    }


}