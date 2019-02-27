package application;

import java.net.URL;
import java.util.ResourceBundle;

import controller.FlightJDBC;
import entity.Flight;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SessionMaintenanceController implements Initializable {
	
	@FXML
	private AnchorPane rootPane;
	
	TableView<Flight> flightTable;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
	@FXML
	private void openSession_Create (ActionEvent event) throws Exception{
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("createASession.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = new Stage (StageStyle.DECORATED);
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.setTitle("Create A Session");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.showAndWait();		
	}
	
	@FXML
	private void openSession_Update (ActionEvent event) throws Exception{
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("UpdateASession.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = new Stage (StageStyle.DECORATED);
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.setTitle("Update A Session");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.showAndWait();		
	}
	@FXML
	private void openSession_Delete (ActionEvent event) throws Exception{
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("DeleteASession.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = new Stage (StageStyle.DECORATED);
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.setTitle("Delete A Session");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.showAndWait();		
	}
	@FXML
	private void openSession_View (ActionEvent event) throws Exception{
		/*Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("ViewASession.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = new Stage (StageStyle.DECORATED);
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.setTitle("View a Session");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.showAndWait();		*/
		TableColumn<Flight, Integer> flightNoColumn = new TableColumn<>("FlightNo");
		flightNoColumn.setMinWidth(50);
		flightNoColumn.setCellValueFactory(new PropertyValueFactory<>("flightNo"));
		
		TableColumn<Flight,String> originColumn = new TableColumn<>("Origin");
		originColumn.setMinWidth(100);
		originColumn.setCellValueFactory(new PropertyValueFactory<>("origin"));
		
		TableColumn<Flight,String> destinationColumn = new TableColumn<>("Destination");
		destinationColumn.setMinWidth(100);
		destinationColumn.setCellValueFactory(new PropertyValueFactory<>("destination"));
		
		TableColumn<Flight,String> departureDateColumn = new TableColumn<>("Departure Date");
		departureDateColumn.setMinWidth(150);
		departureDateColumn.setCellValueFactory(new PropertyValueFactory<>("departureTime"));
		
		TableColumn<Flight,String> arrivalDateColumn = new TableColumn<>("Arrival Date");
		arrivalDateColumn.setMinWidth(150);
		arrivalDateColumn.setCellValueFactory(new PropertyValueFactory<>("arrivalTime"));
		
		
		flightTable = new TableView<>();
		flightTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		flightTable.setItems(getFlight());
		flightTable.getColumns().addAll(flightNoColumn, originColumn, destinationColumn,departureDateColumn, arrivalDateColumn);
		
		VBox vBox = new VBox();
		vBox.getChildren().addAll(flightTable);
		
//		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
 
		Scene scene = new Scene(vBox);
		Stage primaryStage = new Stage (StageStyle.DECORATED);
		primaryStage.setTitle("View a Session");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();		
		
		
	}
	public ObservableList<Flight> getFlight() {
		ObservableList <Flight> flightList = null;
		try {
			FlightJDBC jdbc = new FlightJDBC();
			flightList = FXCollections.observableArrayList(jdbc.ViewAllFlight());
			
			}catch(Exception e){
				e.printStackTrace();
			}
		return flightList;
	}
}
