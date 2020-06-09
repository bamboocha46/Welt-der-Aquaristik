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

public class CastAnabasController extends BasicController {

	// FishTypes as examples
	FishType fishFirst = new FishType(1, "Neon", 5, 120, 1000, 23, 28, 5f, 7.5f, 2, 20, "", Socialization.GRUPPENFISH,
			Cast.SALMLER);
	FishType fishSecond = new FishType(2, "Betta", 7, 30, 100, 24, 30, 5.5f, 7.5f, 2, 20, "",
			Socialization.EINZELHALTUNG, Cast.LABYRINTHFISH);
	FishType fishThird = new FishType(3, "Skalar", 15, 150, 1000, 24, 28, 5.5f, 7.2f, 2, 15, "", Socialization.AGRESSIV,
			Cast.BARSCH);

	private List<FishType> fishTypeFromDB = new ArrayList<FishType>();

	@FXML
	private ComboBox<String> fishTypeComboBox;

	@FXML
	private Button backButton;

	@FXML
	private Button fishTypeShowButton;

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
	ObservableList<FishType> fishTypeList = FXCollections.observableArrayList(fishFirst, fishSecond, fishThird);
	ObservableList<String> fishBreedList = FXCollections.observableArrayList(fishFirst.getBreed(),
			fishSecond.getBreed(), fishThird.getBreed());

//	@FXML
//	void choseFishType(ActionEvent event) {
//
//	}

