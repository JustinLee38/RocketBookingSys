package application;

import java.net.URL;
import java.util.ResourceBundle;

import controller.FlightJDBC;
import controller.InsuranceJDBC;
import controller.SeatJDBC;
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
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Seat_ViewSeatingController implements Initializable {
	@FXML
	Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16;
	@FXML
	Button b1a,b2a,b3a,b4a,b5a,b6a,b7a,b8a,b9a,b10a,b11a,b12a,b13a,b14a,b15a,b16a;
	String seat;
	SeatJDBC jdbc;
	ObservableList <String> seatNoList;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			jdbc = new SeatJDBC();
			
			seatNoList = FXCollections.observableArrayList(jdbc.ViewAllSeatNo());
			}catch(Exception e) {
				e.printStackTrace();
			}
		System.out.println("Hello");
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
	private void Seat_ViewSeating (ActionEvent event) throws Exception{
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Seat_ViewSeating.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = new Stage (StageStyle.DECORATED);
		primaryStage.setTitle("View seats");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();		
	}
	@FXML
	private void hideB1(ActionEvent event) throws Exception{
		b1.setVisible(false);
		seat ="Seat 1";
		System.out.println("Seat selected is "+ seat);

	}
	@FXML
	private void hideB2(ActionEvent event) throws Exception{
		b2.setVisible(false);
		seat ="Seat 2";
		System.out.println("Seat selected is "+ seat);

	}
	@FXML
	private void hideB3(ActionEvent event) throws Exception{
		b3.setVisible(false);
		seat ="Seat 3";
		System.out.println("Seat selected is "+ seat);

	}
	@FXML
	private void hideB4(ActionEvent event) throws Exception{
		b4.setVisible(false);
		seat ="Seat 4";
		System.out.println("Seat selected is "+ seat);

	}
	@FXML
	private void hideB5(ActionEvent event) throws Exception{
		b5.setVisible(false);
		seat ="Seat 5";
		System.out.println("Seat selected is "+ seat);

	}
	@FXML
	private void hideB6(ActionEvent event) throws Exception{
		b6.setVisible(false);
		seat ="Seat 6";
		System.out.println("Seat selected is "+ seat);

	}
	@FXML
	private void hideB7(ActionEvent event) throws Exception{
		b7.setVisible(false);
		seat ="Seat 7";
		System.out.println("Seat selected is "+ seat);

	}
	@FXML
	private void hideB8(ActionEvent event) throws Exception{
		b8.setVisible(false);
		seat ="Seat 8";
		System.out.println("Seat selected is "+ seat);

	}
	@FXML
	private void hideB9(ActionEvent event) throws Exception{
		b9.setVisible(false);
		seat ="Seat 9";
		System.out.println("Seat selected is "+ seat);

	}
	@FXML
	private void hideB10(ActionEvent event) throws Exception{
		b10.setVisible(false);
		seat ="Seat 10";
		System.out.println("Seat selected is "+ seat);

	}
	@FXML
	private void hideB11(ActionEvent event) throws Exception{
		b11.setVisible(false);
		seat ="Seat 11";
		System.out.println("Seat selected is "+ seat);

	}
	@FXML
	private void hideB12(ActionEvent event) throws Exception{
		b12.setVisible(false);
		seat ="Seat 12";
		System.out.println("Seat selected is "+ seat);

	}
	@FXML
	private void hideB13(ActionEvent event) throws Exception{
		b13.setVisible(false);
		seat ="Seat 13";
		System.out.println("Seat selected is "+ seat);

	}
	@FXML
	private void hideB14(ActionEvent event) throws Exception{
		b14.setVisible(false);
		seat ="Seat 14";
		System.out.println("Seat selected is "+ seat);

	}
	@FXML
	private void hideB15(ActionEvent event) throws Exception{
		b15.setVisible(false);
		seat ="Seat 15";
		System.out.println("Seat selected is "+ seat);

	}
	@FXML
	private void hideB16(ActionEvent event) throws Exception{
		b16.setVisible(false);
		seat ="Seat 16";
		System.out.println("Seat selected is "+ seat);

	}
	@FXML
	private void hideB1a(){
		b1a.setVisible(false);

	}
	@FXML
	private void hideB2a(){
		b2a.setVisible(false);

	}
	@FXML
	private void hideB3a(){
		b3a.setVisible(false);

	}
	@FXML
	private void hideB4a(){
		b4a.setVisible(false);

	}
	@FXML
	private void hideB5a(){
		b5a.setVisible(false);

	}
	@FXML
	private void hideB6a(){
		b6a.setVisible(false);

	}
	@FXML
	private void hideB7a(){
		b7a.setVisible(false);

	}
	@FXML
	private void hideB8a(){
		b8a.setVisible(false);

	}

	@FXML
	private void hideB9a() {
		b9a.setVisible(false);

	}
	@FXML
	private void hideB10a() {
		b10a.setVisible(false);

	}
	@FXML
	private void hideB11a() {
		b11a.setVisible(false);

	}
	@FXML
	private void hideB12a(){
		b12a.setVisible(false);

	}
	@FXML
	private void hideB13a(){
		b13a.setVisible(false);

	}
	@FXML
	private void hideB14a() {
		b14a.setVisible(false);

	}
	@FXML
	private void hideB15a() {
		b15a.setVisible(false);

	}
	@FXML
	private void hideB16a() {
		b16a.setVisible(false);

	}
	@FXML
	private void seatSelected(ActionEvent event) throws Exception {
		((Node)(event.getSource())).getScene().getWindow().hide();

	}
	
}

