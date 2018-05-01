
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.ToggleButton;

public class GuiDriver extends Application {
	private static final double BUTTON_WIDTH = 80;
	private static final double BUTTON_HEIGHT = 80;
	private coordButton[][] buttons = new coordButton[8][8];
	private Board gameBoard = new Board();
	private int[] startcoords = new int[2];
	private int[] endcoords = new int[2];
	private int numClicks = 0;
	private boolean currentTurn = false;
	private AI ai = new AI();
	private boolean aiTrue = true;

	public static void main(String[] args) {

		launch(args);

	}

	private void updateBoard() {

		gameBoard.upBoard(buttons);

	}

	@Override
	public void start(Stage window) throws Exception {

		GridPane gridpane = new GridPane();
		VBox vbox = new VBox();
		vbox.setAlignment(Pos.CENTER);
		Text text = new Text();

		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				buttons[row][col] = new coordButton(row, col);
				buttons[row][col].setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
				buttons[row][col].setStyle("-fx-base: #f44e42;");
				buttons[row][col].setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						
							if (numClicks == 0) {

								startcoords[0] = (int) ((coordButton) event.getSource()).getRow();
								startcoords[1] = (int) ((coordButton) event.getSource()).getCol();
								numClicks++;
							} else if (numClicks == 1) {

								endcoords[0] = (int) ((coordButton) event.getSource()).getRow();
								endcoords[1] = (int) ((coordButton) event.getSource()).getCol();

								if (gameBoard.validateMove(startcoords[0], startcoords[1], endcoords[0], endcoords[1],
										currentTurn)) {

									gameBoard.movePiece(startcoords[0], startcoords[1], endcoords[0], endcoords[1],
											currentTurn);
									updateBoard();
									numClicks = 0;

									if (currentTurn == true) {

										currentTurn = false;

									} else {

										currentTurn = true;

									}
									
									if (aiTrue == true) {
										
										int[] aicoords = ai.getAIMove(gameBoard, currentTurn);
										gameBoard.movePiece(aicoords[0], aicoords[1], aicoords[2], aicoords[3], currentTurn);
										currentTurn = false;
										updateBoard();
										
									}
									
									if (gameBoard.checkOver()) {
										
										text.setText(gameBoard.checkWinner() + " is the winner.");
										text.setFont(new Font(20));
										vbox.getChildren().add(text);
										Scene end = new Scene(vbox,500,500);
										window.setScene(end);
										
									}

								} else {

									numClicks = 0;
									System.out.println("Invalid move. Try again.");

								}

							}

						

					}
				});

				gridpane.add(buttons[row][col], col, row);
			}
		}

		for (int i = 0; i < 3; i += 2) {

			for (int t = 0; t < 8; t += 2) {

				buttons[i][t].setStyle("-fx-base: #e5e5e5;");
			}
		}
		for (int i = 1; i < 8; i += 2) {
			buttons[1][i].setStyle("-fx-base: #e5e5e5;");
		}
		for (int i = 3; i < 5; i++) {

			for (int j = 0; j < 8; j++) {

				buttons[i][j].setStyle("-fx-base: #e5e5e5;");
			}
		}
		for (int i = 5; i < 8; i += 2) {

			for (int j = 1; j < 8; j += 2) {
				buttons[i][j].setStyle("-fx-base: #e5e5e5;");
			}
		}
		for (int i = 0; i < 8; i += 2) {
			buttons[6][i].setStyle("-fx-base: #e5e5e5" + ";");
		}
		for (int i = 0; i < 3; i += 2) {
			for (int t = 1; t < 8; t += 2) {
				buttons[i][t].setStyle("-fx-base: #000000;");
			}
		}
		for (int i = 0; i < 8; i += 2) {
			buttons[1][i].setStyle("-fx-base: #000000;");
		}

		for (int i = 0; i < 8; i += 2) {
			buttons[7][i].setStyle("-fx-base: #c90808;");
		}
		for (int i = 0; i < 8; i += 2) {
			buttons[5][i].setStyle("-fx-base: #c90808;");
		}
		for (int i = 1; i < 8; i += 2) {
			buttons[6][i].setStyle("-fx-base: #c90808;");
		}
		Scene scene = new Scene(gridpane, 500, 500);
		window.setTitle("Checkers");
		window.setScene(scene);
		window.show();
	}

}
