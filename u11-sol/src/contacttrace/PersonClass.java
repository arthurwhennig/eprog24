package contacttrace;
import java.util.ArrayList;
import java.util.List;

public class PersonClass implements Person {
	public List<Integer> usedIDs;
	public List<Integer> seenIDs;
	public NotificationType typ;
	public boolean positive;
	public int age;
	public ContactTracer c;
	
	
	public PersonClass(int age,ContactTracer c) {
		usedIDs=new ArrayList<>();
		seenIDs=new ArrayList<>();
		typ=NotificationType.NoNotification;
		positive=false;
		this.age=age;
		this.c=c;
	}
	

	@Override
	public List<Integer> getUsedIds() {
		return usedIDs;
	}

	@Override
	public List<Integer> getSeenIds() {
		return seenIDs;
	}

	@Override
	public Person.NotificationType getNotification() {
		return typ;
	}

	@Override
	public void setTestsPositively() {
		positive=true;
		typ=NotificationType.NoNotification;
		c.positivPerson(this);
	}
	
	public void direktKontakt() {
		typ=NotificationType.HighRiskNotification;
	}
	
	public void indirektKontakt() {
		if (age>60) {
			if (typ!=NotificationType.HighRiskNotification) {
				typ=NotificationType.LowRiskNotification;
			}
		}
	}
	
	
	
}
