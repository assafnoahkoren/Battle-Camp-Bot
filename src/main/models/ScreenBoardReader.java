package models;

import org.sikuli.basics.Debug;
import org.sikuli.script.*;

import java.util.ArrayList;
import java.util.Comparator;

public class ScreenBoardReader implements GameBoardReader {
    public GameBoard readBoard() {
        Screen s = new Screen();
        Debug.info("Screen: %s", s);
        Image screenCapture = new Image(s.capture());
//        Image screenCapture = new Image(s.userCapture());
        ImagePath.setBundlePath("./assets");

        long start = System.currentTimeMillis();
        Finder f = new Finder(screenCapture);
        ArrayList<GemPattern> gemPatternList = GemPattern.allPatterns();
        ArrayList<Gem> gems = new ArrayList<Gem>();

        for (GemPattern gemPattern : gemPatternList) {
            f.findAll(gemPattern.getPattern());
            while (f.hasNext()) {
                Match m = f.next();
                gems.add(new Gem(gemPattern.type, m.getTarget()));
            }
        }

        sortGemsByLocation(gems);

        long duration = ((System.currentTimeMillis()) - start);
        Debug.info("Count: %d", gems.size());
        Debug.info("Duration: %d millis", duration);

        if (gems.size() == 30) {
            return new GameBoard(gems);
        } else {
            return null;
        }

    }

    private void sortGemsByLocation(ArrayList<Gem> gems) {
        gems.sort((Gem g1, Gem g2) -> {
            int result = g1.location.getY() - g2.location.getY();
//            Debug.info("g1 y: %d", g1.location.getY());
//            Debug.info("g2 y: %d", g2.location.getY());
//            Debug.info("result: %d\n", result);
            // If Approximately in same row sort by X value.
            if ( result > -30 && result < 30 ) {
                result = Integer.compare(g1.location.getX(), g2.location.getX());
            }

            return result;
        });
    }
}
