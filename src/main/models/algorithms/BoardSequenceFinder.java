package models.algorithms;

import models.GameBoard;
import models.GemSequence;

import java.util.ArrayList;
import java.util.Comparator;

public abstract class BoardSequenceFinder {
    public abstract ArrayList<GemSequence> findSequences(GameBoard board);

}
