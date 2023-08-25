package Util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Model.Team;

public class LeagueUtil {
	public static void updateTeamStatistics(Team homeTeam, Team awayTeam, int homeGoals, int awayGoals) {
		// Ev sahibi takımın istatistiklerini güncellenir
		homeTeam.setMatchPlayed(); // Oynanan maç set edilir
		homeTeam.setScoredGoal(homeGoals); // Ev sahini atılan gol set edilir
		homeTeam.setConcededGoal(awayGoals); // Ev sahibi yenilen gol set edilir

		if (homeGoals > awayGoals) {
			homeTeam.setWin(); // Ev sahibine galibiyet set edilir
			homeTeam.setPoint(3); // Ev sahibine 3 puan set edilir
		} else if (homeGoals == awayGoals) {
			homeTeam.setDraw(); // Ev sahiine beraberlik set edilir
			homeTeam.setPoint(1); // Ev sahibine 1 puan set edilir
		} else {
			homeTeam.setDefeat(); // Ev sahibine mağlubiyet set edilir
		}

		// Deplasman takımının istatistiklerini güncellenir
		awayTeam.setMatchPlayed(); // Oynanan maç set edilir
		awayTeam.setScoredGoal(awayGoals); // Deplasman atılan gol set edilir
		awayTeam.setConcededGoal(homeGoals); // Deplasman yenilen gol set edilir

		if (awayGoals > homeGoals) {
			awayTeam.setWin(); // Deplasman takımına galibiyet set edilir
			awayTeam.setPoint(3); // Deplasman takımına 3 puan set edilir
		} else if (awayGoals == homeGoals) {
			awayTeam.setDraw(); // Deplasman takımına beraberlik set edilir
			awayTeam.setPoint(1); // Deplasman takımına 1 puan set edilir
		} else {
			awayTeam.setDefeat(); // Deplasman takımına mağlubiyet set edilir
		}

		homeTeam.setAverage(homeGoals, awayGoals); // averajlar set edilir
		awayTeam.setAverage(awayGoals, homeGoals); // averajlar set edilir

	}

	public static void printStandings(List<Team> teams) { // Puan durumunu yazdırılır
		Collections.sort(teams, new StandingsComparator()); // teams listesini, StandingsComparator sınıfı tarafından
															// belirlenen kriterlere göre sıralar

		System.out.printf("%-12s %-30s %s %n", "Strength", "Team Name", "Match Statistics");
		for (Team team : teams) { // Puan durumu sıralı bir şekilde ekrana yazdırılır
			System.out.printf("%-10d %-18s P:%-3d W:%-3d D:%-3d L:%-3d GF:%-3d GA:%-3d GD:%-3d PT:%-3d %n",
					team.getAverageStrength(), team.getName(), team.getMatchPlayed(), team.getWin(), team.getDraw(),
					team.getDefeat(), team.getScoredGoal(), team.getConcededGoal(), team.getAverage(), team.getPoint());
		}
	}

	static class StandingsComparator implements Comparator<Team> { // Bu sınıf, Comparator<Team> arabirimini uygular ve
																	// takımları belirli kriterlere göre karşılaştırmak
																	// için kullanılır.
		@Override
		public int compare(Team team1, Team team2) { // İlk olarak puanlarına göre sıralar, ardından averajlarına,
														// atılan gollere ve galibiyet sayılarına göre sıralama yapar.
			if (team1.getPoint() != team2.getPoint()) {
				return team2.getPoint() - team1.getPoint();
			} else if (team1.getAverage() != team2.getAverage()) {
				return team2.getAverage() - team1.getAverage();
			} else if (team1.getScoredGoal() != team2.getScoredGoal()) {
				return team2.getScoredGoal() - team1.getScoredGoal();
			} else {
				return team2.getWin() - team1.getWin();
			}
		}
	}
}
