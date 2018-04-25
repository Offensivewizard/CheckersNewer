


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.ToggleButton;



public class GuiDriver extends Application {
	private static final double BUTTON_WIDTH = 10;
	private static final double BUTTON_HEIGHT = 10;
	private static coordButton[][] buttons = new coordButton[8][8];
	
	public static void main(String[] args) {
		
		launch(args);

	}

	@Override
	public void start(Stage window) throws Exception {
		
		 GridPane gridpane = new GridPane();
		 
		 for (int row=0; row<8; row++){
				for (int col=0; col<8; col++){
					buttons[row][col] = new coordButton(row,col);
					buttons[row][col].setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
					buttons[row][col].setStyle("-fx-base: #f44e42;");
					buttons[row][col].setOnAction(new EventHandler<ActionEvent>() {
			            @Override
			            public void handle(ActionEvent event) {
			            	System.out.println(((coordButton)event.getSource()).getRow());
			            	System.out.println(((coordButton)event.getSource()).getCol());
			            }
			        });
					
					gridpane.add(buttons[row][col], col, row);
				}
				}
		 
		 
		 Scene scene = new Scene(gridpane, 500, 500);
		 window.setTitle("Checkers");
	        window.setScene(scene);
	        window.show();
	}
	
	

	
	
	
	
	
}
	
	

