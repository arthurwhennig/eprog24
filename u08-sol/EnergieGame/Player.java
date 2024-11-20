public class Player {
	public final String name;
	
	//Change String to role  
	public final Role role;
	
	private int energy;
	
	// PRE: name != null
	// PRE: role != null and role must be a valid Role class 
	//change constructor to Role role
	public Player(String name, Role role) {
		this.name = name;
		this.role = role;
		this.energy = 10;
	}
	
	public void changeEnergyBy(int value) {
		energy += value;
	}

	public String toString() {
		return name + " (" + role + ", " + energy + ")";
	}
}
