package com.codecool.marsexploration.logic.analyzer;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Outcome;

import java.util.Optional;

public class AlienSpotter implements Analyzer{

    @Override
    public Optional<Outcome> analyze(Context context) {

        if(context.isAlienSpotted()){
            return Math.random()>0.5 ? Optional.of(Outcome.NOT_COLONIZABLE_ALIENS)
                    : Optional.of(Outcome.FRIENDLY_ALIENS);
        }
        return Optional.empty();
    }
}
