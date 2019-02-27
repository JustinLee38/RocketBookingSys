package application;

import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;

import controller.SeatJDBC;
import entity.Flight;
import entity.Seat;
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

public class UpdateASeatController implements Initializable{
	
	@FXML
	private ComboBox seatNo, seatType, seatFood, seatDescription;
	SeatJDBC jdbc;
	Seat seat;
	
	ObservableList <String> seatNoList;
	
	ObservableList <String> seatTypeList;

	ObservableList <String> seatFoodList;

	ObservableList <String> seatDescList;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			jdbc = new SeatJDBC();
			seatNoList = FXCollections.observableArrayList(jdbc.ViewAllSeatNo());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		seat = new Seat();
		seatTypeList = FXCollections.observableArrayList(seat.defaultSeatType());
		seatFoodList = FXCollections.observableArrayList(seat.defaultSeatFood());
		seatDescList = FXCollections.observableArrayList(seat.defaultSeatDescription());
		
		
		seatNo.setValue("Select Seat No");
		seatNo.setItems(seatNoList);
		
		seatType.setValue("Select Seat Type");
		seatType.setItems(seatTypeList);
		
		seatFood.setValue("Select Seat Food");
		seatFood.setItems(seatFoodList);
		
		seatDescription.setValue("Select Description");
		seatDescription.setItems(seatDescList);
	}
	
	@FXML
	private void openSession_Update (ActionEvent event) throws Exception{
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("UpdateASeat.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = new Stage (StageStyle.DECORATED);
		primaryStage.setTitle("Update A Seat");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();		
	}
	public void printSelection(ActionEvent event) throws Exception {
		String seatNoOutput = seatNo.getSelectionModel().getSelectedItem().toString();
		String seatTypeOutput = seatType.getSelectionModel().getSelectedItem().toString();
		String seatFoodOutput = seatFood.getSelectionModel().getSelectedItem().toString();
		String seatDescriptionOutput = seatDescription.getSelectionModel().getSelectedItem().toString();
		double seatPrice = seat.seatPrice(seatFoodOutput);
		
		
		
		int result = Integer.parseInt(seatNoOutput);
		
		Seat seat = new Seat(result, seatTypeOutput, seatFoodOutput,  seatPrice, seatDescriptionOutput);
		jdbc.updateSeat(seat);
	
		System.out.println("Seat No: "+ seatNoOutput);
		System.out.println("Seat Type: "+ seatTypeOutput);
		System.out.println("Seat Food: "+ seatFoodOutput);
		System.out.println("Seat Description: "+ seatDescriptionOutput);
		((Node)(event.getSource())).getScene().getWindow().hide();
		
	}
	@FXML
	private void update_Exit(ActionEvent event) throws Exception{
		System.exit(0);		
	}
}

