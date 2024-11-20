import java.util.Arrays;
import java.util.Random;

public class Game {
	private Random random;
	private Player[] players;
	private int playerCount;
	
	// PRE: maxPlayers >= 0
	public Game(int maxPlayers) {
		random = new Random();
		players = new Player[maxPlayers];
		playerCount = 0;
	}
	
	// PRE: player != null
	public void addPlayer(Player player) {
		if (playerCount < players.length ) {
			players[playerCount] = player;
			playerCount++;
		}
	}
	
	public void energizeAll() {
		for (int i = 0; i < playerCount; i++) {
			Player player = players[i];
			
			//change to Enum Role
			if (player.role == Role.HONEST) {
				player.changeEnergyBy(1);
			} else if (player.role == Role.TRICKSTER) {
				player.changeEnergyBy(random.nextInt(-4, 5));
			} else if (player.role == Role.SOCERER) {
				player.changeEnergyBy(random.nextInt(0, 3));
			} else {
				// This should never happen!
			}
		}
	}
	
	public String toString() {
		return Arrays.toString(players); // Not nice (includes unused slots), but OK
	}
}
