package Code.Areas;

public class Woods extends Areas {
	
	/*
	 * Class that represent a wood, inherits all the field from the parent class Areas.
	 */
	public Woods() {
		super.setTag("Woods");	// initialize the area name with parent set method
		super.setEquipmentNeeded("brakes");
		super.setAreaDescription("You are trying to enter into a woods, you are going to face some gnarly terrain,\nbe sure to have some good beakes or you will slide on some roots.");
		
	}
	


}
