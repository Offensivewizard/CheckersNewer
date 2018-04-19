
public class Board {

	GamePiece[][] board;

	public Board() {

		board = new GamePiece[8][8];
		for (int i = 0; i < 3; i += 2) {

			for (int t = 0; t < 8; t += 2) {

				board[i][t] = new GamePiece(Colour.EMPTY);
			}
		}
		for (int i = 1; i < 8; i += 2) {
			board[1][i] = new GamePiece(Colour.EMPTY);
		}
		for (int i = 3; i < 5; i++) {

			for (int j = 0; j < 8; j++) {

				board[i][j] = new GamePiece(Colour.EMPTY);
			}
		}
		for (int i = 5 ; i < 8 ; i += 2) {
			
			for (int j = 1 ; j < 8 ; j += 2) {
				board[i][j] = new GamePiece(Colour.EMPTY);
			}
		}
		for (int i = 0 ; i < 8 ; i += 2 ) {
			board[6][i] = new GamePiece(Colour.EMPTY);
		}
		for (int i = 0; i < 3; i += 2) {
			for (int t = 1; t < 8; t += 2) {
				board[i][t] = new GamePiece(Colour.BLACK);
			}
		}
		for (int i = 0; i < 8; i += 2) {
			board[1][i] = new GamePiece(Colour.BLACK);
		}

		for (int i = 0; i < 8; i += 2) {
			board[7][i] = new GamePiece(Colour.RED);
		}
		for (int i = 0; i < 8; i += 2) {
			board[5][i] = new GamePiece(Colour.RED);
		}
		for (int i = 1; i < 8; i += 2) {
			board[6][i] = new GamePiece(Colour.RED);
		}
	}

	public void display() {
		for (int j = 0; j < 8; j++) {
			for (int g = 0; g < 8; g++) {
				System.out.print(board[j][g].getColour() + " ");
			}
			System.out.println();
		}
	}
}
