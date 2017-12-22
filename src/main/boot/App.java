package boot;

import models.GameBoard;
import models.Gem;
import models.GemSequence;
import models.ScreenBoardReader;
import models.algorithms.BasicBoardSequenceFinder;
import models.algorithms.BoardEvaluator;
import models.algorithms.BoardSequenceFinder;
import org.sikuli.basics.Debug;


public class App {
    public static void main(String[] args) {
        ScreenBoardReader reader = new ScreenBoardReader();
        GameBoard board = reader.readBoard();
        System.out.println(board);
        BoardEvaluator evaluator = new BoardEvaluator(new BasicBoardSequenceFinder());
        Debug.info("Board evaluation: %s", evaluator.evaluateBoard(board));


    }

}
