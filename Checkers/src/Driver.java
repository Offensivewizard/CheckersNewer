
public class Driver {

	public static void main(String[] args) {
		ArrayList<ArrayList<Cell>> board = new ArrayList<ArrayList<Cell>>();

		Cell cell1 = new Cell(CellType.RED);
		System.out.println(cell1.getState());

		
		
		for (int i = 0; i < 4; i++) {
			board.get(0).add(new Cell(CellType.EMPTY));
			board.get(0).add(new Cell(CellType.BLACK));
		}
		for (int i = 1; i < 4; i++) {
			board.get(1).add(new Cell(CellType.BLACK));
			board.get(1).add(new Cell(CellType.EMPTY));

		}
		for (int i = 0; i < 4; i++) {
			board.get(2).add(new Cell(CellType.EMPTY));
			board.get(2).add(new Cell(CellType.BLACK));
		}
		for (int i = 0; i < 8; i++) {
			board.get(3).add(new Cell(CellType.EMPTY));
			board.get(4).add(new Cell(CellType.EMPTY));

		}
		for (int i = 1; i < 4; i++) {
			board.get(5).add(new Cell(CellType.RED));
			board.get(5).add(new Cell(CellType.EMPTY));

		}
		for (int i = 0; i < 4; i++) {
			board.get(6).add(new Cell(CellType.EMPTY));
			board.get(6).add(new Cell(CellType.RED));
		}
		for (int i = 1; i < 4; i++) {
			board.get(7).add(new Cell(CellType.RED));
			board.get(7).add(new Cell(CellType.EMPTY));

		
	}
		printBoard(board);
		
}
	
	public static void printBoard(ArrayList<ArrayList<Cell>> board){
		for(int i=0;i<8;i++){
			for(int t = 0;t<8;t++){
				System.out.print(board.get(i).get(t).getState());
			}
		}
	}

	}

}
