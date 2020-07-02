package at.varga.java.welt_der_aquaristik.controller;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import at.varga.java.welt_der_aquaristik.application.Constants;
import at.varga.java.welt_der_aquaristik.application.Main;
import at.varga.java.welt_der_aquaristik.db.FillTestDB;
import at.varga.java.welt_der_aquaristik.exception.ServiceException;
import at.varga.java.welt_der_aquaristik.model.AQ;

import at.varga.java.welt_der_aquaristik.model.FishTypeInAQ;

import at.varga.java.welt_der_aquaristik.service.AQService;
import at.varga.java.welt_der_aquaristik.service.FishTypeInAQService;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;

import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

public class AQDateSheetController extends BasicController implements Initializable {

	AQService aqService = new AQService();
	FishTypeInAQService fishTypeInAQService = new FishTypeInAQService();

	private ObservableList<AQ> aqListFromDB = FXCollections.observableArrayList();

	@FXML
	private Button AddNewFishButton;
	@FXML
	private Button deleteFishButton;
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

	@FXML
	private ComboBox<AQ> aqComboBox;

	// Table elements
	@FXML
	private TableView<FishTypeInAQ> fishTypeInAQTable;
	@FXML
	private TableColumn<FishTypeInAQ, String> breedColumn;
	@FXML
	private TableColumn<FishTypeInAQ, Integer> quantityColumn;

	public static Stage primaryStage;

	// Controller gives AQId to next Controller: AddNewFishToAQController
	@FXML
	void addANewFishToAQ(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(Constants.PATH_TO_ADDNEWFISHTOAQ_FXML));
			Parent root = loader.load();

			AddNewFishToAQController addNewFishToAQController = loader.getController();
			addNewFishToAQController.giveMeAQ(aqComboBox.getValue());

			Stage addNewFishWindow = new Stage();
			addNewFishWindow.setTitle("Neuen Fisch zur " + aqComboBox.getValue() + " Aquarium hinzufügen");
			addNewFishWindow.initModality(Modality.WINDOW_MODAL);
			addNewFishWindow.initOwner(Main.primaryStage);

			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource(Constants.PATH_TO_APPLICATION_CSS).toExternalForm());
			addNewFishWindow.setScene(scene);
			addNewFishWindow.showAndWait();

			System.out.println(aqComboBox.getValue());
			int id = aqListFromDB.indexOf(aqComboBox.getValue());
			updateUI(id);

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@FXML
	void deleteFish(ActionEvent event) {

		try {
			FXMLLoader loader = new FXMLLoader(
					getClass().getResource(Constants.PATH_TO_POP_UP_AREYOUSURE_DELETE_FISH_FROM_AQ_FXML));
			Parent root = loader.load();

			PopUpAreYouSureDeleteFishFromAQController popUpAreUSureDFFAq = loader.getController();
			popUpAreUSureDFFAq.giveMeFishTypeInAQToDel(fishTypeInAQTable.getSelectionModel().getSelectedItem());

			Stage popUpAUS = new Stage();
			popUpAUS.initModality(Modality.WINDOW_MODAL);
			popUpAUS.initOwner(Main.primaryStage);

			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource(Constants.PATH_TO_APPLICATION_CSS).toExternalForm());
			popUpAUS.setScene(scene);
			popUpAUS.showAndWait();

			System.out.println(aqComboBox.getValue());
			int id = aqListFromDB.indexOf(aqComboBox.getValue());
			updateUI(id);

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@FXML
	void deleteAQ(ActionEvent event) {

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(Constants.PATH_TO_POP_UP_AREYOUSURE_FXML));
			Parent root = loader.load();

			PopUpAreYouSureController popUpAreUSure = loader.getController();
			popUpAreUSure.giveMeAQ(aqComboBox.getValue());

			Stage popUpAUS = new Stage();
			popUpAUS.initModality(Modality.WINDOW_MODAL);
			popUpAUS.initOwner(Main.primaryStage);

			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource(Constants.PATH_TO_APPLICATION_CSS).toExternalForm());
			popUpAUS.setScene(scene);
			popUpAUS.showAndWait();

			System.out.println(aqComboBox.getValue());
			int id = aqListFromDB.indexOf(aqComboBox.getValue());

			updateUI(id);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		try {
			if (aqService.getAllAQ().isEmpty()) {
				FillTestDB.main(null);
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		// FishTabelle
		breedColumn.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<FishTypeInAQ, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<FishTypeInAQ, String> param) {

						return new SimpleStringProperty(param.getValue().getFishType().getBreed());
					}
				});
		quantityColumn.setCellValueFactory(new PropertyValueFactory<FishTypeInAQ, Integer>("quantity"));

		aqComboBox.setOnAction(this::handleAQSelected);
		// MyAQS List
		updateUI(0);
	}

	private void updateUI(int id) {
		try {
			aqListFromDB.clear();
			aqListFromDB.addAll(aqService.getAllAQ());
			aqComboBox.setItems(aqListFromDB);
			aqComboBox.setValue(aqListFromDB.get(id));
			showAQParameters(aqListFromDB.get(id));

		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}

	@FXML
	void handleAQSelected(ActionEvent event) {

		System.out.println(event.getSource());

		AQ a = ((ComboBox<AQ>) event.getSource()).getValue();
		stockingDensity(a);

		showAQParameters(a);

	}

	void showAQParameters(AQ a) {

		sizeText.setText(a.getSizeWidth() + "cm x " + a.getSizeLength() + "cm x " + a.getSizeHeight() + "cm");
		volumenText.setText(String.valueOf(a.getVolumen()) + " l");
		temperaturText.setText(String.valueOf(a.getTemperatur()) + "°C");
		ghText.setText(String.valueOf(a.getgH()) + "°d");
		phText.setText(String.valueOf(a.getPh()));
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		stockingDensityText.setText(df.format(a.getStockingDensity()) + " cm Fisch/l");

		ObservableList<FishTypeInAQ> list = FXCollections.observableArrayList();

		list.addAll(a.getListOfFishes());

		fishTypeInAQTable.setItems(list);

//		stockingDensity(a);
	}

	void stockingDensity(AQ a) {
		if (a.getStockingDensity() > 1) {
			showPopUp("Du hast zu viele Fische im " + a.getTitel() + "!!!");
		}
	}

	// closes actuelly window, leads to PrimerWindow
	@FXML
	void back(ActionEvent event) {

		backToPrScene(event);
	}

}