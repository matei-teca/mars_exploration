package com.codecool.marsexploration.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileWriter {

    public void write(String path, String content) {
        try{
            Files.write(Paths.get(path), content.getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
