package at.varga.java.welt_der_aquaristik.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.sun.prism.paint.Color;

import at.varga.java.welt_der_aquaristik.application.Constants;
import at.varga.java.welt_der_aquaristik.application.Main;
import at.varga.java.welt_der_aquaristik.model.Cast;
import at.varga.java.welt_der_aquaristik.model.FishType;
import at.varga.java.welt_der_aquaristik.model.FishTypeInAQ;
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

public class CastAnabasController {

	//FishTypes as examples
	FishType fishFirst = new FishType(1, "Neon", 5, 120, 1000, 23, 28, 5f, 7.5f, 2, 20, "", Socialization.GROUP,
			Cast.SALMLER);
	FishType fishSecond = new FishType(2, "Betta", 7, 30, 100, 24, 30, 5.5f, 7.5f, 2, 20, "", Socialization.SEPARETE,
			Cast.LABYRINTHFISH);
	FishType fishThird = new FishType(3, "Skalar", 15, 150, 1000, 24, 28, 5.5f, 7.2f, 2, 15, "",
			Socialization.AGGRESSIVE, Cast.BARSCH);

	private List<FishType> fishTypeFromDB = new ArrayList<FishType>();

	@FXML
	private ComboBox<String> fishTypeComboBox;

	@FXML
	private Button backButton;

	@FXML
	private Button fishTypeShowButton;
	//FishParametersTextFields
	@FXML
	private TextField sizeTextField;

	@FXML
	private TextField aqSizeTextField;

	@FXML
	private TextField temperaturTextField;
	@FXML
	private TextField gHTextField;

	@FXML
	private TextField phTextField;

	@FXML
	private TextField socialisationsTextField;
	
	//List for example (because i dont have DB yet)

	ObservableList<FishType> fishTypeList = FXCollections.observableArrayList(fishFirst, fishSecond, fishThird);
	ObservableList<String> fishBreedList = FXCollections.observableArrayList(fishFirst.getBreed(),
			fishSecond.getBreed(), fishThird.getBreed());

	@FXML
	void choseFishType(ActionEvent event) {

	}

//	@FXML
//	void showFishType(ActionEvent event) {
//
//	}

	@FXML
	void back(ActionEvent event) {
		Stage currentStage = (Stage) ((Node) event.getTarget()).getScene().getWindow();
		currentStage.close();
	}

	@FXML
	private void initialize() {

		fishTypeFromDB.add(fishFirst);
		fishTypeFromDB.add(fishSecond);
		fishTypeFromDB.add(fishThird);

		fishTypeComboBox.setValue(fishFirst.getBreed());
		fishTypeComboBox.setItems(fishBreedList);

	}

	@FXML
	void onMousePressed(ActionEvent event) {

		for (FishType f : fishTypeFromDB) {
			if (f.getBreed().equals(fishTypeComboBox.getValue())) {
				sizeTextField.setText(String.valueOf(f.getSize()));
				aqSizeTextField.setText(String.valueOf(f.getMinAqVolumen() + " - " + f.getMaxAqVolumen()));
				temperaturTextField.setText(String.valueOf(f.getMinTemperatur() + " - " + f.getMaxTemperatur()));
				gHTextField.setText(String.valueOf(f.getMinGH() + " - " + f.getMaxGH()));
				phTextField.setText(String.valueOf(f.getMinPh()) + " - " + f.getMaxPh());
				socialisationsTextField.setText(String.valueOf(f.getSocialization()));
			}
		}

//		for (int i = 0; i < fishTypeFromDB.size(); i++) {
//			if (fishTypeFromDB.get(i).getBreed().equals(fishTypeComboBox.getValue())) {
//				sizeTextField.setText(String.valueOf(fishTypeFromDB.get(i).getSize())); 
//				
//			}
//
//			
//		}

	}


}
