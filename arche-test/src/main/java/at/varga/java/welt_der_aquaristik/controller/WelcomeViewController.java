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

public class WelcomeViewController {

	@FXML
	private Text titelText;

	@FXML
	private ChoiceBox<?> listOfAQsChioceBox;

	@FXML
	private Button newAQButton;

	@FXML
	private Text textNameForMyAQs;

	@FXML
	private SplitMenuButton MyAQsMenuButton;

	@FXML
	private Button listOfFischesButton;

	// this method opens a new Window (CreateNewAQ)
	@FXML
	void openNewAQScene(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource(Constants.PATH_TO_CREATENEWAQ_FXML));
		AnchorPane addNewAQ = null;
		try {
			addNewAQ = loader.load();
		} catch (IOException e) {

			e.printStackTrace();
		}

		Stage createNewAQStage = new Stage();
		createNewAQStage.setTitle("Neues Aquarium hinzufügen");
		createNewAQStage.initModality(Modality.WINDOW_MODAL);
		createNewAQStage.initOwner(Main.primaryStage);

		Scene scene = new Scene(addNewAQ);
		createNewAQStage.setScene(scene);
		createNewAQStage.showAndWait();
	}

	// this method opens a new Window (ListOfFishes)
	@FXML
	void openListOfFishesWindow(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource(Constants.PATH_TO_FISH_POOL_VIEW_FXML));
		AnchorPane showListOfFishes = null;
		try {
			showListOfFishes = loader.load();
		} catch (IOException e) {

			e.printStackTrace();
		}

		Stage listOfFishes = new Stage();
		listOfFishes.setTitle("Liste der Fische");
		listOfFishes.initModality(Modality.WINDOW_MODAL);
		listOfFishes.initOwner(Main.primaryStage);

		Scene scene = new Scene(showListOfFishes);
		listOfFishes.setScene(scene);
		listOfFishes.showAndWait();

	}

	// This method opens an AQDateSheet
	@FXML
	void openAnAQ(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource(Constants.PATH_TO_AQDATESHEET_FXML));
		AnchorPane showAnAQ = null;
		try {
			showAnAQ = loader.load();
		} catch (IOException e) {

			e.printStackTrace();
		}

		Stage aqDateSheet = new Stage();
		aqDateSheet.setTitle(".getName");
		aqDateSheet.initModality(Modality.WINDOW_MODAL);
		aqDateSheet.initOwner(Main.primaryStage);

		Scene scene = new Scene(showAnAQ);
		aqDateSheet.setScene(scene);
		aqDateSheet.showAndWait();

	}

}
