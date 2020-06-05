package at.varga.java.welt_der_aquaristik.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import at.varga.java.welt_der_aquaristik.application.Constants;
import at.varga.java.welt_der_aquaristik.application.Main;
import at.varga.java.welt_der_aquaristik.model.Cast;
import at.varga.java.welt_der_aquaristik.model.FishType;
import at.varga.java.welt_der_aquaristik.model.Socialization;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddNewFishToAQController {

	// FishTypes as examples
	FishType fishFirst = new FishType(1, "Neon", 5, 120, 1000, 23, 28, 5f, 7.5f, 2, 20, "", Socialization.GROUP,
			Cast.SALMLER);
	FishType fishSecond = new FishType(2, "Betta", 7, 30, 100, 24, 30, 5.5f, 7.5f, 2, 20, "", Socialization.SEPARETE,
			Cast.LABYRINTHFISH);
	FishType fishThird = new FishType(3, "Skalar", 15, 150, 1000, 24, 28, 5.5f, 7.2f, 2, 15, "",
			Socialization.AGGRESSIVE, Cast.BARSCH);

	private List<FishType> fishTypeFromDB = new ArrayList<FishType>();
	ObservableList<String> fishBreedList = FXCollections.observableArrayList(fishFirst.getBreed(),
			fishSecond.getBreed(), fishThird.getBreed());


	@FXML
	private ComboBox<String> perchComboBox;

	@FXML
	private ComboBox<String> catFishComboBox;

	@FXML
	private ComboBox<String> anabasComboBox;

	@FXML
	private ComboBox<String> coldWaterFishComboBox;

	@FXML
	private ComboBox<String> darioComboBox;

	@FXML
	private Button breakButton;

	@FXML
	private ComboBox<String> otherFishComboBox;

	@FXML
	private Button saveButton;

	@FXML
	private ComboBox<String> tetraComboBox;

	@FXML
	private ComboBox<String> viviparousComboBox;

	@FXML
	private TextField pieceOfFisches;

	@FXML
	void save(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource(Constants.PATH_TO_POP_UP_SAVE_FXML));
		AnchorPane popUpSaveMessage = null;
		try {
			popUpSaveMessage = loader.load();
		} catch (IOException e) {

			e.printStackTrace();
		}

		Stage puSave = new Stage();
		puSave.setTitle("Speicherung");
		puSave.initModality(Modality.WINDOW_MODAL);
		puSave.initOwner(Main.primaryStage);

		Scene scene = new Scene(popUpSaveMessage);
		puSave.setScene(scene);
		puSave.showAndWait();

	}

	@FXML
	void back(ActionEvent event) {
		Stage currentStage = (Stage) ((Node) event.getTarget()).getScene().getWindow();
		currentStage.close();
	}

	@FXML
	void choosePerch(ActionEvent event) {

	}

	@FXML
	void chooseColdWaterFish(ActionEvent event) {

	}

	@FXML
	void chooseViviparous(ActionEvent event) {

	}

	@FXML
	void chooseCatFish(ActionEvent event) {

	}

	@FXML
	void chooseDario(ActionEvent event) {

	}

	@FXML
	void chooseAnabas(ActionEvent event) {

		
	}

	@FXML
	void choosetetra(ActionEvent event) {

	}

	@FXML
	void chooseOtherFish(ActionEvent event) {

	}
	

	@FXML
	private void initialize() {

		fishTypeFromDB.add(fishFirst);
		fishTypeFromDB.add(fishSecond);
		fishTypeFromDB.add(fishThird);
		
		anabasComboBox.setValue(fishFirst.getBreed());
		anabasComboBox.setItems(fishBreedList);

		

	}

}

//import java.io.IOException;
//
//import at.varga.java.welt_der_aquaristik.application.Constants;
//import at.varga.java.welt_der_aquaristik.application.Main;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Node;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.AnchorPane;
//import javafx.stage.Modality;
//import javafx.stage.Stage;
//
//public class AddNewFishToAQController {
//
//	@FXML
//	private Button breakButton;
//
//	@FXML
//	private Button saveButton;
//
//	@FXML
//	private TextField pieceOfFisches;
//
//	// back to AQ datesheet window
//	@FXML
//	void back(ActionEvent event) throws IOException {
//		Stage currentStage = (Stage) ((Node) event.getTarget()).getScene().getWindow();
//		currentStage.close();
//
//	}
//
//	// doesnt save yet
//	// just show popUp: SaveMessage
//	@FXML
//	void save(ActionEvent event) {
//
//		FXMLLoader loader = new FXMLLoader();
//		loader.setLocation(Main.class.getResource(Constants.PATH_TO_PUSAVE_FXML));
//		AnchorPane popUpSaveMessage = null;
//		try {
//			popUpSaveMessage = loader.load();
//		} catch (IOException e) {
//
//			e.printStackTrace();
//		}
//
//		Stage puSave = new Stage();
//		puSave.setTitle("Speicherung");
//		puSave.initModality(Modality.WINDOW_MODAL);
//		puSave.initOwner(Main.primaryStage);
//
//		Scene scene = new Scene(popUpSaveMessage);
//		puSave.setScene(scene);
//		puSave.showAndWait();
//
//	}
//
//}
