package at.varga.java.welt_der_aquaristik.controller;
//ITT PROBÀLKOZOK EGY FISHCASTCONTROLLER LÉTREHOZÁSAÁVALAMI ÁLTALÁNOS


import java.util.ArrayList;
import java.util.List;

import at.varga.java.welt_der_aquaristik.model.Cast;
import at.varga.java.welt_der_aquaristik.model.FishType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class CastCatfishController {

	@FXML
	private ComboBox<?> fishTypeComboBox;

	@FXML
	private Button backButton;

	@FXML
	private Button fishTypeShowButton;
//	
//	private List<FishType> fishTypeFromDB = new ArrayList<FishType>();
//	
//	@FXML
//	void choseFishType(ActionEvent event) {
//		for (FishType f : fishTypeFromDB) {
//			if (f.getBreed().equals(Cast.BARSCH)) {
//
//			}
//
//		}
//
//	}

	@FXML
	void showFishType(ActionEvent event) {

	}

	@FXML
	void back(ActionEvent event) {
		Stage currentStage = (Stage)((Node)event.getTarget()).getScene().getWindow();
		currentStage.close();
	}

}
