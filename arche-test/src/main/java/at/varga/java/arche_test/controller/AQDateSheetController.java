package at.varga.java.arche_test.controller;

import java.io.IOException;

import at.varga.java.arche_test.application.Constants;
import at.varga.java.arche_test.application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import javafx.stage.Modality;
import javafx.stage.Stage;

public class AQDateSheetController {

	@FXML
	private Button AddNewFishButton;

	
	//Method to add a new fish to the AQ
	@FXML
	void addANewFishToAQ(ActionEvent event) {

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
	
	//does not delete any fish yet
	//just show PUAreUSure
    @FXML
    void deleteFish(ActionEvent event) {
    	
  	  FXMLLoader loader = new FXMLLoader ();
  			loader.setLocation(Main.class.getResource(Constants.PATH_TO_PUAREUSURE_FXML));
  			AnchorPane popUpAUSure = null;
  			try {
  				popUpAUSure = loader.load();
  			} catch (IOException e) {
  				
  				e.printStackTrace();
  			}
  			
  			Stage puAUS = new Stage();
  			puAUS.setTitle("Bist sicher?");
  			puAUS.initModality(Modality.WINDOW_MODAL);
  			puAUS.initOwner(Main.primaryStage);
  			
  			Scene scene = new Scene(popUpAUSure);
  			puAUS.setScene(scene);
  			puAUS.showAndWait();


    }

   //does not delete any fish yet
  	//just show PUAreUSure
    @FXML
    void deleteAQ(ActionEvent event) {

   	  FXMLLoader loader = new FXMLLoader ();
		loader.setLocation(Main.class.getResource(Constants.PATH_TO_PUAREUSURE_FXML));
		AnchorPane popUpAUSure = null;
		try {
			popUpAUSure = loader.load();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		Stage puAUS = new Stage();
		puAUS.setTitle("Bist sicher?");
		puAUS.initModality(Modality.WINDOW_MODAL);
		puAUS.initOwner(Main.primaryStage);
		
		Scene scene = new Scene(popUpAUSure);
		puAUS.setScene(scene);
		puAUS.showAndWait();
    }
	
	

}