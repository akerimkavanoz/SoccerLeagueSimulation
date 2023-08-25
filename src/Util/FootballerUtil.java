package Util;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import Model.Footballer;
import Model.Team;
import Model.goalkeeperAttributes;
import Model.Attributes;

public class FootballerUtil {

	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

	// Random bir isim oluşturan metot
	public static Footballer generateRandomName() {
		int nameLength = 7 + (int) (Math.random() * 5); // 7-11 karakter arası bir isim oluşturmak için
		StringBuilder nameBuilder = new StringBuilder();

		for (int i = 0; i < nameLength; i++) {
			char randomChar = ALPHABET.charAt((int) (Math.random() * ALPHABET.length()));
			nameBuilder.append(randomChar); // Alfabeden random harf seçerek nameBuilder a ekleme yapar döngü bittiğinde
											// futbolcu ismi oluşmuş olur
		}

		return new Footballer(nameBuilder.toString());
	}

	public static List<Footballer> generateRandomPlayers(int numberOfPlayers) {
		List<Footballer> footballers = new ArrayList<>();

		int goalkeepersToAdd = 54; // 54 kaleci olacak
		int defendersToAdd = 180; // 180 defans olacak
		int midfieldersToAdd = 108; // 108 orta saha olacak
		int forwardsToAdd = 108; // 108 hücum oyuncusu olacak

		while (footballers.size() < numberOfPlayers) { // 18 takım ve her takımda 25 futbolcu olacağı için main.java
														// içerisinde metoda numberOfPlayers değeri 450 olarak yollandı.
														// 450 adet futbolcu oluşturulur. Bu futbolcuların 54 adeti
														// kaleci, 180 adeti defans, 108 adeti orta saha ve 108 adeti
														// hücum oyuncusudur
			if (goalkeepersToAdd > 0) {
				Footballer footballer = generateRandomName();
				footballer.setPosition("GOALKEEPER");
				footballers.add(footballer);
				goalkeepersToAdd--;
			}
			if (defendersToAdd > 0) {
				Footballer footballer = generateRandomName();
				footballer.setPosition("DEFENDER");
				footballers.add(footballer);
				defendersToAdd--;
			}
			if (midfieldersToAdd > 0) {
				Footballer footballer = generateRandomName();
				footballer.setPosition("MIDFIELDER");
				footballers.add(footballer);
				midfieldersToAdd--;
			}
			if (forwardsToAdd > 0) {
				Footballer footballer = generateRandomName();
				footballer.setPosition("OFFENSIVE");
				footballers.add(footballer);
				forwardsToAdd--;
			}
		}

		return footballers;

	}

	public static void assignAbilities(List<Footballer> footballers) {

		for (Footballer footballer : footballers) { // Oyuncuların pozisyonlarına göre enum içerisindeki özelliklerine
													// random değer atanır
			String position = footballer.getPosition();

			switch (position) {
			case "DEFENDER":
				assignAttributes(footballer, Attributes.values(), "DEFENDER");
				break;
			case "GOALKEEPER":
				assignAttributes(footballer, goalkeeperAttributes.values(), "GOALKEEPER");
				break;
			case "MIDFIELDER":
				assignAttributes(footballer, Attributes.values(), "MIDFIELDER");
				break;
			case "OFFENSIVE":
				assignAttributes(footballer, Attributes.values(), "OFFENSIVE");
				break;
			}
		}
	}

