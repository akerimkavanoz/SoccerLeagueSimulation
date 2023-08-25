package Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Model.Footballer;
import Model.Team;

public class TeamUtil {

	// Random bir takım ismi oluşturan metot
	public static Team createRandomTeam() {
		// Takım adını oluşturmak için rastgele harf seçelim
		StringBuilder randomTeamName = new StringBuilder();
		Random random = new Random();

		// 10 karakter uzunluğunda bir isim oluşturmak için 10 kez dönelim
		for (int i = 0; i < 10; i++) {
			char randomChar = (char) ('A' + random.nextInt(26));
			randomTeamName.append(randomChar);
		}

		// Takım nesnesini oluşturup random isimle döndürelim
		return new Team(randomTeamName.toString());
	}

	// Random takım isimleri oluşturan metot
	public static List<Team> createRandomTeams(int numberOfTeams) {
		List<Team> teams = new ArrayList<>();
		for (int i = 0; i < numberOfTeams; i++) {
			teams.add(createRandomTeam());
		}
		return teams;
	}

	public static void calculateAndSetTeamStrengths(List<Team> teams) {
		for (Team team : teams) {
			int totalDefenderStrength = 0;
			int totalMidfieldStrength = 0;
			int totalOffensiveStrength = 0;
			int totalGoalkeeperStrength = 0;

			List<Footballer> players = team.getPlayers();

			for (Footballer player : players) {
				String position = player.getPosition();
				switch (position) {
				case "DEFENDER":
					totalDefenderStrength += player.getTotalPower(); // Takımın toplam defans gücü hesaplanır
					break;
				case "MIDFIELDER":
					totalMidfieldStrength += player.getTotalPower(); // Takımın toplam orta saha gücü hesaplanır
					break;
				case "OFFENSIVE":
					totalOffensiveStrength += player.getTotalPower(); // Takımın toplam hücum gücü hesaplanır
					break;
				case "GOALKEEPER":
					totalGoalkeeperStrength += player.getTotalPower(); // Takımın toplam kaleci gücü hesaplanır
					break;
				}
			}

			int numDefenders = 10; // Takımda olması gereken defans oyuncu sayısı
			int numMidfielders = 6; // Takımda olması gereken orta saha oyuncu sayısı
			int numOffensives = 6; // Takımda olması gereken hücum oyuncu sayısı
			int numGoalkeepers = 3; // Takımda olması gereken kaleci oyuncu sayısı

			int defenderAverage = totalDefenderStrength / numDefenders; // Toplam defans gücünü defans oyuncu sayısına
																		// bölerek takımın ortalama defans gücü
																		// hesaplanır
			int midfieldAverage = totalMidfieldStrength / numMidfielders; // Toplam orta saha gücünü orta saha oyuncu
																			// sayısına bölerek takımın ortalama orta
																			// saha gücü hesaplanır
			int offensiveAverage = totalOffensiveStrength / numOffensives; // Toplam hücum gücünü hücum orta saha oyuncu
																			// sayısına bölerek takımın ortalama hücum
																			// gücü hesaplanır
			int goalkeeperAverage = totalGoalkeeperStrength / numGoalkeepers; // Toplam kaleci gücü kaleci oyuncu
																				// sayısına bölerek takımın ortalama
																				// kaleci gücü hesaplanır

			Random random = new Random();
			int fanStrength = random.nextInt(10) + 1; // Takımın random taraftar gücü oluşturulur

			int totalAverageStrength = (defenderAverage + midfieldAverage + offensiveAverage + goalkeeperAverage) / 4; // Takımın
																														// ortalama
																														// gücü
																														// hesaplanır
			// Takımın özelliklerine göre güçleri set edilir
			team.setDefenderAverageStrength(defenderAverage);
			team.setMidfieldAverageStrength(midfieldAverage);
			team.setOffensiveAverageStrength(offensiveAverage);
			team.setGoalkeeperAverageStrength(goalkeeperAverage);
			team.setAverageStrength(totalAverageStrength);
			team.setFanStrength(fanStrength);
		}
	}

	public static void printTeamNames2(List<Team> teams) {
		
//		Team a = new Team("Trabzonspor");
//		teams.add(a);
//		Team b = new Team("Fenerbahce");
//		teams.add(b);
//		Team c = new Team("Galatasaray");
//		teams.add(c);
//		Team d = new Team("Besiktas");
//		teams.add(d);
//		Team e = new Team("Adana Demirspor");
//		teams.add(e);
//		Team f = new Team("Bursaspor");
//		teams.add(f);
//		Team g = new Team("Goztepe");
//		teams.add(g);
//		Team h = new Team("Samsunspor");
//		teams.add(h);
//		Team ı = new Team("Ankaragucu");
//		teams.add(ı);
//		Team i = new Team("Kayserispor");
//		teams.add(i);
//		Team j = new Team("Konyaspor");
//		teams.add(j);
//		Team k = new Team("Antalyaspor");
//		teams.add(k);
//		Team l = new Team("Sivasspor");
//		teams.add(l);
//		Team m = new Team("Basaksehir");
//		teams.add(m);
//		Team n = new Team("Hatayspor");
//		teams.add(n);
//		Team o = new Team("Gaziantep");
//		teams.add(o);
//		Team p = new Team("Kocaelispor");
//		teams.add(p);
//		Team r = new Team("Sakaryaspor");
//		teams.add(r);

		// Oluşturulan takımların isimlerini ekrana yazdıralım
		for (Team team : teams) {
			System.out.println("Team Name: " + team.getName());
		}
	}

	public static void printTeamNames(List<Team> teams) { // Takımların özellikleri, güçleri ve oyuncuları ekrana
															// yazdırılır
		int counter = 1;
		int counter2 = 1;

		for (Team team : teams) {
			System.out.printf(
					"Team: %d%nTeam Name: %s%nGoalkeeper Strength: %d%nDefensive Strength: %d%nMidfield Strength: %d%nAttack Strength: %d%nAverage Strength: %d%nFan Strength: %d%n",
					counter2, team.getName(), team.getGoalkeeperAverageStrength(), team.getDefenderAverageStrength(),
					team.getMidfieldAverageStrength(), team.getOffensiveAverageStrength(), team.getAverageStrength(),
					team.getFanStrength());
			counter2++;
			counter = 1;
			System.out.printf("%-16s %-14s %-21s %s %14s %n", "Footballer", "Name", "Position", "Strength",
					"Team Name");
			for (Footballer player : team.getPlayers()) {
				System.out.printf("%-16s %-14s %-21s %d %21s %n", counter + ". Footballers:", player.getName(),
						player.getPosition(), player.getTotalPower(), player.getTeam());
				counter++;
			}
			System.out.println("------------------------------------------------------------------------------------");
		}
	}
}
