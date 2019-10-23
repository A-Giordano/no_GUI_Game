package Code;

public class Puzzles {
	private String question;
	private int answer;
	private boolean isAsked;
	
	/*
	 * Class that represent a puzzle in this game, contains his own fields and methods.
	 */
	public Puzzles(String question, int answer, int level) {
		super();
		this.question = question;
		this.answer = answer;
		this.isAsked = false;
	}

	/*
	 * Method that returns the puzzle's question.
	 */
	public String getQuestion() {
		return question;
	}

	/*
	 * Method that returns the puzzle's answer.
	 */
	public int getAnswer() {
		return answer;
	}

	/*
	 * Method that returns if the puzzle has been asked.
	 */
	public boolean isAsked() {
		return isAsked;
	}

	/*
	 * Method that sets if the puzzle has been asked.
	 */
	public void setIsAsked(boolean isAnswered) {
		this.isAsked = isAnswered;
	}
	
	/*
	 * Method that prints the puzzle's question.
	 */
	public void printQuestion() {
		System.out.println(question);
	}
	
	
	
	

}
