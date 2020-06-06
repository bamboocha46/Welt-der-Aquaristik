package at.varga.java.welt_der_aquaristik.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PopUpAreYouSureController extends BasicController {

	@FXML
	private Button noButton;

	// noButton leads to previous Window
	@FXML
	void back(ActionEvent event) {
		ActionEvent e = event;
		backToPrScene(e);

	}

}
