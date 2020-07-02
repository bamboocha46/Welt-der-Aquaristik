package at.varga.java.welt_der_aquaristik.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.FetchType;

import at.varga.java.welt_der_aquaristik.application.Constants;
import at.varga.java.welt_der_aquaristik.application.Main;
import at.varga.java.welt_der_aquaristik.db.FillTestDB;
import at.varga.java.welt_der_aquaristik.exception.ServiceException;

import at.varga.java.welt_der_aquaristik.model.FishType;

import at.varga.java.welt_der_aquaristik.service.FishTypeService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CastController extends BasicController {

	FishTypeService fishTypeService = new FishTypeService();

	private List<FishType> fishTypeFromDB = new ArrayList<FishType>();

	ObservableList<FishType> fishBreedList = FXCollections.observableArrayList();
	List<FishType> fishArtList = new ArrayList<FishType>();

	@FXML
	private ComboBox<FishType> fishTypeComboBox;

	@FXML
	private Button backButton;

	@FXML
	private Button addNewFishButton;

	// FishParametersTextFields
	@FXML
	private Label sizeLabel;
	@FXML
	private Label aqSizeLabel;
	@FXML
	private Label temperaturLabel;
	@FXML
	private Label gHLabel;
	@FXML
	private Label phLabel;
	@FXML
	private Label socialisationsLabel;
	private String cast;

	@FXML
	void openAddNewFishSceen(ActionEvent event) {

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(Constants.PATH_TO_ADDNEWFISHTOLIST_FXML));
			Parent root = loader.load();

			AddNewFishToListController addNewFTListCtrl = loader.getController();
			addNewFTListCtrl.giveMeCast(cast);

			Stage stage = new Stage();
			stage.setTitle("Neuen Fisch (" + cast + ") zur Liste hinzufuegen");
			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(Main.primaryStage);

			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource(Constants.PATH_TO_APPLICATION_CSS).toExternalForm());
			stage.setScene(scene);
			stage.showAndWait();

			closeSceene(event);

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@FXML
	public void initialize(String cast) {
		this.cast = cast;

		try {
			if  (fishTypeService.getAllFishType().isEmpty()) {
				FillTestDB.main(null);
			}
		} catch (ServiceException e1) {

			e1.printStackTrace();
		}
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

		fishTypeComboBox.setOnAction(this::handleAQSelected);
	}

	@FXML
	void handleAQSelected(ActionEvent event) {

		System.out.println(event.getSource());

		FishType f = ((ComboBox<FishType>) event.getSource()).getValue();

		showFishType(f);

	}

	// fill up the field of Fishtype with parameters from DB

	void showFishType(FishType f) {
		sizeLabel.setText(String.valueOf(f.getSize()) + "cm");
		aqSizeLabel.setText(String.valueOf(f.getMinAqVolumen() + " l - " + f.getMaxAqVolumen() + " l"));
		temperaturLabel.setText(String.valueOf(f.getMinTemperatur() + " - " + f.getMaxTemperatur()));
		gHLabel.setText(String.valueOf(f.getMinGH() + " - " + f.getMaxGH()));
		phLabel.setText(String.valueOf(f.getMinPh()) + " - " + f.getMaxPh());
		socialisationsLabel.setText(f.getSocialization().getName());

		System.out.println(temperaturLabel);
	}

	@FXML
	void deleteFish(ActionEvent event) {

		try {
			fishTypeService.deleteFishType(fishTypeComboBox.getValue());
			fishBreedList.clear();
			fishTypeComboBox.getItems().clear();
			fishArtList.clear();
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		showPopUp("Fisch ist geloescht.");
		System.out.println("Fish deleted");
		initialize(cast);

	}

	@FXML
	void editFishType(ActionEvent event) {

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(Constants.PATH_TO_EDIT_FISH_VIEW_FXML));
			Parent root = loader.load();

			EditFishController efctrl = loader.getController();
			efctrl.initialize(fishTypeComboBox.getValue());

			Stage eFStage = new Stage();
			eFStage.setTitle("Bearbeiten " + fishTypeComboBox.getValue().getBreed());
			eFStage.initModality(Modality.WINDOW_MODAL);
			eFStage.initOwner(Main.primaryStage);

			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource(Constants.PATH_TO_APPLICATION_CSS).toExternalForm());
			eFStage.setScene(scene);
			eFStage.showAndWait();

			closeSceene(event);

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@FXML
	void back(ActionEvent event) {
		String path = Constants.PATH_TO_FISH_POOL_VIEW_FXML;
		String setTitel = "Liste der Fische";
		showNewScene(path, setTitel);

		closeSceene(event);
	}

}
