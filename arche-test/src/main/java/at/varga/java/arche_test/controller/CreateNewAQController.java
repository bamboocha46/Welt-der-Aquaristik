package at.varga.java.arche_test.controller;

import java.io.IOException;

import at.varga.java.arche_test.application.Constants;
import at.varga.java.arche_test.application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CreateNewAQController {

	@FXML
	private TextField volume;

	@FXML
	private TextField aqNameTextField;

	@FXML
	private Button newFishButton;

	@FXML
	private TextField size3;

	@FXML
	private Button breakButton;

	@FXML
	private TextField size1;

	@FXML
	private TextField size2;

	@FXML
	private Button saveButton;

//    @FXML
//    void save(ActionEvent event) {
//
//    }
//
	//back to PrimarWindow
	 @FXML
	    void back(ActionEvent event) throws IOException {
		 FXMLLoader loader = new FXMLLoader(getClass().getResource(Constants.PATH_TO_PRIMER_FXML));  
		    Stage stage = new Stage();
		    stage.setScene(new Scene((Parent) loader.load()));
		    stage.show();

	    }

	// Method to add Fish(es) to the new AQ
	@FXML
	void addNewFish(ActionEvent event) {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource(Constants.PATH_TO_ADDNEWFISHTOAQ_FXML));
		AnchorPane addNewFishToAQ = null;
		try {
			addNewFishToAQ = loader.load();
		} catch (IOException e) {

			e.printStackTrace();
		}

		Stage addNewFishWindow = new Stage();
		addNewFishWindow.setTitle("Neuen Fisch zur Aquarium hinzufügen");
		addNewFishWindow.initModality(Modality.WINDOW_MODAL);
		addNewFishWindow.initOwner(Main.primaryStage);

		Scene scene = new Scene(addNewFishToAQ);
		addNewFishWindow.setScene(scene);
		addNewFishWindow.showAndWait();

	}
	
	//doesnt save yet
	// just show popUp: SaveMessage
	  @FXML
	    void save(ActionEvent event) {
		  
		  FXMLLoader loader = new FXMLLoader ();
			loader.setLocation(Main.class.getResource(Constants.PATH_TO_PUSAVE_FXML));
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

}
