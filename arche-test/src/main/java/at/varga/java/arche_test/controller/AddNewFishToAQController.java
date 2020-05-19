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

public class AddNewFishToAQController {

	@FXML
	private Button breakButton;

	@FXML
	private Button saveButton;

	@FXML
	private TextField pieceOfFisches;
	
	//back to AQ datesheet window
	@FXML
    void back(ActionEvent event) throws IOException {
		 FXMLLoader loader = new FXMLLoader(getClass().getResource(Constants.PATH_TO_AQDATESHEET_FXML));  
		    Stage stage = new Stage();
		    stage.setScene(new Scene((Parent) loader.load()));
		    stage.show();

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
