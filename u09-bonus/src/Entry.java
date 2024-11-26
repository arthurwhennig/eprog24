
public class Entry {
	
	int fileID;
	char userID;
	boolean readOnly;
	int position;
	
	public Entry(int fileID, char userID, boolean readOnly, int position) {
		this.fileID = fileID;
		this.userID = userID;
		this.readOnly = readOnly;
		this.position = position;
	}

}
