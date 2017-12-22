package models.algorithms;


import models.GameBoard;
import models.GemSequence;

import java.util.ArrayList;
import java.util.Comparator;

public class BoardEvaluator implements Comparator<GameBoard> {
    protected BoardSequenceFinder sequenceFinder;

    public BoardEvaluator(BoardSequenceFinder sequenceFinder) {
        this.sequenceFinder = sequenceFinder;
    }

    @Override
    public int compare(GameBoard g1, GameBoard g2) {
        return evaluateBoard(g1) - evaluateBoard(g2);
    }

    public int evaluateBoard(GameBoard gameBoard) {
        int evaluation = 0;
        ArrayList<GemSequence> gemSequences = sequenceFinder.findSequences(gameBoard);
        for (GemSequence seq : gemSequences) {
            evaluation += Math.pow(10, seq.getLength()/3.0);
        }

        return evaluation;
    }
}
