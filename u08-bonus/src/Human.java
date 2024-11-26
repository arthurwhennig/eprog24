public class Human {
	
	public int health, position;
	private PlayerType type;
	
	private Action action = Action.NONE;
	private int delaySummon = 0;
	
	
	public Human(PlayerType type, int health, int position) {
		this.health = health;
		this.position = position;
		this.type = type;
	}
	
	public boolean hasAction() {
		return this.action != Action.NONE;
	}
	
	public void resetAction() {
		this.action = Action.NONE;
	}
	
	public Action getAction() {
		return this.action;
	}
	
	public void decrementDelay() {
		if (this.delaySummon > 0) this.delaySummon--;
	}
	
	public int getDelay() {
		return this.delaySummon;
	}
	
	public PlayerType getType() {
		return this.type;
	}
	
	
	public int getHealth() {
		return health;
	}
	
	public void damage(int damage) {
		if (this.health - damage <= 0) this.health = 0;
		else this.health = this.health - damage;
	}
	
	public int getPosition() {
		return position;
	}
	
	public void setPosition(int newPosition) {
		if (newPosition < 0 || newPosition >= 1000) return;
		this.position = newPosition;
	}
	
	public boolean isAlive() {
		return health > 0;
	}
	
	public boolean scheduleAction(Action action) {
		if (!this.isAlive() || this.action != Action.NONE) return false;
		this.action = action;
		if (action == Action.SUMMON && this.type == PlayerType.CLERIC) {
			this.delaySummon = 2;
		} else if (action == Action.SUMMON && this.type == PlayerType.WARRIOR) {
			this.delaySummon = 1;
		} else {
			this.delaySummon = 0;
		}
		return Game.queue.add(this);
	}
	
	
}
