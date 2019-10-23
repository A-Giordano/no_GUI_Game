package Code.Areas;

import Code.Creatures.Players;

public class Desert extends Areas {
	boolean sandstorm;
	
	/*
	 * Class that represent a desert, inherits all the field from the parent class Areas, plus has his sandstorm field and a different checkEquipement method. 
	 */
	public Desert() {
		super.setTag("Desert");	// initialize the area name with parent set method
		super.setEquipmentNeeded("googles");
		isSandStorm();

	}
	/*
	 * Method that randomly decide whether there is a storm in the Desert.
	 */
	public void isSandStorm() {
		if (super.getRandGen().nextBoolean() == true) {
			sandstorm = true;
			super.setAreaDescription("You are trying to enter into a desert, there is a sandstorm at the moment, hence you need googles to proceed.");
		}
		else {
			sandstorm = false;
			super.setAreaDescription("You are lucky, the weather is sunny right now.");
		}
	}

	
	/*
	 * Method that checks if the player has the needed equipment
	 */
	public boolean checkEquipment(Players player) {
		if (sandstorm == true) {
			
			return super.checkEquipment(player);
		}
		else {
			return true;
		}
	}
}
