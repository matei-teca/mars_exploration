package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Rover;

public class Movement implements Phase {

    @Override
    public void perform(Context context) {
        Rover rover = context.getRover();

        int roverX = rover.getPosition().x();
        int roverY = rover.getPosition().y();

        rover.setPosition(new Coordinate( roverX + 1,  roverY + 1));

    }

}
