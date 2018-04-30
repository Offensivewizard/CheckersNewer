import java.util.Arrays;
import java.util.Random;

public class AI {

	public AI() {

		
	}
	
	public int[] getAIMove(Board gameBoard, boolean cTurn) {
		
		int[] coords = new int[4];
		Random rand = new Random();
		
		for(int i = 0; i<4; i++){
			coords[i] = rand.nextInt(8);
		}
		
		while (!gameBoard.validateMove(coords[0],coords[1],coords[2],coords[3],cTurn)) {
			
			for(int i = 0; i<4; i++){
				coords[i] = rand.nextInt(8);
			}
			

			
		}
		

		return coords;


		
	}
}

