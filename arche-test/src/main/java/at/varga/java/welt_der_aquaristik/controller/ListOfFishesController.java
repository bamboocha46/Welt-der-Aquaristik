package at.varga.java.welt_der_aquaristik.controller;

import java.io.IOException;

import at.varga.java.welt_der_aquaristik.application.Constants;
import at.varga.java.welt_der_aquaristik.application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ListOfFishesController {

	// FishCastButtons
	@FXML
	private Button perchButton;
	@FXML
	private Button coldWaterFishButton;
	@FXML
	private Button anabasButton;
	@FXML
	private Button tetraButton;
	@FXML
	private Button viviparousButton;
	@FXML
	private Button ownFishButton;
	@FXML
	private Button catFishButton;
    @FXML
    private Button darioButton;

	@FXML
	private Button addNewFishButton;
	@FXML
	private Button backButton;

//	@FXML
//	private ChoiceBox testChoiceBox;
//	@FXML
//	private Button testButton;
//
//	String test1 = "Fish1";
//	String test2 = "Fish2";
//
//	// it is just for a GUI test
//	ObservableList<String> testList = FXCollections.observableArrayList(test1, test2);

	// method to create and add a new Fish to "List of fishes"
	// Doesent save any fishes yet


	@FXML
	void showPerches(ActionEvent event) {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource(Constants.PATH_TO_CAST_PERCH_FXML));
		AnchorPane showPerches = null;
		try {
			showPerches = loader.load();
		} catch (IOException e) {

			e.printStackTrace();
		}

		Stage perches = new Stage();
		perches.setTitle("Barsche");
		perches.initModality(Modality.WINDOW_MODAL);
		perches.initOwner(Main.primaryStage);

		Scene scene = new Scene(showPerches);
		perches.setScene(scene);
		perches.showAndWait();
	}

	@FXML
	void showAnabasses(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource(Constants.PATH_TO_CAST_ANABAS_FXML));
		AnchorPane showAnabesses = null;
		try {
			showAnabesses = loader.load();
		} catch (IOException e) {

			e.printStackTrace();
		}

		Stage anabas = new Stage();
		anabas.setTitle("Labyrinthfishe");
		anabas.initModality(Modality.WINDOW_MODAL);
		anabas.initOwner(Main.primaryStage);

		Scene scene = new Scene(showAnabesses);
		anabas.setScene(scene);
		anabas.showAndWait();

	}

	@FXML
	void showColdWaterFishes(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource(Constants.PATH_TO_COLDWATERFISH_FXML));
		AnchorPane showColdWaterFishes = null;
		try {
			showColdWaterFishes = loader.load();
		} catch (IOException e) {

			e.printStackTrace();
		}

		Stage coldwaterfishes = new Stage();
		coldwaterfishes.setTitle("Kaltwasserfishe");
		coldwaterfishes.initModality(Modality.WINDOW_MODAL);
		coldwaterfishes.initOwner(Main.primaryStage);

		Scene scene = new Scene(showColdWaterFishes);
		coldwaterfishes.setScene(scene);
		coldwaterfishes.showAndWait();

	}
	
	  @FXML
	    void showDarios(ActionEvent event) {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource(Constants.PATH_TO_COLDWATERFISH_FXML));
			AnchorPane showDarios = null;
			try {
				showDarios = loader.load();
			} catch (IOException e) {

				e.printStackTrace();
			}

			Stage darios = new Stage();
			darios.setTitle("Bärblinge");
			darios.initModality(Modality.WINDOW_MODAL);
			darios.initOwner(Main.primaryStage);

			Scene scene = new Scene(showDarios);
			darios.setScene(scene);
			darios.showAndWait();
	    }

	@FXML
	void showCatFishes(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource(Constants.PATH_TO_CAST_CATFISH_FXML));
		AnchorPane showCatFishes = null;
		try {
			showCatFishes = loader.load();
		} catch (IOException e) {

			e.printStackTrace();
		}

		Stage catfishes = new Stage();
		catfishes.setTitle("Welse");
		catfishes.initModality(Modality.WINDOW_MODAL);
		catfishes.initOwner(Main.primaryStage);

		Scene scene = new Scene(showCatFishes);
		catfishes.setScene(scene);
		catfishes.showAndWait();

	}

	@FXML
	void showViviparouses(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource(Constants.PATH_TO_CAST_VIVIPAROUS_FXML));
		AnchorPane showViviparousses = null;
		try {
			showViviparousses = loader.load();
		} catch (IOException e) {

			e.printStackTrace();
		}

		Stage viviparous = new Stage();
		viviparous.setTitle("Lebendgebärende");
		viviparous.initModality(Modality.WINDOW_MODAL);
		viviparous.initOwner(Main.primaryStage);

		Scene scene = new Scene(showViviparousses);
		viviparous.setScene(scene);
		viviparous.showAndWait();
	}


	@FXML
	void showTetras(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource(Constants.PATH_TO_CAST_TETRA_FXML));
		AnchorPane showTetras = null;
		try {
			showTetras = loader.load();
		} catch (IOException e) {

			e.printStackTrace();
		}

		Stage tetras = new Stage();
		tetras.setTitle("Salmler");
		tetras.initModality(Modality.WINDOW_MODAL);
		tetras.initOwner(Main.primaryStage);

		Scene scene = new Scene(showTetras);
		tetras.setScene(scene);
		tetras.showAndWait();
	}

	@FXML
	void showOwnFish(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource(Constants.PATH_TO_CAST_OWNFISH_FXML));
		AnchorPane showOwnFishes = null;
		try {
			showOwnFishes = loader.load();
		} catch (IOException e) {

			e.printStackTrace();
		}

		Stage ownFishes = new Stage();
		ownFishes.setTitle("Eigene Fishe");
		ownFishes.initModality(Modality.WINDOW_MODAL);
		ownFishes.initOwner(Main.primaryStage);

		Scene scene = new Scene(showOwnFishes);
		ownFishes.setScene(scene);
		ownFishes.showAndWait();
	}

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
	void back(ActionEvent event) {

		Stage currentStage = (Stage) ((Node) event.getTarget()).getScene().getWindow();
		currentStage.close();
	}

