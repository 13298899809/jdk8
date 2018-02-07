package com.ruge.StreamAPI;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 武健
 * \* Date: 2018/2/6
 * \* Time: 21:27
 * \* To change this template use File | Settings | File Templates.
 * \* Description:Stream的三步操作
 *                  1:创建Stream
 *                  2:中间操作
 *                  3:终止操作
 * \
 */
public class CreateStreamAPI {
    /**
     * 创建Stream
     */
    @Test
    public void test1(){
        /**
         * 1 通过Collection系列集合提供的stream()或parallelStream()
         */
        List<String> list1 = new ArrayList();
        Stream<String> stream1 = list1.stream();

        /**
         * 2 通过Arrays中的静态方法stream() 获取数组流
         */
        Integer [] integers = {1,2,3,4,5,6,7,6,5,4,3,2,1};
        Stream<Integer> stream2 = Arrays.stream(integers);

        /**
         * 3 通过Stream中的静态方法 of()
         */
        Stream<Integer> stream3 = Stream.of(3,2,1);
        /**
         * 4 创建无限流
         */
                /**
                 * 迭代
                 */
        Stream<Integer> stream4 = Stream.iterate(10,(x)-> x+2);
        /**
         * 死循环了
         */
        //stream4.forEach(System.out::println);
        stream4.limit(10).forEach(System.out::println);
        Stream<Double> generate = Stream.generate(() -> Math.random());
        generate.limit(5).forEach(System.out::println);
    }
}