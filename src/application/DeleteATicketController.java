package application;

import java.net.URL;
import java.util.ResourceBundle;

import controller.FlightJDBC;
import controller.TicketJDBC;
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

public class DeleteATicketController implements Initializable {
	@FXML
	private ComboBox ticketNo;
	
	TicketJDBC jdbc;
	ObservableList <String> ticketNoList;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		try {
			jdbc = new TicketJDBC();
			ticketNoList = FXCollections.observableArrayList(jdbc.ViewAllTicketNo());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ticketNo.setValue("Select Ticket No");
		ticketNo.setItems(ticketNoList);
	}
	@FXML
	private void openTicketing_Delete (ActionEvent event) throws Exception{
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("DeleteATicket.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = new Stage (StageStyle.DECORATED);
		primaryStage.setTitle("Delete Tickets");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();		
	}

	public void printSelection(ActionEvent event) throws Exception {
		String ticketNoOutput = ticketNo.getSelectionModel().getSelectedItem().toString();
		
		jdbc.deleteTicket(ticketNoOutput);
		
		System.out.println("Delete: "+ticketNoOutput);
		((Node)(event.getSource())).getScene().getWindow().hide();
		
	}

}
