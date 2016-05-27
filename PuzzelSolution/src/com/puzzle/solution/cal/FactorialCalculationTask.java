package com.puzzle.solution.cal;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 * This class is used to parallel execute large factorial calculations.
 *
 * Created by udoluweera on 5/12/16.
 */
public class FactorialCalculationTask extends RecursiveTask<BigInteger> {

    private BigInteger rangeStart;
    private BigInteger rangeEnd;
    private BigInteger limit;
    private BigInteger threshold = new BigInteger("10000");

    public FactorialCalculationTask(BigInteger rangeStart, BigInteger rangeEnd, BigInteger limit) {
        this.rangeStart = rangeStart;
        this.rangeEnd = rangeEnd;
        this.limit = limit;
    }

    public FactorialCalculationTask(BigInteger rangeEnd, BigInteger limit) {
        this.rangeEnd = rangeEnd;
        this.limit = limit;
        this.rangeStart = BigInteger.ONE;
    }

    public FactorialCalculationTask() {}

    @Override
    protected BigInteger compute() {

        if (calculateWorkLoad().compareTo(threshold)  > 0) {

            List<FactorialCalculationTask> subTaskList = createSubTasksByThreshold(calculateWorkLoad(), threshold);

            for (FactorialCalculationTask subTask : subTaskList) {
                subTask.fork();
            }

            BigInteger result = BigInteger.ZERO;
            for (FactorialCalculationTask factorialCalculationTask : subTaskList) {
                result  = result.add(factorialCalculationTask.join());
            }
            return result;

        } else {
            /* Calculate the sum of factorial for given range */
            BigInteger factorialForPreviousNumber = FactorialCalculator.factorialForGivenNumber(this.getRangeStart(), this.getLimit());
            BigInteger result =  FactorialCalculator.calculateFactorial(
                    this.getRangeStart(), this.getRangeEnd(), this.getLimit(), factorialForPreviousNumber);
            return result;
        }
    }

    /**
     * This method is used to create a set of tasks for given threshold and workload
     *
     * @param currentWorkLoad
     * @return
     */
    private List<FactorialCalculationTask> createSubTasksByThreshold(BigInteger currentWorkLoad, BigInteger threshold) {

        List<FactorialCalculationTask> subTasksList = new ArrayList<>();

        BigInteger upperBound = BigInteger.ZERO;
        if (currentWorkLoad.mod(this.threshold).compareTo(BigInteger.ZERO) > 0) {
            upperBound = (currentWorkLoad.divide(this.threshold)).add(BigInteger.ONE);
        } else {
            upperBound = (currentWorkLoad.divide(this.threshold));
        }


        for (BigInteger j = BigInteger.ONE; j.compareTo(upperBound)  <= 0; j = j.add(BigInteger.ONE)) {

            BigInteger start = ((this.threshold.multiply(j.subtract(BigInteger.ONE)).add(BigInteger.ONE)));
            BigInteger end = BigInteger.ZERO;
            if (j.compareTo(upperBound) == 0 && currentWorkLoad.mod(this.threshold).compareTo(BigInteger.ZERO) > 0) {
                end = rangeStart.add(((currentWorkLoad.mod(this.threshold)).subtract(BigInteger.ONE)));
            } else {
                end = this.threshold.multiply(j);
            }
            FactorialCalculationTask calculationTask = new FactorialCalculationTask(start,end,this.limit);
            subTasksList.add(calculationTask);
        }
        return subTasksList;
    }


    private BigInteger calculateWorkLoad() {
        return rangeEnd.add(BigInteger.ONE).subtract(rangeStart);
    }

    public void setRangeStart(BigInteger rangeStart) {
        this.rangeStart = rangeStart;
    }

    public void setRangeEnd(BigInteger rangeEnd) {
        this.rangeEnd = rangeEnd;
    }

    public void setLimit(BigInteger limit) {
        this.limit = limit;
    }

    public BigInteger getRangeStart() {
        return rangeStart;
    }

    public BigInteger getRangeEnd() {
        return rangeEnd;
    }

    public BigInteger getLimit() {
        return limit;
    }

    public BigInteger getThreshold() {
        return threshold;
    }

    public void setThreshold(BigInteger threshold) {
        this.threshold = threshold;
    }
}
