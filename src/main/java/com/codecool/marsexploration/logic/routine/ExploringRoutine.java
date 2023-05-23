package com.codecool.marsexploration.logic.routine;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.logic.phase.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExploringRoutine implements Routine {

    private List<Phase> phases = new ArrayList<>(List.of(new Movement(), new Scan(),
            new AnalyzeEngine(), new Log(), new StepIncrement()));

    @Override
    public void move(Context context) {

    }
}
