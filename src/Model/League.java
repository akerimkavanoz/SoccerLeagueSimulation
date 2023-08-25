package Model;

import java.util.ArrayList;
import java.util.List;

public class League {
    private List<Team> teams;
    private List<Week> weeks;

    public League(List<Team> teams) {
        this.teams = teams;
        this.weeks = new ArrayList<>();
    }

    public void addWeek(Week week) {
        weeks.add(week);
    }

    public List<Team> getTeams() {
        return teams;
    }
    
    public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

    public List<Week> getWeeks() {
        return weeks;
    }
    
    public void setWeeks(List<Week> weeks) {
		this.weeks = weeks;
	}
}