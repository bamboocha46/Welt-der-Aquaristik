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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CastController extends BasicController {

	FishTypeService fishTypeService = new FishTypeService();


	private List<FishType> fishTypeFromDB = new ArrayList<FishType>();

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
	private String cast;

	ObservableList<FishType> fishBreedList = FXCollections.observableArrayList();
	List<FishType> fishArtList = new ArrayList<FishType>();

	@FXML
	void openAddNewFishSceen(ActionEvent event) {

//		String path = Constants.PATH_TO_ADDNEWFISHTOLIST_FXML;
//		String setTitel = "Neuen Fisch zur Liste hinzufügen";
//
//		showNewScene(path, setTitel);
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(Constants.PATH_TO_ADDNEWFISHTOLIST_FXML));
			Parent root = loader.load();

			AddNewFishToListController addNewFTListCtrl = loader.getController();
			addNewFTListCtrl.giveMeCast(cast);

			Stage stage = new Stage();
			stage.setTitle("Neuen Fisch (" + cast + ") zur Liste hinzufügen");
			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(Main.primaryStage);

			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource(Constants.PATH_TO_APPLICATION_CSS).toExternalForm());
			stage.setScene(scene);
			stage.showAndWait();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@FXML
	public void initialize(String cast) {
		this.cast = cast;

		// System.out.println("castCombobox value:" + cast);

//		fishTypeFromDB.add(fishFirst);
//		fishTypeFromDB.add(fishSecond);
//		fishTypeFromDB.add(fishThird);
//		fishTypeFromDB.add(fish4);
//		fishTypeFromDB.add(fish5);
//		fishTypeFromDB.add(fish6);
//		fishTypeFromDB.add(fish7);
//		fishTypeFromDB.add(fish8);
//		fishTypeFromDB.add(fish9);
//		fishTypeFromDB.add(fish10);
//		fishTypeFromDB.add(fish11);
//		fishTypeFromDB.add(fish12);
//		fishTypeFromDB.add(fish13);
//		fishTypeFromDB.add(fish14);
//		fishTypeFromDB.add(fish15);
		try {
			fishTypeFromDB = fishTypeService.getAllFishType();
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		for (FishType f : fishTypeFromDB) {
			if (f.getCast().getCastName().equals(cast)) {
				fishArtList.add(f);
			}
		}
		for (FishType f : fishArtList) {
			fishBreedList.add(f);
		}

		// This initialization doesent work, if it is only ONE fish im fishBreedList
//		if (fishBreedList != null) {
//			fishTypeComboBox.setValue(fishBreedList.get(0));
//		}

		fishTypeComboBox.setValue(fishBreedList.get(0));
		showFishType(fishBreedList.get(0));
		fishTypeComboBox.setItems(fishBreedList);
	}

	@FXML
	void handleAQSelected(ActionEvent event) {

		System.out.println(event.getSource());

		FishType f = ((ComboBox<FishType>) event.getSource()).getValue();

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


	@FXML
	void deleteFish(ActionEvent event) {

		try {
			fishTypeService.deleteFishType(fishTypeComboBox.getValue());
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		System.out.println("Fish deleted");

		// COMBOBOX +DATENTEXTFIElDS UPDATE
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
