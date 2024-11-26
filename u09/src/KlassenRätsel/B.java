package KlassenRätsel;
import java.io.PrintStream;

// Ausser der "extends" Klausel, veraendern Sie diese Datei nicht!

public class B extends A {

	B() {}

	B(int w) {
		super(w);
	}

	public void bar(PrintStream output) {
		super.bar(output);
		output.println("Bingo");
	}
}
