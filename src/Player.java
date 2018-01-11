package TicTacToeProject;

/* A model class to define structure of a Player object */
public class Player {
	private char mark;
	private String name;
	
	public char getMark() {
		return mark;
	}
	public String getName() {
		return name;
	}
	public Player(String name) {
		super();
		this.name = name;
	}
	public Player(char mark) {
		super();
		this.mark = mark;
	}
	public Player(char mark, String name) {
		super();
		this.mark = mark;
		this.name = name;
	}
	
}
