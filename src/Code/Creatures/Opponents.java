package Code.Creatures;

public interface Opponents {
	
	/*
	 * Method that returns if the player has accepted the challenge.
	 */
	public boolean isChallengeAccepted();
	
	/*
	 * Method that prints the opponent introduction.
	 */
	public void opponentIntroduction();
	
	/*
	 * Methods that asks to the player if he want to accept the challenge.
	 */
	public void challengeProposal (Players palyer, int choice);
	
	/*
	 * Method that simulates the challenge between an opponent and the player.
	 */
	public void challenge(Players player);
	
	/*
	 * Method that returns true or false weather the opponent has bees defeated.
	 */
	public boolean getIsDefeated ();
	

}
