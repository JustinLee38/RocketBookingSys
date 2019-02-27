package application;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controller.FlightJDBC;
import controller.InsuranceJDBC;
import controller.SeatJDBC;
import controller.TicketJDBC;
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


public class CreateATicketController implements Initializable{
	@FXML
	private ComboBox flightNo,insNo;
	TicketJDBC ticketJdbc;
	FlightJDBC flightJdbc;
	SeatJDBC seatJdbc;
	InsuranceJDBC insJdbc;
	

	ObservableList <String> flightNoList;


	ObservableList <String> insNoList;


	@Override
	public void initialize(URL url, ResourceBundle rb) {
		try {
		flightJdbc = new FlightJDBC();
		seatJdbc = new SeatJDBC();
		insJdbc = new InsuranceJDBC();
		
		flightNoList = FXCollections.observableArrayList(flightJdbc.ViewAllFlightNo());
		insNoList = FXCollections.observableArrayList(insJdbc.ViewAllInsNo());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		flightNo.setValue("Select Flight No");
		flightNo.setItems(flightNoList);
	
		
		insNo.setValue("Select Insurance No");
		insNo.setItems(insNoList);
	}  


	@FXML
	private void openTicketing_Create (ActionEvent event) throws Exception{
		
		/*ArrayList<String> ticketList = getTicketInfo();
		int ticketNo = Integer.parseInt(ticketList.get(0));
		double price = Double.parseDouble(ticketList.get(1));
		int flightNo = Integer.parseInt(ticketList.get(2));
		int insNo = Integer.parseInt(ticketList.get(3));*/
		
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("CreateATicket.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = new Stage (StageStyle.DECORATED);
		primaryStage.setTitle("Create A Ticket");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();		
	}
	
	public ArrayList<String> printSelection(ActionEvent event) throws Exception {
		int flightNoOutput = Integer.parseInt(flightNo.getSelectionModel().getSelectedItem().toString());
		//int seatNoOutput = Integer.parseInt(seatNo.getSelectionModel().getSelectedItem().toString());
		int insNoOutput = Integer.parseInt(insNo.getSelectionModel().getSelectedItem().toString());
		ticketJdbc = new TicketJDBC();
		
		//calculate price
		//double seatPrice = seatJdbc.getSeatPrice(seatNoOutput);;
		double insPrice = insJdbc.getInsPrice(insNoOutput);		
		double price = insPrice + 1000;
		//double price = seatPrice + insPrice + 1000;
		
		//ticketNoOutput Validation
		int ticketNo = ticketJdbc.ticketNoValidation();
		
		Ticket ticket = new Ticket(ticketNo, price, flightNoOutput, insNoOutput);
		//Ticket ticket = new Ticket(ticketNo, price, flightNoOutput, seatNoOutput, insNoOutput);
		
		ticketJdbc.addTicket(ticket);

		System.out.println("Ticket No: "+ticketNo);
		System.out.println("Flight no: " + flightNoOutput);
		//System.out.println("Seat no: " + seatNoOutput);
		System.out.println("Insurance no: " + insNoOutput);
		
		ArrayList <String> ticketList=new ArrayList<String>();
		ticketList.add(Integer.toString(ticketNo));
		ticketList.add(Double.toString(price));
		ticketList.add(Integer.toString(flightNoOutput));
		ticketList.add(Integer.toString(insNoOutput));
		
		return ticketList;
		
		//((Node)(event.getSource())).getScene().getWindow().hide();
		
		
	}
	public void getTicketInfo() throws Exception {
		int flightNoOutput = Integer.parseInt(flightNo.getSelectionModel().getSelectedItem().toString());
		//int seatNoOutput = Integer.parseInt(seatNo.getSelectionModel().getSelectedItem().toString());
		int seatNoOutput = 0;
		int insNoOutput = Integer.parseInt(insNo.getSelectionModel().getSelectedItem().toString());
		ticketJdbc = new TicketJDBC();
		
		//calculate price
		//double seatPrice = seatJdbc.getSeatPrice(seatNoOutput);;
		double insPrice = insJdbc.getInsPrice(insNoOutput);		
		double price = insPrice;
		//double price = seatPrice + insPrice + 1000;
		
		//ticketNoOutput Validation
		int ticketNo = ticketJdbc.ticketNoValidation();
		
		//Ticket ticket = new Ticket(ticketNo, price, flightNoOutput, insNoOutput);
		Ticket_SeatSelectionController tssc = new Ticket_SeatSelectionController();
		tssc.setFlightNo(flightNoOutput);
		Ticket ticket = new Ticket(ticketNo, price, flightNoOutput, seatNoOutput, insNoOutput);
		
		ticketJdbc.addTicket(ticket);

		System.out.println("Ticket No: "+ticketNo);
		System.out.println("Flight no: " + flightNoOutput);
		//System.out.println("Seat no: " + seatNoOutput);
		System.out.println("Insurance no: " + insNoOutput);
		
		ArrayList <String> ticketList=new ArrayList<String>();
		ticketList.add(Integer.toString(ticketNo));
		ticketList.add(Double.toString(price));
		ticketList.add(Integer.toString(flightNoOutput));
		ticketList.add(Integer.toString(insNoOutput));
		
		//return ticketList;
		//((Node)(event.getSource())).getScene().getWindow().hide();		
	}
	
	@FXML
	private void openTicketing_SeatSelection (ActionEvent event) throws Exception{
		getTicketInfo();
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Ticket_SeatSelection.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = new Stage (StageStyle.DECORATED);
		primaryStage.setTitle("Select A Seat");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();		
	}
	
}