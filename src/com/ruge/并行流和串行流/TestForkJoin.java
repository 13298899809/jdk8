package com.ruge.并行流和串行流;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 武健
 * \* Date: 2018/2/7
 * \* Time: 21:24
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class TestForkJoin {
    @Test
    public void test1() {
        Instant start = Instant.now();
        /**
         * 需要线程池的支持
         */
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        /**
         * 实例化方法并传入参数
         */
        ForkJoinTask<Long> forkJoinTask = new ForkJoin(1, 100000000000L);
        /**
         * 获取返回值
         */
        Long invoke = forkJoinPool.invoke(forkJoinTask);
        System.out.println(invoke);
        Instant end = Instant.now();
        //18885毫秒
        System.out.println("耗时：" + Duration.between(start, end).toMillis()+"毫秒");

    }

    /**
     * 普通for循环
     */
    @Test
    public void test2(){
        Instant start = Instant.now();
        double d = 0;
        for (double i = 0; i <=100000000000L; i++) {
            d = d+i;
        }
        System.out.println(d);
        Instant end = Instant.now();
        //334045毫秒
        System.out.println("耗时:"+Duration.between(start,end).toMillis()+"毫秒");
    }
    @Test
    public void jdk8并行流(){
        Instant start = Instant.now();
        long reduce = LongStream.rangeClosed(0, 100000000000L)
                .parallel()
                .reduce(0, Long::sum);
        System.out.println(reduce);
        Instant end = Instant.now();
        //14393毫秒
        System.out.println("耗时:"+Duration.between(start,end).toMillis()+"毫秒");
    }

}