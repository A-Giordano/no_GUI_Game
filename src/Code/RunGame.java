package Code;

import Code.Creatures.Players;
import Code.Items.EnergyDrinks;
import Code.Items.Helmets;
import Code.Puzzles;


public class RunGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Maps m = new Maps();
		Players p1 = new Players();
		UserInputs uI = new UserInputs();
		p1.setTag(uI.askPlayerName(p1));
		
		m.addCreatureXY(p1, 2, 2);
		m.addSpecialItem(0, 0);
		p1.addSpecificEquipmentSet(uI.askEquipement(p1));
		System.out.println(p1.getEquipmentSet());
		System.out.println(p1.getEquipmentSet().size());
		System.out.println(p1.getRandomEqSet());

		m.printMap();
		while (p1.isAlive() && p1.winGame() == false) {
			m.setAreaByEqNeeded(p1, p1.getRandomEqSet());		// use  getnextEqSet() for simulation always right
			m.printMap();	
			p1.printCoordinate();
			m.movePlayer(p1, uI.directionChoice());
		}

	}
	
	

}
