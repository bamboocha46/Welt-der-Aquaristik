package at.varga.java.welt_der_aquaristik.controller;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

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
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AddNewFishToListController extends BasicController {

	ObservableList<Socialization> fishSocializationList = FXCollections.observableArrayList(Socialization.values());

	// TextField for FishParameters
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
	private Button addPhotoButton;
	@FXML
	private TextField urlTextField;
	@FXML
	private ImageView photoImageView;



	@FXML
	private Button backButton;

	@FXML
	private Button saveButton;

	@FXML

	void handleSelectFileAction(ActionEvent event) throws URISyntaxException {
//		FileChooser fileChooser = new FileChooser();
//
//		fileChooser.setInitialDirectory(new File(getClass().getResource("/images").toURI()));
//
//		File file = fileChooser.showOpenDialog(addPhotoButton.getScene().getWindow());
//		if (file != null) {
//
//			Path p = Paths.get(file.getPath());
//
//			// create path relative from resources, prepending '/' necessary for
//			// getResource(...)
//			urlTextField.setText("/images/" + p.getFileName().toString());
//			Image image = new Image(getClass().getResourceAsStream(urlTextField.getText()));
//			photoImageView.setImage(image);
		System.err.println("feskgmkeg");

//		}
	}

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

		String path = Constants.PATH_TO_POP_UP_SAVE_FXML;
		String setTitel = "Speicherung";
		showNewScene(path, setTitel);

	}



	@FXML
	void back(ActionEvent event) {

		ActionEvent e = event;
		backToPrScene(e);
	}

}
