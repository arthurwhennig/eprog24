
public class Zeitspanne {
	private int hours;
	private int minutes;
	
	private int MIN_MINUTES = 0;
	private int MAX_MINUTES = 59;
	
	public Zeitspanne(int hours, int minutes) {
		this.hours = hours + minutes / 60;
		this.minutes = minutes % 60;
	}
	
	
	
	public int getHours() {
		return this.hours;
	}
	
	public void setHours(int hours) {
		if (hours <= 0) this.hours = 0;
		else this.hours = hours;
	}
	
	public int getMinutes() {
		return this.minutes;
	}
	
	public void setMinutes(int minutes) {
		if (minutes <= 0) this.minutes = this.MIN_MINUTES;
		else if (minutes >= 59) this.minutes = this.MAX_MINUTES;
		else this.minutes = minutes;
	}
	
	public String toString() {
		return "Zeitspanne: " + this.hours + " Stunden und " + this.minutes + " Minuten.";
	}
	
	public void setTime(int hours, int minutes) {
		if (hours <= 0 || minutes <= 0) {
			this.hours = 0;
			this.minutes = 0;
		} else {
			this.hours = hours;
			this.minutes = minutes;
		}
	}
	
	public void addTime(int hours, int minutes) {
		if (hours < 0 || minutes < 0) return;
		int total = hours * 60 + minutes + this.hours * 60 + this.minutes;
		this.hours = total / 60;
		this.minutes = total % 60;
	}
	
	public void subtractTime(int hours, int minutes) {
		if (hours < 0 || minutes < 0) return;
		int total = this.hours * 60 + this.minutes - hours * 60 - minutes;
		if (total <= 0) {
			this.hours = 0;
			this.minutes = 0;
		} else {
			this.hours = total / 60;
			this.minutes = total % 60;
		}
	}

	public void round() {
		if (this.minutes >= 30) this.hours += 1;
		else if (this.hours >= 1) this.hours -= 1;
		else this.hours = 0;
		this.minutes = 0;
	}
	
	public boolean isMoreThan(Zeitspanne other) {
		if (this.hours == other.hours) return this.minutes > other.minutes;
		return this.hours > other.hours;
	}
}
