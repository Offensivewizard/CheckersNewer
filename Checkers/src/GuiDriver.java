

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class GuiDriver extends Application {
	
	Button[][] buttons = new Button[8][8];
	
	public static void main(String[] args) {
		
		launch(args);

	}

	@Override
	public void start(Stage window) throws Exception {
		
		 GridPane gridpane = new GridPane();
		 populateButtons(gridpane);
		 Scene scene = new Scene(gridpane, 500, 500);
		 window.setTitle("Checkers");
	        window.setScene(scene);
	        window.show();
	}
	
	private void populateButtons(GridPane gp){
		
		for (int row=0; row<8; row++){
			for (int col=0; col<8; col++){
				buttons[col][row] = new Button("E");
				gp.add(buttons[col][row], col, row);
			}
		}
		
	}
}
	
	

