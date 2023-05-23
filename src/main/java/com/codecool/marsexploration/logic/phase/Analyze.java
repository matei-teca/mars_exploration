package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Outcome;
import com.codecool.marsexploration.logic.analyzer.Analyzer;

import java.util.Optional;

public class Analyze implements Phase, Analyzer {


    @Override
    public Optional<Outcome> analyze(Context context) {

        int stepNumber = context.getStepNumber();
        int countMineral = 0;
        int countWater = 0;
        int countAliens = 0;

        return Optional.of(stepNumber == 100 ? Outcome.TIMEOUT :
                countMineral == 4 && countWater == 3 ?
                        Outcome.COLONIZABLE :
                        countAliens > 0 ? Outcome.NOT_COLONIZABLE_ALIENS :
                        Outcome.NOT_COLONIZABLE_RESOURCES);
    }

    @Override
    public void perform(Context context) {

    }
}
