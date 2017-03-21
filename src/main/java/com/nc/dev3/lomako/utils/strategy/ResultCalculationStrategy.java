package com.nc.dev3.lomako.utils.strategy;

import com.nc.dev3.lomako.beans.test.Test;
import com.nc.dev3.lomako.beans.test.TestAnswers;

/**
 * Created by arturlomako on 3/17/17.
 */
public interface ResultCalculationStrategy {
    int calculateResult(Test test, TestAnswers testAnswers);
    int calculateMaxResult(Test test);
}
