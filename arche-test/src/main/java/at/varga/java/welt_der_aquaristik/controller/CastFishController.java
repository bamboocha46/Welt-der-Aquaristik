package at.varga.java.welt_der_aquaristik.controller;

import java.util.List;

import at.varga.java.welt_der_aquaristik.application.Constants;
import at.varga.java.welt_der_aquaristik.model.FishType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class CastFishController extends BasicController {

	@FXML
	private ComboBox<String> fishTypeComboBox;

	@FXML
	private Button fishTypeShowButton;

	@FXML
	private Button backButton;

	List<FishType> fishTypeList;

	public CastFishController(List<FishType> fishTypeList) {
		this.fishTypeList = fishTypeList;

	}

	void start(String path, String titel) {

		showNewScene(path, titel);
		initalize();
	}

	@FXML
	private void initalize() {

		ObservableList<String> fishBreedList = FXCollections.observableArrayList();

		if (this.fishTypeList != null) {
			for (FishType f : fishTypeList) {
				fishBreedList.add(f.getBreed());
			}
		} else {
			fishBreedList.add("hülyeség");
			System.out.println("picsába, nem sikerült!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		}
		if (fishBreedList != null) {
			fishTypeComboBox.setValue(fishBreedList.get(0));
			fishTypeComboBox.setItems(fishBreedList);
		} else {
			System.out.println("liste ures");
		}

	}

	@FXML
	void choseFishType(ActionEvent event) {

	}

	@FXML
	void showFishType(ActionEvent event) {

	}

	@FXML
	void back(ActionEvent event) {

	}

}
