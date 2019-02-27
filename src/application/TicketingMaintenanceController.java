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

public class TicketingMaintenanceController implements Initializable {
	
	@FXML
	private AnchorPane rootPane;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
	@FXML
	private void openTicketing_Create (ActionEvent event) throws Exception{
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("CreateATicket.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = new Stage (StageStyle.DECORATED);
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.setTitle("Create A Ticket");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.showAndWait();		
	}
	@FXML
	private void openTicketing_View (ActionEvent event) throws Exception{
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("ViewATicket.fxml"));
		Scene scene = new Scene(root);
		//Scene scene1 = new Scene(ViewASession.sceneView1(label1, button1), 200, 200);
		Stage primaryStage = new Stage (StageStyle.DECORATED);
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.setTitle("View Tickets");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.showAndWait();		
	}
	@FXML
	private void openTicketing_Update (ActionEvent event) throws Exception{
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("UpdateATicket.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = new Stage (StageStyle.DECORATED);
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.setTitle("Update Tickets");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.showAndWait();		
	}
	@FXML
	private void openTicketing_Delete (ActionEvent event) throws Exception{
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("DeleteATicket.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = new Stage (StageStyle.DECORATED);
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.setTitle("Delete Tickets");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();		
	}
}
