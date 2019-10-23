package Code.Creatures;

import java.util.ArrayList;
import java.util.Arrays;

import Code.Items.EnergyDrinks;
import Code.Items.Helmets;
import Code.Items.Items;

public class Players extends Fighters {
	private int normalMinAttack;
	private int normalMaxAttack;
	private ArrayList<Items> itemsList;
	private ArrayList<String> equipmentSet;
	private ArrayList<String> equipmentNeeded; 

	/*
	 * Class that represent the fight creatures in this game, inherits fields and methods from Fighters and Characters classes, plus his own fields and methods.
	 */
	public Players() {
		normalMinAttack = 0;
		normalMaxAttack = 6;
		super.setHp(100);
		super.setMinAttack(normalMinAttack);
		super.setMaxAttack(normalMaxAttack);
		itemsList = new ArrayList<>();			//Array?????
		equipmentSet = new ArrayList<>();	
		equipmentNeeded = new ArrayList<String>(Arrays.asList("brakes", "googles","suspensions", "tyres"));	

	}
	
	/*
	 * Method that returns the itemsList of the player.
	 */
	public ArrayList<Items> getItemsList() {
		return itemsList;
	}
	
	/*
	 * Method that returns the normal minimum attack of the player.
	 */
	public int getNormalMinAttack() {
		return normalMinAttack;
	}

	/*
	 * Method that returns the normal max attack of the player.
	 */
	public int getNormalMaxAttack() {
		return normalMaxAttack;
	}
	
	/*
	 * Method that returns a random equipment owned by the player.
	 */
	public String getRandomEqSet() {
		return equipmentSet.get(super.getRandGen().nextInt(equipmentSet.size()));
	}
	
	/*
	 * Method that returns the last equipment obtained by the player.
	 */
	public String getnextEqSet() {
		return equipmentSet.get(equipmentSet.size() -1);
	}
	
	/*
	 * Method that returns the list  of equipment needed by the player.
	 */
	public ArrayList<String> getEquipmentNeeded() {
		return equipmentNeeded;
	}
	
	/*
	 * Method that returns the list  of equipment owned by the player.
	 */
	public ArrayList<String> getEquipmentSet() {
		return equipmentSet;
	}
	
	/*
	 * Method that adds an equipment to the player from the equipment still needed.
	 */
	public void addEquipmentSet() {
		if (equipmentNeeded.size() != 0) {
			String newEquipement = equipmentNeeded.get(super.getRandGen().nextInt(equipmentNeeded.size()));
			equipmentSet.add(newEquipement);
			equipmentNeeded.remove(newEquipement);
			System.out.println("Man: Thanks a lot! You can have my spare " + newEquipement + ".");
			System.out.println(newEquipement + " just added to your bag.");
		}
	}
	
	/*
	 * Method that adds a specific equipment to the player from the equipment still needed.
	 */
	public void addSpecificEquipmentSet(String equipment) {
		if (equipmentNeeded.size() != 0) {
			equipmentSet.add(equipment);
			equipmentNeeded.remove(equipment);
		}
	}
		
	
	/*
	 * Method that adds a specific item to the player.
	 */
	public void addItem(Items item) {
		itemsList.add(item);
	}

	/*
	 * Method that checks if the player has a specific equipment.
	 */
	public boolean haveEquipment (String equipment) {
		if (equipmentSet != null) {
		return equipmentSet.contains(equipment);
		}
		else {
			return false;
		}
	}
	
	/*
	 * Method that checks if the player has a specific item.
	 */
	public boolean haveItem (Items item) {
		if (itemsList != null) {
		return itemsList.contains(item);
		}
		else {
			return false;
		}
	}
	
	/*
	 * Method that counts the number of the same items owned by the player.
	 */
	public int countItem(Items item) {
		int counter = 0;
		for(Items items : itemsList) {
			if (items == item) {	
				counter++;
			}	
		}
		return counter;
	}
	/*
	 * Method that allows the player to use an item and if he own it.
	 */
	public void useItem(String itemName) {
		Items itemsFounded = null;
		if (itemsList != null) {	
			for (Items item : itemsList) {
				if (item.getTag().equals(itemName)) {
					itemsFounded = item;
					item.power(this);
					itemsList.remove(item);
					System.out.println(item.getTag() + " remained in your bag: " + countItem(item));
					break;					
				}	
			}
			if (itemsFounded == null) {
				System.out.println("You don't have any " + itemName + " in your bag.");
			}	
		}
		else {
			System.out.println("Your bag is empty");
		}
	}
	
	/*
	 * Method that returns true or false whether the player own or not the special item.
	 */
	public boolean winGame() {
		boolean winGame = false;
		for (Items item : itemsList) {
			if (item.getTag().equals("special Item")){
				winGame = true;
				System.out.println("You have shredded all the trails and become a master of MTB!! You Won this Game!!");
				break;
			}
		}
		return winGame;
	}
	
	/*
	 * Method that returns true or false whether the player is alive.
	 */
	public boolean isAlive() {
		if (getHp() > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
