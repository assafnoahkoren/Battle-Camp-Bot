package models.algorithms;

import models.GameBoard;
import models.Gem;
import models.GemSequence;

import javax.sound.midi.Sequence;
import java.util.ArrayList;

public class BasicBoardSequenceFinder extends BoardSequenceFinder {

    public BasicBoardSequenceFinder() {
    }

    public ArrayList<GemSequence> findSequences(GameBoard board) {
        ArrayList<GemSequence> sequencesArray = new ArrayList<>();

        for (int row = 0; row < 5; row++) {
            sequencesArray.addAll(evaluateRow(row, board));
        }
        for (int col = 0; col < 6; col++) {
            sequencesArray.addAll(evaluateCol(col, board));
        }

        return sequencesArray;
    }


    private ArrayList<GemSequence> evaluateRow(int row, GameBoard board) {
        ArrayList<GemSequence> sequences = new ArrayList<>();
        int sequenceLength = 1;
        for (int col = 0; col < 5; col++) {
            Gem currentGem = board.getGem(row, col);
            Gem nextGem = board.getGem(row, col + 1);
            if (nextGem.getType() == currentGem.getType()) {
                sequenceLength++;
                if (col == 4) {
                    if (sequenceLength >= 3) {
                        sequences.add(new GemSequence(sequenceLength, currentGem.getType()));
                    }
                    sequenceLength = 1;
                }
            } else {
                if (sequenceLength >= 3) {
                    sequences.add(new GemSequence(sequenceLength, currentGem.getType()));
                }
                sequenceLength = 1;
            }
        }
        return sequences;
    }

    private ArrayList<GemSequence> evaluateCol(int col, GameBoard board) {
        ArrayList<GemSequence> sequences = new ArrayList<>();
        int sequenceLength = 1;
        for (int row = 0; row < 4; row++) {
            Gem currentGem = board.getGem(row, col);
            Gem nextGem = board.getGem(row + 1, col);
            if (nextGem.getType() == currentGem.getType()) {
                sequenceLength++;
                if (row == 3) {
                    if (sequenceLength >= 3) {
                        sequences.add(new GemSequence(sequenceLength, currentGem.getType()));
                    }
                    sequenceLength = 1;
                }
            } else {
                if (sequenceLength >= 3) {
                    sequences.add(new GemSequence(sequenceLength, currentGem.getType()));
                }
                sequenceLength = 1;
            }
        }
        return sequences;
    }


    private int calcNewRow(int row, Move move) {
        if (move == Move.DOWN) {
            return row + 1;
        } else if (move == Move.UP) {
            return row - 1;
        } else {
            return row;
        }
    }

    private int calcNewCol(int col, Move move) {
        if (move == Move.RIGHT) {
            return col + 1;
        } else if (move == Move.LEFT) {
            return col - 1;
        } else {
            return col;
        }
    }

}
