package Util;

import java.util.Random;

import Model.Match;
import Model.Team;

public class MatchUtil {
	public static void simulateMatch(Team homeTeam, Team awayTeam, int homeFanStrength) {
		Random random = new Random();
		Match matches = new Match(homeTeam, awayTeam);
		int homeGoals = simulateGoals(random, homeTeam.getAverageStrength(), homeFanStrength);  // Ev sahibi takımı golü
		int awayGoals = simulateGoals(random, awayTeam.getAverageStrength(), 0); // Deplasman takımı golü. Deplasman taraftar gücü sıfır kabul
																					// edilir
		matches.setHomeTeamScore(homeGoals);  // Matches sınıfına ev sahibi takım golü set edilir
		matches.setAwayTeamScore(awayGoals);  // Matches sınıfına deplasman takım golü set edilir
		System.out.println(homeTeam.getName() + " " + matches.getHomeTeamScore() + " - " + matches.getAwayTeamScore()
				+ " " + awayTeam.getName());                    // Maç sonuçları ekrana yazdırılır
		LeagueUtil.updateTeamStatistics(homeTeam, awayTeam, homeGoals, awayGoals);    // Takımların istatistikleri güncellenir
	}

	public static int simulateGoals(Random random, int teamStrength, int fanStrength) {
		double randomFactor = random.nextDouble(); // Rastgele faktör (0.0 - 1.0 arasında)
		double[] probabilities = { 0.1, 0.2, 0.3, 0.2, 0.1, 0.05, 0.03, 0.02, 0.01, 0.01 }; // Olasılık dağılımı

		// Takım gücü ve taraftar gücüne bağlı olarak olasılıkları artır
		for (int i = 0; i < probabilities.length; i++) {
			probabilities[i] += (teamStrength * 0.8 + fanStrength * 0.2) * 0.001;
		}

		double cumulativeProbability = 0.0;
		int goals = 0;

		for (int i = 0; i < probabilities.length; i++) {
			cumulativeProbability += probabilities[i];
			if (randomFactor <= cumulativeProbability) { // Kumulatif olasılık hesaplanır ve rastgele faktörle
															// karşılaştırılır.
				goals = i; // Eğer rastgele faktör, kumulatif olasılığa eşit veya küçükse, gol sayısı
							// atanır ve döngü sona erer.
				break;
			}
		}

		return goals;
	}
}
