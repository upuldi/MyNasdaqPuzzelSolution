package com.puzzle.solution.cal;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;


/**
 * Created by udoluweera on 5/13/16.
 */
public class FactorialCalculatorTest {

    @Test
    public void factorialShouldBeCalculatedForGivenNumberAndLimit() {
        Assert.assertEquals(BigInteger.valueOf(21), FactorialCalculator.calculateFactorial(BigInteger.valueOf(5), BigInteger.valueOf(2)));
        Assert.assertEquals(BigInteger.valueOf(41), FactorialCalculator.calculateFactorial(BigInteger.valueOf(6), BigInteger.valueOf(2)));
        Assert.assertEquals(BigInteger.valueOf(423), FactorialCalculator.calculateFactorial(BigInteger.valueOf(8), BigInteger.valueOf(3)));
        Assert.assertEquals(BigInteger.valueOf(25233), FactorialCalculator.calculateFactorial(BigInteger.valueOf(10), BigInteger.valueOf(5)));
        Assert.assertEquals(BigInteger.valueOf(409113), FactorialCalculator.calculateFactorial(BigInteger.valueOf(10), BigInteger.valueOf(10)));
    }

    @Test
    public void factorialShouldBeCalculatedWhenLimitIsOverNumber() {
        Assert.assertEquals(BigInteger.valueOf(33), FactorialCalculator.calculateFactorial(BigInteger.valueOf(5), BigInteger.valueOf(5)));
        Assert.assertEquals(BigInteger.valueOf(33), FactorialCalculator.calculateFactorial(BigInteger.valueOf(5), BigInteger.valueOf(7)));
        Assert.assertEquals(BigInteger.valueOf(33), FactorialCalculator.calculateFactorial(BigInteger.valueOf(5), BigInteger.valueOf(10)));
    }

    @Test
    public void factorialShouldBeCalculatedWhenLimitIsOne() {
        Assert.assertEquals(BigInteger.valueOf(10), FactorialCalculator.calculateFactorial(BigInteger.valueOf(5), BigInteger.valueOf(1)));
    }

    @Test
    public void factorialForASingleNumberShouldCalulateWhenLimitIsBelowTheNumber() {
        Assert.assertEquals(BigInteger.valueOf(4), FactorialCalculator.factorialForGivenNumber(BigInteger.valueOf(5), BigInteger.valueOf(1)));
        Assert.assertEquals(BigInteger.valueOf(12), FactorialCalculator.factorialForGivenNumber(BigInteger.valueOf(5), BigInteger.valueOf(2)));
        Assert.assertEquals(BigInteger.valueOf(90), FactorialCalculator.factorialForGivenNumber(BigInteger.valueOf(11), BigInteger.valueOf(2)));
    }

    @Test
    public void factorialForASingleNumberShouldCalulateWhenLimitIsHigherThanGivenNumber() {
        Assert.assertEquals(BigInteger.valueOf(24), FactorialCalculator.factorialForGivenNumber(BigInteger.valueOf(5), BigInteger.valueOf(6)));
        Assert.assertEquals(BigInteger.valueOf(24), FactorialCalculator.factorialForGivenNumber(BigInteger.valueOf(5), BigInteger.valueOf(8)));
        Assert.assertEquals(BigInteger.valueOf(3628800), FactorialCalculator.factorialForGivenNumber(BigInteger.valueOf(11), BigInteger.valueOf(15)));
    }

    @Test
    public void factorialForRangeShouldBeCalculatedWhenLimitIsBelowStart() {
        Assert.assertEquals(BigInteger.valueOf(21), FactorialCalculator.calculateFactorial(
                BigInteger.ONE,BigInteger.valueOf(5),BigInteger.valueOf(2),BigInteger.ZERO));
        Assert.assertEquals(BigInteger.valueOf(232), FactorialCalculator.calculateFactorial(
                BigInteger.valueOf(5), BigInteger.valueOf(10), BigInteger.valueOf(2), BigInteger.valueOf(12)));
    }

    @Test
    public void factorialForRangeShouldBeCalculatedWhenLimitIsHigherThanStart() {

        Assert.assertEquals(BigInteger.valueOf(432720), FactorialCalculator.calculateFactorial(
                BigInteger.valueOf(5), BigInteger.valueOf(10), BigInteger.valueOf(6), BigInteger.valueOf(120)));

        Assert.assertEquals(BigInteger.valueOf(10110), FactorialCalculator.calculateFactorial(
                BigInteger.valueOf(4), BigInteger.valueOf(9), BigInteger.valueOf(5), BigInteger.valueOf(6)));
    }
}
