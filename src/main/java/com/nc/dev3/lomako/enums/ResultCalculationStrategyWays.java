package com.nc.dev3.lomako.enums;

/**
 * Created by arturlomako on 3/21/17.
 */

/**
 * Show available kind of calculate test result
 *
 * <li>{@link #STRICT}</li>
 * <li>{@link #SCALED}</li>
 * */
public enum ResultCalculationStrategyWays {

    /**
     * In this instance in a task
     * that has multiple answers,
     * the correct answers should be all
     * */
    STRICT,

    /**
     * In this instance in a task
     * that has multiple answers,
     * points are awarded for each correct answer
     * */
    SCALED;
}
