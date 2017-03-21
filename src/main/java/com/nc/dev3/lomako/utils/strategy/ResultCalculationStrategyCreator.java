package com.nc.dev3.lomako.utils.strategy;

import com.nc.dev3.lomako.enums.ResultCalculationStrategyWays;
import com.nc.dev3.lomako.utils.strategy.impl.ScaledResultCalculatingStrategy;
import com.nc.dev3.lomako.utils.strategy.impl.StrictResultCalculatingStrategy;

/**
 * Created by arturlomako on 3/21/17.
 */
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
