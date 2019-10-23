package Code.Creatures;

public class Fighters extends Creatures {
	private int hp;
	private int minAttack;
	private int maxAttack;
	
	/*
	 * Class that represent the fight creatures in this game, inherits fields and methods from Character class.
	 */
	public Fighters() {			
	}
	
	/*
	 * Method that returns the hp of the fighter.
	 */
	public int getHp() {
		return hp;
	}
	
	/*
	 * Method that sets the hp of the fighter.
	 */
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	/*
	 * Method that returns the minimum attack of the fighter.
	 */
	public int getMinAttack() {
		return minAttack;
	}
	
	/*
	 * Method that sets the minimum attack of the fighter.
	 */
	public void setMinAttack(int minAttack) {
		this.minAttack = minAttack;
	}
	
	/*
	 * Method that returns the max attack of the fighter.
	 */
	public int getMaxAttack() {
		return maxAttack;
	}
	
	/*
	 * Method that sets the max attack of the fighter.
	 */
	public void setMaxAttack(int maxAttack) {
		this.maxAttack = maxAttack;
	}


	/*
	 * Method that simulate the attack to another fighter.
	 */
	public void attack(Fighters opponent) {
		int damage = (super.getRandGen().nextInt(maxAttack - minAttack) + minAttack) * 5;
		opponent.setHp(opponent.getHp() - damage);	
		if (opponent.getHp() < 0) {
			opponent.setHp(0);
		}
		if (damage == 0) {
			System.out.println(this.getTag() + " attack, but " + opponent.getTag() + " avoid the attck");
		}
		else {
		System.out.println(super.getTag() + " attack, the damage is: " + damage + " - " + opponent.getTag() + " Hp decreased to: " + opponent.getHp());
		}
	}
	
	public void printFields(Fighters fighter) {
		System.out.println(super.getTag() + " Hp: " + hp + " minAttack: " + minAttack*5 + " maxAttack: " + maxAttack*5);
	}

}
