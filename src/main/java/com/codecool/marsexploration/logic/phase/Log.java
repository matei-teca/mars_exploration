package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Rover;
import com.codecool.marsexploration.util.FileReader;
import com.codecool.marsexploration.util.FileWriter;

import java.io.File;
import java.io.IOException;

public class Log implements Phase {

    @Override
    public void perform(Context context) {
        FileWriter fileWriter = new FileWriter();
        FileReader fileReader = new FileReader();

        String filePath = context.getLogFile();
        File file = new File(filePath);
        String existingContent = null;
        if (file.exists()) {
            existingContent = fileReader.readFile(filePath);
        }

        String logLine =  moveLine(context);

        if(context.getOutcome() != null){
            String outcomeLine = outcomeLine(context);
            logLine += outcomeLine;
        }

        if(existingContent == null){
            fileWriter.write(filePath, logLine);
        } else{
            fileWriter.write(filePath, existingContent+logLine);
        }

    }

    private String moveLine(Context context){
        return "STEP " + context.getStepNumber() + "; "
                + "EVENT position" + "; "
                + "UNIT " + context.getRover().getId()
                + "; POSITION [" + context.getRover().getPosition().y() + ", " + context.getRover().getPosition().x() + "]\n";
    }

    private String outcomeLine(Context context) {
        return "STEP " + context.getStepNumber() + "; "
                + "EVENT outcome; "
                + "OUTCOME " + context.getOutcome() + "\n";
    }

}
