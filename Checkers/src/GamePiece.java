
public class GamePiece {

	private Colour colour;
	private static boolean king;
	private static String colourString;

	public GamePiece(Colour colour) {

		this.colour = colour;
		king = false;

	}

	public void setColour(Colour colour) {

		this.colour = colour;

	}

	public String printColour() {

		switch (colour) {
		case RED:
			colourString = "R";
			break;
		case BLACK:
			colourString = "B";
			break;
		case EMPTY:
			colourString = "E";
			break;
		}

		return colourString;

	}

	public Colour getColour() {

		return colour;

	}

	public void makeKing() {

		king = true;

	}
	
	public void removeKing() {
		
		king = false;
		
	}

	public boolean checkKing() {

		return king;

	}

}
