
public class Driver {

	public static void main(String[] args) {
		
		boolean currentTurn = false;
		Board gameBoard = new Board();
		
		gameBoard.display();
		gameBoard.movePiece(2, 1, 1, 1, currentTurn);
		gameBoard.display();
		
	
	}
}
