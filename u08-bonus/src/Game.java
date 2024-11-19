import java.util.ArrayList;

public class Game {
	
	private Human[] players;
	private int currPlayer;
	
	public Game() {
		this.players = new Human[100];
		this.currPlayer = 0;
		Human.actionQueue.clear();
	}
	
	public void warriorTurn(Human warrior) {
		Action action = warrior.getAction();
		
		if (action == Action.ATTACK) {
			for (int i = 0; i < players.length; i++) {
				Human otherPlayer = players[i];
				if (otherPlayer == null) break;
				if (otherPlayer == warrior) continue;
				if (Math.abs(otherPlayer.getPosition() - warrior.getPosition()) <= 1) { // decrease health
					otherPlayer.damage(10);
				}
			}
		} else if (action == Action.SUMMON) {
			if (warrior.getDelay() != 0) return;
			warrior.damage(5);
		}
	}
	
	public void clericTurn(Human cleric) {
		Action action = cleric.getAction();
		
		if (action == Action.ATTACK) {
			for (int i = 0; i < players.length; i++) {
				Human otherPlayer = players[i];
				if (otherPlayer == null) break;
				if (otherPlayer == cleric) continue;
				if (Math.abs(otherPlayer.getPosition() - cleric.getPosition()) <= 1) { // decrease health
					otherPlayer.damage(3);
				}
			}
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
		for (Human player : Human.actionQueue) {
			if (player.getAction() != Action.ATTACK && player.getDelay() > 0) {
				result.add(player);
			} else {
				player.resetAction();
			}
		}
		Human.actionQueue = result;
	}
	
	void advanceTurn() {
		for (Human player : Human.actionQueue) {
			if (player.hasAction() && player.isAlive()) {
				Action action = player.getAction();
				if (player.getType() == PlayerType.JESTER) continue;
				if (player.getType() == PlayerType.CLERIC) {
					clericTurn(player);
				}
				if (player.getType() == PlayerType.WARRIOR) {
					warriorTurn(player);
				}
			}
		}
		decreaseAllDelays();
		resetAllActions();
		
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
