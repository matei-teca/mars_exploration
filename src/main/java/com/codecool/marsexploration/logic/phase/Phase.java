package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;

import java.io.IOException;

public interface Phase {
    void perform(Context context) throws IOException;
}
