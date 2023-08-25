package Model;

public class Footballer {
	private String name;
	private String position;
	private double physicalAbility;
	private double mentalAbility;
	private double technicalAbility;
	private double goalkeepingAbility;
	private int totalPower;
	private String team;

	public Footballer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public double getPhysicalAbility() {
		return physicalAbility;
	}
	
	public void setPhysicalAbility(double physicalAbility) {
		this.physicalAbility = physicalAbility;
	}

	public double getMentalAbility() {
		return mentalAbility;
	}

	public void setMentalAbility(double mentalAbility) {
		this.mentalAbility = mentalAbility;
	}

	public double getTechnicalAbility() {
		return technicalAbility;
	}

	public void setTechnicalAbility(double technicalAbility) {
		this.technicalAbility = technicalAbility;
	}

	public double getGoalkeepingAbility() {
		return goalkeepingAbility;
	}

	public void setGoalkeepingAbility(double goalkeepingAbility) {
		this.goalkeepingAbility = goalkeepingAbility;
	}
	
	public int getTotalPower() {
		return totalPower;
	}
	
	public void setTotalPower(int totalPower) {
		this.totalPower = totalPower;
	}
	
	public String getTeam() {
		return team;
	}
	
	public void setTeam(String team) {
		this.team = team;
	}
}
