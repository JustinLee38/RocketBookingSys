package application;

import java.net.URL;
import java.util.ResourceBundle;

import controller.InsuranceJDBC;
import entity.Insurance;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CreateAInsuranceController implements Initializable{

	@FXML
	private ComboBox insurer,insName;
	Insurance ins;
	InsuranceJDBC jdbc;
	ObservableList <String> insurerList;
	ObservableList <String> insNameList;
	String msg;
	Stage stage;


	@FXML
	private AnchorPane rootPane;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ins = new Insurance();
		insurerList = FXCollections.observableArrayList(ins.defaultInsurer());
		insNameList = FXCollections.observableArrayList(ins.defaultInsName());

		insurer.setValue("Select Insurer");
		insurer.setItems(insurerList);

		insName.setValue("Select Insurance Name");
		insName.setItems(insNameList);


	}
	@FXML
	private void openInsurance_Create (ActionEvent event) throws Exception{
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("CreateAInsurance.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = new Stage (StageStyle.DECORATED);
		primaryStage.setTitle("Create Insurances");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();		
	}
	public void printSelection(ActionEvent event) throws Exception {
		String insurerOutput = insurer.getSelectionModel().getSelectedItem().toString();
		String insNameOutput = insName.getSelectionModel().getSelectedItem().toString();
		jdbc = new InsuranceJDBC();

		boolean validate = jdbc.insuranceValidation(insurerOutput, insNameOutput);

		if(!validate) {

			double price = ins.insPrice(insNameOutput);
			String insDesc = ins.insDesc(insNameOutput);

			//insNo Validation
			int insNo = jdbc.insNoValidation();
			Insurance ins = new Insurance(insNo, insurerOutput, insNameOutput, insDesc, price);
			jdbc.addInsurance(ins);
			System.out.println(insurerOutput+ " is Insurer");
			System.out.println(insNameOutput+ " is Insurance Name");
			
		}else {
			DisplayMessageUI("Error! This Plan Already Exist!");
			
		}
		((Node)(event.getSource())).getScene().getWindow().hide();

		

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

