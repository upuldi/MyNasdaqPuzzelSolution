package com.puzzle.solution.cal;

import java.math.BigInteger;

/**
 * Created by udoluweera on 5/12/16.
 */
public class FactorialCalculator {

    /**
     * This is an overloaded method to calculate factorial for a given number from one.
     *
     * @param end Given number N
     * @param limit limit C
     * @return
     */
    public static BigInteger calculateFactorial(BigInteger end, BigInteger limit) {

        return calculateFactorial(BigInteger.ONE,end,limit,BigInteger.ZERO);
    }

    /**
     * This method is used to calculate a factorial for a given number based on limit
     *
     * @param n Number
     * @param c Limit
     * @return
     */
    public static final BigInteger factorialForGivenNumber(BigInteger n,BigInteger c){

        if (n.compareTo(BigInteger.ONE)  <= 0) return BigInteger.ZERO;
        BigInteger factorial = BigInteger.ONE;

        /* Limit should only be applied when the number is greater than limit. */
        BigInteger j = BigInteger.ONE;
        if (n.compareTo(c)>0) {
            j = n.subtract(c);
        } else {
            j = BigInteger.ONE;
        }

        for (BigInteger i= j; i.compareTo(n) < 0;i=i.add(BigInteger.ONE)){
            factorial = factorial.multiply(i);
        }
        return factorial;
    }

    /**
     * This method is used to calculate the factorial for a given range.
     *
     * @param start Range Starting number
     * @param end Range Ending Number
     * @param limit Limit
     * @param firstFactorial Factorial of the first number of the range.
     * @return
     */
    public static BigInteger calculateFactorial(BigInteger start, BigInteger end, BigInteger limit, BigInteger firstFactorial) {

        BigInteger sum = BigInteger.ZERO;

        if (firstFactorial.compareTo(BigInteger.ZERO)>0) {
            sum = sum.add(firstFactorial);
        } else {
            firstFactorial = BigInteger.ONE;
        }

        BigInteger j = BigInteger.ZERO;
        if(start.compareTo(BigInteger.ONE) == 0){
            j = new BigInteger("2");
        } else {
            j = start.add(BigInteger.ONE);
        }

        for (BigInteger i = j; i.compareTo(end) <= 0; i = i.add(BigInteger.ONE)) {
            if (i.compareTo(limit.add(BigInteger.ONE)) <= 0) {
                firstFactorial = (i.subtract(BigInteger.ONE)).multiply(firstFactorial);
                sum = sum.add(firstFactorial);

            } else {
                firstFactorial = (firstFactorial.divide( (i.subtract(limit).subtract(BigInteger.ONE)))).multiply( i.subtract(BigInteger.ONE) );
                sum = sum.add(firstFactorial);
            }
        }
        return sum;
    }


}
