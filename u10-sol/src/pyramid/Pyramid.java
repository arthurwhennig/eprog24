package pyramid;

import java.util.ArrayList;

public class Pyramid {
	
	public static boolean isPyramid(Node node) {
		// Falls node == null, soll gemaess Aufgabenstellung eine Exception geworfen werden.
		if(node == null) { 
			throw new IllegalArgumentException();
		}
		ArrayList<Node> nodes = new ArrayList<Node>(); // Liste zum Sammeln der Nodes in der Pyramide
		nodes.add(node); // Zu beginn haben wir nur Node
		
		int k=1; // Anzahl gefundene Stufen - zu Beginn 1, da wir node bereits kennen
		boolean finalLayer = false; // Sobald wir null antreffen, sind wir in der letzten Stufe
		
		// Der Loop prüft Stufe für Stufe die Nodes und fügt sie zur Liste nodes hinzu
		for(int i=0; i<nodes.size(); ++i) {
			Node curr = nodes.get(i); // Den zu betrachtenden Node
			if (curr.getLeft() == null && curr.getRight() == null) {
				// Falls beide null sind, dann sind wir in der letzten Stufe
				finalLayer = true;
				
				// Falls die Stufe aber bereits angefangen wurde, dann ist es keine Pyramide (Bedingung 1)
				if (nodes.size() != k*(k+1)/2) {
					return false;
				}
			} else if (finalLayer || curr.getLeft() == null || curr.getRight() == null) {
				// Wir sind in der letzten Stufe und nicht beide sind null
				// oder nur einer der beiden ist null
				// => Keine Pyramide
				return false;
			} else {
				Node left = curr.getLeft();
				Node right = curr.getRight();
				
				if(nodes.size() == k*(k+1)/2) { // curr ist der erste Node der Stufe
					
					k++; // Wir sind also in der nächsten Stufe
					
					if(nodes.contains(left)) { // left ist bereits in der Liste (Bedingung 3) => keine Pyramide
						return false;
					}
					
					nodes.add(left); // left wird in die Liste gespeichert
					
				} else { // curr ist nicht der erste Node einer Stufe
					
					if(nodes.getLast() != left) { // Bedingung 2 ist nicht erfüllt => keine Pyramide
						return false;
					}
					
				}
				
				if (nodes.contains(right)) { // right ist bereits in der Liste (Bedingung 1/3 ) => keine Pyramide
					return false;
				}
				
				nodes.add(right); // right wird in die Liste gespeichert
				
				
			}
		}
		
		// Falls nichts fehlgeschlagen hat, dann ist es eine Pyramide
		return true;
	}

	public static void main(String[] args) {
		Node pyramid = new Node(
			new Node(null, null),
			new Node(null, null));
        System.out.println("result: " + isPyramid(pyramid));
	}

}
