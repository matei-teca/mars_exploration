package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.*;
import com.codecool.marsexploration.logic.phase.Log;
import com.codecool.marsexploration.logic.routine.ExploringRoutine;
import com.codecool.marsexploration.util.FileReader;

import java.io.StringReader;
import java.util.*;

public class ExplorationSimulator {

    public void simulate(SimulationInput input) {
     // initialize tools

        List<List<String>> realMap = convertMap(input.mapPath());


        Rover rover1 = new Rover("rover-1", new Coordinate(input.landing().y(), input.landing().x()), 2);
        Context context = new Context(input.timeout(),  realMap, input.landing(), rover1, input.logPath());

    //analyse scan, log for landing then loop for exploration

    if(!realMap.get(input.landing().y()).get(input.landing().x()).equals(" ")){
        context.setOutcome(Outcome.WRONG_LANDING_COORDINATES);
        new Log().perform(context);
        System.out.println("WRONG_LANDING_COORDINATES");
    } else {
        rover1.setRoutine(new ExploringRoutine());
        rover1.getRoutine().move(context);
        rover1.getDiscoveredMap().get(input.landing().y()).set(input.landing().x(),"S");
        StringBuilder lineBuilt = new StringBuilder();

        for(List<String> line: context.getRealMap()){
            System.out.println(line);
        }
        System.out.println("\n");
        for(List<String> line: rover1.getDiscoveredMap()){
            for(String string : line){
                lineBuilt.append(string).append("  ");
            }
            lineBuilt.append("\n");
        }
        System.out.println(lineBuilt);
    }

    }

    private List<List<String>> convertMap(String pathMap ){

        List<List<String>> realMap = new ArrayList<>();
        FileReader fileReader = new FileReader();
        String stringMap = fileReader.readFile(pathMap + ".map");


        StringReader stringReader = new StringReader(stringMap);

        // Create a Scanner object to read from the StringReader
        Scanner scanner = new Scanner(stringReader);

        // Read lines one by one
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            List<String> mapLine = new ArrayList<>();
            for(int i = 0; i< line.length();i++){
                mapLine.add(line.substring(i, i+1));
            }
            realMap.add(mapLine);
        }

        scanner.close();
        stringReader.close();

        return realMap;
    }

}
