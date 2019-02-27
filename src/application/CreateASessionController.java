package application;


import java.net.URL;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import controller.FlightJDBC;
import entity.Flight;


public class CreateASessionController implements Initializable{
	  
	
	@FXML
	private ComboBox origin,destination,departureDate;
	ObservableList <String> originList;
	Flight flight;
	ObservableList <String> destinationList;

	ObservableList <String> departureDateList;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		flight = new Flight();
		originList = FXCollections.observableArrayList(flight.defaultOriginList());
		destinationList = FXCollections.observableArrayList(flight.defaultDestinationList());
		departureDateList = FXCollections.observableArrayList(flight.defaultDepartureDate());
		
		origin.setValue("Select Origin");
		origin.setItems(originList);
		
		destination.setValue("Select destination");
		destination.setItems(destinationList);
		
		departureDate.setValue("Select Departure Date");
		departureDate.setItems(departureDateList);
		
	}  
public void printSelection(ActionEvent event) throws Exception {
	String originOutput = origin.getSelectionModel().getSelectedItem().toString();
	String destinationOutput = destination.getSelectionModel().getSelectedItem().toString();
	String departureDateOutput = departureDate.getSelectionModel().getSelectedItem().toString();
	String arrivalDate = null;
	
	FlightJDBC jdbc = new FlightJDBC();
	int flightNo = jdbc.flightNoValidation();
	
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	try {
	    //startDate = df.parse(departureDateOutput);
	    java.util.Date utilDepartureDate = df.parse(departureDateOutput);
	    java.sql.Date sql_StartDate = new java.sql.Date( utilDepartureDate.getTime() );
	    Calendar c = Calendar.getInstance();
		c.setTime(utilDepartureDate); 
		c.add(Calendar.DATE, 360); // Adding 5 days
		arrivalDate = df.format(c.getTime());
		
	} catch (ParseException e) {
	    e.printStackTrace();
	}
	
	Flight flight = new Flight(flightNo, originOutput , destinationOutput, departureDateOutput, arrivalDate);
	jdbc.addFlight(flight);
	
	
	System.out.println("Origin: "+originOutput);
	System.out.println("Destination: "+destinationOutput);
	System.out.println("Departure Date: "+departureDateOutput);
	((Node)(event.getSource())).getScene().getWindow().hide();
	
}
	
	
	@FXML
	private void openSession_Create (ActionEvent event) throws Exception{
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("createASession.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = new Stage (StageStyle.DECORATED);
		primaryStage.setTitle("Create A Session");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();		
	
		
	}
@FXML
private void playVideo(ActionEvent event) throws Exception{
	Scene scene = new Scene(new Group(), 1250,700);
	Stage primaryStage = new Stage (StageStyle.DECORATED);
    primaryStage.setScene(scene);

    // Name and display the Stage.
    primaryStage.setTitle("Hello Media");
    primaryStage.show();

	primaryStage.setTitle("Mars and Moon");
	primaryStage.setScene(scene);
	 // Create the media source.
	//String source= "file:/C:/Users/Samuel/Desktop/Programming/Assignment2Final/src/resources/Video1.mp4";
    Media media = new Media(getClass().getResource("/resources/Video1.mp4").toExternalForm());

    // Create the player and set to play automatically.
    MediaPlayer mediaPlayer = new MediaPlayer(media);
    mediaPlayer.setAutoPlay(true);

    // Create the view and add it to the Scene.
    MediaView mediaView = new MediaView(mediaPlayer);
    ((Group) scene.getRoot()).getChildren().add(mediaView);
	primaryStage.show();		
}
}
