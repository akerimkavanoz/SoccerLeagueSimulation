package Util;

import Model.Team;
import Model.Match;
import Model.Week;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FixtureUtil {
	public static List<Week> generateFixture(List<Team> teams) {
		int totalWeeks = teams.size() - 1; // Takım sayısından bir az hafta olduğu için toplam hafta sayısı hesaplanır
		int matchesPerWeek = teams.size() / 2; // Bir haftada takım sayısının yarısı kadar maç olduğu için maç sayısı
												// hesaplanır
		List<Week> fixture = new ArrayList<>(); // Fikstürün tutulacağı liste
		List<Match> previousMatchups = new ArrayList<>(); // Daha önce eşleşen takımları kontrol etmek için liste

		Collections.shuffle(teams); // Takımları rastgele karıştırır (Her çalıştırdığımızda farklı fikstür çekilmesi
									// için)

		for (int week = 1; week <= totalWeeks; week++) { // 17 hafta kadar döner ve fikstür çekilir
			Week weekObj = new Week(week); // Week sınıfından obje oluşturulur

			for (int match = 0; match < matchesPerWeek; match++) { // Maç eşleştirmeleri burada yapılır
				Team homeTeam; // Ev sahibi takım
				Team awayTeam; // Deplasman takımı

				// İlk hafta kendi sahasında oynayan takım, sonraki hafta deplasmanda oynar
				// Burada şöyle bir durum oluşuyor rotateTeam metodu çalıştırıldığı için iki
				// hafta üst üste bir takım iç saha bir takım dış sahada oynar. Bu takımlar 2
				// haftada bir değişiyor
				if (week % 2 == 1) { //
					homeTeam = teams.get(match);
					awayTeam = teams.get(teams.size() - 1 - match);
				} else {
					awayTeam = teams.get(match);
					homeTeam = teams.get(teams.size() - 1 - match);
				}

				Match Matchup = new Match(homeTeam, awayTeam); // Eşleştirme yapılır

				// Daha önce eşleşen takımları kontrol et
				boolean hasConflict = previousMatchups.stream()
						.anyMatch(matchup -> (matchup.getHomeTeam() == homeTeam && matchup.getAwayTeam() == awayTeam)
								|| (matchup.getHomeTeam() == awayTeam && matchup.getAwayTeam() == homeTeam));

				if (!hasConflict) { // Takımlar daha önce eşleşmemiş ise hem eşleşen listesine hemde weekObj.add
									// metodu ile Week sınıfına ekleme yapılır
					previousMatchups.add(Matchup); // previousMatchups listesine Matchup bilgisini ekler
					weekObj.addMatch(new Match(homeTeam, awayTeam)); // Week objesindeki addMatch metoduna Match
																		// bilgisini yollar
				} else {
					match--; // Tekrar aynı indeksteki takımları eşleştirmek için match değişkenini azaltır
				}
			}

			fixture.add(weekObj); // Fikstür listesine ekleme yapılır
			rotateTeams(teams); // Takım listesi rotate edilir
		}

		for (int weekNumber = 18; weekNumber <= 34; weekNumber++) { // Kalan 17 hafta ilk 17 haftanın tersi olacak
																	// şekilde fikstüre eklenir
			Week originalWeek = fixture.get(weekNumber - 18);
			Week reverseWeek = new Week(weekNumber);
			Week weekObj = new Week(weekNumber); // Week sınıfından obje oluşturulur
			for (Match match : originalWeek.getMatches()) {
				weekObj.addMatch(new Match(match.getAwayTeam(), match.getHomeTeam()));
				reverseWeek.addMatch(new Match(match.getAwayTeam(), match.getHomeTeam())); // Ev sahibi takım ile
																							// deplasman takımının yeri
																							// değiştirilerek kalan 17
																							// haftalık fikstür
																							// oluşturulur
			}

			fixture.add(reverseWeek);
		}

		printFixture(fixture, teams); // Fikstür ekrana yazdırılır
		return fixture;
	}

	public static void rotateTeams(List<Team> teams) { // Listenin sonundaki takımı listenin 1.sırasına ekler
		Team lastTeam = teams.remove(teams.size() - 1);
		teams.add(1, lastTeam);
	}

	public static void printFixture(List<Week> fixture, List<Team> teams) { // Fikstür ve maç sonuçları ekrana
																			// yazdırılır

		for (Week week : fixture) {
			System.out.println(week.getWeekNumber() + ".th week matches");
			System.out.println("----------------------------");

			for (Match match : week.getMatches()) {
				Team homeTeam = match.getHomeTeam();
				Team awayTeam = match.getAwayTeam();

				System.out.println(homeTeam.getName() + " vs " + awayTeam.getName()); // Fikstür ekrana yazdırılır
			}

			System.out.println();
			System.out.println(week.getWeekNumber() + ".th week match results");
			System.out.println("----------------------------");

			for (Match match : week.getMatches()) {
				Team homeTeam = match.getHomeTeam();
				Team awayTeam = match.getAwayTeam();

				MatchUtil.simulateMatch(homeTeam, awayTeam, homeTeam.getFanStrength()); // Maç sonuçları ekrana
																						// yazdırılır
			}

			System.out.println();
			System.out.println(week.getWeekNumber() + ".th week rankings");
			System.out.println("----------------------------");
			LeagueUtil.printStandings(teams); // Puan durumu ekrana yazdırılır
			System.out.println();
		}
	}
}