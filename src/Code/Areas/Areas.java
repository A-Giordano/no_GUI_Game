package Code.Areas;

import java.util.Random;

import Code.Creatures.Creatures;
import Code.Creatures.FightCreatures;
import Code.Creatures.GameCreatures;
import Code.Creatures.Players;
import Code.Creatures.PuzzleCreatures;
import Code.Items.EnergyDrinks;
import Code.Items.Helmets;
import Code.Items.Items;
import Code.Items.ScpecialItem;
import Code.Items.Wrenches;


public class Areas {
	private Random randGen;
	private String tag;
	private Items item;
	private Creatures creature;
	private String equipmentNeeded;
	private String areaDescription;
	
	/*
	 * Class that represent an area, containing fields and methods of it.
	 */
	public Areas() {
		randGen = new Random();		// used to add the randomCreature
		setItem();
		addRandomCreature();	
	}
	

	/*
	 * Method that returns the item stored in this area.
	 */
	public Items getItem() {
		return item;
	}



	/*
	 * Method that creates a new SpecialItems and set it as item to the Areas .
	 */
	public void setSpecialItem() {
		item = new ScpecialItem();
	}
	
	/*
	 * Method that randomly selects as Item and set it as item to the Areas .
	 */
	public void setItem() {
		switch(randGen.nextInt(4)) {
		case 0: item = null; break;
		case 1:item = new EnergyDrinks(); break;
		case 2:item = new Helmets(); break;
		case 3:item = new Wrenches() ; break;

		}
	}
	
	/*
	 * Method that returns the tag of the item or none if the field is empty.
	 */
	public String getItemTag() {
		if(item != null) {
			return item.getTag();
		}
		else {
			return "none";
		}
	}
	/*
	 * Method that returns the description of the area.
	 */
	public String getAreaDescription() {
		return areaDescription;
	}
	/*
	 * Method that sets the description of the area.
	 */
	public void setAreaDescription(String areaDescription) {
		this.areaDescription = areaDescription;
	}
	/*
	 * Method that returns the random generator.
	 */
	public Random getRandGen() {
		return randGen;
	}

	/*
	 * Method that returns the area's tag.
	 */
	public String getTag() {
		return tag;
	}
	/*
	 * Method that sets the area's tag.
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}	
	
	public String getCreatureTag() {
		return creature.getTag();
	}
	
	/*
	 * Method that returns the area's creature.
	 */
	public Creatures getCreature() {
		return creature;
	}
	
	/*
	 * Method that returns the equipment needed to enter in the area.
	 */
	public String getEquipmentNeeded() {
		return equipmentNeeded;
	}
	
	/*
	 * Method that sets the equipment needed to enter in the area.
	 */
	public void setEquipmentNeeded(String equipmentNeeded) {
		this.equipmentNeeded = equipmentNeeded;
	}
	
	/*
	 * Method that sets a specific creature into the area.
	 */
	public void setCreature(Creatures creature) {
		this.creature = creature;
	}
	
	/*
	 * Method that randomly adds a FightCreature, a PuzzleCreature or a GameCreature into the area. 
	 */
	public void addRandomCreature() {
		int chooser = randGen.nextInt(3);
		switch (chooser) {
		case 0: creature = new GameCreatures(); break;
		case 1: creature = new PuzzleCreatures(); break;
		case 2: creature = new FightCreatures(); break;
		default: break;
		}	
	}
	
	/*
	 * Method that checks if the player has the equipment needed to enter into the area.
	 */
	public boolean checkEquipment(Players player) {
		if (player.haveEquipment(equipmentNeeded)) {
			System.out.println("Luckly you are well furnished, so you can proceed.");
			return true;
		}
		else {
			System.out.println("Get some new " + equipmentNeeded + " to be able to proceed in this " + tag);
		}
		return false;
	}
	
	/*
	 * Method that adds the area item to the player.
	 */
	public void addItemToPlayer(Players player) {
		if (item != null) {
			player.addItem(item);
			System.out.println(player.getTag() + " has just obtained " + getItemTag() + ".");
			item = null;
		}
		
	}
	
	/*
	 * Method that prints the description of the area the area.
	 */
	public void printAreaDescription() {
		System.out.println(areaDescription);
	}


	


	



	

}
