public class WaitQueueServer {
	// N is the length of queue array size
	public WaitQueueServer(int N) {
		// TODO: Implement your wait queue array
		
	}
    
    // Add a request to the waiting queue: a user wants this file in Read/Write mode
    // Return format: Response(head, tail)
    public Response add(int fileID, char userID, boolean readOnly) {
        // TODO: 

        return new Response(-1,-1);
    }
    
    // Pop queued request(s) on this fileID
    // Return format: {userID, ...}
    public char[] pop(int fileID) {
        // TODO: 

        return new char[0];
    }
    
    // Get a quick reference list on all queued files, and the list is sorted by fileID
    // Return format: {{fileID, head, tail}, {...}, ...}
    public int[][] getQuickList() {
        // TODO: 

        return new int[0][];
    }
}
