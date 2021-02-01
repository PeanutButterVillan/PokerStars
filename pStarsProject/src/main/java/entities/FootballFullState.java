package entities;

public class FootballFullState {
    public String homeTeam;
    public String awayTeam;
    public boolean finished;
    public Team team;

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Team[] getTeams() {
        return teams;
    }

    public void setTeams(Team[] teams) {
        this.teams = teams;
    }

    public Team[] teams;


    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public int gameTimeInSeconds;

    public int getGameTimeInSeconds() {
        return gameTimeInSeconds;
    }

    public void setGameTimeInSeconds(int gameTimeInSeconds) {
        this.gameTimeInSeconds = gameTimeInSeconds;
    }

    public Goal[] goals;

    public Goal[] getGoals() {
        return goals;
    }

    public void setGoals(Goal[] goals) {
        this.goals = goals;
    }

    public String period;

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String[] possibles;

    public String[] getPossibles() {
        return possibles;
    }

    public void setPossibles(String[] possibles) {
        this.possibles = possibles;
    }

    public String[] corners;

    public String[] getCorners() {
        return corners;
    }

    public void setCorners(String[] corners) {
        this.corners = corners;
    }

    public String[] redCards;

    public String[] getRedCards() {
        return redCards;
    }

    public void setRedCards(String[] redCards) {
        this.redCards = redCards;
    }

    public String[] yellowCards;

    public String[] getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(String[] yellowCards) {
        this.yellowCards = yellowCards;
    }

    public String startDateTime;

    public String getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(String startDateTime) {
        this.startDateTime = startDateTime;
    }

    public boolean started;

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }



    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }
}
