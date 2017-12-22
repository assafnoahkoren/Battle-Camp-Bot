package models.algorithms;

import models.GameBoard;

import java.awt.*;

public class BoardState {
    GameBoard gameBoard;
    Point p;
    BoardState parentState;

    public BoardState(GameBoard gameBoard, Point p, BoardState parentState) {
        this.gameBoard = gameBoard;
        this.p = p;
        this.parentState = parentState;
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public Point getP() {
        return p;
    }

    public BoardState getParentState() {
        return parentState;
    }

    public void setGameBoard(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public void setP(Point p) {
        this.p = p;
    }

    public void setParentState(BoardState parentState) {
        this.parentState = parentState;
    }

}
