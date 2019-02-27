package application;

import java.net.URL;
import java.util.ResourceBundle;

import controller.FlightJDBC;
import controller.SeatJDBC;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DeleteASeatController implements Initializable{
	@FXML
	private ComboBox seatNo;
	SeatJDBC jdbc;
	Seat seat;
	
	ObservableList <String> seatNoList ;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		try {
			jdbc = new SeatJDBC();
			seatNoList = FXCollections.observableArrayList(jdbc.ViewAllSeatNo());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		seatNo.setValue("Select Seat No");
		seatNo.setItems(seatNoList);
	}
	@FXML
	private void openSeating_Delete (ActionEvent event) throws Exception{
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("DeleteASeat.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = new Stage (StageStyle.DECORATED);
		primaryStage.setTitle("Delete a Seat");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();		
	}
	public void printSelection(ActionEvent event) throws Exception {
		String seatNoOutput = seatNo.getSelectionModel().getSelectedItem().toString();
		
		jdbc.deleteSeat(seatNoOutput);
		
		System.out.println("Seat No: "+seatNoOutput);
		((Node)(event.getSource())).getScene().getWindow().hide();
		
	}
}

