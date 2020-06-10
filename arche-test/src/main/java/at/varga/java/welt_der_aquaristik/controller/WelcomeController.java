package at.varga.java.welt_der_aquaristik.controller;

import java.io.IOException;

import at.varga.java.welt_der_aquaristik.application.Constants;
import at.varga.java.welt_der_aquaristik.application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class WelcomeController extends BasicController {

	@FXML
	private Button myAQsButton;

	@FXML
	private Button newAQButton;

	@FXML
	private Button listOfFischesButton;

	// this method opens a new Window (CreateNewAQ)
	@FXML
	void openNewAQScene(ActionEvent event) {

		String path = Constants.PATH_TO_CREATENEWAQ_FXML;
		String setTitel = "Neues Aquarium hinzufügen";

		showNewScene(path, setTitel);

	}

	// this method opens a new Window (ListOfFishes)
	@FXML
	void openListOfFishesWindow(ActionEvent event) {
		String path = Constants.PATH_TO_FISH_POOL_VIEW_FXML;
		String setTitel = "Liste der Fische";

		showNewScene(path, setTitel);

	}

	// This method opens the AQDateSheet Scene
	@FXML
	void openAQDateSheet(ActionEvent event) {

		String path = Constants.PATH_TO_AQDATESHEET_FXML;
		String setTitel = ".getName";

		showNewScene(path, setTitel);

	}

}
