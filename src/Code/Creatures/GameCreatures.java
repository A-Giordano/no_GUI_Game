package Code.Creatures;

import java.util.Scanner;

public class GameCreatures extends Creatures implements Opponents{
	private int gameCounter;
	private boolean challengeAccepted;
		
	/*
	 * Class that represent the game creatures in this game, inherits fields and methods from Characters class and implement the Opponents Interface, plus his own fields and methods.
	 */
	public GameCreatures() {
		super.setTag("GameCreature");
		gameCounter = 0;
		challengeAccepted = false;
	}
	

	/*
	 * Method that returns if the player has accepted the challenge.
	 */
	public boolean isChallengeAccepted() {
		return challengeAccepted;
	}

	/*
	 * Method that prints the game creature introduction.
	 */
	public void opponentIntroduction () {	
		System.out.println("A stranger approach you, and say: You seems a valorous adversary, why dont't we do a race to see who's the best!?");
	}

	/*
	 * Methods that asks to the player if he want to accept the challenge.
	 */
	public void challengeProposal (Players palyer, int choice) {	
		if (choice == 1) {
			System.out.println("Opponent: Silly choice, you will never defeat me!");
			System.out.println("Opponent: Let's start the race!");
			System.out.println("You are in the race, after some corners nobody is really leading...");
			challengeAccepted = true;
		}
		else {
			System.out.println("You leave and went back to the previous area");
		}
	}
	
	/*
	 * Method that simulates a round of a game between a game creature and the player.(rock-paper-scissor).
	 */
	public void gameChallenge(Players player, int choice) {
			int previousGameCounter = gameCounter;
			int opponentChoice = (super.getRandGen().nextInt(3) +1);		
			if (choice == opponentChoice) {
				System.out.println("Both of you have chose the same line, the lead hasn't changed");
			}
			else if (choice == 1 && opponentChoice == 2) {
				System.out.println("Wrong Choice! Your opponent has choose the outside line and carryed more speed!");
				gameCounter--;				
			}
			else if (choice == 2 && opponentChoice == 3) {
				System.out.println("Wrong Choice! Your opponent jumped over you in the corner!");
				gameCounter--;				
			}
			else if (choice == 3 && opponentChoice == 1) {
				System.out.println("Wrong Choice! Your opponent has choose the inside line, cut the corner and he has been faster!");
				gameCounter--;				
			}
			else if (choice == 2 && opponentChoice == 1) {
				System.out.println("Great Choice! You've carryed more speed!");
				gameCounter++;				
			}
			else if (choice == 3 && opponentChoice == 2) {
				System.out.println("Great Choice! You've jumped over your opponent!");
				gameCounter++;				
			}
			else if (choice == 1 && opponentChoice == 3) {
				System.out.println("Great Choice! You've cut the corner and you've been faster!");
				gameCounter++;				
			}
			
			if (previousGameCounter== gameCounter) {
				System.out.println("the race is going, but the lead hasn't changed!");
			}			
			else if (previousGameCounter == -1 && gameCounter == -2) {
				System.out.println("Your opponent is increasing his lead!");
			}
			else if (previousGameCounter == 0 && gameCounter == -1) {
				System.out.println("Your opponent overtook you and take the lead!");
			}
			else if (previousGameCounter == 1 && gameCounter == 0) {
				System.out.println("Concentrate! You are losing your lead!");
			}
			else if (previousGameCounter == 2 && gameCounter == 1) {
				System.out.println("Attention your lead is decreaasing!");
			}
			if (previousGameCounter == 1 && gameCounter == 2) {
				System.out.println("Congratulation! You are increasing your lead!");
			}			
			else if (previousGameCounter == 0 && gameCounter == 1) {
				System.out.println("You overtook your opponent!");
			}
			else if (previousGameCounter == -1 && gameCounter == 0) {
				System.out.println("You are regain some terrain, you almost reach him!");
			}
			else if (previousGameCounter == -2 && gameCounter == -1) {
				System.out.println("You are regain some terrain, but still not enough!");
			}		
	}
	
	/*
	 * Method that simulates the 3 round game between a game creature and the player.
	 */
	public void challenge(Players player) {
		gameChallenge(player, super.getuI().challengeChoice(this));
		gameChallenge(player, super.getuI().challengeChoice(this));
		gameChallenge(player, super.getuI().challengeChoice(this));
	}
	
	/*
	 * Method that returns true or false weather the game creature has bees defeated.
	 */
	public boolean getIsDefeated () {
		if (gameCounter > 0) {
			System.out.println("Congratulation you won the race! Now you can proceed.");
			return true;
		}
		else if (gameCounter == 0){
			System.out.println("You almost did it, but your opponet won, next time you will be luckier");
			return false;
		}
		else {
			System.out.println("Your opponent won the race, go back to training!");
			return false;
		}
	}
	

}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
