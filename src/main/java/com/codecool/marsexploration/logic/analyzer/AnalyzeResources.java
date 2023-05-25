package com.codecool.marsexploration.logic.analyzer;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Outcome;
import com.codecool.marsexploration.data.Symbol;

import java.util.List;
import java.util.Optional;

public class AnalyzeResources implements Analyzer{

    @Override
    public Optional<Outcome> analyze(Context context) {

        for(List<String> line : context.getRover().getDiscoveredMap() ){
            if(line.contains(Symbol.UNKNOWN.getSymbol())){
                return Optional.empty();
            }
        }
        return Optional.of(Outcome.NOT_COLONIZABLE_RESOURCES);
    }
}