	public static <T extends Enum<T>> Map<T, Integer> assignAttributes(Footballer footballer, T[] attributes,
			String position) {
		Map<T, Integer> attributesMap = new LinkedHashMap<>(); // Enum LinkedHashMap yapısına çevrilir linked
																// kullanmamızın sebebi enumun sırasının bozulmaması
																// için
		Random random = new Random();

		for (T attribute : attributes) {
			int randomValue = random.nextInt(20) + 1;
			attributesMap.put(attribute, randomValue); // Enum içerisindeki tüm özelliklere 1-20 arası random değer
														// atanır
		}

		int index = 0;
		double totalPhysicalAbility = 0;
		double totalMentalAbility = 0;
		double totalTechnicalAbility = 0;
		int totalGoalkeepingAbility = 0;
		double total = 0;

		for (Map.Entry<T, Integer> entry : attributesMap.entrySet()) {
			T attribute = entry.getKey();
			int value = entry.getValue();
			if (position.equals("DEFENDER")) {

				if (index < 8) { // Defans pozisyonunun önemli özellikleri 1 kat sayısı değerinde olduğu için
									// (çarpmada 1 etkisiz eleman olduğundan) totalPhysicalAbility değişkenine
									// eklenir
					if (attribute.toString().equals("BALANCE") || attribute.toString().equals("JUMPING_REACH")
							|| attribute.toString().equals("STAMINA") || attribute.toString().equals("STRENGTH")) {
						totalPhysicalAbility += value;
					} else { // Önemli özelliklerin dışındaki özellikler 0.2 kat sayısı ile çarpılıp
								// totalPhysicalAbility değişkenine eklenir
						totalPhysicalAbility += (value * 0.2);
					}

				} else if (index > 7 && index < 22) { // Yukarıdaki if bloğu içerisindeki mantık aşağıdaki tüm yapıda
														// geçerlidir
					if (attribute.toString().equals("CONCENTRATION") || attribute.toString().equals("LEADERSHIP")
							|| attribute.toString().equals("BRAVERY") || attribute.toString().equals("POSITIONING")) {
						totalMentalAbility += value;
					} else {
						totalMentalAbility += (value * 0.2);
					}

				} else if (index > 21 && index < 37) {
					if (attribute.toString().equals("FIRST_TOUCH") || attribute.toString().equals("HEADING")
							|| attribute.toString().equals("MARKING") || attribute.toString().equals("TACKLING")) {
						totalTechnicalAbility += value;
					} else {
						totalTechnicalAbility += (value * 0.2);
					}
				}
			}

			else if (position.equals("MIDFIELDER")) {
				if (index < 8) {
					if (attribute.toString().equals("NATURAL_FITNESS") || attribute.toString().equals("BALANCE")
							|| attribute.toString().equals("PACE") || attribute.toString().equals("STAMINA")) {
						totalPhysicalAbility += value;
					} else {
						totalPhysicalAbility += (value * 0.2);
					}

				} else if (index > 7 && index < 22) {
					if (attribute.toString().equals("OFF_THE_BALL") || attribute.toString().equals("LEADERSHIP")
							|| attribute.toString().equals("COMPOSURE") || attribute.toString().equals("FLAIR")) {
						totalMentalAbility += value;
					} else {
						totalMentalAbility += (value * 0.2);
					}

				} else if (index > 21 && index < 37) {
					if (attribute.toString().equals("FIRST_TOUCH") || attribute.toString().equals("HEADING")
							|| attribute.toString().equals("PASSING") || attribute.toString().equals("TECHNIQUE")) {
						totalTechnicalAbility += value;
					} else {
						totalTechnicalAbility += (value * 0.2);
					}
				}
			}

			else if (position.equals("OFFENSIVE")) {
				if (index < 8) {
					if (attribute.toString().equals("NATURAL_FITNESS") || attribute.toString().equals("BALANCE")
							|| attribute.toString().equals("STRENGTH") || attribute.toString().equals("PACE")) {
						totalPhysicalAbility += value;
					} else {
						totalPhysicalAbility += (value * 0.2);
					}

				} else if (index > 7 && index < 22) {
					if (attribute.toString().equals("FLAIR") || attribute.toString().equals("VISION")
							|| attribute.toString().equals("COMPOSURE")
							|| attribute.toString().equals("ANTICIPATION")) {
						totalMentalAbility += value;
					} else {
						totalMentalAbility += (value * 0.2);
					}

				} else if (index > 21 && index < 37) {
					if (attribute.toString().equals("DRIBBLING") || attribute.toString().equals("FIRST_TOUCH")
							|| attribute.toString().equals("PASSING") || attribute.toString().equals("TECHNIQUE")) {
						totalTechnicalAbility += value;
					} else {
						totalTechnicalAbility += (value * 0.2);
					}
				}
			}

			else if (position.equals("GOALKEEPER")) {
				if (index < 8) {
					if (attribute.toString().equals("AGILITY") || attribute.toString().equals("JUMPING_REACH")
							|| attribute.toString().equals("BALANCE") || attribute.toString().equals("STAMINA")) {
						totalPhysicalAbility += value;
					} else {
						totalPhysicalAbility += (value * 0.2);
					}

				} else if (index > 7 && index < 22) {
					if (attribute.toString().equals("DETERMINATION") || attribute.toString().equals("POSITIONİNG")
							|| attribute.toString().equals("CONCENTRATION") || attribute.toString().equals("BRAVERY")) {
						totalMentalAbility += value;
					} else {
						totalMentalAbility += (value * 0.2);
					}

				} else if (index > 21 && index < 36) {
					if (attribute.toString().equals("REFLEXES") || attribute.toString().equals("ONE_ON_ONES")
							|| attribute.toString().equals("AERIAL_REACH")
							|| attribute.toString().equals("COMMAND_OF_AREA")) {
						totalTechnicalAbility += value;
					} else {
						totalTechnicalAbility += (value * 0.2);
					}
				}
			}

			index++;
		}

		if (position.equals("GOALKEEPER")) { // Kalecilik özellikleri kaleci pozisyonundaki oyuncular için 10-20 değeri
												// arasında verilir diğer futbolcular ise 1-20 değeri arasında
			totalGoalkeepingAbility = random.nextInt(11) + 10;
		} else {
			totalGoalkeepingAbility = random.nextInt(20) + 1;
		}

		total = totalPhysicalAbility + totalMentalAbility + totalTechnicalAbility + totalGoalkeepingAbility; // Oyuncunun
																												// toplam
																												// gücü
		// Oyuncunun güçleri özelliklerine göre set edilir
		footballer.setPhysicalAbility(totalPhysicalAbility);
		footballer.setMentalAbility(totalMentalAbility);
		footballer.setTechnicalAbility(totalTechnicalAbility);
		footballer.setGoalkeepingAbility(totalGoalkeepingAbility);
		footballer.setTotalPower((int) total); // Oyuncunun toplam gücü küsüratlı olmaması için int türüne cast edilir
												// ve footballer içerisinde TotalPower değerine set edilir
		return attributesMap;
	}

