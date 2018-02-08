package com.ruge.时间_日期API;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import static java.util.concurrent.Executors.*;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 武健
 * \* Date: 2018/2/8
 * \* Time: 20:50
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class jdk8之前的线程安全问题 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        Callable<Date> callable = new Callable<Date>() {
            @Override
            public Date call() throws Exception {
//            return simpleDateFormat.parse("20180808");
                return jdk8之前的线程锁.conver("20160808");
            }
        };
        /**
         * 线程池
         */
        ExecutorService executorService = newFixedThreadPool(10);
        List<Future<Date>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(executorService.submit(callable));
        }
        for (Future<Date> f : list
                ) {
            System.out.println(f.get());
        }
        executorService.shutdown();
    }
}