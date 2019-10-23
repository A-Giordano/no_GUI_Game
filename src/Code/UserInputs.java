package Code;
import java.util.Scanner;

import Code.Creatures.Creatures;
import Code.Creatures.FightCreatures;
import Code.Creatures.Opponents;
import Code.Creatures.Players;

public class UserInputs {
	private Scanner userInput;
	private Opponents opponent;

	public UserInputs() {
		userInput = new Scanner(System.in);

	}
	
	public Opponents getOpponent() {
		return opponent;
	}

	public void setOpponent(Opponents opponent) {
		this.opponent = opponent;
	}
	
	public String askPlayerName(Players player) {
		System.out.println("Please select Player name:");
		return userInput.nextLine();
	}
	
	public String askEquipement(Players player) {
		System.out.println("Now chose your favourite bike gear between:");
		System.out.println(player.getEquipmentNeeded());
		String choice = userInput.nextLine();
		while (!(choice.equals("brakes"))  && !(choice.equals("suspensions")) && !(choice.equals("googles"))  && !(choice.equals("tyres"))) {
			System.out.println("Please enter a valid input: Press: 1 to fight or 2 to run away");
			choice = userInput.nextLine();
		}
		System.out.println("Those will be really helpfull to proceed.");
		return choice;
	}
	
	/*
	 * Method to ask the player the desired direction
	 * Possible to not use it if we don't want to ask direction input
	 */
	public int directionChoice() {
		System.out.println("Where do you prefer to go? Press 5 for up, 2 for down, 1 for left and 3 for right");
		String choice = userInput.nextLine();
		while (!(choice.equals("1"))  && !(choice.equals("2")) && !(choice.equals("3")) && !(choice.equals("5"))) {
			System.out.println("Please enter a valid input: Press 5 for up, 2 for down, 1 for left and 3 for right");
			choice = userInput.nextLine();
		}
		int intChoice = Integer.parseInt(choice);		
		return intChoice;	}

	public int proposalChoice(Opponents opponent) {
		Creatures creature = (Creatures) opponent; 
		int choice = -1;
		if (creature.getTag().equals("FightCreature")) {
			choice = fightProposalChoice();
		}
		else if (creature.getTag().equals("GameCreature")) {
			choice = gameProposalChoice();
		}
		else if (creature.getTag().equals("PuzzleCreature")) {
			choice = puzzleProposalChoice();
		}
		return choice;
	}
	
	public int challengeChoice(Creatures creature) {
		int choice = -1;
		if (creature.getTag().equals("FightCreature")) {
			choice = fightChoice();
		}
		else if (creature.getTag().equals("GameCreature")) {
			choice = gameChoice();
		}
		else if (creature.getTag().equals("PuzzleCreature")) {
			choice = puzzleChoice();
		}
		return choice;
	}
	
	/*
	 * Method to ask the player if want to accept the challenge
	 * Possible to not use it if we don't want interaction
	 */
	public int fightProposalChoice() {
	
		System.out.println("You can run away in the previous area or fight him to progress, press: 1 to fight or 2 to run away");
		String choice = userInput.nextLine();
		while (!(choice.equals("1"))  && !(choice.equals("2"))) {
			System.out.println("Please enter a valid input: Press: 1 to fight or 2 to run away");
			choice = userInput.nextLine();
		}
		int intChoice = Integer.parseInt(choice);		
		return intChoice;
	}	
	
	/*
	 * Method that simulate the 1st challenge
	 * Possible to not use it if we don't want interaction
	 */
	public int fightChoice() {
		System.out.println("Press 1 to attack or 2 to use your helmet, 3 to have an energy drink, 4 to use the wrench as a weapon and 5 to run away.");
		String choice = userInput.nextLine();
		while (!(choice.equals("1"))  && !(choice.equals("2")) && !(choice.equals("3"))  && !(choice.equals("4"))) {
			System.out.println("Please enter a valid input, Press 1 to attack, 2 for use your helmet, 3 for have an energy drink and 4 to run away.");
			choice = userInput.nextLine();
		}
		int intChoice = Integer.parseInt(choice);			
		return intChoice;
	}
	
	/*
	 * Method to ask the player if want to accept the challenge
	 * Possible to not use it if we don't want interaction
	 */
	public int gameProposalChoice() {
		System.out.println("Your opponent is waiting, press: 1 to accept the challenge or 2 to leave");
		String choice = userInput.nextLine();
		while (!(choice.equals("1"))  && !(choice.equals("2"))) {
			System.out.println("Please enter a valid input: Press 1 to accept the challenge or 2 to leave");
			choice = userInput.nextLine();
		}
		int intChoice = Integer.parseInt(choice);		
		return intChoice;
	}	
	
	/*
	 * Method that simulate the 1st challenge
	 * Possible to not use it if we don't want interaction
	 */
	public int gameChoice() {
		System.out.println("Another tight corner is coming, wich line would you chose?");
		System.out.println("Press 1 for choose the inside line, 2 for the outside line, 3 for jump the corner.");
		String choice = userInput.nextLine();
		while (!(choice.equals("1"))  && !(choice.equals("2")) && !(choice.equals("3"))) {
			System.out.println("Please enter a valid input, press 1 for choose the inside line, 2 for the outside line, 3 for jump the corner.");
			choice = userInput.nextLine();
		}
		int intChoice = Integer.parseInt(choice);
		return intChoice;
	}	
	
	/*
	 * Method to ask the player if want to accept the challenge
	 * Possible to not use it if we don't want interaction
	 */
	public int puzzleProposalChoice() {
		System.out.println("Press: 1 to help him or 2 to go back");
		String choice = userInput.nextLine();
		while (!(choice.equals("1"))  && !(choice.equals("2"))) {
			System.out.println("Please enter a valid input: Press: 1 to help him or 2 to go back");
			choice = userInput.nextLine();
		}
		int intChoice = Integer.parseInt(choice);		
		return intChoice;
	}	
	
	/*
	 * Method that simulate the 1st challenge
	 * Possible to not use it if we don't want interaction
	 */
	public int puzzleChoice() {
		String choice = userInput.nextLine();
		while (!(choice.equals("1"))  && !(choice.equals("2")) && !(choice.equals("3"))  && !(choice.equals("4"))) {
			System.out.println("Please enter a valid input, Press 1 or 2");
			choice = userInput.nextLine();
		}
		int intChoice = Integer.parseInt(choice);			
		return intChoice;
	}	



}	
