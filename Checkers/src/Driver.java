import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {

		boolean currentTurn = false;
		Board gameBoard = new Board();
		Scanner in = new Scanner(System.in);
		int[] coord = new int[4];

		System.out.println("Welcome to simple checkers! Here's the default board:");
		gameBoard.display();

		while (!gameBoard.checkOver()) {
			// For now, this isn't going to be very player friendly, since it's
			// going to be handled by GUI later anyways.
			currentTurn = false;
			System.out.println("Black checkers, it's your turn! Input your coordinates in order:");
			coord[0] = in.nextInt();
			coord[1] = in.nextInt();
			coord[2] = in.nextInt();
			coord[3] = in.nextInt();

			while (!gameBoard.validateMove(coord[0], coord[1], coord[2], coord[3], currentTurn)) {
				gameBoard.display();
				System.out.println("Invalid coordinates, try again. Input your coordinates in order:");
				coord[0] = in.nextInt();
				coord[1] = in.nextInt();
				coord[2] = in.nextInt();
				coord[3] = in.nextInt();

			}

			gameBoard.movePiece(coord[0], coord[1], coord[2], coord[3], currentTurn);

			if (gameBoard.checkOver()) {

				break;

			}

			currentTurn = true;
			gameBoard.display();
			System.out.println("Red checkers, it's your turn! Input your coordinates in order:");
			coord[0] = in.nextInt();
			coord[1] = in.nextInt();
			coord[2] = in.nextInt();
			coord[3] = in.nextInt();

			while (!gameBoard.validateMove(coord[0], coord[1], coord[2], coord[3], currentTurn)) {
				gameBoard.display();
				System.out.println("Invalid coordinates, try again. Input your coordinates in order:");
				coord[0] = in.nextInt();
				coord[1] = in.nextInt();
				coord[2] = in.nextInt();
				coord[3] = in.nextInt();

			}

			gameBoard.movePiece(coord[0], coord[1], coord[2], coord[3], currentTurn);
			gameBoard.display();

			if (gameBoard.checkOver()) {

				break;

			}

		}

		System.out.println("The game is over!");
		System.out.println(gameBoard.checkWinner() + " wins.");

	}
}
