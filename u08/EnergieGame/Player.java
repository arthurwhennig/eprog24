public class Player {
	public final String name;
	
	/* 
	 * TODO: Change role to type "Role" and make sure that 
	 *       the remaining code also uses type "Role" instead
	 *       of String for all role-related behaviour in all 
	 *       classes of EnergieGame.
	 */      
	public final String role;
	
	private int energy;
	
	// PRE: name != null
	// PRE: role != null and role must be a valid Role class 
	public Player(String name, String role) {
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
