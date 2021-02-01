package entities;

public class Fixture {

    // For tests using JsonObject
    public static final String ID = "fixtureId";

    public int fixtureId;

    public void setFixtureId(int fixtureId){
        this.fixtureId = fixtureId;
    }

    public int getFixtureId() {
        return fixtureId;
    }

    public FixtureStatus fixtureStatus;

    public FootballFullState footballFullState;

    public static String getID() {
        return ID;
    }
}
