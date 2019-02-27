package application;
 
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

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
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Ticket_SeatSelectionController implements Initializable{
	@FXML //b1-b16 are prompted when seat is selected
	Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16;
	@FXML //b1a-b16a are prompted whenseat is available to be chosen
	Button b1a,b2a,b3a,b4a,b5a,b6a,b7a,b8a,b9a,b10a,b11a,b12a,b13a,b14a,b15a,b16a;
	@FXML //b1a1 - b16a1 are to hide seats when they are not available
	Button b1a1,b2a1,b3a1,b4a1,b5a1,b6a1,b7a1,b8a1,b9a1,b10a1,b11a1,b12a1,b13a1,b14a1,b15a1,b16a1;
	
	String seat ;
	int total;
	SeatJDBC seatJdbc;
	TicketJDBC ticketJdbc;
	ObservableList <String> seatNoList;	
	ObservableList <String> flightSeatNoList;	
	private static int flightNo;
	
	@FXML
	private AnchorPane rootPane;
	
	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;

	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			seatJdbc = new SeatJDBC();
			ticketJdbc = new TicketJDBC();
			flightSeatNoList = FXCollections.observableArrayList(ticketJdbc.ViewAllSeatNo(flightNo));
			System.out.println(flightSeatNoList);
			seatNoList = FXCollections.observableArrayList(seatJdbc.ViewAllSeatNo());
			}catch(Exception e) {
				e.printStackTrace();
			}
		if(flightSeatNoList.contains("1"))
			hideB1();
		if(flightSeatNoList.contains("2"))
			hideB2();
		if(flightSeatNoList.contains("3"))
			hideB3();
		if(flightSeatNoList.contains("4"))
			hideB4();
		if(flightSeatNoList.contains("5"))
			hideB5();
		if(flightSeatNoList.contains("6"))
			hideB6();
		if(flightSeatNoList.contains("7"))
			hideB7();
		if(flightSeatNoList.contains("8"))
			hideB8();
		
		
		if(seatNoList.contains("1")) { 
			hideB1a();
			System.out.println("in 1");
		}
		if(seatNoList.contains("2")){ 
			hideB2a();
			System.out.println("in 2");
		}
		if(seatNoList.contains("3")) 
			hideB3a();
		if(seatNoList.contains("4")) 
			hideB4a();
		if(seatNoList.contains("5")) 
			hideB5a();
		if(seatNoList.contains("6")) 
			hideB6a();
		if(seatNoList.contains("7")) { 
			hideB7a();
			System.out.println("in 7");
		}
		if(seatNoList.contains("8")) { 
			hideB8a();
			System.out.println("in 8");
		}
		if(seatNoList.contains("9")) 
			hideB9a();		
		if(seatNoList.contains("10")) 
			hideB10a();
		if(seatNoList.contains("11")) 
			hideB11a();
		if(seatNoList.contains("12")) 
			hideB12a();
		if(seatNoList.contains("13")) 
			hideB13a();
		if(seatNoList.contains("14")) 
			hideB14a();
		if(seatNoList.contains("15")) 
			hideB15a();
		if(seatNoList.contains("16")) 
			hideB16a();
	}
	@FXML
	private void openTicketing_SeatSelection (ActionEvent event) throws Exception{
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Ticket_SeatSelection.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = new Stage (StageStyle.DECORATED);
		primaryStage.setTitle("Select A Seat");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();		
	}
	@FXML
	private void hideB1() {
			b1.setVisible(false);
			seat ="1";
			System.out.println("Seat selected is "+ seat);
			
	}
	@FXML
	private void hideB2(){
		  b2.setVisible(false);
		  seat ="2";
		  System.out.println("Seat selected is "+ seat);
			
	}
	@FXML
	private void hideB3() {
		  b3.setVisible(false);
		  seat ="3";
		  System.out.println("Seat selected is "+ seat);

	}
	@FXML
	private void hideB4() {
		  b4.setVisible(false);
		  seat ="4";
		  System.out.println("Seat selected is "+ seat);
	
	}
	@FXML
	private void hideB5() {
		  b5.setVisible(false);
		  seat ="5";
		  System.out.println("Seat selected is "+ seat);
	
	}
	@FXML
	private void hideB6() {
		  b6.setVisible(false);
		  seat ="6";
		  System.out.println("Seat selected is "+ seat);
	
	}
	@FXML
	private void hideB7() {
		  b7.setVisible(false);
		  seat ="7";
		  System.out.println("Seat selected is "+ seat);
	
	}
	@FXML
	private void hideB8() {
		  b8.setVisible(false);
		  seat ="8";
		  System.out.println("Seat selected is "+ seat);
		
	}
	@FXML
	private void hideB9() {
		  b9.setVisible(false);
		  seat ="9";
		  System.out.println("Seat selected is "+ seat);
		
	}
	@FXML
	private void hideB10() {
		  b10.setVisible(false);
		  seat ="10";
		  System.out.println("Seat selected is "+ seat);
			
	}
	@FXML
	private void hideB11() {
		  b11.setVisible(false);
		  seat ="11";
		  System.out.println("Seat selected is "+ seat);
			
	}
	@FXML
	private void hideB12() {
		  b12.setVisible(false);
		  seat ="12";
		  System.out.println("Seat selected is "+ seat);
			
	}
	@FXML
	private void hideB13() {
		  b13.setVisible(false);
		  seat ="13";
		  System.out.println("Seat selected is "+ seat);
			
	}
	@FXML
	private void hideB14() {
		  b14.setVisible(false);
		  seat ="14";
		  System.out.println("Seat selected is "+ seat);
			
	}
	@FXML
	private void hideB15() {
		  b15.setVisible(false);
		  seat ="15";
		  System.out.println("Seat selected is "+ seat);
			
	}
	@FXML
	private void hideB16() {
		  b16.setVisible(false);
		  seat ="16";
		  System.out.println("Seat selected is "+ seat);
		  
		  
	}
	
	@FXML
	private void hideB1a(){
		b1a1.setVisible(false);

	}
	@FXML
	private void hideB2a(){
		b2a1.setVisible(false);

	}
	@FXML
	private void hideB3a(){
		b3a1.setVisible(false);

	}
	@FXML
	private void hideB4a(){
		b4a1.setVisible(false);

	}
	@FXML
	private void hideB5a(){
		b5a1.setVisible(false);

	}
	@FXML
	private void hideB6a(){
		b6a1.setVisible(false);

	}
	@FXML
	private void hideB7a(){
		b7a1.setVisible(false);

	}
	@FXML
	private void hideB8a(){
		b8a1.setVisible(false);

	}

	@FXML
	private void hideB9a() {
		b9a1.setVisible(false);

	}
	@FXML
	private void hideB10a() {
		b10a1.setVisible(false);

	}
	@FXML
	private void hideB11a() {
		b11a1.setVisible(false);

	}
	@FXML
	private void hideB12a(){
		b12a1.setVisible(false);

	}
	@FXML
	private void hideB13a(){
		b13a1.setVisible(false);

	}
	@FXML
	private void hideB14a() {
		b14a1.setVisible(false);

	}
	@FXML
	private void hideB15a() {
		b15a1.setVisible(false);

	}
	@FXML
	private void hideB16a() {
		b16a1.setVisible(false);

	}
	@FXML
	private void seatSelected(ActionEvent event) throws Exception {
		
		seatJdbc = new SeatJDBC();
		ticketJdbc = new TicketJDBC();
		
		int seatNo = Integer.parseInt(seat);
		
		double seatPrice = seatJdbc.getSeatPrice(seatNo);
		int ticketNo = ticketJdbc.getTicketNo(seatNo);
		double price = ticketJdbc.getPrice(seatNo);
		
		double priceTotal = price + seatPrice;
		
		System.out.println(ticketNo);
				
		
		
		
		Ticket ticket = new Ticket(ticketNo, priceTotal, seatNo );

		ticketJdbc.updateTicket2(ticket);
		
		
		((Node)(event.getSource())).getScene().getWindow().hide();
	
	}

	}


