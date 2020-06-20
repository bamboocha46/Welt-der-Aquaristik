package at.varga.java.welt_der_aquaristik.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.sun.prism.paint.Color;

import at.varga.java.welt_der_aquaristik.application.Constants;
import at.varga.java.welt_der_aquaristik.application.Main;
import at.varga.java.welt_der_aquaristik.exception.ServiceException;
import at.varga.java.welt_der_aquaristik.model.AQ;
import at.varga.java.welt_der_aquaristik.model.Cast;
import at.varga.java.welt_der_aquaristik.model.FishType;
import at.varga.java.welt_der_aquaristik.model.FishTypeInAQ;
import at.varga.java.welt_der_aquaristik.model.Socialization;
import at.varga.java.welt_der_aquaristik.service.FishTypeService;
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

public class CastController extends BasicController {
	
	FishTypeService fishTypeService = new FishTypeService();

	// FishTypes as examples
	FishType fishFirst = new FishType(1, "Neon", 5, 120, 1000, 23, 28, 5f, 7.5f, 2, 20, "", Socialization.GRUPPENFISH,
			Cast.SALMLER);
	FishType fishSecond = new FishType(2, "Betta", 7, 30, 100, 24, 30, 5.5f, 7.5f, 2, 20, "",
			Socialization.EINZELHALTUNG, Cast.LABYRINTHFISCH);
	FishType fishThird = new FishType(3, "balbla", 15, 150, 1555000, 24, 28, 5.5f, 7.2f, 2, 15, "",
			Socialization.AGRESSIV, Cast.BARSCH);
	FishType fish4 = new FishType(3, "Skalar", 15, 150, 1000, 24, 28, 5.5f, 7.2f, 2, 15, "", Socialization.AGRESSIV,
			Cast.BARSCH);
	FishType fish5 = new FishType(4, "fish1", 15, 150, 1000, 24, 28, 5.5f, 7.2f, 2, 15, "", Socialization.AGRESSIV,
			Cast.ANDERE_FISCH);
	FishType fish6 = new FishType(5, "fish2", 115, 150, 1000, 24, 28, 5.5f, 7.2f, 2, 15, "", Socialization.AGRESSIV,
			Cast.BARSCH);
	FishType fish7 = new FishType(6, "fish3", 1115, 150, 1000, 24, 28, 5.5f, 7.2f, 2, 15, "", Socialization.AGRESSIV,
			Cast.BAERBLING);
	FishType fish8 = new FishType(7, "fish4", 11115, 150, 1000, 24, 28, 5.5f, 7.2f, 2, 15, "", Socialization.AGRESSIV,
			Cast.KALTWASSERFISCH);
	FishType fish9 = new FishType(8, "fish5", 155, 150, 1000, 24, 28, 5.5f, 7.2f, 2, 15, "", Socialization.AGRESSIV,
			Cast.LABYRINTHFISCH);
	FishType fish10 = new FishType(9, "fish6", 22, 1500, 10000, 24, 28, 5.5f, 7.2f, 2, 15, "", Socialization.AGRESSIV,
			Cast.LABYRINTHFISCH);
	FishType fish11 = new FishType(10, "fish7", 35, 150, 1000, 24, 28, 5.5f, 7.2f, 2, 15, "", Socialization.GRUPPENFISH,
			Cast.LEBENDGEBAERENDE);
	FishType fish12 = new FishType(11, "fish8", 45, 150, 1000, 24, 28, 5.5f, 7.2f, 2, 15, "", Socialization.AGRESSIV,
			Cast.SALMLER);
	FishType fish13 = new FishType(12, "fish9", 55, 150, 1000, 24, 28, 5.5f, 7.2f, 2, 15, "", Socialization.GRUPPENFISH,
			Cast.WELS);
	FishType fish14 = new FishType(13, "fish10", 175, 150, 1000, 24, 28, 5.5f, 7.2f, 2, 15, "", Socialization.AGRESSIV,
			Cast.LABYRINTHFISCH);
	FishType fish15 = new FishType(14, "fish11", 1, 150, 1000, 24, 28, 5.5f, 7.2f, 2, 15, "", Socialization.AGRESSIV,
			Cast.LABYRINTHFISCH);

	private List<FishType> fishTypeFromDB = new ArrayList<FishType>();

//	@FXML
//	private ComboBox<String> fishTypeComboBox;
	@FXML
	private ComboBox<FishType> fishTypeComboBox;

	@FXML
	private Button backButton;

	@FXML
	private Button addNewFishButton;

	// FishParametersTextFields
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

