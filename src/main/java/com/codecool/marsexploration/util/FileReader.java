package com.codecool.marsexploration.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader {

    public String readFile(String filePath){
        try{
            String content = Files.readString(Paths.get(filePath));
            return content;
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
