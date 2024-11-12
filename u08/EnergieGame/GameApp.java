public class GameApp {
	public static void main(String[] args) {
		Game game = new Game(5);
		game.addPlayer(new Player("Valja", "HONEST"));
		game.addPlayer(new Player("Vania", "SOCERER"));
		game.addPlayer(new Player("Noah", "TRICKSTER"));
		
		System.out.println(game);
		game.energizeAll();
		System.out.println(game);
		game.energizeAll();
		System.out.println(game);
	}
}