//	@FXML
//	private void initialize() {
//
//		testChoiceBox.setItems(testList);
//
//	}
//
//	// button to show an fishDatesheet
//	@FXML
//	void showTestFishDateSheet(ActionEvent event) {
//		testmethod();
//
//	}
//
//	// It just to Gui-Test
//	private void testmethod() {
//
//		if (testChoiceBox.getValue().equals(test1)) {
//
//			FXMLLoader loader = new FXMLLoader();
//			loader.setLocation(Main.class.getResource(Constants.PATH_TO_FISHDATESHEET_FXML));
//			AnchorPane fischDateSheet = null;
//			try {
//				fischDateSheet = loader.load();
//			} catch (IOException e) {
//
//				e.printStackTrace();
//			}
//
//			Stage showFoshDateSheet = new Stage();
//			showFoshDateSheet.setTitle(".getFishName");
//			showFoshDateSheet.initModality(Modality.WINDOW_MODAL);
//			showFoshDateSheet.initOwner(Main.primaryStage);
//
//			Scene scene = new Scene(fischDateSheet);
//			showFoshDateSheet.setScene(scene);
//			showFoshDateSheet.showAndWait();
//
//		} else if (testChoiceBox.getValue().equals(test2)) {
//			FXMLLoader loader = new FXMLLoader();
//			loader.setLocation(Main.class.getResource(Constants.PATH_TO_FISHDATESHEET_FXML));
//			AnchorPane fischDateSheet = null;
//			try {
//				fischDateSheet = loader.load();
//			} catch (IOException e) {
//
//				e.printStackTrace();
//			}
//
//			Stage showFoshDateSheet = new Stage();
//			showFoshDateSheet.setTitle(".getFishName");
//			showFoshDateSheet.initModality(Modality.WINDOW_MODAL);
//			showFoshDateSheet.initOwner(Main.primaryStage);
//
//			Scene scene = new Scene(fischDateSheet);
//			showFoshDateSheet.setScene(scene);
//			showFoshDateSheet.showAndWait();
//
//		}
//
//	}

}
