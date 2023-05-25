package com.codecool.marsexploration.util;

import java.util.List;

public class MapPrinter {

    public static void printExploredMap(List<List<String>> map){
        StringBuilder lineBuilt = new StringBuilder();
        for(List<String> line: map){
            for(String string : line){
                lineBuilt.append(string).append("  ");
            }
            lineBuilt.append("\n");
        }
        System.out.println(lineBuilt);
    }
}