	public static Footballer findStrongestPlayer(List<Footballer> footballers) { // İstenildiğinde tüm oyuncular
																					// içerisindeki en güçlü oyuncuyu
																					// bulamak için ekstra olarak bu
																					// metot yazılmıştır
		if (footballers.isEmpty()) {
			return null;
		}

		Footballer strongestPlayer = footballers.get(0);
		for (Footballer player : footballers) {
			if (player.getTotalPower() > strongestPlayer.getTotalPower()) {
				strongestPlayer = player;
			}
		}

		return strongestPlayer;
	}

	public static Footballer findWeakestPlayer(List<Footballer> footballers) { // İstenildiğinde tüm oyuncular
																				// içerisindeki en güçsüz oyuncuyu
																				// bulamak için ekstra olarak bu metot
																				// yazılmıştır
		if (footballers.isEmpty()) {
			return null;
		}

		Footballer weakestPlayer = footballers.get(0);
		for (Footballer player : footballers) {
			if (player.getTotalPower() < weakestPlayer.getTotalPower()) {
				weakestPlayer = player;
			}
		}

		return weakestPlayer;
	}

	public static void normalizeTotalPower(List<Footballer> footballers) { // Futbolcu güçleri toplamda en az 18
																			// değerini ve en fazla 356 değerini
																			// alabilmektedir. Futbolcu özellikleri 100
																			// değeri üzerinden olması için normalize
																			// ediliyor
		if (footballers.isEmpty()) {
			return;
		}

		double minTotalPower = 18;
		double maxTotalPower = 356;

		for (Footballer player : footballers) {
			int normalizedTotalPower = normalizeAttribute(player.getTotalPower(), minTotalPower, maxTotalPower, 0, 100);
			player.setTotalPower(normalizedTotalPower);
		}
	}

	private static int normalizeAttribute(double attributeValue, double minAttributeValue, double maxAttributeValue,
			double newMin, double newMax) {
		double normalizedValue = ((attributeValue - minAttributeValue) / (maxAttributeValue - minAttributeValue))
				* (newMax - newMin) + newMin;
		return (int) Math.max(Math.min(normalizedValue, newMax), newMin); // Normalizasyon formülü uygulanarak yeni
																			// değer return ediliyor
	}

	public static void assignPlayersToTeams(List<Footballer> footballers, List<Team> teams) {
		List<Footballer> goalkeepers = new ArrayList<>();
		List<Footballer> defenders = new ArrayList<>();
		List<Footballer> midfielders = new ArrayList<>();
		List<Footballer> forwards = new ArrayList<>();

		// Futbolcuları pozisyonlarına göre gruplara ayıralım
		for (Footballer player : footballers) {
			String position = player.getPosition();
			if (position.equals("GOALKEEPER")) {
				goalkeepers.add(player);
			} else if (position.equals("DEFENDER")) {
				defenders.add(player);
			} else if (position.equals("MIDFIELDER")) {
				midfielders.add(player);
			} else if (position.equals("OFFENSIVE")) {
				forwards.add(player);
			}
		}

		// Her bir takım için futbolcuları atayalım
		for (Team team : teams) {
			assignPlayersToTeam(team, goalkeepers, 3); // Her takıma 3 kaleci atanır
			assignPlayersToTeam(team, defenders, 10); // Her takıma 10 defans atanır
			assignPlayersToTeam(team, midfielders, 6); // Her takıma 6 orta saha atanır
			assignPlayersToTeam(team, forwards, 6); // Her takıma 6 hücum oyuncusu atanır
		}
	}

	public static void assignPlayersToTeam(Team team, List<Footballer> players, int count) {
		Random random = new Random();

		for (int i = 0; i < count; i++) {
			if (!players.isEmpty()) {
				int randomIndex = random.nextInt(players.size()); // Random oyuncu seçilmek için randomIndex değeri
																	// oluşturulur
				Footballer player = players.remove(randomIndex); // Takıma eklenecek oyuncu listeden silinir ve player
																	// değişkenine atanır
				player.setTeam(team.getName()); // Oyuncunun takımı set edilir
				team.addPlayer(player); // Takıma oyuncu eklenir
			}
		}
	}

	public static void printFootballers(List<Footballer> footballers) {
		int counter = 1;
		// Oluşturulan futbolcuların isimlerini ve diğer özelliklerini ekrana yazdıralım
		for (Footballer footballer : footballers) {
			System.out.println(counter + ". Footballer Name: " + footballer.getName() + " " + footballer.getPosition()
					+ " " + footballer.getTotalPower());
			counter++;
		}
	}
}
