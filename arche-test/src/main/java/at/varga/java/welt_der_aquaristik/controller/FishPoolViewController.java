package at.varga.java.welt_der_aquaristik.controller;

import java.io.IOException;

import at.varga.java.welt_der_aquaristik.application.Constants;
import at.varga.java.welt_der_aquaristik.application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FishPoolViewController extends BasicController {

	// FishCastButtons
	@FXML
	private Button perchButton;
	@FXML
	private Button coldWaterFishButton;
	@FXML
	private Button anabasButton;
	@FXML
	private Button tetraButton;
	@FXML
	private Button viviparousButton;
	@FXML
	private Button otherFishButton;
	@FXML
	private Button catFishButton;
	@FXML
	private Button darioButton;

	@FXML
	private Button backButton;

	@FXML
	void showPerches(ActionEvent event) {
		String path = Constants.PATH_TO_CAST_PERCH_FXML;
		String setTitel = "Barsche";

		showNewScene(path, setTitel);
	}

	@FXML
	void showAnabasses(ActionEvent event) {

		String path = Constants.PATH_TO_CAST_ANABAS_FXML;
		String setTitel = "Labyrinthfishe";

		showNewScene(path, setTitel);

	}

	@FXML
	void showColdWaterFishes(ActionEvent event) {
		String path = Constants.PATH_TO_CAST_ANABAS_FXML;
		String setTitel = "Kaltwasserfishe";

		showNewScene(path, setTitel);

	}

	// !!!!! DarioPath funktioniert nicht, überprüfen!!!!
	@FXML
	void showDarios(ActionEvent event) {
		String path = Constants.PATH_TO_CAST_ANABAS_FXML;
		String setTitel = "Bärblinge";

		showNewScene(path, setTitel);

	}

	@FXML
	void showCatFishes(ActionEvent event) {
		String path = Constants.PATH_TO_CAST_ANABAS_FXML;
		String setTitel = "Welse";

		showNewScene(path, setTitel);

	}

	@FXML
	void showViviparouses(ActionEvent event) {
		String path = Constants.PATH_TO_CAST_VIVIPAROUS_FXML;
		String setTitel = "Lebendgebärende";

		showNewScene(path, setTitel);

	}

	@FXML
	void showTetras(ActionEvent event) {
		String path = Constants.PATH_TO_CAST_TETRA_FXML;
		String setTitel = "Salmler";

		showNewScene(path, setTitel);

	}

	@FXML
	void showOtherFish(ActionEvent event) {
		String path = Constants.PATH_TO_CAST_OTHERFISH_FXML;
		String setTitel = "Andere Fishe";

		showNewScene(path, setTitel);

	}

	@FXML
	void back(ActionEvent event) {

		ActionEvent e = event;
		backToPrScene(e);
	}

}


