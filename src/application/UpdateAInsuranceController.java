package application;

import java.net.URL;
import java.util.ResourceBundle;

import controller.InsuranceJDBC;
import controller.SeatJDBC;
import entity.Insurance;
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

public class UpdateAInsuranceController implements Initializable{
	
	@FXML
	private ComboBox insNo,insurer,insName;
	Insurance ins;
	InsuranceJDBC jdbc;
	ObservableList <String> insNoList;
	ObservableList <String> insurerList;
	ObservableList <String> insNameList;

	
	
	@FXML
	private AnchorPane rootPane;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			jdbc = new InsuranceJDBC();
			insNoList = FXCollections.observableArrayList(jdbc.ViewAllInsNo());
		} catch (Exception e) {
			e.printStackTrace();
		}
		ins = new Insurance();
		insurerList = FXCollections.observableArrayList(ins.defaultInsurer());
		insNameList = FXCollections.observableArrayList(ins.defaultInsName());
		
		insNo.setValue("Select Insurance No");
		insNo.setItems(insNoList);
		
		insurer.setValue("Select Insurer");
		insurer.setItems(insurerList);
		
		insName.setValue("Select Insurance Name");
		insName.setItems(insNameList);
		
	
	}
	@FXML
	private void openInsurance_Update (ActionEvent event) throws Exception{
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("UpdateAInsurance.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = new Stage (StageStyle.DECORATED);
		primaryStage.setTitle("Update Insurances");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();		
	}
	public void printSelection(ActionEvent event) throws Exception {
		String insNoOutput = insNo.getSelectionModel().getSelectedItem().toString();
		String insurerOutput = insurer.getSelectionModel().getSelectedItem().toString();
		String insNameOutput = insName.getSelectionModel().getSelectedItem().toString();
		double price = ins.insPrice(insNameOutput);
		String desc = ins.insDesc(insNameOutput);
		
		
		int result = Integer.parseInt(insNoOutput);
		Insurance ins = new Insurance(result,insurerOutput,insNameOutput,desc,price);
		jdbc.updateInsurance(ins);
		
		System.out.println(insNoOutput+ " is Ins No");
		System.out.println(insurerOutput+ " is Insurer");
		System.out.println(insNameOutput+ " is Insurance Name");
	
		
		((Node)(event.getSource())).getScene().getWindow().hide();
		
	}
}

