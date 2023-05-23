package com.codecool.marsexploration.logic.analyzer;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Outcome;
import com.codecool.marsexploration.data.Rover;
import com.codecool.marsexploration.logic.analyzer.Analyzer;

import java.util.Optional;

public class AnalyzeTimeout implements Analyzer {


    @Override
    public Optional<Outcome> analyze(Context context) {
        int stepNumber = context.getStepNumber();
        return stepNumber == 100 ? Optional.of(Outcome.TIMEOUT) : Optional.empty();
    }

}
