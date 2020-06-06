package at.varga.java.welt_der_aquaristik.controller;

import java.io.IOException;

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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class AddNewFishToListController {

	ObservableList<Socialization> fishSocializationList = FXCollections.observableArrayList(Socialization.values());

	@FXML
	private TextField minGhTextField;

	@FXML
	private TextField minPhTextField;

	@FXML
	private TextField castFinalTextField;

	@FXML
	private TextField sizeTextField;

	@FXML
	private TextField breedTextField;

	@FXML
	private TextField minTemperaturTextField;

	@FXML
	private TextField maxPhTextField;

	@FXML
	private TextField aqMaxVolumenTextField;

	@FXML
	private TextField aqMinVolumenTextField;

	@FXML
	private TextField maxGhTextField;

	@FXML
	private TextField maxTemperaturTextField;

	@FXML
	private ComboBox<Socialization> socializationComboBox;

	@FXML
	private Button backButton;

	@FXML
	private Button saveButton;

	// doesnt save yet
	// just show popUp: SaveMessage

	@FXML
	private void initialize() {
		socializationComboBox.setValue(Socialization.AGRESSIV);
		socializationComboBox.setItems(fishSocializationList);

	}

	@FXML
	void save(ActionEvent event) {

		FishType saved = new FishType();

		saved.setCast(Cast.EIGENE_FISCH);
		saved.setBreed(breedTextField.getText());
		saved.setSize(Double.valueOf(sizeTextField.getText()));
		saved.setMinAqVolumen(Double.valueOf(aqMinVolumenTextField.getText()));
		saved.setMaxAqVolumen(Double.valueOf(aqMaxVolumenTextField.getText()));
		saved.setMinTemperatur(Float.valueOf(minTemperaturTextField.getText()));
		saved.setMaxTemperatur(Float.valueOf(maxTemperaturTextField.getText()));
		saved.setMinPh(Float.valueOf(minPhTextField.getText()));
		saved.setMaxPh(Float.valueOf(maxPhTextField.getText()));
		saved.setMinGH(Integer.valueOf(minGhTextField.getText()));
		saved.setMaxGH(Integer.valueOf(maxGhTextField.getText()));
		saved.setSocialization(socializationComboBox.getValue());

		System.err.println(saved);

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

}
