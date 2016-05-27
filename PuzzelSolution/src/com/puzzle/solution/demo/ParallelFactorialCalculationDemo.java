package com.puzzle.solution.demo;

import com.puzzle.solution.cal.FactorialCalculationTask;

import java.math.BigInteger;
import java.util.concurrent.ForkJoinPool;

/**
 * Created by udoluweera on 5/12/16.
 */
public class ParallelFactorialCalculationDemo {

    public static void main(String[] args) {

        demoCalculationWithTime(new BigInteger("1000000"),new BigInteger("200"));
        demoCalculationWithTime(new BigInteger("10000000"),new BigInteger("200"));
    }

    private static void demoCalculationWithTime(BigInteger rangeEnd,BigInteger limit) {

        long startTime = System.currentTimeMillis();

        ForkJoinPool forkJoinPool = new ForkJoinPool(10);

        FactorialCalculationTask factorialCalculationTask = new FactorialCalculationTask(rangeEnd,limit);
        BigInteger returnedValue = forkJoinPool.invoke(factorialCalculationTask);
        long endTime = System.currentTimeMillis();

        System.out.println(String.format("For N = %d and c = %d ==> %d ",rangeEnd,limit,returnedValue));
        System.out.println(String.format("Time taken : %d  ms" ,endTime-startTime));
    }

}
