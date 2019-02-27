package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UpdateASeat extends Application{
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("UpdateASeat.fxml"));

			Scene scene = new Scene(root);

			primaryStage.setTitle("Update a seat");
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();		
	//		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	 
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("");
		launch(args);
	}
}
