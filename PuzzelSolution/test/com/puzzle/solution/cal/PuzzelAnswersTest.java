package com.puzzle.solution.cal;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

/**
 * Created by udoluweera on 5/13/16.
 */
public class PuzzelAnswersTest {

    @Test
    public void N_100_and_C_10_answer() {

        Assert.assertEquals(new BigInteger("513946235090696089113"),
                FactorialCalculator.calculateFactorial(BigInteger.valueOf(100), BigInteger.valueOf(10)));

        /* Range funtion test */
        Assert.assertEquals(new BigInteger("513946235090696089113"),
                FactorialCalculator.calculateFactorial(BigInteger.ONE, BigInteger.valueOf(100), BigInteger.valueOf(10),BigInteger.ZERO ));
    }

    @Test
    public void N_1000_000_and_C_200_answer() {

        BigInteger answer = FactorialCalculator.calculateFactorial(BigInteger.valueOf(1000000), BigInteger.valueOf(200));
        String first10Digits = answer.toString().substring(0,10);

        Assert.assertEquals("4876116127",first10Digits);
    }
}
