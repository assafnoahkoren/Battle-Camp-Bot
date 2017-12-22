package models;


import org.sikuli.script.Pattern;

import java.util.ArrayList;

public class GemPattern {
    Pattern p;
    GemType type;

    public Pattern getPattern() {
        return p;
    }

    public GemType getType() {
        return type;
    }

    public void setP(Pattern p) {
        this.p = p;
    }

    public void setType(GemType type) {
        this.type = type;
    }

    public GemPattern(GemType type, Pattern p) {
        this.type = type;
        this.p = p;
    }

    public static GemPattern fireGem() {
        Pattern p = new Pattern("firePart.png");
        p.similar((float) 0.9);
        GemType g = GemType.FIRE;

        return new GemPattern(g, p);
    }

    public static GemPattern healGem() {
        Pattern p = new Pattern("healPart.png");
        p.similar((float) 0.95);
        GemType g = GemType.HEAL;

        return new GemPattern(g, p);
    }

    public static GemPattern leafGem() {
        Pattern p = new Pattern("leafPart.png");
        p.similar((float) 0.75);
        GemType g = GemType.LEAF;

        return new GemPattern(g, p);
    }

    public static GemPattern stoneGem() {
        Pattern p = new Pattern("stonePart.png");
        p.similar((float) 0.85);
        GemType g = GemType.STON;

        return new GemPattern(g, p);
    }

    public static GemPattern waterGem() {
        Pattern p = new Pattern("waterPart.png");
        p.similar((float) 0.9);
        GemType g = GemType.WATR;

        return new GemPattern(g, p);
    }

    public static GemPattern windGem() {
        Pattern p = new Pattern("windPart.png");
        p.similar((float) 0.5);
        GemType g = GemType.WIND;

        return new GemPattern(g, p);
    }

    public static ArrayList<GemPattern> allPatterns() {
        ArrayList<GemPattern> gemList = new ArrayList<GemPattern>();
        gemList.add(fireGem());
        gemList.add(healGem());
        gemList.add(leafGem());
        gemList.add(stoneGem());
        gemList.add(waterGem());
        gemList.add(windGem());

        return gemList;
    }

}
