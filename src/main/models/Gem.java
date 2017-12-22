package models;

import org.sikuli.script.Location;

public class Gem {
    GemType type;
    Location location;

    public Gem(GemType type, Location location) {
        this.type = type;
        this.location = location;
    }

    public GemType getType() {
        return type;
    }

    public Location getLocation() {
        return location;
    }
}
