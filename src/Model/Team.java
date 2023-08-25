package Model;

import java.util.ArrayList;
import java.util.List;

public class Team {
	private String name;
	private List<Footballer> players;
	private int defenderAverageStrength;
	private int midfieldAverageStrength;
	private int offensiveAverageStrength;
	private int goalkeeperAverageStrength;
	private int averageStrength;
	private int fanStrength;
	private int scoredGoal;
	private int concededGoal;
	private int matchPlayed;
	private int win;
	private int draw;
	private int defeat;
	private int average;
	private int point;

	public Team(String name) {
		this.name = name;
		this.players = new ArrayList<>();
	}

	public void addPlayer(Footballer player) {
		players.add(player);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Footballer> getPlayers() {
		return players;
	}

	public void setPlayers(List<Footballer> players) {
		this.players = players;
	}

	public int getDefenderAverageStrength() {
		return defenderAverageStrength;
	}

	public void setDefenderAverageStrength(int defenderAverageStrength) {
		this.defenderAverageStrength = defenderAverageStrength;
	}

	public int getMidfieldAverageStrength() {
		return midfieldAverageStrength;
	}

	public void setMidfieldAverageStrength(int midfieldAverageStrength) {
		this.midfieldAverageStrength = midfieldAverageStrength;
	}

	public int getOffensiveAverageStrength() {
		return offensiveAverageStrength;
	}

	public void setOffensiveAverageStrength(int offensiveAverageStrength) {
		this.offensiveAverageStrength = offensiveAverageStrength;
	}

	public int getGoalkeeperAverageStrength() {
		return goalkeeperAverageStrength;
	}

	public void setGoalkeeperAverageStrength(int goalkeeperAverageStrength) {
		this.goalkeeperAverageStrength = goalkeeperAverageStrength;
	}

	public int getAverageStrength() {
		return averageStrength;
	}

	public void setAverageStrength(int averageStrength) {
		this.averageStrength = averageStrength;
	}

	public int getFanStrength() {
		return fanStrength;
	}

	public void setFanStrength(int fanStrength) {
		this.fanStrength = fanStrength;
	}

	public int getScoredGoal() {
		return scoredGoal;
	}

	public void setScoredGoal(int scoredGoal) {
		this.scoredGoal += scoredGoal;
	}

	public int getConcededGoal() {
		return concededGoal;
	}

	public void setConcededGoal(int concededGoal) {
		this.concededGoal += concededGoal;
	}

	public int getMatchPlayed() {
		return matchPlayed;
	}

	public void setMatchPlayed() {
		this.matchPlayed++;
	}

	public int getWin() {
		return win;
	}

	public void setWin() {
		this.win++;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw() {
		this.draw++;
	}

	public int getDefeat() {
		return defeat;
	}

	public void setDefeat() {
		this.defeat++;
	}

	public int getAverage() {
		return average;
	}

	public void setAverage(int scoredGoal, int concededGoal) {
		this.average += scoredGoal - concededGoal;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point += point;
	}
}
