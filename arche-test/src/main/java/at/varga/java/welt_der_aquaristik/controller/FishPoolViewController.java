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

public class FishPoolViewController extends BasicController {

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
	private Button otherFishButton;
	@FXML
	private Button catFishButton;
	@FXML
	private Button darioButton;

	@FXML
	private Button backButton;

	@FXML
	void showPerches(ActionEvent event) {
		String path = Constants.PATH_TO_CAST_PERCH_FXML;
		String setTitel = "Barsche";

		showNewScene(path, setTitel);
	}

	@FXML
	void showAnabasses(ActionEvent event) {

		String path = Constants.PATH_TO_CAST_ANABAS_FXML;
		String setTitel = "Labyrinthfishe";

		showNewScene(path, setTitel);

	}

	@FXML
	void showColdWaterFishes(ActionEvent event) {
		String path = Constants.PATH_TO_CAST_ANABAS_FXML;
		String setTitel = "Kaltwasserfishe";

		showNewScene(path, setTitel);

	}

	// !!!!! DarioPath funktioniert nicht, überprüfen!!!!
	@FXML
	void showDarios(ActionEvent event) {
		String path = Constants.PATH_TO_CAST_ANABAS_FXML;
		String setTitel = "Bärblinge";

		showNewScene(path, setTitel);

	}

	@FXML
	void showCatFishes(ActionEvent event) {
		String path = Constants.PATH_TO_CAST_ANABAS_FXML;
		String setTitel = "Welse";

		showNewScene(path, setTitel);

	}

	@FXML
	void showViviparouses(ActionEvent event) {
		String path = Constants.PATH_TO_CAST_VIVIPAROUS_FXML;
		String setTitel = "Lebendgebärende";

		showNewScene(path, setTitel);

	}

	@FXML
	void showTetras(ActionEvent event) {
		String path = Constants.PATH_TO_CAST_TETRA_FXML;
		String setTitel = "Salmler";

		showNewScene(path, setTitel);

	}

	@FXML
	void showOtherFish(ActionEvent event) {
		String path = Constants.PATH_TO_CAST_OTHERFISH_FXML;
		String setTitel = "Andere Fishe";

		showNewScene(path, setTitel);

	}

	@FXML
	void back(ActionEvent event) {

		ActionEvent e = event;
		backToPrScene(e);
	}

}