	// List as example (because i dont have DB yet)
//	ObservableList<FishType> fishTypeList = FXCollections.observableArrayList(fishFirst, fishSecond, fishThird);

	// ObservableList<String> fishBreedList = FXCollections.observableArrayList();
	ObservableList<FishType> fishBreedList = FXCollections.observableArrayList();
	List<FishType> fishArtList = new ArrayList<FishType>();

	@FXML
	void openAddNewFishSceen(ActionEvent event) {

		String path = Constants.PATH_TO_ADDNEWFISHTOLIST_FXML;
		String setTitel = "Neuen Fisch zur Liste hinzufügen";

		showNewScene(path, setTitel);

	}

	@FXML
	public void initialize(String cast) {

		// System.out.println("castCombobox value:" + cast);

		fishTypeFromDB.add(fishFirst);
		fishTypeFromDB.add(fishSecond);
		fishTypeFromDB.add(fishThird);
		fishTypeFromDB.add(fish4);
		fishTypeFromDB.add(fish5);
		fishTypeFromDB.add(fish6);
		fishTypeFromDB.add(fish7);
		fishTypeFromDB.add(fish8);
		fishTypeFromDB.add(fish9);
		fishTypeFromDB.add(fish10);
		fishTypeFromDB.add(fish11);
		fishTypeFromDB.add(fish12);
		fishTypeFromDB.add(fish13);
		fishTypeFromDB.add(fish14);
		fishTypeFromDB.add(fish15);

		for (FishType f : fishTypeFromDB) {
			if (f.getCast().getCastName().equals(cast)) {
				fishArtList.add(f);
			}
		}
		for (FishType f : fishArtList) {
			fishBreedList.add(f);
		}
//		for (FishType f : fishArtList) {
//			fishBreedList.add(f.getBreed());
//		}

		// This initialization doesent work, if it is only ONE fish im fishBreedList
//		if (fishBreedList != null) {
//			fishTypeComboBox.setValue(fishBreedList.get(0));
//		}

//		fishTypeComboBox.setItems(fishBreedList);
		fishTypeComboBox.setValue(fishBreedList.get(0));
		showFishType(fishBreedList.get(0));
		fishTypeComboBox.setItems(fishBreedList);
	}
	
	@FXML
	void handleAQSelected(ActionEvent event) {
		
		System.out.println(event.getSource());
		
		FishType f = ((ComboBox<FishType>)event.getSource()).getValue();

		showFishType(f);
		
	}

	// fill up the field of Fishtype with parameters from DB
	
	void showFishType(FishType f) {
		sizeTextField.setText(String.valueOf(f.getSize()));
		aqSizeTextField.setText(String.valueOf(f.getMinAqVolumen() + " - " + f.getMaxAqVolumen()));
		temperaturTextField.setText(String.valueOf(f.getMinTemperatur() + " - " + f.getMaxTemperatur()));
		gHTextField.setText(String.valueOf(f.getMinGH() + " - " + f.getMaxGH()));
		phTextField.setText(String.valueOf(f.getMinPh()) + " - " + f.getMaxPh());
		socialisationsTextField.setText(f.getSocialization().getName());
	}

//	// fill up the field of Fishtype with parameters from DB
//	@FXML
//	void showFishType(ActionEvent event) {
//
//		for (FishType f : fishArtList) {
//			if (f.getBreed().equals(fishTypeComboBox.getValue())) {
//				sizeTextField.setText(String.valueOf(f.getSize()));
//				aqSizeTextField.setText(String.valueOf(f.getMinAqVolumen() + " - " + f.getMaxAqVolumen()));
//				temperaturTextField.setText(String.valueOf(f.getMinTemperatur() + " - " + f.getMaxTemperatur()));
//				gHTextField.setText(String.valueOf(f.getMinGH() + " - " + f.getMaxGH()));
//				phTextField.setText(String.valueOf(f.getMinPh()) + " - " + f.getMaxPh());
//				socialisationsTextField.setText(f.getSocialization().getName());
//			}
//		}
//
//	}

	@FXML
	void deleteFish(ActionEvent event) {
		
		
		try {
			fishTypeService.deleteFishType(fishTypeComboBox.getValue());
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		System.out.println("Fish deleted");
		
		//COMBOBOX +DATENTEXTFIElDS UPDATE
	}

	@FXML
	void editFishType(ActionEvent event) {
		try {
			fishTypeService.updateFishType(fishTypeComboBox.getValue());
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		System.out.println(fishTypeComboBox.getValue() + " edited");
		
	}

	@FXML
	void back(ActionEvent event) {
		ActionEvent e = event;
		backToPrScene(e);

	}

}
