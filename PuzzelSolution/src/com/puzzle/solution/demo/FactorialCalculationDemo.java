package com.puzzle.solution.demo;

import com.puzzle.solution.cal.FactorialCalculator;

import java.math.BigInteger;

/**
 * Created by udoluweera on 5/12/16.
 */
public class FactorialCalculationDemo {

    public static void main(String[] args) {

        demoCalculation(new BigInteger("1000000"), new BigInteger("200"));
        demoCalculation(new BigInteger("10000000"), new BigInteger("200"));
    }

    private static void demoCalculation(BigInteger n, BigInteger c) {

        long startTime = System.currentTimeMillis();
        BigInteger result = FactorialCalculator.calculateFactorial(n,c);

        long endTime = System.currentTimeMillis();
        System.out.println(String.format("For N = %d and c = %d ==> %d ",n,c,result));
        System.out.println(String.format("Time taken : %d  ms" ,endTime-startTime));
    }

}



