package Code.Items;

import Code.Creatures.Players;

public class Helmets implements Items{
	private String tag;
	
	/*
	 * Class that represent a helmet in this game, implement the Items Interface, plus his own field and method.
	 */
	public Helmets() {
		tag = "helmet";
	}
	
	/*
	 * Method that returns the tag of the helmet.
	 */
	public String getTag() {
		return tag;
	}

	/*
	 * Methods that simulates the use of a helmet.
	 */
	public void power(Players player) {
		System.out.println("You wear your helmet, it protect you from the attack, but now it is too damaged to be use it again.");
	}



}
