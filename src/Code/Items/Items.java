package Code.Items;

import Code.Creatures.Players;

public interface Items {
	
	/*
	 * Method that returns the tag of the item.
	 */
	public String getTag();
	
	/*
	 * Methods that simulates  the use of an item.
	 */
	public void power(Players player);
	

}
