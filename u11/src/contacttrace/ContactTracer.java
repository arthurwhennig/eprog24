package contacttrace;

import java.util.List;
import java.util.ArrayList;

public class ContactTracer {
	/**
	 * Erstellt eine neue Person im Kontext dieses Contact Tracers.
	 *
	 * Alle Person-Objekte, die von dieser Methode erstellt werden, sollen
	 * sich gegenseitig begegnen und benachrichtigen können.
	 */
	private int currID = 0;
	private ArrayList<Contact> contacts = new ArrayList<Contact>();
	
	public Person createPerson(int age) {
		Contact p = new Contact(this, age);
		contacts.add(p);
		return p;
	}
	
	public int getNewID() {
		return ++currID;
	}
	
	public ArrayList<Contact> getContacts() {
		return contacts;
	}

	/**
	 * Protokolliert eine (beidseitige) Begegnung von p1 und p2.
	 */
	public void registerEncounter(Person p1, Person p2) {
		List<Integer> seen1 = p1.getSeenIds();
		List<Integer> used1 = p1.getUsedIds();	
		List<Integer> seen2 = p2.getSeenIds();
		List<Integer> used2 = p2.getUsedIds();	
		
		int newID1 = getNewID();
		int newID2 = getNewID();
		
		seen1.add(newID2);
		used1.add(newID1);
		seen2.add(newID1);
		used2.add(newID2);
	}
}