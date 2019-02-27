package application;

import java.net.URL;
import java.util.ResourceBundle;

import controller.FlightJDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DeleteASessionController implements Initializable {
	
	@FXML
	private ComboBox flightNo;
	FlightJDBC jdbc;
	ObservableList <String> flightNoList;
			
	

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			jdbc = new FlightJDBC();
			flightNoList = FXCollections.observableArrayList(jdbc.ViewAllFlightNo());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		flightNo.setValue("Select Flight No");
		flightNo.setItems(flightNoList);
	}
	@FXML
	private void openSession_Delete (ActionEvent event) throws Exception{
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("DeleteASession.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = new Stage (StageStyle.DECORATED);
		primaryStage.setTitle("Delete A Session");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();		
	}
	public void printSelection(ActionEvent event) throws Exception {
	
		String flightNoOutput = flightNo.getSelectionModel().getSelectedItem().toString();
		
		jdbc.deleteFlight(flightNoOutput);
		
		System.out.println("Flight No: " + flightNoOutput);
		((Node)(event.getSource())).getScene().getWindow().hide();
		
	}
	
}
