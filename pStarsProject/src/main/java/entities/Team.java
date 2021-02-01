package entities;

public class Team {

    public Team()
    {

    }
    public Team(String association, String name, String teamId)
    {
        this.association = association;
        this.name = name;
        this.teamId = teamId;
    }

    public String association;

    public String getAssociation() {
        return association;
    }

    public void setAssociation(String association) {
        this.association = association;
    }

    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String teamId;

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }
}
