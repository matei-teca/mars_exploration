package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Rover;
import com.codecool.marsexploration.util.FileReader;
import com.codecool.marsexploration.util.FileWriter;

import java.io.IOException;

public class Log implements Phase {

    @Override
    public void perform(Context context) {
        FileWriter fileWriter = new FileWriter();
        FileReader fileReader = new FileReader();

        String filePath = context.getLogFile();
        String existingContent = fileReader.readFile(filePath);

        Rover rover = context.getRover();

        String logLine =  "STEP " + context.getStepNumber() + "; "
                + "EVENT position" + "; "
                + "UNIT " + rover.getId()
                + "POSITION [" + rover.getPosition().x() + ", " + rover.getPosition().y() + "]\n";
        if(context.getOutcome() != null){
            logLine = "STEP " + context.getStepNumber() + "; "
                    + "EVENT outcome; "
                    + "OUTCOME " + context.getOutcome() + "\n";
        }
        if(existingContent == null){
            fileWriter.write(filePath, logLine);
        } else{
            fileWriter.write(filePath, existingContent+logLine);
        }

    }
}
