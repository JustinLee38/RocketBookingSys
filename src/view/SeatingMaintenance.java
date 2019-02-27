package view;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SeatingMaintenance {
    ListView list;
    Button btOK;
    Stage stage;
    
    public SeatingMaintenance () {    	 
    	//create controls
		list = new ListView();
		btOK = new Button("OK");
		btOK.setPrefWidth(300);	
		btOK.setOnAction(event->stage.hide());
		
		FlowPane flow2 = new 
		   FlowPane(Orientation.VERTICAL, 10, 10, list, btOK);
		flow2.setAlignment(Pos.CENTER);		
		Scene scene = new Scene(flow2, 350, 500);
		stage = new Stage();
		stage.setTitle("Seating Maintenance");
		stage.setScene(scene);
		stage.show();		
	}
}