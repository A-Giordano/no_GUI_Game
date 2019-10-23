package Code.Areas;

public class Mountain extends Areas {
	
	/*
	 * Class that represent a mountain, inherits all the field from the parent class Areas.
	 */
	public Mountain() {
		super.setTag("Mountain");	// initialize the area name with parent set method
		super.setEquipmentNeeded("suspensions"); 
		super.setAreaDescription("You are trying to enter into a mountain rocky section, you would need some good suspencions to get trough it.");
	}
	


}
