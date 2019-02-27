package view;
 
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenu extends Application{
	Button b1, b2, b3, b4, b5;
	Stage stage;
	
	public void start(Stage stage){
		this.stage = stage;
		b1 = new Button("Session Maintenance");
		b2 = new Button("Seating Maintenance");
		b3 = new Button("Ticketing Maintenance");
		b4 = new Button("Apply Membership");
		b5 = new Button("Exit");
		b1.setPrefWidth(500);
		b2.setPrefWidth(500);
		b3.setPrefWidth(500);
		b4.setPrefWidth(500);
		b5.setPrefWidth(500);
		
		b1.setOnAction(this::handleButtonAction);
		b2.setOnAction(this::handleButtonAction);
		b3.setOnAction(this::handleButtonAction);
		b4.setOnAction(this::handleButtonAction);
		b5.setOnAction(this::handleButtonAction);
		
		VBox box = new VBox(10, b1,b2,b3,b4,b5);
		box.setPadding(new Insets(20));
		Scene scene =new Scene(box, 500, 500);
		this.stage.setScene(scene);
		this.stage.setTitle("Main Menu");
		this.stage.show();		
	}

	 private void handleButtonAction(ActionEvent event) {
	     if (event.getSource() == b1){
	    	System.out.println("button session");
	    	new SessionMaintenance();
	     } else if (event.getSource() == b2) {
	    	 System.out.println("button seating");
	    	 new SeatingMaintenance();
	     }else if (event.getSource() == b3) {
	    	 System.out.println("button ticketing");
	    	 new TicketingMaintenance();
	     }else if (event.getSource() == b4) {
	    	 System.out.println("button membership");
	    	 new SetInsurance();
	     }
	     else {
	    	 System.out.println("exit");
	    	 System.exit(0);	    	
	 } }
	       

	public static void main(String[] args) {
		launch(args);
	}
	
	
}
