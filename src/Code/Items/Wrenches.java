package Code.Items;

import Code.Creatures.Players;

public class Wrenches implements Items{
	private String tag;
	
	/*
	 * Class that represent a wrench in this game, implement the Items Interface, plus his own field and method.
	 */
	public Wrenches() {
		tag = "wrench";
	}
	
	/*
	 * Method that returns the tag of the wrench.
	 */
	public String getTag() {
		return tag;
	}

	/*
	 * Methods that simulates the use of a wrench.
	 */
	public void power(Players player) {
		player.setHp(player.getHp() - 5);
		player.setMaxAttack(11);
		player.setMinAttack(6);
		System.out.println("You attacked using the wrench, but hitting him you hurt your wrist and lost your wrench.");
		System.out.println(player.getTag() + "Hp reduced to: " + player.getHp());	
	}
}
