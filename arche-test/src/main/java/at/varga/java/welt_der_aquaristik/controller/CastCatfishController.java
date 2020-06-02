package at.varga.java.welt_der_aquaristik.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class CastCatfishController {

	@FXML
	private ComboBox<?> fishTypeComboBox;

	@FXML
	private Button backButton;

	@FXML
	private Button fishTypeShowButton;

	@FXML
	void choseFishType(ActionEvent event) {

	}

	@FXML
	void showFishType(ActionEvent event) {

	}

	@FXML
	void back(ActionEvent event) {
		Stage currentStage = (Stage)((Node)event.getTarget()).getScene().getWindow();
		currentStage.close();
	}

}
