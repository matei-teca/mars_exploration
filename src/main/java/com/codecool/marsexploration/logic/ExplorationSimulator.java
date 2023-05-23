package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.*;

import java.util.ArrayList;
import java.util.List;

public class ExplorationSimulator {

    public void simulate(SimulationInput input) {
     // initialize tools

        List<List<String>> realMap = new ArrayList<>();
        Rover rover1 = new Rover("rover-1", new Coordinate(input.landing().x(), input.landing().y()), 2, null);
        Context context = new Context(input.timeout(),  realMap, input.landing(), rover1, input.logPath());


    //analyse scan, log for landing then loop for exploration

    //exploration loop
    //the updated context data is analysed if there is a definite outcome

    // coming back



    }

}
