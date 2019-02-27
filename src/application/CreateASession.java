package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class CreateASession extends Application {
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("createASession.fxml"));

			Scene scene = new Scene(root);
			
			/*   ComboBox<String> myComboBox = new ComboBox<String>();
			    myComboBox.getItems().addAll("Malaysia","USA");
			    myComboBox.setEditable(true);        
			    
			    AnchorPane pane =  (AnchorPane) scene.getRoot();
			    pane.getChildren().add(myComboBox);*/
			
			
			primaryStage.setTitle("Create a session");
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();		
	//		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	 
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		launch(args);
	}
}