//package at.varga.java.welt_der_aquaristik.controller;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import at.varga.java.welt_der_aquaristik.controller.CastAnabasController;
//import at.varga.java.welt_der_aquaristik.model.Cast;
//import at.varga.java.welt_der_aquaristik.model.FishType;
//import at.varga.java.welt_der_aquaristik.model.Socialization;
//import at.varga.java.welt_der_aquaristik.application.Constants;
//import at.varga.java.welt_der_aquaristik.application.Main;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableArray;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Node;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.ChoiceBox;
//import javafx.scene.layout.AnchorPane;
//import javafx.stage.Modality;
//import javafx.stage.Stage;
//
//public class FishPoolViewController extends BasicController {
//	
//	
//
//	// FishCastButtons
//	@FXML
//	private Button perchButton;
//	@FXML
//	private Button coldWaterFishButton;
//	@FXML
//	private Button anabasButton;
//	@FXML
//	private Button tetraButton;
//	@FXML
//	private Button viviparousButton;
//	@FXML
//	private Button otherFishButton;
//	@FXML
//	private Button catFishButton;
//	@FXML
//	private Button darioButton;
//
//	@FXML
//	private Button backButton;
//	
//	
//
//	@FXML
//	void showPerches(ActionEvent event) {
//		String path = Constants.PATH_TO_CAST_ANABAS_FXML;
//		String setTitel = "Barsche";
//
//		showNewScene(path, setTitel);
//	}
//
//	@FXML
//	void showAnabasses(ActionEvent event) {
//		//just because i dont have DB yet
//		FishType fishFirst = new FishType(1, "Neon", 5, 120, 1000, 23, 28, 5f, 7.5f, 2, 20, "", Socialization.GRUPPENFISH,
//				Cast.SALMLER);
//		FishType fishSecond = new FishType(2, "Betta", 7, 30, 100, 24, 30, 5.5f, 7.5f, 2, 20, "",
//				Socialization.EINZELHALTUNG, Cast.LABYRINTHFISH);
//		FishType fishThird = new FishType(3, "Skalar", 15, 150, 1000, 24, 28, 5.5f, 7.2f, 2, 15, "", Socialization.AGRESSIV,
//				Cast.BARSCH);
//
//		ObservableList<FishType> fishTypeList = FXCollections.observableArrayList(fishFirst, fishSecond, fishThird);
//	
//
//		String path = Constants.PATH_TO_CAST_ANABAS_FXML;
//		String setTitel = "Labyrinthfishe";
//
//		CastAnabasController test = new CastAnabasController(fishTypeList);
//		
////		CastAnabasController test = new CastAnabasController(path, setTitel,fishTypeList);
//		
////		test.showNewScene(path, setTitel);
//		test.showNewScene(path, setTitel);
//		//showNewScene(path, setTitel);
//		
//
//	}
//
//	@FXML
//	void showColdWaterFishes(ActionEvent event) {
//		FishType fishFirst = new FishType(1, "Neon", 5, 120, 1000, 23, 28, 5f, 7.5f, 2, 20, "", Socialization.GRUPPENFISH,
//				Cast.SALMLER);
//		FishType fishSecond = new FishType(2, "Betta", 7, 30, 100, 24, 30, 5.5f, 7.5f, 2, 20, "",
//				Socialization.EINZELHALTUNG, Cast.LABYRINTHFISH);
//		FishType fishThird = new FishType(3, "Skalar", 15, 150, 1000, 24, 28, 5.5f, 7.2f, 2, 15, "", Socialization.AGRESSIV,
//				Cast.BARSCH);
//
//		List <FishType> fishTypeList = new ArrayList<FishType>();
//		fishTypeList.add(fishFirst);
//		fishTypeList.add(fishSecond);
//		fishTypeList.add(fishThird);
//		
//		String path = Constants.PATH_TO_CAST_FISH_VIEW_FXML;
//		String setTitel = "Kaltwasserfishe";
//
//		CastFishController cfc = new CastFishController(fishTypeList);
//		cfc.start(path, setTitel);
//		
//
//		showNewScene(path, setTitel);
//
//	}
//
//	// !!!!! DarioPath funktioniert nicht, überprüfen!!!!
//	@FXML
//	void showDarios(ActionEvent event) {
//		String path = Constants.PATH_TO_CAST_ANABAS_FXML;
//		String setTitel = "Bärblinge";
//
//		showNewScene(path, setTitel);
//		
//		
//
//	}
//
//	@FXML
//	void showCatFishes(ActionEvent event) {
//		String path = Constants.PATH_TO_CAST_ANABAS_FXML;
//		String setTitel = "Welse";
//
//		showNewScene(path, setTitel);
//
//	}
//
//	@FXML
//	void showViviparouses(ActionEvent event) {
//		String path = Constants.PATH_TO_CAST_ANABAS_FXML;
//		String setTitel = "Lebendgebärende";
//
//		showNewScene(path, setTitel);
//
//	}
//
//	@FXML
//	void showTetras(ActionEvent event) {
//		String path = Constants.PATH_TO_CAST_ANABAS_FXML;
//		String setTitel = "Salmler";
//
//		showNewScene(path, setTitel);
//
//	}
//
//	@FXML
//	void showOtherFish(ActionEvent event) {
//		String path = Constants.PATH_TO_CAST_ANABAS_FXML;
//		String setTitel = "Andere Fishe";
//
//		showNewScene(path, setTitel);
//
//	}
//
//	@FXML
//	void back(ActionEvent event) {
//
//		ActionEvent e = event;
//		backToPrScene(e);
//	}
//
//}
