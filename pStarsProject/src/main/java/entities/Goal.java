package entities;

public class Goal {
public int clockTime;

    public int getClockTime() {
        return clockTime;
    }

    public void setClockTime(int clockTime) {
        this.clockTime = clockTime;
    }

    public boolean confirmed;

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean ownGoal;

    public boolean isOwnGoal() {
        return ownGoal;
    }

    public void setOwnGoal(boolean ownGoal) {
        this.ownGoal = ownGoal;
    }

    public boolean penalty;

    public boolean isPenalty() {
        return penalty;
    }

    public void setPenalty(boolean penalty) {
        this.penalty = penalty;
    }

    public String period;

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public int playerId;

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int teamId;

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }
}
