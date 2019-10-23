package Code.Items;

import Code.Creatures.Players;

public class EnergyDrinks implements Items {
	private String tag;
	
	/*
	 * Class that represent a energy drink in this game, implement the Items Interface, plus his own field and method.
	 */
	public EnergyDrinks() {
		tag = "energy drink";	
	}
	
	/*
	 * Method that returns the tag of the energy drink.
	 */
	public String getTag() {
		return tag;
	}

	/*
	 * Methods that simulates the use of a Energy Drink.
	 */
	public void power(Players player) {
		player.setHp(100); 					// create and use maxHP?
		System.out.println("You restored your Hp to: " + player.getHp());
	}

}
