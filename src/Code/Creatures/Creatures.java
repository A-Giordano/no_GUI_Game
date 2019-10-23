package Code.Creatures;

import java.util.Random;
import Code.UserInputs;



public class Creatures {
	private UserInputs uI;
	private String tag;
	private int xCoordinate;
	private int yCoordinate;
	private Random randGen;

	/*
	 * Class that represent all the creatures in this game, containing fields and methods of them.
	 */
	public Creatures() {
		randGen = new Random();
		uI = new UserInputs();
	}

	/*
	 * Method that returns the user input.
	 */
	public UserInputs getuI() {
		return uI;
	}
	
	/*
	 * Method that returns the random generator.
	 */
	public Random getRandGen() {
		return randGen;
	}

	/*
	 * Method that returns the creature tag.
	 */
	public String getTag() {
		return tag;
	}
	
	/*
	 * Method that sets the creature's tag.
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	/*
	 * Method that returns the creature's x coordinate.
	 */
	public int getxCoordinate() {
		return xCoordinate;
	}
	
	/*
	 * Method that sets the creature's x coordinate.
	 */
	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}
	
	/*
	 * Method that gets the creature's y coordinate.
	 */
	public int getyCoordinate() {
		return yCoordinate;
	}
	
	/*
	 * Method that sets the creature's y coordinate.
	 */
	public void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
	
	/*
	 * Method that moves the player one step left on the game board.
	 */
	public void moveLeft() {
		if (xCoordinate > 0) {
			xCoordinate--;
		}
		else {
			xCoordinate = 4;
		}
	}
	
	/*
	 * Method that moves the player one step right on the game board.
	 */
	public void moveRight() {
		xCoordinate = (xCoordinate + 1) % 5;
	}
	
	/*
	 * Method that moves the player one step up on the game board.
	 */
	public void moveUp() {
		if (yCoordinate > 0) {
			yCoordinate--;
		}
		else {
			yCoordinate = 4;
		}
	}
	
	/*
	 * Method that moves the player one step down on the game board.
	 */
	public void moveDown() {
		yCoordinate = (yCoordinate + 1) % 5;
	}
	
	/*
	 * Method that prints the player's coordinates on the game board.
	 */
	public void printCoordinate() {
		System.out.println("X: " + xCoordinate + "Y " + yCoordinate);
	}
	

	
	
	

}
