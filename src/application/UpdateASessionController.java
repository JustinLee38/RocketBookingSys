package application;

import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;

import controller.FlightJDBC;
import entity.Flight;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class UpdateASessionController implements Initializable{
	
	@FXML
	private ComboBox flightNo,origin,destination,departureDate;
	FlightJDBC jdbc;
	Flight flight;
	
	ObservableList <String> flightNoList;
	
	ObservableList <String> originList;

	ObservableList <String> destinationList;

	ObservableList <String> departureDateList;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			jdbc = new FlightJDBC();
			flightNoList = FXCollections.observableArrayList(jdbc.ViewAllFlightNo());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		flight = new Flight();
		originList = FXCollections.observableArrayList(flight.defaultOriginList());
		destinationList = FXCollections.observableArrayList(flight.defaultDestinationList());
		departureDateList = FXCollections.observableArrayList(flight.defaultDepartureDate());
		
		
		flightNo.setValue("Select Flight No");
		flightNo.setItems(flightNoList);
		
		origin.setValue("Select Origin");
		origin.setItems(originList);
		
		destination.setValue("Select Destination");
		destination.setItems(destinationList);
		
		departureDate.setValue("Select Departure Date");
		departureDate.setItems(departureDateList);
	}
	@FXML
	private void openSession_Update (ActionEvent event) throws Exception{
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("UpdateASession.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = new Stage (StageStyle.DECORATED);
		primaryStage.setTitle("Update A Session");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();		
	}
	public void printSelection(ActionEvent event) throws Exception {
		String flightNoOutput = flightNo.getSelectionModel().getSelectedItem().toString();
		String originOutput = origin.getSelectionModel().getSelectedItem().toString();
		String destinationOutput = destination.getSelectionModel().getSelectedItem().toString();
		String departureDateOutput = departureDate.getSelectionModel().getSelectedItem().toString();
		String arrivalDate = null;
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
		    //startDate = df.parse(departureDateOutput);
		    java.util.Date utilDepartureDate = df.parse(departureDateOutput);
		    java.sql.Date sql_StartDate = new java.sql.Date( utilDepartureDate.getTime() );
		    Calendar c = Calendar.getInstance();
			c.setTime(utilDepartureDate); 
			c.add(Calendar.DATE, 360); // Adding 5 days
			arrivalDate = df.format(c.getTime());
			
		} catch (ParseException e) {
		    e.printStackTrace();
		}
		
		int result = Integer.parseInt(flightNoOutput);
		Flight flight = new Flight(result, originOutput, destinationOutput, departureDateOutput, arrivalDate);
		jdbc.updateFlight(flight);
	
		System.out.println("Flight No: "+flightNoOutput);
		System.out.println("Origin: "+originOutput);
		System.out.println("Destination: "+destinationOutput);
		System.out.println("Departure Date: "+departureDateOutput);
		((Node)(event.getSource())).getScene().getWindow().hide();
		
	}
	@FXML
	private void update_Exit(ActionEvent event) throws Exception{
		System.exit(0);		
	}
}

