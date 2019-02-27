package application;

import java.net.URL;
import java.util.ResourceBundle;

import controller.SeatJDBC;
import entity.Seat;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CreateASeatController implements Initializable{

	@FXML
	private ComboBox seatType,seatFood,seatDescription;
	Seat seat;
	SeatJDBC jdbc;
	ObservableList <String> seatTypeList;
	ObservableList <String> seatFoodList;
	ObservableList <String> seatDescList;
	String msg;
	Stage stage;


	@FXML
	private AnchorPane rootPane;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		seat = new Seat();
		seatTypeList = FXCollections.observableArrayList(seat.defaultSeatType());
		seatFoodList = FXCollections.observableArrayList(seat.defaultSeatFood());
		seatDescList = FXCollections.observableArrayList(seat.defaultSeatDescription());


		seatType.setValue("Select Seat Type");
		seatType.setItems(seatTypeList);

		seatFood.setValue("Select Seat Food");
		seatFood.setItems(seatFoodList);

		seatDescription.setValue("Select Description");
		seatDescription.setItems(seatDescList);
	}
	@FXML
	private void openSeat_Create (ActionEvent event) throws Exception{
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("CreateASeat.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = new Stage (StageStyle.DECORATED);
		primaryStage.setTitle("Create a Seat");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();		
	}
	public void printSelection(ActionEvent event) throws Exception {
		jdbc = new SeatJDBC();
		String seatTypeOutput = seatType.getSelectionModel().getSelectedItem().toString();
		String seatFoodOutput = seatFood.getSelectionModel().getSelectedItem().toString();
		String seatDescriptionOutput = seatDescription.getSelectionModel().getSelectedItem().toString();
		double seatPrice = seat.seatPrice(seatFoodOutput);

		//Seat validation
		int seatNo =  jdbc.seatNoValidation();

		boolean seatValidation = jdbc.seatValidation();
		if(seatValidation) {

			Seat seat = new Seat(seatNo, seatTypeOutput, seatFoodOutput, seatPrice, seatDescriptionOutput);

			jdbc.addSeat(seat);


			System.out.println("Seat type: "+seatTypeOutput);
			System.out.println("Seat food: "+seatFoodOutput);
			System.out.println("Seat description"+seatDescriptionOutput);


		}else {
			DisplayMessageUI ("Error! You can only create a maximum of 16 Seats.");
		}
		
		((Node)(event.getSource())).getScene().getWindow().hide();
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
		/*URL resource = getClass().getClassLoader().getResource( "img/WhiteBishop.png" );
		String source= "/resources/Video2.mp4";*/
		Media media = new Media(getClass().getResource("/resources/Video2.mp4").toExternalForm());

		// Create the player and set to play automatically.
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setAutoPlay(true);

		// Create the view and add it to the Scene.
		MediaView mediaView = new MediaView(mediaPlayer);
		((Group) scene.getRoot()).getChildren().add(mediaView);
		primaryStage.show();		


	}

	public void DisplayMessageUI (String msg) {
		this.msg = msg;
		Label lb = new Label(msg);
		Button btOK = new Button("Ok");
		btOK.setOnAction(event->stage.close());
		FlowPane flow = new 
				FlowPane(Orientation.VERTICAL, 10, 10, lb, btOK);
		flow.setAlignment(Pos.CENTER);		
		Scene scene = new Scene(flow, 350, 175);
		stage = new Stage();
		stage.setTitle("Message");
		stage.setScene(scene);
		stage.show();		
	}

}


