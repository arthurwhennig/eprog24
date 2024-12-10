
public class Record {
	public boolean busVisited;
	public boolean tramVisited;
	public boolean trainVisited;
	public int timeDist;
	
	public Record() {
		this.busVisited = false;
		this.tramVisited = false;
		this.trainVisited = false;
		this.timeDist = Integer.MAX_VALUE/2;
	}
	
	public boolean visited() {
		return busVisited || tramVisited || trainVisited;
	}
}
