package application;

import java.net.URL;
import java.util.ResourceBundle;

import controller.InsuranceJDBC;
import controller.SeatJDBC;
import entity.Insurance;
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

public class DeleteAInsuranceController implements Initializable{
	
	@FXML
	private ComboBox insNo;
	InsuranceJDBC jdbc;
	Insurance ins;
	
	ObservableList <String> insNoList;

	
	
	@FXML
	private AnchorPane rootPane;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		try {
			jdbc = new InsuranceJDBC();
			insNoList = FXCollections.observableArrayList(jdbc.ViewAllInsNo());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		insNo.setValue("Select Insurance No");
		insNo.setItems(insNoList);

	
	}
	@FXML
	private void openInsurance_Delete (ActionEvent event) throws Exception{
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("DeleteAInsurance.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = new Stage (StageStyle.DECORATED);
		primaryStage.setTitle("Delete Insurances");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();		
	}
	public void printSelection(ActionEvent event) throws Exception {
		String insNoOutput = insNo.getSelectionModel().getSelectedItem().toString();
		
		jdbc.deleteInsurance(insNoOutput);
		
		System.out.println(insNoOutput+ " is Ins No");
		
		((Node)(event.getSource())).getScene().getWindow().hide();
		
	}
}

