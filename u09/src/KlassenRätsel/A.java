package KlassenRätsel;
import java.io.PrintStream;

// Ausser der "extends" Klausel, veraendern Sie diese Datei nicht!

public class A extends Z {

	int a1 = 0;

	A() {}

	A(int v) {
		a1 = v;
	}

	public void foo(PrintStream output) {
		output.println("Found");
	}
}
