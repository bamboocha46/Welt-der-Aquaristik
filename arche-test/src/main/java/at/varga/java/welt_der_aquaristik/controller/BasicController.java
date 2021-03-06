/**
 * 
 */
package at.varga.java.welt_der_aquaristik.controller;

import java.io.IOException;

import at.varga.java.welt_der_aquaristik.application.Constants;
import at.varga.java.welt_der_aquaristik.application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @author eszte
 * Hier are methods, they will be often use by the controllers
 */

public abstract class BasicController {

	public void showNewScene(String path, String setTitel) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource(path));
			AnchorPane ap = null;

			ap = loader.load();

			Stage stage = new Stage();
			stage.setTitle(setTitel);
			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(Main.primaryStage);

			Scene scene = new Scene(ap);
			scene.getStylesheets().add(getClass().getResource(Constants.PATH_TO_APPLICATION_CSS).toExternalForm());
			stage.setScene(scene);
			stage.showAndWait();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void showPopUp(String text) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(Constants.PATH_TO_POP_UP_SAVE_FXML));
			Parent root = loader.load();

			PopUpSaveMessageController popUpSavectrl = loader.getController();
			popUpSavectrl.setPopUpText(text);

			Stage stage = new Stage();
			stage.setTitle("Info");
			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(Main.primaryStage);

			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource(Constants.PATH_TO_APPLICATION_CSS).toExternalForm());
			stage.setScene(scene);
			stage.showAndWait();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void backToPrScene(ActionEvent e) {
		Stage currentStage = (Stage) ((Node) e.getTarget()).getScene().getWindow();
		currentStage.close();

	}

	public void closeSceene(ActionEvent event) {
		((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
	}

}
