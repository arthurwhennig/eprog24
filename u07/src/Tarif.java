
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
		if (intervals.length < 1) return -1;
		int total = 0;
		
		for (int i = 0; i < intervals.length-1; i++) {
			if (consumption >= intervals[i]) {
				total += (intervals[i] * prices[i]);
				consumption -= intervals[i];
			} else {
				total += (consumption * prices[i]);
				consumption = 0;
			}
		}
		total += (consumption * prices[intervals.length-1]);
		
		return total;
	}
}
