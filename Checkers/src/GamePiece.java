
public class GamePiece {
	
	private static Colour colour;
	private static boolean king;
	private static String colourString;
	
	
	public GamePiece (Colour colour) {
		
		this.colour = colour;
		king = false;
		
	}
	
	public void setColour(Colour colour) {
		
		this.colour = colour;
		
	}
	
	public String getColour() {
		
		switch (colour) {
		case RED: colourString = "R";
		break;
		case BLACK: colourString = "B";
		break;
		case EMPTY: colourString = "E";
		break;
		}
		
		return colourString;
		
	}
	
	public static void makeKing() {
		
		king = true;
		
	}
	
	public static boolean checkKing() {
		
		return king;
		
	}
	
}
