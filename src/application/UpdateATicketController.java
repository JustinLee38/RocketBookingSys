package application;

import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;

import controller.FlightJDBC;
import controller.InsuranceJDBC;
import controller.SeatJDBC;
import controller.TicketJDBC;
import entity.Flight;
import entity.Ticket;
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
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class UpdateATicketController implements Initializable{
	
	@FXML
	private ComboBox ticketNo, flightNo, seatNo, insNo;
	TicketJDBC ticketJdbc;
	FlightJDBC flightJdbc;
	SeatJDBC seatJdbc;
	InsuranceJDBC insJdbc;
	Ticket ticket;
	
	ObservableList <String> ticketNoList;
	
	ObservableList <String> flightNoList;

	ObservableList <String> seatNoList;

	ObservableList <String> insNoList;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			ticketJdbc = new TicketJDBC();
			flightJdbc = new FlightJDBC();
			seatJdbc = new SeatJDBC();
			insJdbc = new InsuranceJDBC();
			ticketNoList = FXCollections.observableArrayList(ticketJdbc.ViewAllTicketNo());
			flightNoList = FXCollections.observableArrayList(flightJdbc.ViewAllFlightNo());
			seatNoList = FXCollections.observableArrayList(seatJdbc.ViewAllSeatNo());
			insNoList = FXCollections.observableArrayList(insJdbc.ViewAllInsNo());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ticketNo.setValue("Select Ticket No");
		ticketNo.setItems(ticketNoList);
		
		flightNo.setValue("Select Flight No");
		flightNo.setItems(flightNoList);
		
		seatNo.setValue("Select Seat No");
		seatNo.setItems(seatNoList);
		
		insNo.setValue("Select Insurance No");
		insNo.setItems(insNoList);
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
		int ticketNoOutput = Integer.parseInt(ticketNo.getSelectionModel().getSelectedItem().toString());
		int flightNoOutput = Integer.parseInt(flightNo.getSelectionModel().getSelectedItem().toString());
		int seatNoOutput = Integer.parseInt(seatNo.getSelectionModel().getSelectedItem().toString());
		int insNoOutput = Integer.parseInt(insNo.getSelectionModel().getSelectedItem().toString());
				
		//calculate price
		double seatPrice = seatJdbc.getSeatPrice(seatNoOutput);;
		double insPrice = insJdbc.getInsPrice(insNoOutput);;
				
		double price = seatPrice + insPrice + 1000;
		
		Ticket ticket = new Ticket(ticketNoOutput, price, flightNoOutput, seatNoOutput, insNoOutput);
		ticketJdbc.updateTicket(ticket);
	
		System.out.println("Ticket No: "+ticketNoOutput);
		System.out.println("Flight No: "+ flightNoOutput);
		System.out.println("Seat No: "+ seatNoOutput);
		System.out.println("Insurance No: "+ insNoOutput);
		((Node)(event.getSource())).getScene().getWindow().hide();
		
	}
	@FXML
	private void update_Exit(ActionEvent event) throws Exception{
		System.exit(0);		
	}
}

