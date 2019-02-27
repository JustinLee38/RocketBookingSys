package application;

import java.net.URL;
import java.util.ResourceBundle;

import controller.InsuranceJDBC;
import entity.Insurance;
import entity.Ticket;
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

public class InsuranceMaintenanceController implements Initializable {

	@FXML
	private AnchorPane rootPane;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
	@FXML
	private void openInsurance_Create (ActionEvent event) throws Exception{
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("CreateAInsurance.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = new Stage (StageStyle.DECORATED);
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.setTitle("Create Insurances");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.showAndWait();		
	}
	@FXML
	private void openInsurance_Update (ActionEvent event) throws Exception{
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("UpdateAInsurance.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = new Stage (StageStyle.DECORATED);
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.setTitle("Update Insurances");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.showAndWait();		
	}
	@FXML
	private void openInsurance_Delete (ActionEvent event) throws Exception{
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("DeleteAInsurance.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = new Stage (StageStyle.DECORATED);
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.setTitle("Delete Insurances");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();		
	}
	
	@FXML
	private void openInsurance_View (ActionEvent event) throws Exception{
		/*Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("ViewAInsurance.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = new Stage (StageStyle.DECORATED);
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.setTitle("View Insurances");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.showAndWait();	*/	
		
		TableView<Insurance> insTable;
		
		TableColumn<Insurance, Integer> insNoColumn = new TableColumn<>("Insurance No");
		insNoColumn.setMinWidth(50);
		insNoColumn.setCellValueFactory(new PropertyValueFactory<>("insNo"));

		TableColumn<Insurance,String> insurerColumn = new TableColumn<>("Insurer");
		insurerColumn.setMinWidth(100);
		insurerColumn.setCellValueFactory(new PropertyValueFactory<>("insurer"));

		TableColumn<Insurance,String> insNameColumn = new TableColumn<>("Product Name");
		insNameColumn.setMinWidth(100);
		insNameColumn.setCellValueFactory(new PropertyValueFactory<>("insName"));

		TableColumn<Insurance,Double> insPriceColumn = new TableColumn<>("Insurance Price");
		insPriceColumn.setMinWidth(50);
		insPriceColumn.setCellValueFactory(new PropertyValueFactory<>("insPrice"));

		TableColumn<Insurance,String> descColumn = new TableColumn<>("Description");
		descColumn.setMinWidth(150);
		descColumn.setCellValueFactory(new PropertyValueFactory<>("description"));


		insTable = new TableView<>();
		insTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		insTable.setItems(getInsurance());
		insTable.getColumns().addAll(insNoColumn, insurerColumn, insNameColumn, insPriceColumn, descColumn);

		VBox vBox = new VBox();
		vBox.getChildren().addAll(insTable);

		//		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		Scene scene = new Scene(vBox,1000,350);
		Stage primaryStage = new Stage (StageStyle.DECORATED);
		primaryStage.setTitle("View Insurance");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();		
	}
	
	public ObservableList<Insurance> getInsurance() {
		ObservableList <Insurance> insList = null;
		try {
			InsuranceJDBC jdbc = new InsuranceJDBC();
			insList = FXCollections.observableArrayList(jdbc.ViewAllInsurance());
		}catch(Exception e){
			e.printStackTrace();
		}
		return insList;
	}
}