	@FXML
	void openAddNewFishSceen(ActionEvent event) {

		String path = Constants.PATH_TO_ADDNEWFISHTOLIST_FXML;
		String setTitel = "Neuen Fisch zur Liste hinzufügen";

		showNewScene(path, setTitel);

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
	void fishTypeShowButtonWasPressed(ActionEvent event) {

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

	}
	
	@FXML
	void deleteFish(ActionEvent event) {
		System.out.println("Fish deleted");
	}

	@FXML
	void editFishType(ActionEvent event) {

	}

	@FXML
	void back(ActionEvent event) {
		ActionEvent e = event;
		backToPrScene(e);
	}

}




//package at.varga.java.welt_der_aquaristik.controller;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.sun.prism.paint.Color;
//
//import at.varga.java.welt_der_aquaristik.application.Constants;
//import at.varga.java.welt_der_aquaristik.application.Main;
//import at.varga.java.welt_der_aquaristik.model.Cast;
//import at.varga.java.welt_der_aquaristik.model.FishType;
//import at.varga.java.welt_der_aquaristik.model.FishTypeInAQ;
//import at.varga.java.welt_der_aquaristik.model.Socialization;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Node;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.ComboBox;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.AnchorPane;
//import javafx.stage.Modality;
//import javafx.stage.Stage;
//
//public class CastAnabasController extends BasicController {
//
//	// List as example (because i dont have DB yet)
//	private List<FishType> fishTypeFromDB = new ArrayList<FishType>();
//	FishType fishFirst = new FishType(1, "Neon", 5, 120, 1000, 23, 28, 5f, 7.5f, 2, 20, "", Socialization.GRUPPENFISH,
//			Cast.SALMLER);
//
//	
//
//	ObservableList<String> fishBreedList;
//
//	@FXML
//	private ComboBox<String> fishTypeComboBox;
//
//	@FXML
//	private Button backButton;
//	@FXML
//	private Button fishTypeShowButton;
//
//	@FXML
//	private Button addNewFishButton;
//	@FXML
//	private Button deleteFishTypeButton;
//	@FXML
//	private Button editFishTypeButton;
//
//	// FishParametersTextFields
//	@FXML
//	private TextField sizeTextField;
//	@FXML
//	private TextField aqSizeTextField;
//	@FXML
//	private TextField temperaturTextField;
//	@FXML
//	private TextField gHTextField;
//	@FXML
//	private TextField phTextField;
//	@FXML
//	private TextField socialisationsTextField;
//
//	//Constructor
//	public CastAnabasController(List<FishType> fishTypeList) {
//		this.fishTypeFromDB = fishTypeList;
//
//		for (FishType f : fishTypeList) {
//			this.fishBreedList.add(f.getBreed());
//			//this.fishBreedList.add(String.valueOf(f.getCast()));
//		}
//		ObservableList<FishType> fishTypeList2 = FXCollections.observableArrayList(fishTypeFromDB);
//
//	}
//	
////	//Constructor
////	public CastAnabasController(String path, String setTitel, List<FishType> fishTypeList) {
////		this.fishTypeFromDB = fishTypeList;
////
////		for (FishType f : fishTypeList) {
////			this.fishBreedList.add(f.getBreed());
////			//this.fishBreedList.add(String.valueOf(f.getCast()));
////		}
////		ObservableList<FishType> fishTypeList2 = FXCollections.observableArrayList(fishTypeFromDB);
////
////	}
//	
//	//default Constructor
//	public CastAnabasController() {
//		
//	}
//
////	@FXML
////	void choseFishType(ActionEvent event) {
////
////	}
//
//	@FXML
//	void openAddNewFishSceen(ActionEvent event) {
//
//		String path = Constants.PATH_TO_ADDNEWFISHTOLIST_FXML;
//		String setTitel = "Neuen Fisch zur Liste hinzufügen";
//
//		showNewScene(path, setTitel);
//
//	}
//
//	@FXML
//	private void initialize() {
//
//		fishTypeFromDB.add(fishFirst);
////		fishTypeFromDB.add(fishSecond);
////		fishTypeFromDB.add(fishThird);
//
//		fishTypeComboBox.setValue(fishBreedList.get(0));
//		fishTypeComboBox.setItems(fishBreedList);
//
//	}
//
//	@FXML
//	void fishTypeShowButtonWasPressed(ActionEvent event) {
//
//		for (FishType f : fishTypeFromDB) {
//			if (f.getBreed().equals(fishTypeComboBox.getValue())) {
//				sizeTextField.setText(String.valueOf(f.getSize()));
//				aqSizeTextField.setText(String.valueOf(f.getMinAqVolumen() + " - " + f.getMaxAqVolumen()));
//				temperaturTextField.setText(String.valueOf(f.getMinTemperatur() + " - " + f.getMaxTemperatur()));
//				gHTextField.setText(String.valueOf(f.getMinGH() + " - " + f.getMaxGH()));
//				phTextField.setText(String.valueOf(f.getMinPh()) + " - " + f.getMaxPh());
//				socialisationsTextField.setText(String.valueOf(f.getSocialization()));
//			}
//		}
//
//	}
//
//	@FXML
//	void deleteFish(ActionEvent event) {
//		System.out.println("Fish deleted");
//	}
//
//	@FXML
//	void editFishType(ActionEvent event) {
//
//	}
//
//	@FXML
//	void back(ActionEvent event) {
//		ActionEvent e = event;
//		backToPrScene(e);
//	}
//
//	public void showNewScene(String path, String setTitel) {
//
//		
//		showNewScene(path, setTitel);
//	}
//	
////	public void showNewFishTypeCastScene(String path, String setTitel, List<FishType> fishTypeList) {
////
////		FXMLLoader loader = new FXMLLoader();
////		loader.setLocation(Main.class.getResource(path));
////		AnchorPane ap = null;
////		try {
////			ap = loader.load();
////		Stage stage = new Stage();
////		stage.setTitle(setTitel);
////		stage.initModality(Modality.WINDOW_MODAL);
////		stage.initOwner(Main.primaryStage);
////
////		Scene scene = new Scene(ap);
////		stage.setScene(scene);
////		stage.showAndWait();
////		} catch (IOException e) {
////
////			e.printStackTrace();
////		}
////	}
////		
//
//}
