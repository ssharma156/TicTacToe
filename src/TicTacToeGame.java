package TicTacToeProject;
import java.util.Scanner;

/* This class represents the game */
public class TicTacToeGame {
	static TicTacToeBoard board = new TicTacToeBoard();
	static Player player1;
	static Player player2;
	static Player currentPlayer;
	static boolean haveWinner = false, firstPlayer = true;

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Enter Player1's name : ");
		player1 = new Player('O', scn.next());

		System.out.print("\nEnter Player2's name : ");
		player2 = new Player('X', scn.next());

		System.out.println("\n\nHello, " + player1.getName() + " & " + player2.getName() + "! Welcome onboard.");
		System.out.println("\n" + player1.getName() + "! Your mark is: " + player1.getMark());
		System.out.println(player2.getName() + "! Your mark is: " + player2.getMark());
		
		System.out.println("\n\n___________________________________________________________\n");
		do {
			if (firstPlayer)
				currentPlayer = player1;
			else
				currentPlayer = player2;

			firstPlayer = playTurn(currentPlayer);

			if (haveWinner) {
				System.out.println(
						"\n############################################\nCongratulations " + currentPlayer.getName()
								+ "! You have won the game.\n############################################");
				break;
			} else if (TicTacToeBoard.nOofTilesFilled == 9) {
				System.out.println("\n\nX-----------X------------X-----------X------------X");
				TicTacToeBoard.drawBoard();
				System.out.println(
						"\nXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\nGame ended, but no winner. Better luck.\nXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
				System.out.println("X-----------X------------X-----------X------------X");
				break;
			}

		} while (!haveWinner);

	}

	/*public static boolean playTurn(Player player) {
		int cellNum = scn.nextInt();

		System.out.print("It's " + currentPlayer.getName() + "'s turn. Enter the cell number (1 to 9): ");
		if (TicTacToeBoard.containsValue[(cellNum % 3 == 0) ? cellNum / 3 - 1 : cellNum / 3][(cellNum % 3 == 0) ? 2
				: cellNum % 3 - 1]) {
			System.out.println("Caution " + player.getName() + "! The other player already has marked cell number #"
					+ cellNum + "\nTry again!!!");
			playTurn(player);
		} else {
			haveWinner = TicTacToeBoard.set(cellNum, currentPlayer.getMark());
			TicTacToeBoard.drawBoard();
		}
		return !firstPlayer;
	}*/

	// Meghana Method
	public static boolean playTurn(Player player) {
		int cellNum;
		System.out.print("It's " + currentPlayer.getName() + "'s turn. Enter the cell number (1 to 9): ");
		cellNum = scn.nextInt();
		
		haveWinner = TicTacToeBoard.set(cellNum, currentPlayer.getMark());
		if(TicTacToeBoard.inserted){
			TicTacToeBoard.drawBoard();
			System.out.println("\n___________________________________________________________\n");
			return !firstPlayer;
		}
		else{
			System.out.println("Caution " + player.getName() + "! The other player already has marked cell number #"
					+ cellNum + "\nTry again!!!");
			return firstPlayer;
		}
	}

}
