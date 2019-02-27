package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String args []) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Main.fxml"));

			Scene scene = new Scene(root);

			stage.setTitle("Main Menu");
			stage.setScene(scene);
			stage.show();		
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}
	private void buttonSeating(ActionEvent event) {
	     	System.out.println("button seating");
	    	new SeatingMaintenance();
	}
 
private void buttonTicket(ActionEvent event) {
 	System.out.println("button ticket");
	new TicketingMaintenance();
}
private void buttonInsurance(ActionEvent event) {
 	System.out.println("button insurance");
	new SetInsurance();
}
private void buttonExit(ActionEvent event) {
	 System.out.println("exit");
	 System.exit(0);	 
}
}
