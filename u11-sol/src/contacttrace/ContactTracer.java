package contacttrace;
import java.util.ArrayList;
import java.util.List;


public class ContactTracer {
	public int currentID;
	public List<Person> personen;
	/**
	 * Erstellt eine neue Person im Kontext dieses Contact Tracers.
	 *
	 * Alle Person Objekte, die von dieser Methode erstellt werden, sollen 
	 * sich gegenseitig begegnen und benachrichtigen können.
	 */
	public Person createPerson(int age) {
		Person p=new PersonClass(age,this);
		if (personen==null) {
			personen=new ArrayList<>();
		}
		personen.add(p);
		return p;
	}

	/**
	 * Protokolliert eine (beidseitige) Begegnung von p1 und p2.
	 */
	public void registerEncounter(Person p1, Person p2) {
		((PersonClass) p1).usedIDs.add(currentID);
		((PersonClass) p2).seenIDs.add(currentID);
		currentID++;
		((PersonClass) p2).usedIDs.add(currentID);
		((PersonClass) p1).seenIDs.add(currentID);
		currentID++;
	}
	
	public void positivPerson(Person p) {	//wenn person p positiv ist
		for (Integer usedids:p.getUsedIds()) {	//für jede genutze ID
			for (Person a:personen) {	//für jede mögliche Person: direkten Kontakt prüfen
				if(a.getSeenIds().contains(usedids)) {	//wenn diese person getroffen
					if (!((PersonClass)a).positive) {	//wenn nicht eh schon positiv
						((PersonClass)a).direktKontakt();
						//indirekten kontakt
						for (Integer usdID:a.getUsedIds()) {
							for (Person b:personen) {
								if(b.getSeenIds().contains(usdID)) {	//wenn diese person getroffen
									if (!((PersonClass)b).positive) {	//wenn nicht eh schon positiv
										((PersonClass)b).indirektKontakt();
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
}