package at.varga.java.welt_der_aquaristik.controller;

import java.io.IOException;

import at.varga.java.welt_der_aquaristik.application.Constants;
import at.varga.java.welt_der_aquaristik.application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class AddNewFishToListController {

	@FXML
	private Button backButton;

	// doesnt save yet
	// just show popUp: SaveMessage
	@FXML
	void save(ActionEvent event) {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource(Constants.PATH_TO_POP_UP_SAVE_FXML));
		AnchorPane popUpSaveMessage = null;
		try {
			popUpSaveMessage = loader.load();
		} catch (IOException e) {

			e.printStackTrace();
		}

		Stage puSave = new Stage();
		puSave.setTitle("Speicherung");
		puSave.initModality(Modality.WINDOW_MODAL);
		puSave.initOwner(Main.primaryStage);

		Scene scene = new Scene(popUpSaveMessage);
		puSave.setScene(scene);
		puSave.showAndWait();

	}

	@FXML
	void back(ActionEvent event) {

		Stage currentStage = (Stage) ((Node) event.getTarget()).getScene().getWindow();
		currentStage.close();
	}

}
