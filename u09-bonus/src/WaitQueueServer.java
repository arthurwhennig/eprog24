import java.util.ArrayList;
import java.util.LinkedList;

public class WaitQueueServer {
	
	public ArrayList<Entry> queue;
	public ArrayList<LinkedList<Entry>> quicklist;
	
	// N is the length of queue array size
	public WaitQueueServer(int N) {
		queue = new ArrayList<Entry>(N);
		for (int i = 0; i < N; i++) queue.add(null);
		quicklist = new ArrayList<>();
	}
    
    // Add a request to the waiting queue: a user wants this file in Read/Write mode
    // Return format: Response(head, tail)
    public Response add(int fileID, char userID, boolean readOnly) {
    	int idx = -1;
    	// find tail
        for (int i = 0; i < queue.size(); i++) {
        	if (queue.get(i) == null) {
        		queue.set(i, new Entry(fileID, userID, readOnly, i));
        		idx = i;
        		break;
        	}
        }
        if (idx == -1) return null; // queue is full
        // add the entry to the linked list
        if (fileID >= quicklist.size()) { // create new linked list
        	LinkedList<Entry> list = new LinkedList<>();
        	list.add(queue.get(idx));
        	quicklist.add(fileID, list);
        	return new Response(idx, idx);
        }
        LinkedList<Entry> list = quicklist.get(fileID);
        list.add(queue.get(idx));
        Entry head = list.getFirst();
        return new Response(head.position, idx);
    }
    
    // Pop queued request(s) on this fileID
    // Return format: {userID, ...}
    public char[] pop(int fileID) {
    	ArrayList<Entry> removed = new ArrayList<>();
    	if (fileID >= quicklist.size()) return null;
    	LinkedList<Entry> list = quicklist.get(fileID);
    	if (list == null) return null;
    	
    	Entry head = list.getFirst();
    	if (!head.readOnly) {
    		// collect the write entries to be removed and update span
    		removed.add(head);
    		list.removeFirst();
    	} else {
    		// collect the read entries to be removed and update span
    		for (int i = 0; i < list.size(); i++) {
    			Entry e = list.get(i);
    			if (e == null) continue;
    			if (e.fileID == fileID && e.readOnly) {
    				removed.add(e);
    				list.remove(e);
    			}
    		}
    	}
    	char[] userIDs = new char[removed.size()];
    	for (int i = 0; i < userIDs.length; i++) {
    		Entry toBeRemoved = removed.get(i);
    		if (toBeRemoved == null) continue;
    		userIDs[i] = toBeRemoved.userID;
    		queue.set(toBeRemoved.position, null);
    	}
    	return userIDs;
    }
    
    // Get a quick reference list on all queued files, and the list is sorted by fileID
    // Return format: {{fileID, head, tail}, {...}, ...}
    public int[][] getQuickList() {
        ArrayList<int[]> output = new ArrayList<int[]>();
        for (int i = 0; i < quicklist.size(); i++) {
        	LinkedList<Entry> list = quicklist.get(i);
        	if (list == null || list.isEmpty()) continue;
        	Entry head = list.getFirst();
        	Entry tail = list.getLast();
        	output.add(new int[] { i, head.position, tail.position });
        }
        int[][] results = new int[output.size()][];
        for (int i = 0; i < results.length; i++) {
        	results[i] = output.get(i);
        }
        return results;
    }
}
