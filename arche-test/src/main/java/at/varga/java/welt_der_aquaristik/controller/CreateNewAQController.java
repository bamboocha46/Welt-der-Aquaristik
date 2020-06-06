package at.varga.java.welt_der_aquaristik.controller;

import java.io.IOException;

import at.varga.java.welt_der_aquaristik.application.Constants;
import at.varga.java.welt_der_aquaristik.application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CreateNewAQController extends BasicController {

	@FXML
	private TextField volumeTextField;

	@FXML
	private TextField sizeLength;

	@FXML
	private TextField aqNameTextField;

	@FXML
	private TextField ghTextField;

	@FXML
	private TextField sizeWidth;

	@FXML
	private TextField temperaturTextField;

	@FXML
	private Button breakButton;

	@FXML
	private TextField sizeHeight;

	@FXML
	private Button saveButton;

	@FXML
	private TextField phTextField;

	// back to WelcomeWindow
	@FXML
	void back(ActionEvent event) throws IOException {

		Stage currentStage = (Stage) ((Node) event.getTarget()).getScene().getWindow();
		currentStage.close();

	}

	// doesnt save yet
	// just show popUp: SaveMessage
	@FXML
	void save(ActionEvent event) {
		
		String path = Constants.PATH_TO_POP_UP_SAVE_FXML;
		String setTitel = "Speicherung";

		showNewScene(path, setTitel);


	}

}
