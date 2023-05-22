package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Rover;

public class Scan implements Phase {

    @Override
    public void perform(Context context) {
        Rover rover = context.getRover();

        int roverX = rover.getPosition().x();
        int roverY = rover.getPosition().y();


    }
}
