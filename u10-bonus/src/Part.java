public class Part {

	public void process(Cost c) {
		// Ein generischer Part hat keine process() Semantik
	}

}

class Fluegeltueren extends Part {
	@Override
	public void process(Cost c) {
		int previousCost = c.productionCost;
		c.productionCost = previousCost + 2000;
		c.vat = c.vat + (c.productionCost - previousCost) * 3 / 100;
	}
}

class Fluxkompensator extends Part {
	@Override
	public void process(Cost c) {
		int previousCost = c.productionCost;
		c.productionCost = (200 * previousCost) / 100;
		c.vat = c.vat + (c.productionCost - previousCost) * 7 / 100;
	}
}

class Schwebeumwandlung extends Part {
	@Override
	public void process(Cost c) {
		int previousCost = c.productionCost;
		c.productionCost = (120 * previousCost) / 100;
		c.vat = c.vat + (c.productionCost - previousCost) * 10 / 100;
	}
}

class EinklappbareRaeder extends Part {
	@Override
	public void process(Cost c) {
		int previousCost = c.productionCost;
		if (previousCost + 7000 < 100000)
			c.productionCost = previousCost + 7000;
		else
			c.productionCost = 100000;
		c.vat = c.vat + (c.productionCost - previousCost) * 7 / 100;
	}
}

class OutatimeKennzeichen extends Part {
	@Override
	public void process(Cost c) {
		int previousCost = c.productionCost;
		if (previousCost + 100 < 50000)
			c.productionCost = 50000;
		else
			c.productionCost = previousCost + 100;
		c.vat = c.vat + (c.productionCost - previousCost) * 10 / 100;
	}
}

//erst relevant in Teil (b)
class FirstEditionFluxkompensator extends Part {
	@Override
	public void process(Cost c) {
		int previousCost = c.productionCost;
		c.productionCost = (200 * previousCost) / 100;
		c.vat = c.vat + (c.productionCost - previousCost) * 7 / 100;
	}
}

//erst relevant in Teil (b)
class VerchromteRaeder extends Part {
	@Override
	public void process(Cost c) {
		int previousCost = c.productionCost;
		int diff = Math.max(10000 - (previousCost + 7000), 0);
		c.productionCost = previousCost + diff;
		c.vat = c.vat + (c.productionCost - previousCost) * 7 / 100;
	}
}
