/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.nc.dev3.lomako.utils.strategy;

import com.nc.dev3.lomako.enums.ResultCalculationStrategyWays;
import com.nc.dev3.lomako.utils.strategy.impl.ScaledResultCalculatingStrategy;
import com.nc.dev3.lomako.utils.strategy.impl.StrictResultCalculatingStrategy;

/**
 * This factory create instances of {@link ResultCalculationStrategy}
 * in dependence on {@link ResultCalculationStrategyWays}
 * */
public final class ResultCalculationStrategyCreator {
    public static ResultCalculationStrategy create(ResultCalculationStrategyWays way) {
        ResultCalculationStrategy strategy = null;

        switch (way) {
            case SCALED:
                strategy = new ScaledResultCalculatingStrategy();
                break;
            case STRICT:
                strategy = new StrictResultCalculatingStrategy();
                break;
        }

        return strategy;
    }
}
