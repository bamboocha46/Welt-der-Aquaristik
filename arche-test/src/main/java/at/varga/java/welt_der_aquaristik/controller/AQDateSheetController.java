package at.varga.java.welt_der_aquaristik.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;

import at.varga.java.welt_der_aquaristik.application.Constants;
import at.varga.java.welt_der_aquaristik.application.Main;
import at.varga.java.welt_der_aquaristik.exception.ServiceException;
import at.varga.java.welt_der_aquaristik.model.AQ;
import at.varga.java.welt_der_aquaristik.model.Cast;
import at.varga.java.welt_der_aquaristik.model.FishType;
import at.varga.java.welt_der_aquaristik.model.FishTypeInAQ;
import at.varga.java.welt_der_aquaristik.model.Socialization;
import at.varga.java.welt_der_aquaristik.service.AQService;
import at.varga.java.welt_der_aquaristik.service.FishTypeInAQService;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

public class AQDateSheetController extends BasicController implements Initializable {

	AQService aqService = new AQService();
	FishTypeInAQService fishTypeInAQService = new FishTypeInAQService();

//	private List<AQ> aqListFromDB = new ArrayList<AQ>();
//	private ObservableList<AQ> aqListForView = FXCollections.observableArrayList();
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

	// Controller gives AQId to next Controller: AddNewFishToAQController
	@FXML
	void addANewFishToAQ(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(Constants.PATH_TO_ADDNEWFISHTOAQ_FXML));
			Parent root = loader.load();

			AddNewFishToAQController addNewFishToAQController = loader.getController();
			addNewFishToAQController.giveMeAQ(aqComboBox.getValue());

			Stage addNewFishWindow = new Stage();
			addNewFishWindow.setTitle("Neuen Fisch zur " + aqComboBox.getValue() + " Aquarium hinzuf�gen");
			addNewFishWindow.initModality(Modality.WINDOW_MODAL);
			addNewFishWindow.initOwner(Main.primaryStage);

			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource(Constants.PATH_TO_APPLICATION_CSS).toExternalForm());
			addNewFishWindow.setScene(scene);
			addNewFishWindow.showAndWait();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@FXML
	void deleteFish(ActionEvent event) {

		System.out.println("fishID to delete: " + fishTypeInAQTable.getSelectionModel().getSelectedItem().getId());

		long deletendFish = fishTypeInAQTable.getSelectionModel().getSelectedItem().getId();

		try {
			fishTypeInAQService.deleteFishTypeInAQ(fishTypeInAQTable.getSelectionModel().getSelectedItem());
			System.out.println("Fish deleted from DB");
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		String path = Constants.PATH_TO_POP_UP_AREYOUSURE_FXML;
		String setTitel = "Bist sicher?";
		showNewScene(path, setTitel);

	}

	@FXML
	void deleteAQ(ActionEvent event) {

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(Constants.PATH_TO_POP_UP_AREYOUSURE_FXML));
			Parent root = loader.load();

			PopUpAreYouSureController popUpAreUSure = loader.getController();
			popUpAreUSure.giveMeAQ(aqComboBox.getValue());
			
			Stage popUpAUS = new Stage();
			popUpAUS.setTitle("Bist du sicher?");
			popUpAUS.initModality(Modality.WINDOW_MODAL);
			popUpAUS.initOwner(Main.primaryStage);
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource(Constants.PATH_TO_APPLICATION_CSS).toExternalForm());
			popUpAUS.setScene(scene);
			popUpAUS.showAndWait();

			closeSceene(event);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

//	@FXML
//	void deleteAQ(ActionEvent event) {
//
//		try {
//			aqService.deleteAQ(aqComboBox.getValue());
//		} catch (ServiceException e1) {
//			e1.printStackTrace();
//		}
//
//		FXMLLoader loader = new FXMLLoader();
//		loader.setLocation(Main.class.getResource(Constants.PATH_TO_POP_UP_AREYOUSURE_FXML));
//		AnchorPane popUpAUSure = null;
//		try {
//			popUpAUSure = loader.load();
//		} catch (IOException e) {
//
//			e.printStackTrace();
//		}
//
//		Stage puAUS = new Stage();
//		puAUS.setTitle("Bist sicher?");
//		puAUS.initModality(Modality.WINDOW_MODAL);
//		puAUS.initOwner(Main.primaryStage);
//
//		Scene scene = new Scene(popUpAUSure);
//		puAUS.setScene(scene);
//		puAUS.showAndWait();
//	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// MyAQS List
		try {
			aqListFromDB.addAll(aqService.getAllAQ());

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

		aqComboBox.setItems(aqListFromDB);
		aqComboBox.setValue(aqListFromDB.get(0));
		showAQParameters(aqListFromDB.get(0));
		aqComboBox.setOnAction(this::handleAQSelected);
	}

	@FXML
	void handleAQSelected(ActionEvent event) {

		System.out.println(event.getSource());

		AQ a = ((ComboBox<AQ>) event.getSource()).getValue();

		showAQParameters(a);

	}

	void showAQParameters(AQ a) {

		sizeText.setText(a.getSizeHeight() + " x " + a.getSizeLength() + " x " + a.getSizeHeight());
		volumenText.setText(String.valueOf(a.getVolumen()) + "l");
		temperaturText.setText(String.valueOf(a.getTemperatur()) + "�C");
		ghText.setText(String.valueOf(a.getgH()) + "�d");
		phText.setText(String.valueOf(a.getPh()));
		stockingDensityText.setText(String.valueOf(a.getStockingDensity()) + "cm Fisch/l");

		// jprie: Observable list erstellen, nicht nur casten!

		ObservableList<FishTypeInAQ> list = FXCollections.observableArrayList();

		list.addAll(a.getListOfFishes());

		fishTypeInAQTable.setItems(list);

	}

	// closes actuelly window, leads to PrimerWindow
	@FXML
	void back(ActionEvent event) {

		ActionEvent e = event;
		backToPrScene(e);
	}

}