import javafx.scene.control.Button;

public class coordButton extends Button {
		
	private int col;
	private int row;
	
	
	public coordButton(int r, int c) {
		super();
		row = r;
		col = c;
		
	}
	
	public int getRow() {
		
		return row;
		
	}
	
	public int getCol() {
		
		return col;
		
	}
	
}
