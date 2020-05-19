package at.varga.java.arche_test.controller;

import java.io.IOException;

import at.varga.java.arche_test.application.Constants;
import at.varga.java.arche_test.application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ListOfFishesController {

	@FXML
	private Button addNewFishButton;

	@FXML
	private ChoiceBox testChoiceBox;
	@FXML
	private Button testButton;

	String test1 = "Fish1";
	String test2 = "Fish2";

	//it is just for a GUI test
	ObservableList<String> testList = FXCollections.observableArrayList(test1, test2);

	// method to create and add a new Fish to "List of fishes"
	@FXML
	void creadAndAddNewFishToList(ActionEvent event) {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource(Constants.PATH_TO_ADDNEWFISHTOLIST_FXML));
		AnchorPane addNewFishToList = null;
		try {
			addNewFishToList = loader.load();
		} catch (IOException e) {

			e.printStackTrace();
		}

		Stage createNewFishWindow = new Stage();
		createNewFishWindow.setTitle("Neuen Fisch zur Liste hinzufügen");
		createNewFishWindow.initModality(Modality.WINDOW_MODAL);
		createNewFishWindow.initOwner(Main.primaryStage);

		Scene scene = new Scene(addNewFishToList);
		createNewFishWindow.setScene(scene);
		createNewFishWindow.showAndWait();

	}

	@FXML
	private void initialize() {

		testChoiceBox.setItems(testList);

	}

	// button to show an fishDatesheet
	@FXML
	void showTestFishDateSheet(ActionEvent event) {
		testmethod();

	}

	//It just to Gui-Test
	private void testmethod() {

		if (testChoiceBox.getValue().equals(test1)) {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource(Constants.PATH_TO_FISHDATESHEET_FXML));
			AnchorPane fischDateSheet = null;
			try {
				fischDateSheet = loader.load();
			} catch (IOException e) {

				e.printStackTrace();
			}

			Stage showFoshDateSheet = new Stage();
			showFoshDateSheet.setTitle(".getFishName");
			showFoshDateSheet.initModality(Modality.WINDOW_MODAL);
			showFoshDateSheet.initOwner(Main.primaryStage);

			Scene scene = new Scene(fischDateSheet);
			showFoshDateSheet.setScene(scene);
			showFoshDateSheet.showAndWait();

		} else if (testChoiceBox.getValue().equals(test2)) {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource(Constants.PATH_TO_FISHDATESHEET_FXML));
			AnchorPane fischDateSheet = null;
			try {
				fischDateSheet = loader.load();
			} catch (IOException e) {

				e.printStackTrace();
			}

			Stage showFoshDateSheet = new Stage();
			showFoshDateSheet.setTitle(".getFishName");
			showFoshDateSheet.initModality(Modality.WINDOW_MODAL);
			showFoshDateSheet.initOwner(Main.primaryStage);

			Scene scene = new Scene(fischDateSheet);
			showFoshDateSheet.setScene(scene);
			showFoshDateSheet.showAndWait();

		}

	}

}
