/**
 * 
 */
package at.varga.java.welt_der_aquaristik.controller;

import java.io.IOException;

import at.varga.java.welt_der_aquaristik.application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @author eszte
 *
 */
public abstract class BasicController {
	
	public void showNewScene(String path, String setTitel) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource(path));
		AnchorPane ap = null;
		try {
			ap = loader.load();
		

		Stage stage = new Stage();
		stage.setTitle(setTitel);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(Main.primaryStage);

		Scene scene = new Scene(ap);
		stage.setScene(scene);
		stage.showAndWait();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	


}