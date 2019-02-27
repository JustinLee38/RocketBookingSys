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
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ViewASeatController implements Initializable{
	@FXML
	private AnchorPane rootPane;
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
	private void Seat_ViewSeating (ActionEvent event) throws Exception{
		System.out.println(printSelection(event));
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Seat_ViewSeating.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = new Stage (StageStyle.DECORATED);
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.setTitle("View all Seats");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();		
	}
	
	public String printSelection(ActionEvent event) throws Exception {
		
		String flightNoOutput = flightNo.getSelectionModel().getSelectedItem().toString();
		
		return flightNoOutput;
		
	}

}

