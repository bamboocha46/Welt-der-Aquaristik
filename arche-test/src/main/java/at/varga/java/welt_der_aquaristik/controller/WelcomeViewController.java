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

public class WelcomeViewController extends BasicController {

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
		String setTitel = "Neues Aquarium hinzuf�gen";

		showNewScene(path, setTitel);
//		FXMLLoader loader = new FXMLLoader();
//		loader.setLocation(Main.class.getResource(Constants.PATH_TO_CREATENEWAQ_FXML));
//		AnchorPane addNewAQ = null;
//		try {
//			addNewAQ = loader.load();
//		} catch (IOException e) {
//
//			e.printStackTrace();
//		}
//
//		Stage createNewAQStage = new Stage();
//		createNewAQStage.setTitle("Neues Aquarium hinzuf�gen");
//		createNewAQStage.initModality(Modality.WINDOW_MODAL);
//		createNewAQStage.initOwner(Main.primaryStage);
//
//		Scene scene = new Scene(addNewAQ);
//		createNewAQStage.setScene(scene);
//		createNewAQStage.showAndWait();
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
