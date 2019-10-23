package Code.Creatures;

import java.util.ArrayList;

import Code.Puzzles;



public class PuzzleCreatures extends Creatures implements Opponents {
	private boolean challengeAccepted;
	private ArrayList<Puzzles> puzzleList;  
	private boolean correctAnswer;
	boolean isDefeated;

	/*
	 * Class that represent the game creatures in this game, inherits fields and methods from Characters class and implement the Opponents Interface, plus his own fields and methods.
	 */
	public PuzzleCreatures() {
		super.setTag("PuzzleCreature");
		challengeAccepted = false;
		puzzleList = new ArrayList<>();
		correctAnswer = false;
		isDefeated = false;
		addPuzzle(new Puzzles("My pedals are stuck, I can not move them, what can it be? Press 1 for brakes or 2 for chain.", 2, 1));
		addPuzzle(new Puzzles("My suspensions aren't working, what can it be? Press 1 for inflate them or 2 for remove wheels.", 1, 1));
		addPuzzle(new Puzzles("My brakes squeal, what should I do? Press 1 for whash them with degrasser 2 change brake lever.", 1, 1));	
	}
	
	/*
	 * Method that returns if the player has accepted the challenge.
	 */
	public boolean isChallengeAccepted() {
		return challengeAccepted;
	}
	
	/*
	 * Method that sets all the puzzles to not asked.
	 */
	public void setAllPuzzlesToNotAsked() {
		for(Puzzles puzzle : puzzleList) {
			puzzle.setIsAsked(false);
		}
	}
	
	/*
	 * Method that returns true or false whether all the puzzles has been asked.
	 */
	public boolean AreAllPuzzlesAsked() {
		boolean allAnswered = true;
		for(Puzzles puzzle : puzzleList) {
			if (puzzle.isAsked() == false) {
				allAnswered = false;
				break;
			}
		}
		return allAnswered;
	}
	
	/*
	 * Method that returns a random puzzle if still there are some not asked puzzles or a random one if all already asked.
	 */
	public Puzzles getPuzzle() {
		Puzzles selectedPuzzle = puzzleList.get(super.getRandGen().nextInt(puzzleList.size()));
		if (selectedPuzzle.isAsked() == false) {
			selectedPuzzle.printQuestion();
			selectedPuzzle.setIsAsked(true);
			return selectedPuzzle;
		}
		else {
			if(AreAllPuzzlesAsked()) {
				setAllPuzzlesToNotAsked();
				selectedPuzzle = puzzleList.get(super.getRandGen().nextInt(puzzleList.size()));
			}
			else {
				while(selectedPuzzle.isAsked() == true) {
					selectedPuzzle = puzzleList.get(super.getRandGen().nextInt(puzzleList.size()));
				}
			}
			selectedPuzzle.printQuestion();
			selectedPuzzle.setIsAsked(true);
			return selectedPuzzle;
		}	
	}
	
	/*
	 * Method that adds a new puzzle to the list of them.
	 */
	public void addPuzzle(Puzzles puzzle) {
		puzzleList.add(puzzle);
	}
	
	/*
	 * Method that prints the puzzle creature introduction.
	 */
	public void opponentIntroduction() {
		System.out.println("You see a man having some troubles with his bike, would yo ulike to help him?");
	}
	
	/*
	 * Methods that asks to the player if he want to accept the challenge.
	 */
	public void challengeProposal (Players palyer, int choice) {
		if (choice == 1) {
			System.out.println("man: Thanks you are a good man.");
			challengeAccepted = true;
		}
		else {
			System.out.println("man: No worries I will try to fix it on my own, but mybike is stuck here and you won't be able to proceed.");
		}
	}
	
	/*
	 * Method that simulates a puzzle challenge between a puzzle creature and the player.
	 */
	public void puzzleChallenge(Players player, Puzzles puzzle, int choice) {
		if (puzzle.getAnswer() == choice) {
				isDefeated = true;
				player.addEquipmentSet();
		}
		else {
			System.out.println("That did not fix the issue.");

			System.out.println("Man: May you can try to help me again?");
		}	
	}
	
	/*
	 * Method that simulates multiple puzzle challenges between a puzzle creature and the player.
	 */
	public void challenge(Players player) {
		while (isDefeated ==  false) {
		puzzleChallenge(player, getPuzzle(), super.getuI().challengeChoice(this));
		}
	}

	/*
	 * Method that returns true or false weather the puzzle creature has bees defeated.
	 */
	public boolean getIsDefeated () {
		if (isDefeated == true) {
			System.out.println("Great! you helped to fix the problem and now you can continue!");
		}
		return isDefeated;
	}
	

}
