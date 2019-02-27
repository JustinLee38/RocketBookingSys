package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SeatingMaintenanceController implements Initializable {
	
	@FXML
	private AnchorPane rootPane;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
	@FXML
	private void openSeating_Create (ActionEvent event) throws Exception{
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("CreateASeat.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = new Stage (StageStyle.DECORATED);
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.setTitle("Create A Seat");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.showAndWait();		
	}
	@FXML
	private void openSeating_View (ActionEvent event) throws Exception{
		//Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("ViewASeat.fxml"));
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Seat_ViewSeating.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = new Stage (StageStyle.DECORATED);
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.setTitle("View a Seat");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.showAndWait();		
	}
	@FXML
	private void openSeating_Update (ActionEvent event) throws Exception{
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("UpdateASeat.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = new Stage (StageStyle.DECORATED);
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.setTitle("Update A Seat");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.showAndWait();		
	}
	@FXML
	private void openSeating_Delete (ActionEvent event) throws Exception{
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("DeleteASeat.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = new Stage (StageStyle.DECORATED);
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.setTitle("Delete a Seat");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.showAndWait();		
	}
}
