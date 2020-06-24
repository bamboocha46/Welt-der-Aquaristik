package at.varga.java.welt_der_aquaristik.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import at.varga.java.welt_der_aquaristik.application.Constants;
import at.varga.java.welt_der_aquaristik.exception.ServiceException;
import at.varga.java.welt_der_aquaristik.model.AQ;
import at.varga.java.welt_der_aquaristik.model.Cast;
import at.varga.java.welt_der_aquaristik.model.FishType;
import at.varga.java.welt_der_aquaristik.model.FishTypeInAQ;
import at.varga.java.welt_der_aquaristik.model.Socialization;
import at.varga.java.welt_der_aquaristik.repository.FishTypeRepositoryJPA;
import at.varga.java.welt_der_aquaristik.service.FishTypeInAQService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class AddNewFishToAQController extends BasicController {

	FishTypeInAQService fishTypeInAQService = new FishTypeInAQService();
//	 FishTypes as examples
//	FishType fishFirst = new FishType(1, "Neon", 5, 120, 1000, 23, 28, 5f, 7.5f, 2, 20, "", Socialization.GRUPPENFISH,
//			Cast.SALMLER);
//	FishType fishSecond = new FishType(2, "Betta", 7, 30, 100, 24, 30, 5.5f, 7.5f, 2, 20, "",
//			Socialization.EINZELHALTUNG, Cast.LABYRINTHFISCH);
//	FishType fishThird = new FishType(3, "Skalar", 15, 150, 1000, 24, 28, 5.5f, 7.2f, 2, 15, "", Socialization.AGRESSIV,
//			Cast.BARSCH);
//	FishType fish5 = new FishType(4, "fish1", 15, 150, 1000, 24, 28, 5.5f, 7.2f, 2, 15, "", Socialization.AGRESSIV,
//			Cast.ANDERE_FISCH);
//	FishType fish6 = new FishType(5, "fish2", 115, 150, 1000, 24, 28, 5.5f, 7.2f, 2, 15, "", Socialization.AGRESSIV,
//			Cast.BARSCH);
//	FishType fish7 = new FishType(6, "fish3", 1115, 150, 1000, 24, 28, 5.5f, 7.2f, 2, 15, "", Socialization.AGRESSIV,
//			Cast.BAERBLING);
//	FishType fish8 = new FishType(7, "fish4", 11115, 150, 1000, 24, 28, 5.5f, 7.2f, 2, 15, "", Socialization.AGRESSIV,
//			Cast.KALTWASSERFISCH);
//	FishType fish9 = new FishType(8, "fish5", 155, 150, 1000, 24, 28, 5.5f, 7.2f, 2, 15, "", Socialization.AGRESSIV,
//			Cast.LABYRINTHFISCH);
//	FishType fish10 = new FishType(9, "fish6", 22, 1500, 10000, 24, 28, 5.5f, 7.2f, 2, 15, "", Socialization.AGRESSIV,
//			Cast.LABYRINTHFISCH);
//	FishType fish11 = new FishType(10, "fish7", 35, 150, 1000, 24, 28, 5.5f, 7.2f, 2, 15, "", Socialization.GRUPPENFISH,
//			Cast.LEBENDGEBAERENDE);
//	FishType fish12 = new FishType(11, "fish8", 45, 150, 1000, 24, 28, 5.5f, 7.2f, 2, 15, "", Socialization.AGRESSIV,
//			Cast.SALMLER);
//	FishType fish13 = new FishType(12, "fish9", 55, 150, 1000, 24, 28, 5.5f, 7.2f, 2, 15, "", Socialization.GRUPPENFISH,
//			Cast.WELS);
//	FishType fish14 = new FishType(13, "fish10", 175, 150, 1000, 24, 28, 5.5f, 7.2f, 2, 15, "", Socialization.AGRESSIV,
//			Cast.LABYRINTHFISCH);
//	FishType fish15 = new FishType(14, "fish11", 1, 150, 1000, 24, 28, 5.5f, 7.2f, 2, 15, "", Socialization.AGRESSIV,
//			Cast.LABYRINTHFISCH);

	private List<FishType> fishTypeFromDB = new ArrayList<FishType>();

//	ObservableList<FishType> fishBreedList = FXCollections.observableArrayList(fishFirst, fishSecond, fishThird);

	// Lists to ComboBoxes ->setValue
	ObservableList<FishType> perchList = FXCollections.observableArrayList();
	ObservableList<FishType> coldWaterFishList = FXCollections.observableArrayList();
	ObservableList<FishType> viviparousList = FXCollections.observableArrayList();
	ObservableList<FishType> catFishList = FXCollections.observableArrayList();
	ObservableList<FishType> darioList = FXCollections.observableArrayList();
	ObservableList<FishType> anabasList = FXCollections.observableArrayList();
	ObservableList<FishType> tetraList = FXCollections.observableArrayList();
	ObservableList<FishType> otherFishList = FXCollections.observableArrayList();

//	ObservableList<String> fishBreedList = FXCollections.observableArrayList(fishFirst.getBreed(),
//			fishSecond.getBreed(), fishThird.getBreed());

//	ObservableList<String> perchList = FXCollections.observableArrayList();
//	ObservableList<String> coldWaterFishList = FXCollections.observableArrayList();
//	ObservableList<String> viviparousList = FXCollections.observableArrayList();
//	ObservableList<String> catFishList = FXCollections.observableArrayList();
//	ObservableList<String> darioList = FXCollections.observableArrayList();
//	ObservableList<String> anabasList = FXCollections.observableArrayList();
//	ObservableList<String> tetraList = FXCollections.observableArrayList();
//	ObservableList<String> otherFishList = FXCollections.observableArrayList();

	@FXML
	private TextField pieceOfFisches;
	@FXML
	private ComboBox<FishType> perchComboBox;

	@FXML
	private ComboBox<FishType> catFishComboBox;

	@FXML
	private ComboBox<FishType> anabasComboBox;

	@FXML
	private ComboBox<FishType> coldWaterFishComboBox;

	@FXML
	private ComboBox<FishType> darioComboBox;

	@FXML
	private ComboBox<FishType> otherFishComboBox;

	@FXML
	private ComboBox<FishType> tetraComboBox;

	@FXML
	private ComboBox<FishType> viviparousComboBox;

	@FXML
	private Button saveButton;

	@FXML
	private Button breakButton;

	@FXML
	private Text choosenFishTextField;

	FishType selectedFish;
	private AQ givenAQ;

	public AQ getAquarium() {
		return givenAQ;
	}

	@FXML
	void choosePerch(ActionEvent event) {
		selectedFish = perchComboBox.getValue();
		choosenFishTextField.setText(selectedFish.toString() + ", id" + selectedFish.getId());
	}

	@FXML
	void chooseColdWaterFish(ActionEvent event) {
		selectedFish = coldWaterFishComboBox.getValue();
		choosenFishTextField.setText(selectedFish.toString());
	}

	@FXML
	void chooseViviparous(ActionEvent event) {
		selectedFish = viviparousComboBox.getValue();
		choosenFishTextField.setText(selectedFish.toString());
	}

	@FXML
	void chooseCatFish(ActionEvent event) {
		selectedFish = catFishComboBox.getValue();
		choosenFishTextField.setText(selectedFish.toString());
	}

	@FXML
	void chooseDario(ActionEvent event) {
		selectedFish = darioComboBox.getValue();
		choosenFishTextField.setText(selectedFish.toString());
	}

	@FXML
	void chooseAnabas(ActionEvent event) {
		selectedFish = anabasComboBox.getValue();
		choosenFishTextField.setText(selectedFish.toString());
	}

	@FXML
	void choosetetra(ActionEvent event) {
		selectedFish = tetraComboBox.getValue();
		choosenFishTextField.setText(selectedFish.toString());
	}

	@FXML
	void chooseOtherFish(ActionEvent event) {
		selectedFish = otherFishComboBox.getValue();
		choosenFishTextField.setText(selectedFish.toString());
	}

	@FXML
	private void initialize() {

//		fishTypeFromDB.add(fishFirst);
//		fishTypeFromDB.add(fishSecond);
//		fishTypeFromDB.add(fishThird);
//		fishTypeFromDB.add(fish5);
//		fishTypeFromDB.add(fish6);
//		fishTypeFromDB.add(fish7);
//		fishTypeFromDB.add(fish8);
//		fishTypeFromDB.add(fish9);
//		fishTypeFromDB.add(fish10);
//		fishTypeFromDB.add(fish11);
//		fishTypeFromDB.add(fish12);
//		fishTypeFromDB.add(fish13);
//		fishTypeFromDB.add(fish14);
//		fishTypeFromDB.add(fish15);

		FishTypeRepositoryJPA repo = new FishTypeRepositoryJPA();
		fishTypeFromDB = repo.getAll();
		System.out.println("Loaded fish types");

		fishTypeFromDB.forEach(ft -> System.out.println(ft.getCast()));

		for (FishType f : fishTypeFromDB) {
			if (f.getCast().equals(Cast.BARSCH)) {
				perchList.add(f);
			} else if (f.getCast().equals(Cast.KALTWASSERFISCH)) {
				coldWaterFishList.add(f);
			} else if (f.getCast().equals(Cast.LEBENDGEBAERENDE)) {
				viviparousList.add(f);
			} else if (f.getCast().equals(Cast.WELS)) {
				catFishList.add(f);
			} else if (f.getCast().equals(Cast.BAERBLING)) {
				darioList.add(f);
			} else if (f.getCast().equals(Cast.LABYRINTHFISCH)) {
				anabasList.add(f);
			} else if (f.getCast().equals(Cast.SALMLER)) {
				tetraList.add(f);
			} else if (f.getCast().equals(Cast.ANDERE_FISCH)) {
				otherFishList.add(f);
			}
		}
		perchComboBox.setValue(perchList.get(0));
		perchComboBox.setItems(perchList);

		coldWaterFishComboBox.setValue(coldWaterFishList.get(0));
		coldWaterFishComboBox.setItems(coldWaterFishList);

		viviparousComboBox.setValue(viviparousList.get(0));
		viviparousComboBox.setItems(viviparousList);

		catFishComboBox.setValue(catFishList.get(0));
		catFishComboBox.setItems(catFishList);

		darioComboBox.setValue(darioList.get(0));
		darioComboBox.setItems(darioList);

		anabasComboBox.setValue(anabasList.get(0));
		anabasComboBox.setItems(anabasList);

		tetraComboBox.setValue(tetraList.get(0));
		tetraComboBox.setItems(tetraList);

		otherFishComboBox.setValue(otherFishList.get(0));
		otherFishComboBox.setItems(otherFishList);
	}

//	@FXML
//	void save(ActionEvent event) {
//
//		System.out.println(
//				"Fisch und anzahl  :" + choosenFishTextField.getText() + Integer.valueOf(pieceOfFisches.getText()));
//
//		FishTypeInAQ saved = null;
//		saved.setFishType(selectedFish);
//		saved.setQuantity(Integer.valueOf(pieceOfFisches.getText()));
//		saved.setAq(null);
//		System.out.println(saved);
//		//Control if quantity INT is
//		int quantity;
//		boolean isInputFormatCorrect = true;
//		try {
//			quantity = Integer.parseInt(pieceOfFisches.getText());
//
//		} catch (NumberFormatException ex) {
//			isInputFormatCorrect = false;
//		}
//		if (isInputFormatCorrect) {
//			try {
//				fishTypeInAQService.addFishTypeInAQ(saved);
//				System.out.println(saved + " saved in DB");
//				saved = null;
//				
//			} catch (ServiceException e) {
//
//				e.printStackTrace();
//			}
//
//			String path = Constants.PATH_TO_POP_UP_SAVE_FXML;
//			String setTitel = "Speicherung";
//			showNewScene(path, setTitel);
//			
//		}
//	
//	}
	// CSAKPROBA
	@FXML
	public void giveMeAQ(AQ a) {
		this.givenAQ = a;
	}

	@FXML
	void save(ActionEvent event) {

		System.out.println(
				"Fisch und anzahl  :" + choosenFishTextField.getText() + Integer.valueOf(pieceOfFisches.getText()));

//		FishTypeInAQ saved = null;
//		FishTypeInAQ saved = new FishTypeInAQ();

		// jprie: nachsehen ob FishTypeInAQ existiert
		List<FishTypeInAQ> list = givenAQ.getListOfFishes();
		Optional<FishTypeInAQ> match = list.stream().filter(ft -> ft.getFishType().getCast() == selectedFish.getCast())
				.findFirst();

		FishTypeInAQ ftqa;

		if (match.isPresent()) {
			ftqa = match.get();
			ftqa.setQuantity(ftqa.getQuantity() + Integer.valueOf(pieceOfFisches.getText()));

			try {
				fishTypeInAQService.updateFishTypeInAQ(ftqa);
			} catch (ServiceException e) {

				e.printStackTrace();

			}

		} else {
			ftqa = new FishTypeInAQ(selectedFish, givenAQ, Integer.valueOf(pieceOfFisches.getText()));

			int quantity;
			boolean isInputFormatCorrect = true;
			try {
				quantity = Integer.parseInt(pieceOfFisches.getText());

			} catch (NumberFormatException ex) {
				isInputFormatCorrect = false;
			}
			if (isInputFormatCorrect) {
				try {
					fishTypeInAQService.addFishTypeInAQ(ftqa);
				} catch (ServiceException e) {

					e.printStackTrace();
				}
			}
		}

		System.out.println(ftqa);

//		saved.setFishType(selectedFish);
//		saved.setQuantity(Integer.valueOf(pieceOfFisches.getText()));
//		saved.setAq(givenAQ);
//		System.out.println(saved);
		// Control if quantity INT is
//		int quantity;
//		boolean isInputFormatCorrect = true;
//		try {
//			quantity = Integer.parseInt(pieceOfFisches.getText());
//
//		} catch (NumberFormatException ex) {
//			isInputFormatCorrect = false;
//		}
//		if (isInputFormatCorrect) {
//			try {
//				fishTypeInAQService.addFishTypeInAQ(saved);
//				System.out.println(saved + " saved in DB");
//				saved = null;
//
//			} catch (ServiceException e) {
//
//				e.printStackTrace();
//			}

		String path = Constants.PATH_TO_POP_UP_SAVE_FXML;
		String setTitel = "Speicherung";
		showNewScene(path, setTitel);

	}

	@FXML
	void back(ActionEvent event) {
		ActionEvent e = event;
		backToPrScene(e);
	}

}
