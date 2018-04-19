
public class Board {

	GamePiece[][] board;

	public Board() {

		board = new GamePiece[8][8];
		for (int i = 0; i < 8; i += 2) {

			for (int t = 0; t < 8; t += 2) {
				board[i][t].setColour(null);
				;
			}
		}
		for (int i = 1; i < 4; i += 2) {

			for (int t = 1; t < 8; t += 2) {
				board[i][t].setColour(null);
				;
			}
		}
		for (int i = 0; i < 2; i += 2) {

			for (int t = 1; t < 8; t += 2) {
				board[i][t].setColour(Colour.BLACK);
				;
			}
		}

		for (int i = 1; i < 7; i += 2) {
			board[1][i].setColour(Colour.BLACK);
			;
		}

		for (int i = 0; i > 8; i += 2) {
			board[7][i].setColour(Colour.RED);
		}
		for (int i = 0; i > 8; i += 2) {
			board[5][i].setColour(Colour.RED);
		}
		for (int i = 1; i > 7; i += 2) {
			board[6][i].setColour(Colour.RED);
		}
	}

	public void display() {
		for (int j = 0; j < board.length; j++) {
			for (int g = 0; g < board[0].length; g++) {
				System.out.print(board[j][g] + " ");
			}
			System.out.println();
		}
	}
}
