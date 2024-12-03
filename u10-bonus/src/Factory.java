public class Factory {
	/*
	 * Zur Erinnerung: Sie duerfern die Anweisungen der Methode computeCost aendern
	 * aber nicht die Parameterliste oder den Rueckgabewert Wenn es keine public
	 * static Methode mit diesem Namen und Rueckgabewert gibt, erhalten Sie 0 Punkte
	 * Sie duerfen in diese Klasse weitere Methoden hinzufuegen
	 */
	public static Cost computeCost(Part[] steps) {
		
		Cost c = new Cost();
		
		int countFlux = 0;
		boolean luxury = false;
		for (Part p : steps) {
			if (p instanceof Fluxkompensator) countFlux++;
			if (p instanceof Schwebeumwandlung && countFlux != 0 || p instanceof OutatimeKennzeichen && countFlux != 0) return null;
			if (p instanceof FirstEditionFluxkompensator || p instanceof VerchromteRaeder) luxury = true;
			p.process(c);
		}
		if (countFlux > 1) return null;
	
		if (luxury) c.luxuryTax = c.productionCost * 5/100;
		else c.luxuryTax = 0;

		return c;
	}

	public static void main(String[] args) {
		Cost c = Factory.computeCost(new Part[] { 
				new EinklappbareRaeder(), 
				new Fluxkompensator() });
		
		System.out.println("Die Kosten betragen sich auf " + c.productionCost + " (MWst " + c.vat + ", Luxus-Steuer "
				+ c.luxuryTax + ")");
	}
}
