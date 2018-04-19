
public class Driver {

	public static void main(String[] args) {
	
		Board gameBoard = new Board();
		gameBoard.display();
		gameBoard.movePiece(2, 1, 3, 2);
		gameBoard.display();
	
	}
}
