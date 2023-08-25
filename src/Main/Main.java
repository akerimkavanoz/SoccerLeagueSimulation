package Main;

import Model.Team;
import Model.Footballer;
import Util.FixtureUtil;
import Util.TeamUtil;
import Util.FootballerUtil;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Team> teams = TeamUtil.createRandomTeams(18);
		//List<Team> teams = new ArrayList<>(); // Oluşturulan takımları içerisine atacağımız bir ArrayList oluşturduk
		TeamUtil.printTeamNames2(teams); // Oluşturulan takımları ekrana yazdır
		List<Footballer> footballers = FootballerUtil.generateRandomPlayers(450); // Random şekilde 450 futbolcu
																					// oluşturuluyor
		FootballerUtil.assignAbilities(footballers); // Futbolcuların pozisyonlarına göre güçleri random şekilde
														// atanıyor
		// FootballerUtil.printFootballers(footballers); // Futbolcuları listele
		// System.out.println(FootballerUtil.findStrongestPlayer(footballers).getName());
		// Gücü en yüksek futbolcu
		// System.out.println(FootballerUtil.findWeakestPlayer(footballers).getName());
		// Gücü en düşük futbolcu
		FootballerUtil.normalizeTotalPower(footballers); // Futbolcu güçlerini normalize ediyoruz
		FootballerUtil.assignPlayersToTeams(footballers, teams); // Futbolcuları random şekilde takımlara ayırıyor
		TeamUtil.calculateAndSetTeamStrengths(teams); // Takımların güçleri hesaplanıyor
		TeamUtil.printTeamNames(teams); // Takımların özellikleri ve oyuncular ekrana yazdırılıyor
		FixtureUtil.generateFixture(teams); // Fikstür çekiliyor, maçlar oynanıyor ve maç sonuçları
											// ile beraber puan durumu ekrana yazdırılıyor
	}
}
