package contacttrace;

import java.util.List;
import java.util.ArrayList;

public class Contact implements Person {
	private ContactTracer tracer;
	private int age;
	private ArrayList<Integer> usedIds;
	private ArrayList<Integer> seenIds;
	private boolean isDirectContact;
	private boolean isIndirectContact;
	private boolean isPositive;
	
	public Contact(ContactTracer tracer, int age) {
		this.tracer = tracer;
		this.age = age;
		this.usedIds = new ArrayList<Integer>();
		this.seenIds = new ArrayList<Integer>();
	}
	
	@Override
	public List<Integer> getUsedIds() {
		return this.usedIds;
	}
	
	public boolean hasEncountered(int id) {
		return seenIds.contains(id);
	}

	@Override
	public List<Integer> getSeenIds() {
		return this.seenIds;
	}

	@Override
	public NotificationType getNotification() {
		if (this.isPositive) return NotificationType.NoNotification;
		if (this.isDirectContact) return NotificationType.HighRiskNotification;
		if (this.isIndirectContact) return (this.age <= 60) ? NotificationType.NoNotification : NotificationType.LowRiskNotification;
		return NotificationType.NoNotification;
		
	}

	@Override
	public void setTestsPositively() {
		ArrayList<Contact> contacts = tracer.getContacts();
		ArrayList<Contact> directs = new ArrayList<Contact>();
		
		this.isPositive = true;
		
		// update all direct contacts
		for (Contact c : contacts) {
			for (int seenId : c.seenIds) {
				if (this.usedIds.contains(seenId) && !c.isPositive) {
					directs.add(c);
					c.isDirectContact = true;
				}
			}
		}
		// update all indirect contacts
		for (Contact d : directs) {
			for (int seenId : d.seenIds) {
				for (Contact c : contacts) {
					if (c.usedIds.contains(seenId) && !c.isPositive) {
						c.isIndirectContact = true;
					}
				}
			}
		}
		
	}

}
