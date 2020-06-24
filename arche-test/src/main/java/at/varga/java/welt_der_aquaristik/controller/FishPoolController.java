package at.varga.java.welt_der_aquaristik.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import at.varga.java.welt_der_aquaristik.application.Constants;
import at.varga.java.welt_der_aquaristik.application.Main;
import at.varga.java.welt_der_aquaristik.model.Cast;
import at.varga.java.welt_der_aquaristik.model.FishType;
import at.varga.java.welt_der_aquaristik.model.FishTypeInAQ;
import at.varga.java.welt_der_aquaristik.model.Socialization;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FishPoolController extends BasicController {

//	@FXML
//	private ComboBox<String> castComboBox;
	@FXML
	private ComboBox<String> castComboBox;
	@FXML
	private Button showCastViewButton;

	@FXML
	private Button backButton;

	// constant examples
	FishType fishFirst = new FishType(1, "Neon", 5, 120, 1000, 23, 28, 5f, 7.5f, 2, 20, "", Socialization.GRUPPENFISH,
			Cast.SALMLER);
	FishType fishSecond = new FishType(2, "Betta", 7, 30, 100, 24, 30, 5.5f, 7.5f, 2, 20, "",
			Socialization.EINZELHALTUNG, Cast.LABYRINTHFISCH);
	FishType fishThird = new FishType(3, "Skalar", 15, 150, 1000, 24, 28, 5.5f, 7.2f, 2, 15, "", Socialization.AGRESSIV,
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

	
	public ObservableList<String> list = FXCollections.observableArrayList(
			Cast.ANDERE_FISCH.getCastName(), 
			Cast.BARSCH.getCastName(), 
			Cast.BAERBLING.getCastName(), 
			Cast.KALTWASSERFISCH.getCastName(), 
			Cast.LABYRINTHFISCH.getCastName(), 
			Cast.LEBENDGEBAERENDE.getCastName(), 
			Cast.SALMLER.getCastName(), 
			Cast.WELS.getCastName());
	
//	public ObservableList<Cast> list = FXCollections.observableArrayList(
//			Cast.ANDERE_FISCH, 
//			Cast.BARSCH, 
//			Cast.BAERBLING, 
//			Cast.KALTWASSERFISCH, 
//			Cast.LABYRINTHFISCH, 
//			Cast.LEBENDGEBAERENDE, 
//			Cast.SALMLER, 
//			Cast.WELS);

	
	@FXML
	private void initialize() {
		castComboBox.setItems(list);

	}

	// open a new Sceen and give a String to the controller of the next Scene
	@FXML
	void showCastView(ActionEvent event) throws IOException {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(Constants.PATH_TO_CAST_VIEW_FXML));
			Parent root = loader.load();

			CastController castctrl = loader.getController();
			castctrl.initialize(castComboBox.getValue());

			Stage stage = new Stage();
			stage.setTitle(castComboBox.getValue());
			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(Main.primaryStage);

			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource(Constants.PATH_TO_APPLICATION_CSS).toExternalForm());
			stage.setScene(scene);
			stage.showAndWait();
		} catch (IOException e) {

			e.printStackTrace();
		}
		
//		Stage currentStage = (Stage) ((Node) event.getTarget()).getScene().getWindow();
//		currentStage.hide();
//		Stage currentStage = (Stage) ((Node) event.getTarget()).getScene().getWindow();
//		currentStage.hide();

	}

	@FXML
	void back(ActionEvent event) {

		ActionEvent e = event;
		backToPrScene(e);
		
	}

}
