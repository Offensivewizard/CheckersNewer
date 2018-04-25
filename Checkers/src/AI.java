import java.util.Random;

public class AI {

	public AI() {

		
	}
	
	public int[] getAIMove() {
		
		int[] coords = new int[4];
		Random rand = new Random();

		int r = rand.nextInt(8) + 0;
		
		for(int i = 0; i<4; i++){
			coords[i] = r;
		}
		
		

		return coords;


		
	}
}

/*while (!gameBoard.validateMove(coord[0], coord[1], coord[2], coord[3], currentTurn)) {
gameBoard.display();
System.out.println("Invalid coordinates, try again. Input your coordinates in order:");
coord[0] = in.nextInt();
coord[1] = in.nextInt();
coord[2] = in.nextInt();
coord[3] = in.nextInt();

}
*/