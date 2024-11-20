public class GameApp {
	public static void main(String[] args) {
		Game game = new Game(5);
		game.addPlayer(new Player("Valja", Role.HONEST));
		game.addPlayer(new Player("Vania", Role.SOCERER));
		game.addPlayer(new Player("Noah", Role.TRICKSTER));
		
		System.out.println(game);
		game.energizeAll();
		System.out.println(game);
		game.energizeAll();
		System.out.println(game);
	}
}
