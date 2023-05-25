package com.codecool.marsexploration.logic.routine;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.logic.analyzer.AlienSpotter;
import com.codecool.marsexploration.logic.phase.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExploringRoutine implements Routine {

    private List<Phase> phases = new ArrayList<>(List.of(new Movement(), new Scan(),
            new AnalyzeEngine(), new Log(), new StepIncrement()));

    @Override
    public void move(Context context) {
        new Scan().perform(context);
        for(Phase phase : phases){
            if(phase instanceof AnalyzeEngine){
                ((AnalyzeEngine) phase).addAnalyzer(new AlienSpotter());
            }
        }
        while(context.getOutcome() == null){
            for(Phase phase : phases){
                try{
                    phase.perform(context);
                } catch (IOException e){
                    System.out.println("Phase execution error: " + phase + " message: " + e.getMessage());
                }
            }
        }

        context.getRover().setRoutine(new ReturningRoutine());
        context.getRover().getRoutine().move(context);
    }

    public void addPhase (Phase phase) {
        phases.add(phase);
    }
}
