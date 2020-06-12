package at.varga.java.welt_der_aquaristik.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import at.varga.java.welt_der_aquaristik.application.Constants;
import at.varga.java.welt_der_aquaristik.application.Main;
import at.varga.java.welt_der_aquaristik.model.AQ;
import at.varga.java.welt_der_aquaristik.model.Cast;
import at.varga.java.welt_der_aquaristik.model.FishType;
import at.varga.java.welt_der_aquaristik.model.FishTypeInAQ;
import at.varga.java.welt_der_aquaristik.model.Socialization;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AQDateSheetController extends BasicController implements Initializable  {

	@FXML
	private Button AddNewFishButton;
	@FXML
	private Button backButton;

	// AQ parametrs elements
	@FXML
	private Text volumenText;
	@FXML
	private Text temperaturText;
	@FXML
	private Text sizeText;
	@FXML
	private Text phText;
	@FXML
	private Text stockingDensityText;
	@FXML
	private Text ghText;
	// MyAQsList elements
	@FXML
	private ComboBox<String> aqComboBox;


	// Table elements
	@FXML
	private TableView<FishTypeInAQ> fishTypeInAQTable;
	@FXML
	private TableColumn<FishTypeInAQ, String> breedColumn;
	@FXML
	private TableColumn<FishTypeInAQ, Integer> quantityColumn;

	// Method to add a new fish to the AQ
	// opes just a new scene, donesent save any fishes yet
	@FXML
	void addANewFishToAQ(ActionEvent event) {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource(Constants.PATH_TO_ADDNEWFISHTOAQ_FXML));
		AnchorPane addNewFishToAQ = null;
		try {
			addNewFishToAQ = loader.load();
		} catch (IOException e) {

			e.printStackTrace();
		}

		Stage addNewFishWindow = new Stage();
		addNewFishWindow.setTitle("Neuen Fisch zur Aquarium hinzufügen");
		addNewFishWindow.initModality(Modality.WINDOW_MODAL);
		addNewFishWindow.initOwner(Main.primaryStage);

		Scene scene = new Scene(addNewFishToAQ);
		addNewFishWindow.setScene(scene);
		addNewFishWindow.showAndWait();

	}

	// does not delete any fish yet
	// just show PUAreUSure
	@FXML
	void deleteFish(ActionEvent event) {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource(Constants.PATH_TO_POP_UP_AREYOUSURE_FXML));
		AnchorPane popUpAUSure = null;
		try {
			popUpAUSure = loader.load();
		} catch (IOException e) {

			e.printStackTrace();
		}

		Stage puAUS = new Stage();
		puAUS.setTitle("Bist sicher?");
		puAUS.initModality(Modality.WINDOW_MODAL);
		puAUS.initOwner(Main.primaryStage);

		Scene scene = new Scene(popUpAUSure);
		puAUS.setScene(scene);
		puAUS.showAndWait();

	}

	// does not delete any fish yet
	// just show PUAreUSure
	@FXML
	void deleteAQ(ActionEvent event) {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource(Constants.PATH_TO_POP_UP_AREYOUSURE_FXML));
		AnchorPane popUpAUSure = null;
		try {
			popUpAUSure = loader.load();
		} catch (IOException e) {

			e.printStackTrace();
		}

		Stage puAUS = new Stage();
		puAUS.setTitle("Bist sicher?");
		puAUS.initModality(Modality.WINDOW_MODAL);
		puAUS.initOwner(Main.primaryStage);

		Scene scene = new Scene(popUpAUSure);
		puAUS.setScene(scene);
		puAUS.showAndWait();
	}



	// constant examples
	FishType fishFirst = new FishType(1, "Neon", 5, 120, 1000, 23, 28, 5f, 7.5f, 2, 20, "", Socialization.GRUPPENFISH,
			Cast.SALMLER);
	FishType fishSecond = new FishType(2, "Betta", 7, 30, 100, 24, 30, 5.5f, 7.5f, 2, 20, "", Socialization.EINZELHALTUNG,
			Cast.LABYRINTHFISH);
	FishType fishThird = new FishType(3, "Skalar", 15, 150, 1000, 24, 28, 5.5f, 7.2f, 2, 15, "",
			Socialization.AGRESSIV, Cast.BARSCH);

	public ObservableList<FishTypeInAQ> list = FXCollections.observableArrayList(
			new FishTypeInAQ(fishFirst.getBreed(), 1, 10), 
			new FishTypeInAQ(fishSecond.getBreed(), 1, 15),
			new FishTypeInAQ(fishThird.getBreed(), 2, 1));
	
	public ObservableList<FishTypeInAQ> list2 = FXCollections.observableArrayList(
			new FishTypeInAQ("Blau barsch", 1, 10), 
			new FishTypeInAQ("Silber Barsch", 1, 15),
			new FishTypeInAQ("Quietschende Badeente", 2, 42));
	

	// AQs as example

	AQ aq1 = new AQ(1, "Amazonas", 60, 180, 60, 26, 15, 7.5, null);
	AQ aq2 = new AQ(2, "Nano", 30, 30, 30, 24, 8, 7.3, list);
	AQ aq3 = new AQ(3, "LieblingsAQ", 60, 60, 30, 22, 10, 7.7, list2);

	private List<AQ> aqsFromDB = new ArrayList<AQ>();

	ObservableList<String> aqTitelList = FXCollections.observableArrayList(aq1.getTitel(), aq2.getTitel(), aq3.getTitel());

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// FishTabelle
		breedColumn.setCellValueFactory(new PropertyValueFactory<FishTypeInAQ, String>("breed"));
		quantityColumn.setCellValueFactory(new PropertyValueFactory<FishTypeInAQ, Integer>("quantity"));
		fishTypeInAQTable.setItems(list);

		// MyAQS List
		aqsFromDB.add(aq1);
		aqsFromDB.add(aq2);
		aqsFromDB.add(aq3);

//		fishTypeInAQFromDB.add(fishTIA1);
//		fishTypeInAQFromDB.add(fishTIA2);
//		fishTypeInAQFromDB.add(fishTIA3);

		aqComboBox.setValue(aq1.getTitel());
		aqComboBox.setItems(aqTitelList);

	}

	@FXML
	void showAQParameters(ActionEvent event) {

		for (AQ a : aqsFromDB) {
			if (a.getTitel().equals(aqComboBox.getValue())) {
				sizeText.setText(a.getSizeHeight() + " x " + a.getSizeLength() + " x " + a.getSizeHeight());
				volumenText.setText(String.valueOf(a.getVolumen()) + "l");
				temperaturText.setText(String.valueOf(a.getTemperatur()) + "°C");
				ghText.setText(String.valueOf(a.getgH()) + "°d");
				phText.setText(String.valueOf(a.getPh()));
				stockingDensityText.setText(String.valueOf(a.getStockingDensity()) + "cm Fisch/l");
				fishTypeInAQTable.setItems((ObservableList<FishTypeInAQ>) a.getListOfFishes());
			}
		}

	}
	
	// closes actuelly window, leads to PrimerWindow
	@FXML
	void back(ActionEvent event) {

		ActionEvent e= event;
		backToPrScene (e);
	}

}