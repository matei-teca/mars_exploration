package com.codecool.marsexploration.logic.analyzer;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Outcome;
import com.codecool.marsexploration.data.Rover;

import java.util.Optional;

public class AnalyzeSuccess implements Analyzer{

    @Override
    public Optional<Outcome> analyze(Context context) {
        Rover rover = context.getRover();

        int countMineral = rover.getCoordinateTrackRecords().get("minerals").size();
        int countWater = rover.getCoordinateTrackRecords().get("water").size();

        return countMineral == 4 && countWater == 3 ?
                Optional.of(Outcome.COLONIZABLE) : Optional.empty();
    }
}
