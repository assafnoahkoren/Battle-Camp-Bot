package models;

import java.util.ArrayList;
import java.util.Arrays;

public class GameBoard {
    Gem[][] board;

    public GameBoard() {
        board = new Gem[5][6];
    }

    public GameBoard(Gem[][] board) {
        this.board = board;
    }

    public GameBoard(ArrayList<Gem> gems) {
        this.board = new Gem[5][6];
        if (gems.size() != 30) return;

        int i = 0;
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 6; col++) {
                this.board[row][col] = gems.get(i);
                i++;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 6; col++) {
                str.append("[").append(this.board[row][col].type.name()).append("]");
            }
            str.append('\n');
        }
        return str.toString();
    }

    public void setGem(Gem gem, int row, int col) {
        if (  (row < 5 && row >= 0) &&
                (col < 6 && col >= 0)    ) {
            this.board[row][col] = gem;
        }
    }

    public Gem getGem(int row, int col) {
        if (  (row < 5 && row >= 0) &&
              (col < 6 && col >= 0)    ) {
            return this.board[row][col];
        } else {
            return null;
        }
    }

    public Gem[][] getBoard() {
        return this.board;
    }

}
