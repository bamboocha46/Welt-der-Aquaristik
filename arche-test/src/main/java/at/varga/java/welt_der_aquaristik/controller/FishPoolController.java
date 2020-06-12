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
			Socialization.EINZELHALTUNG, Cast.LABYRINTHFISH);
	FishType fishThird = new FishType(3, "Skalar", 15, 150, 1000, 24, 28, 5.5f, 7.2f, 2, 15, "", Socialization.AGRESSIV,
			Cast.BARSCH);

	public ObservableList<String> list = FXCollections.observableArrayList(String.valueOf(fishFirst.getCast()),
			String.valueOf(fishSecond.getCast()), String.valueOf(fishThird.getCast()));

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
			stage.setScene(scene);
			stage.showAndWait();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@FXML
	void back(ActionEvent event) {

		ActionEvent e = event;
		backToPrScene(e);
	}

}
