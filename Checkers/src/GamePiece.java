
public class GamePiece {
	
	private static Colour colour;
	private static boolean king;
	private static String colourString;
	
	
	public GamePiece (Colour colour) {
		
		this.colour = colour;
		king = false;
		
	}
	
	public static String getColour() {
		
		switch (colour) {
		case RED: colourString = "r";
		break;
		case BLACK: colourString = "b";
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
