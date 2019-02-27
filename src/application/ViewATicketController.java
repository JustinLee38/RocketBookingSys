package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controller.FlightJDBC;
import controller.TicketJDBC;
import entity.Insurance;
import entity.Seat;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ViewATicketController implements Initializable {

	@FXML
	private ComboBox flightNo;
	FlightJDBC jdbc;
	TicketJDBC ticketJdbc;
	ObservableList <String> flightNoList;
	ArrayList <Ticket> ticketListConsole ;




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
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("ViewATicket.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = new Stage (StageStyle.DECORATED);
		primaryStage.setTitle("Delete A Session");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();		
	}
	public void printSelection(ActionEvent event) throws Exception {

		TableView<Ticket> ticketTable;

		TableColumn<Ticket, Integer> flightNoColumn = new TableColumn<>("Flight No");
		flightNoColumn.setMinWidth(50);
		flightNoColumn.setCellValueFactory(new PropertyValueFactory<>("flightNo"));

		TableColumn<Ticket,String> ticketNoColumn = new TableColumn<>("Ticket No");
		ticketNoColumn.setMinWidth(100);
		ticketNoColumn.setCellValueFactory(new PropertyValueFactory<>("ticketNo"));

		TableColumn<Ticket,String> ticketPriceColumn = new TableColumn<>("Ticket Price");
		ticketPriceColumn.setMinWidth(100);
		ticketPriceColumn.setCellValueFactory(new PropertyValueFactory<>("ticketPrice"));

		TableColumn<Ticket,String> seatNoColumn = new TableColumn<>("Seat No");
		seatNoColumn.setMinWidth(150);
		seatNoColumn.setCellValueFactory(new PropertyValueFactory<>("seatNo"));

		TableColumn<Ticket,String> insNoColumn = new TableColumn<>("Insurance No");
		insNoColumn.setMinWidth(150);
		insNoColumn.setCellValueFactory(new PropertyValueFactory<>("insNo"));
		
		TableColumn<Ticket,String> seatPrice = new TableColumn<>("Seat Price");
		seatPrice.setMinWidth(150);
		seatPrice.setCellValueFactory(new PropertyValueFactory<>("seatPrice"));
		
		TableColumn<Ticket,String> insPrice = new TableColumn<>("Insurance Price");
		insPrice.setMinWidth(150);
		insPrice.setCellValueFactory(new PropertyValueFactory<>("insPrice"));


		ticketTable = new TableView<>();
		ticketTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		ticketTable.setItems(getTicket());
		ticketTable.getColumns().addAll(flightNoColumn, ticketNoColumn,  seatNoColumn, insNoColumn, seatPrice, insPrice, ticketPriceColumn);

		VBox vBox = new VBox();
		vBox.getChildren().addAll(ticketTable);

		//		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		Scene scene = new Scene(vBox,1200,350);
		Stage primaryStage = new Stage (StageStyle.DECORATED);
		primaryStage.setTitle("View Ticketing");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();


		((Node)(event.getSource())).getScene().getWindow().hide();

	}

	/*	private void openTicketing_Delete (ActionEvent event) throws Exception{



	}*/


	public ObservableList<Ticket> getTicket() {

		String flightNoOutput = flightNo.getSelectionModel().getSelectedItem().toString();
		try {
			ticketJdbc = new TicketJDBC();
			ticketListConsole = ticketJdbc.ViewAllTicket(flightNoOutput);
		}catch(Exception e) {
			e.printStackTrace();
		}
		ObservableList <Ticket> ticketList = null;
		
		
		try {
			TicketJDBC jdbc = new TicketJDBC();
			ticketList = FXCollections.observableArrayList(jdbc.ViewAllTicket(flightNoOutput));

		}catch(Exception e){
			e.printStackTrace();
		}

		System.out.println("Tickets: " + ticketListConsole);

		ObservableList <Ticket> flightList = null;
		try {
			TicketJDBC jdbc = new TicketJDBC();
			flightList = FXCollections.observableArrayList(jdbc.ViewAllTicket(flightNoOutput));

		}catch(Exception e){
			e.printStackTrace();
		}
		return flightList;
	}



}
