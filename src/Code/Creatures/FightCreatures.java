package Code.Creatures;

import java.util.Scanner;

import Code.UserInputs;
import Code.Items.EnergyDrinks;
import Code.Items.Helmets;
import Code.Items.Items;

public class FightCreatures extends Fighters implements Opponents {
	private boolean challengeAccepted;
	private boolean escape;
	private boolean isDefeated;
	
	/*
	 * Class that represent the fight creatures in this game, inherits fields and methods from Fighters and Characters classes and implement the Opponents Interface, plus his own fields and methods.
	 */
	public FightCreatures() {
		super.setHp((super.getRandGen().nextInt(5)+2)*10);
		super.setMinAttack(0);
		super.setMaxAttack(super.getRandGen().nextInt(5)+1);
		super.setTag("FightCreature");
		challengeAccepted = false;  	
		escape = false;
		isDefeated = false;

		
		
	}
	
	/*
	 * Method that returns if the player escape from the challenge.
	 */
	public boolean getEscape() {
		return escape;
	}

	/*
	 * Method that returns if the player has accepted the challenge.
	 */
	public boolean isChallengeAccepted() {
		return challengeAccepted;
	}
	
	/*
	 * Method that prints the opponent introduction.
	 */
	public void opponentIntroduction() {
		System.out.println("You see a man suspiciously walking towards you, shouting: Give me your bike or you will have troubles!");
	}
	
	/*
	 * Methods that asks to the player if he want to accept the challenge.
	 */
	public void challengeProposal (Players player, int choice) {	
		if (choice == 1) {
			System.out.println("Thief: Get ready to be beat up!");
			challengeAccepted = true;
		}
		else {
			System.out.println("You leave and went back to the previous area");
		}
	}
	

	/*
	 * Method that simulates a round of a fight between a fight creature and the player.
	 */
	public void fightChallenge(Players player, int choice) {
		switch(choice) {
			case 1:{
				player.attack(this);
				attack(player);
				break;
			}
			case 2: player.useItem("helmet"); break;							
			case 3: player.useItem("energy drink"); break;	
			case 4:{
				player.useItem("wrench");
				player.attack(this);
				player.setMaxAttack(player.getNormalMaxAttack());
				player.setMinAttack(player.getNormalMinAttack());

				break;	
			}
			case 5:{
				escape = true; 
				System.out.println("You esceped from your opponent and went back to the previous area.");
				break;
			}
		}
	}
		
	
	/*
	 * Method that simulates the fight between a fight creature and the player.
	 */
	public void challenge(Players player) {
		
		while (this.getHp() > 0 && player.getHp() > 0 && escape == false) {
			fightChallenge(player, super.getuI().challengeChoice(this));		
		}
		if (this.getHp()<1) {
			isDefeated = true;
		}
		
	}

	/*
	 * Method that returns true or false weather the fight creature has bees defeated.
	 */
	public boolean getIsDefeated () {
		if (isDefeated == true)
		System.out.println("Congratulation! You defeated the thief and save your bike, now you can proceed.");
		else {
			if (escape == true) {
				System.out.println("You esceped from your opponent and went back to the previous area.");
				escape = false;
			}
			else {
				System.out.println("The thief stole your bike and you are too tired to continue.");
			}
		}
		return isDefeated;
	}


}

