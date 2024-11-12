
public class Tarif {
	private int[] intervals;
	private int[] prices;
	private int curr; 
	
	public Tarif(int size) {
		this.intervals = new int[size];
		this.prices = new int[size];
		this.curr = 0;
	}
	
	public void addRule(int interval, int price) {
		this.intervals[curr] = interval;
		this.prices[curr] = price;
		curr++;
	}
	
	public int getPrice(int consumption) {
		int total = 0;
		for (int i = 0; i < intervals.length; i++) {
			int rest = consumption - intervals[i];
			if (rest < 0) break;
			total += prices[i] * intervals[i];
			consumption = rest;
		}
		return total;
	}
}
