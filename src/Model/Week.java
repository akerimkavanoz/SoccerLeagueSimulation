package Model;

import java.util.ArrayList;
import java.util.List;

public class Week {
	private int weekNumber;
	private List<Match> matches;

	public Week(int weekNumber) {
		this.weekNumber = weekNumber;
		this.matches = new ArrayList<>();
	}

	public void addMatch(Match match) {
		matches.add(match);
	}

	public int getWeekNumber() {
		return weekNumber;
	}

	public void setWeekNumber(int weekNumber) {
		this.weekNumber = weekNumber;
	}

	public List<Match> getMatches() {
		return matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}
}