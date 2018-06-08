
import java.io.FileInputStream;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/*
 * NewStage() is the method that represents the game that opens after a button is pressed on the Menu  
 */


class NewStage {
	private static final double BUTTON_WIDTH = 80;
	private static final double BUTTON_HEIGHT = 80;
	private coordButton[][] buttons = new coordButton[8][8];
	private Board gameBoard = new Board();
	private int[] startcoords = new int[2];
	private int[] endcoords = new int[2];
	private int numClicks = 0;
	private boolean currentTurn = false;
	private AI ai = new AI();
	public boolean aiTrue;

	private void updateBoard() {
		gameBoard.upBoard(buttons);
	}


		
  NewStage (boolean gamestatus)  {
	  if (gamestatus == true){
		  aiTrue =true;
	  }
	  
	  else {
		  aiTrue =false;
	  }
	  			//is named window but is different from the window in the "start" method 
	  			Stage window = new Stage();
			
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
											System.out.println("It is now black's turn.");
											currentTurn = false;

										} else {
											System.out.println("It is now red's turn.");
											currentTurn = true;

										}
										

										if (aiTrue == true && gameBoard.checkOver() == false) {

											int[] aicoords = ai.getAIMove(gameBoard, currentTurn);
											gameBoard.movePiece(aicoords[0], aicoords[1], aicoords[2], aicoords[3],
													currentTurn);
											currentTurn = false;
											System.out.println("It is now black's turn.");
											updateBoard();

										}
										
										if (gameBoard.checkOver()) {
											
											Button playagain = new Button ("Play Again with CPU");
											Button playagain2  = new Button ("Play Again with 2 Players");

											text.setText(gameBoard.checkWinner() + " is the winner.");
											text.setFont(new Font(20));
											vbox.getChildren().add(text);
											vbox.getChildren().add(playagain);
											vbox.getChildren().add(playagain2);
											playagain.setOnAction(e-> new NewStage(true));
											playagain2.setOnAction(e-> new NewStage(false));
											Scene end = new Scene(vbox, 500, 500);
											window.setTitle("Game Over");
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


public class GuiDriver extends Application {

	
	
	public static void main(String[] args) {

		launch(args);

	}

		@Override
		public void start(Stage window) throws Exception {
			
			
		
		Text title = new Text();
		VBox vbox1 = new VBox();
		Scene start = new Scene(vbox1, 500, 500);
		window.setScene(start);
		
		
	
		title.setText("Welcome to Checkers");
		title.setFont(new Font(50));
		vbox1.getChildren().add(title);
		
		Button twoPlayers = new Button("2 Players");
		Button CPU = new Button("CPU");
		
		CPU.setOnAction(e-> new NewStage(true) );
		twoPlayers.setOnAction(e-> new NewStage(false));
	
		vbox1.getChildren().add(twoPlayers);
		vbox1.getChildren().add(CPU);
		
		vbox1.setAlignment(Pos.CENTER);
		window.setTitle("Welcome");
		window.show();
	}
	}
	

