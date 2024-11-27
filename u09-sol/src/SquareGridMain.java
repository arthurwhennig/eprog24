public class SquareGridMain {

    public static void main(String[] args) {
        // Sie koennen die main-Methode beliebig aendern.
        Node n00 = new Node();
        Node n10 = new Node();
        Node n01 = new Node();

        n00.setDown(n10);
        n00.setRight(n01);

        System.out.println("analyzeSquareGrid Resultat (erwartet: 1) " + SquareGrid.analyzeSquareGrid(n00));

        Node n11 = new Node();
        n01.setDown(n11);
        n10.setRight(new Node());

        System.out.println("analyzeSquareGrid Resultat (erwartet: 1): " + SquareGrid.analyzeSquareGrid(n00));

        n10.setRight(n11);

        System.out.println("analyzeSquareGrid Resultat (erwartet: 2): " + SquareGrid.analyzeSquareGrid(n00));
    }
}
