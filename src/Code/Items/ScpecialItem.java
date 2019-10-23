package Code.Items;

import Code.Creatures.Players;

public class ScpecialItem implements Items{
	private String tag;
	
	/*
	 * Class that represent the special item in this game, implement the Items Interface, plus his own field and method.
	 */
	public ScpecialItem() {
		tag = "special Item";
	}
	
	/*
	 * Method that returns the tag of the special item.
	 */
	public String getTag() {
		return tag;
	}

	/*
	 * Methods that simulates the use of a special Item.
	 */
	public void power(Players player) {
		System.out.println("Congratulation you found the special Item, now your quest it's over!");
	}
}
