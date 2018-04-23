
public class Board {

	GamePiece[][] board;
	int redPiece = 12;
	int blackPiece = 12;

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
		for (int i = 5; i < 8; i += 2) {

			for (int j = 1; j < 8; j += 2) {
				board[i][j] = new GamePiece(Colour.EMPTY);
			}
		}
		for (int i = 0; i < 8; i += 2) {
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
	
	public void instaWin() {
		
		redPiece = 0;
		
	}
	
	public void display() {
		for (int j = 0; j < 8; j++) {

			for (int g = 0; g < 8; g++) {

				System.out.print(board[j][g].printColour() + " ");

			}

			System.out.println();

		}

		System.out.println("---------------");

	}

	public void movePiece(int y1, int x1, int y2, int x2, boolean currentTurn) {

		boolean isKing = false;
		// Get the colour of the original piece.
		Colour oColour = board[y1][x1].getColour();
		// Check if the original piece was a king or not.
		if (board[y1][x1].checkKing() == true) {

			isKing = true;

		}
		// Make the piece's previous place empty, and make the new one the
		// original colour.
		board[y1][x1].setColour(Colour.EMPTY);

		board[y2][x2].setColour(oColour);
		// For when the piece jumps over another piece.
		if (Math.abs(x1 - x2) == 2) {
			// If the piece is moving to the left.
			if (x1 > x2) {
				// If the piece is moving up the board from red's
				// perspective.
				if (y1 > y2) {
					// Removing the piece from the board completely.
					board[y1 - 1][x1 - 1].setColour(Colour.EMPTY);
					board[y1 - 1][x1 - 1].removeKing();

				}
				// If the piece is moving down.
				else {

					board[y1 + 1][x1 - 1].setColour(Colour.EMPTY);
					board[y1 + 1][x1 - 1].removeKing();

				}

			}
			// If the piece is moving to the right.
			else {
				// If the piece is moving up.
				if (y1 > y2) {

					board[y1 - 1][x1 + 1].setColour(Colour.EMPTY);
					board[y1 - 1][x1 + 1].removeKing();

				}
				// If the piece is moving down.
				else {

					board[y1 + 1][x1 + 1].setColour(Colour.EMPTY);
					board[y1 + 1][x1 + 1].removeKing();

				}

			}
			// If red takes a piece, then remove 1 from the blackPiece
			// count.
			if (currentTurn == true) {

				blackPiece--;

			}
			// If black takes a piece, then remove 1 from the redPiece
			// count.
			else {

				redPiece--;

			}
		}

		if (isKing == true) {

			board[y2][x2].makeKing();
			board[y1][x1].removeKing();

		}

	}

	public boolean checkOver() {

		if (blackPiece == 0 || redPiece == 0) {

			return true;

		}

		else {

			return false;

		}

	}

	public boolean validateMove(int y1, int x1, int y2, int x2, boolean currentTurn) {

		// Checks if the move is within the range of the board.
		if (x1 >= 0 && x1 <= 7 && y1 >= 0 && y1 <= 7 && x2 >= 0 && x2 <= 7 && y2 >= 0 && y2 <= 7) {
			// Check if the piece is actually moving diagonally.
			if (Math.abs(x1 - x2) >= 1) {
				// Check if either the old space or the new space is empty.
				if (board[y2][x2].getColour().equals(Colour.EMPTY) && !board[y1][x1].getColour().equals(Colour.EMPTY)) {
					// Check whether the current turn corresponds to the piece
					// being moved.
					if (board[y1][x1].getColour().equals(Colour.RED) && currentTurn == true) {
						// In this case, the colour of the piece being moved is
						// red,
						// so we need
						// to check whether the piece is moving forward or
						// backwards
						// from its side of the board.
						// In this case, if the piece is moving forward, the
						// space
						// it's moving too will have
						// a lower y value than the space it's moving from.
						if (y2 < y1) {
							// This if statement catches if the move is a simple
							// one
							// space move.
							if (Math.abs(y2 - y1) == 1) {

								return true;

							}
							// If the amount of spaces the piece is supposedly
							// moving 2 spaces,
							// then it gets a bit more complex. A valid move
							// would
							// be for a jump, and so
							// the validity of the jump needs to be found.
							else if (Math.abs(y2 - y1) == 2) {
								// If the piece is moving to the right.
								if (x1 < x2) {

									if (board[y1 - 1][x1 + 1].getColour().equals(Colour.BLACK)) {

										return true;

									}

								}
								// If the piece is moving to the left.
								else if (x2 > x1) {

									if (board[y1 - 1][x1 - 1].getColour().equals(Colour.BLACK)) {

										return true;

									}

								}

							}

						}
						// If the piece is trying to move backwards, then we
						// check
						// if it's a king or not.
						// If it's not a king, then the move gets the boot.
						// Everything else from here on out is the same as the
						// other if statement.
						else if (y2 > y1 && board[y1][x1].checkKing() == true) {

							if (Math.abs(y2 - y1) == 1) {

								return true;

							}

							else if (Math.abs(y2 - y1) == 2) {

								if (x2 > x1) {

									if (board[y1 + 1][x1 + 1].getColour().equals(Colour.BLACK)) {

										return true;

									}

								}

								else if (x2 < x1) {

									if (board[y1 + 1][x1 - 1].getColour().equals(Colour.BLACK)) {

										return true;

									}

								}

							}

						}

					}
					// This is essentially the same, except it is for black
					// pieces.
					// This means a comparisons and checks will be switched
					// around.
					if (board[y1][x1].getColour().equals(Colour.BLACK) && currentTurn == false) {

						// The only difference here, where we check for if the
						// piece is a king if the piece is moving down instead
						// of up.
						if (y2 < y1 && board[y1][x1].checkKing() == true) {

							if (Math.abs(y2 - y1) == 1) {

								return true;

							} else if (Math.abs(y2 - y1) == 2) {

								if (x1 < x2) {

									if (board[y1 - 1][x1 + 1].getColour().equals(Colour.RED)) {

										return true;

									}

								}

								else if (x2 > x1) {

									if (board[y1 - 1][x1 - 1].getColour().equals(Colour.RED)) {

										return true;

									}

								}

							}

						}

						else if (y2 > y1) {

							if (Math.abs(y2 - y1) == 1) {

								return true;

							}

							else if (Math.abs(y2 - y1) == 2) {

								if (x2 > x1) {

									if (board[y1 + 1][x1 + 1].getColour().equals(Colour.RED)) {

										return true;

									}

								}

								else if (x2 < x1) {

									if (board[y1 + 1][x1 - 1].getColour().equals(Colour.RED)) {

										return true;

									}

								}

							}

						}

					}

				}
			}
		}

		return false;

	}

	public String checkWinner() {
		
		if (redPiece == 0) {
			
			return "Black";
			
		}
		
		else {
			
			return "Red";
			
		}
		
		
	}
	
	public void king(int y, int x, boolean currentTurn) {
		
		if (board[y][x].getColour().equals(Colour.RED) && y == 0) {
			
			board[y][x].makeKing();
			
		}
		
		else if (board[y][x].getColour().equals(Colour.BLACK) && y == 7) {
			
			board[y][x].makeKing();
			
		}
		
	}
	
}
