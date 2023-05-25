package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Outcome;
import com.codecool.marsexploration.logic.analyzer.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AnalyzeEngine implements Phase{
    
    private List<Analyzer> analyzers = new ArrayList<>(List.of(new AnalyzeTimeout(), new AnalyzeResources(), new AnalyzeSuccess()));

    @Override
    public void perform(Context context) {
        for(Analyzer analyzer : analyzers){
            if(analyzer.analyze(context).isPresent()){
                context.setOutcome(analyzer.analyze(context).get());
                break;
            }
        }
    }

    public void addAnalyzer (Analyzer analyzer) {
        analyzers.add(analyzer);
    }
}
