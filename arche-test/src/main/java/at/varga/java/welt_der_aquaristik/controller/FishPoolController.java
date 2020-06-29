package at.varga.java.welt_der_aquaristik.controller;

import java.io.IOException;

import at.varga.java.welt_der_aquaristik.application.Constants;
import at.varga.java.welt_der_aquaristik.application.Main;
import at.varga.java.welt_der_aquaristik.model.Cast;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FishPoolController extends BasicController {

	@FXML
	private ComboBox<String> castComboBox;
	@FXML
	private Button showCastViewButton;

	@FXML
	private Button backButton;

	public ObservableList<String> list = FXCollections.observableArrayList(Cast.ANDERE_FISCH.getCastName(),
			Cast.BARSCH.getCastName(), Cast.BAERBLING.getCastName(), Cast.KALTWASSERFISCH.getCastName(),
			Cast.LABYRINTHFISCH.getCastName(), Cast.LEBENDGEBAERENDE.getCastName(), Cast.SALMLER.getCastName(),
			Cast.WELS.getCastName());

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
			
			closeSceene(event);
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
