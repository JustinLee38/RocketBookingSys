package application;
	
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import controller.FlightJDBC;
import entity.Flight;


public class ViewASession extends Application {
	//@Override
	
	TableView<Flight> flightTable;
	public void start(Stage primaryStage) {
		try {
			//Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("ViewASession.fxml"));
			
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
			
			Scene scene = new Scene(vBox);
			primaryStage.setTitle("View A Session");
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();		
	//		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	 
		} catch(Exception e) {
			e.printStackTrace();
		}
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
	
	public static void main(String[] args) {
		
		launch(args);
	}
}
