public class User {
	private int id;
	private int[] consumption = new int[4];
	private int currQuartal;
	private Tarif tarif;
	
	public User(int id, Tarif tarif) {
		this.id = id;
		this.tarif = tarif;
	}
	
	public void addConsumption(int quartal) {
		if (currQuartal > 3) return;
		consumption[currQuartal++] = quartal;
	}
	
	public int getTotalConsumption() {
		int sum = 0;
		for (int i = 0; i < consumption.length; i++) sum += consumption[i];
		return sum;
	}
	
	public int calculateBill() {
		int total = getTotalConsumption();
		int rappen = tarif.getPrice(total);
		return (int) Math.round((double) rappen/100);
	}
	
	public String getBill() {
		return this.id + " " + calculateBill();
	}
}
