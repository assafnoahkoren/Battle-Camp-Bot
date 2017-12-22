package models;

public class GemSequence {
    int length;
    GemType type;


    public GemSequence(int length, GemType type) {
        this.length = length;
        this.type = type;
    }

    public int getLength() {
        return length;
    }

    public GemType getType() {
        return type;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setType(GemType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "GemSequence{" +
                "length=" + length +
                ", type=" + type +
                '}';
    }
}
