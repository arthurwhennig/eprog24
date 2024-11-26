import java.util.ArrayList;

public class Game {
	
	public static ArrayList<Human> queue;
	
	private Human[] players;
	private int currPlayer;
	
	public Game() {
		this.players = new Human[100];
		this.currPlayer = 0;
		Game.queue = new ArrayList<Human>();
	}
	
	public void jesterTurn(Human jester) {
		jester.resetAction();
	}
	
	public void warriorTurn(Human warrior) {
		Action action = warrior.getAction();
		
		if (action == Action.ATTACK) {
			for (int i = 0; i < players.length; i++) {
				Human otherPlayer = players[i];
				if (otherPlayer == null) break;
				if (otherPlayer == warrior) continue;
				if (Math.abs(otherPlayer.getPosition() - warrior.getPosition()) == 1) { // decrease health
					otherPlayer.damage(10);
				}
			}
			warrior.resetAction();
		} else if (action == Action.SUMMON) {
			if (warrior.getDelay() != 0) return;
			warrior.damage(5);
			warrior.resetAction();
		}
	}
	
	public void clericTurn(Human cleric) {
		Action action = cleric.getAction();
		
		if (action == Action.ATTACK) {
			for (int i = 0; i < players.length; i++) {
				Human otherPlayer = players[i];
				if (otherPlayer == null) break;
				if (otherPlayer == cleric) continue;
				if (Math.abs(otherPlayer.getPosition() - cleric.getPosition()) == 1) { // decrease health
					otherPlayer.damage(3);
				}
			}
			cleric.resetAction();
		} else if (action == Action.SUMMON) {
			if (cleric.getDelay() != 0) return;
			for (int i = 0; i < players.length; i++) {
				Human otherPlayer = players[i];
				if (otherPlayer == null) break;
				if (otherPlayer == cleric || !otherPlayer.isAlive()) continue;
				int diff = Math.abs(otherPlayer.getPosition() - cleric.getPosition());
				if (3 <= diff && diff <= 5) {
					otherPlayer.setPosition(cleric.getPosition());
				}
			}
			cleric.resetAction();
		}
	}
	
	public void decreaseAllDelays() {
		for (int i = 0; i  < players.length; i++) {
			Human player = players[i];
			if (player == null) break;
			player.decrementDelay();
		}
	}
	
	public void resetAllActions() {
		ArrayList<Human> result = new ArrayList<Human>();
		for (Human player : Game.queue) {
			if (player.getAction() == Action.SUMMON && player.getDelay() > 0) {
				result.add(player);
			}
		}
		Game.queue = result;
	}
	
	void advanceTurn() {
		for (Human player : Game.queue) {
			if (player.hasAction() && player.isAlive()) {
				if (player.getType() == PlayerType.JESTER) {
					jesterTurn(player);
				} else if (player.getType() == PlayerType.CLERIC) {
					clericTurn(player);
				} else if (player.getType() == PlayerType.WARRIOR) {
					warriorTurn(player);
				}
			}
		}
		resetAllActions();
		decreaseAllDelays();
	}

	Human createJester(int health, int position) {
		if (health <= 0 || currPlayer >= players.length) return null;
		Human newJester = new Human(PlayerType.JESTER, health, position);
		players[currPlayer++] = newJester;
		return newJester;
	}
	
	Human createWarrior(int health, int position) {
		if (health <= 0 || currPlayer >= players.length) return null;
		Human newWarrior = new Human(PlayerType.WARRIOR, health, position);
		players[currPlayer++] = newWarrior;
		return newWarrior;
	}
	
	Human createCleric(int health, int position) {
		if (health <= 0 || currPlayer >= players.length) return null;
		Human newCleric = new Human(PlayerType.CLERIC, health, position);
		players[currPlayer++] = newCleric;
		return newCleric;
	}
	
	
}
