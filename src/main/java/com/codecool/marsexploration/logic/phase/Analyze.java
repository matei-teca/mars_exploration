package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Outcome;
import com.codecool.marsexploration.data.Rover;
import com.codecool.marsexploration.logic.analyzer.Analyzer;

import java.util.Optional;

public class Analyze implements Phase, Analyzer {


    @Override
    public Optional<Outcome> analyze(Context context) {
        Rover rover = context.getRover();

        int stepNumber = context.getStepNumber();
        int countMineral = rover.getCoordinateTrackRecords().get("minerals").size();
        int countWater = rover.getCoordinateTrackRecords().get("water").size();
        int countAliens = rover.getCoordinateTrackRecords().get("aliens").size();

        return Optional.of(stepNumber == 100 ? Outcome.TIMEOUT :
                countMineral == 4 && countWater == 3 ?
                        Outcome.COLONIZABLE :
                        countAliens > 0 ? Outcome.NOT_COLONIZABLE_ALIENS :
                        Outcome.NOT_COLONIZABLE_RESOURCES);
    }

    @Override
    public void perform(Context context) {
        if(analyze(context).isPresent()){
            context.setOutcome(analyze(context).get());
        }
    }
}
