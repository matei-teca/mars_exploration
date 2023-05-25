package com.codecool.marsexploration.mapGenerator.data;

public enum  Element {
    MOUNTAIN("^"),
    PIT("#"),
    MINERAL("*"),
    WATER("~"),
    ALIEN("A");

    private final String symbol;

    Element(String Symbol){
        this.symbol = Symbol;
    }

    public String getSymbol (){
        return symbol;
    }
}
