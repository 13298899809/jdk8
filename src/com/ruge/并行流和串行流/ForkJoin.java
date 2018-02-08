package com.ruge.并行流和串行流;

import org.junit.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 武健
 * \* Date: 2018/2/7
 * \* Time: 21:02
 * \* To change this template use File | Settings | File Templates.
 * \* Description: 并行流和串行流
 * \      数据累加总和
 */
public class ForkJoin extends RecursiveTask<Long> {

    private static final long serialVersionUID = 1234567890987654321L;;
    private static final long THRESHOLD = 1000000;;

    private long start;
    private long end;

    public ForkJoin() {
    }

    public ForkJoin(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length = end - start;
        if (length<=THRESHOLD){
            long sum = 0;
            for (long i = start; i <= end ; i++) {
                sum = sum + i;
            }
            return sum;
        }else {
            long middle = (start+end)/2;
            ForkJoin forkJoinleft = new ForkJoin(start,middle);
            /**
             * 拆分子线程 同时压入线程队列
             */
            forkJoinleft.fork();
            ForkJoin forkJoinright = new ForkJoin(middle+1,end);
            /**
             * 拆分子线程 同时压入线程队列
             */
            forkJoinright.fork();
            return forkJoinleft.join()+forkJoinright.join();
        }
    }

}