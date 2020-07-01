package at.varga.java.welt_der_aquaristik.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import at.varga.java.welt_der_aquaristik.exception.ServiceException;
import at.varga.java.welt_der_aquaristik.model.AQ;
import at.varga.java.welt_der_aquaristik.model.Cast;
import at.varga.java.welt_der_aquaristik.model.FishType;
import at.varga.java.welt_der_aquaristik.model.FishTypeInAQ;
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

	private List<FishType> fishTypeFromDB = new ArrayList<FishType>();

	// Lists to ComboBoxes ->setValue
	ObservableList<FishType> perchList = FXCollections.observableArrayList();
	ObservableList<FishType> coldWaterFishList = FXCollections.observableArrayList();
	ObservableList<FishType> viviparousList = FXCollections.observableArrayList();
	ObservableList<FishType> catFishList = FXCollections.observableArrayList();
	ObservableList<FishType> darioList = FXCollections.observableArrayList();
	ObservableList<FishType> anabasList = FXCollections.observableArrayList();
	ObservableList<FishType> tetraList = FXCollections.observableArrayList();
	ObservableList<FishType> otherFishList = FXCollections.observableArrayList();

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
		choosenFishTextField.setText(selectedFish.toString());
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

	@FXML
	public void giveMeAQ(AQ a) {
		this.givenAQ = a;
	}
	@FXML
	void save(ActionEvent event) {

		// Control if UserQuantity input is correct
		int quantity;

		boolean isInputFormatCorrect = true;
		try {
			quantity = Integer.parseInt(pieceOfFisches.getText());
		} catch (NumberFormatException ex) {
			isInputFormatCorrect = false;
		}
		
		//Control,if quantity >0
		if(isInputFormatCorrect) {
			if (Integer.valueOf(pieceOfFisches.getText()) > 0) {
				
			}else {
				isInputFormatCorrect = false;
				showPopUp("Sie müssen eine pozitive Zahl eingeben!");
			}
			
		}

		// controll if AQ for Fish Ok is
		if (isAQOkForFish(givenAQ, selectedFish)) {

			// Input from User is correct
			if (isInputFormatCorrect) {
				// jprie: nachsehen ob FishTypeInAQ existiert
				List<FishTypeInAQ> list = givenAQ.getListOfFishes();
				Optional<FishTypeInAQ> match = list.stream()
						.filter(ft -> ft.getFishType().getCast() == selectedFish.getCast()).findFirst();

				FishTypeInAQ ftqa;

				if (match.isPresent()) {
					ftqa = match.get();
					ftqa.setQuantity(ftqa.getQuantity() + Integer.valueOf(pieceOfFisches.getText()));

					try {
						fishTypeInAQService.updateFishTypeInAQ(ftqa);
						showPopUp("zusätlichen Fische sind zur AQ hingefügt");
					} catch (ServiceException e) {

						e.printStackTrace();

					}

				} else {
					ftqa = new FishTypeInAQ(selectedFish, givenAQ, Integer.valueOf(pieceOfFisches.getText()));

					try {
						fishTypeInAQService.addFishTypeInAQ(ftqa);
						showPopUp(pieceOfFisches.getText() + " Stk " + choosenFishTextField.getText() + " würde zur "
								+ givenAQ.getTitel() + " hingefügt");
					} catch (ServiceException e) {

						e.printStackTrace();
					}
				}

				System.out.println(ftqa);

				// If UserInput is wrong, User get a PopUp
			} else {
				showPopUp("Falsche Eingabe, bitte korrigieren!"
						+ "Bitte geben Sie nur ganze, positive Nummer ein!");
				
				System.out.println("Wrong UserInput int!=int");
			}
		} else {
			showPopUp("Wähle einen andrem Fisch!");
		}

	}

	@FXML
	void back(ActionEvent event) {

		backToPrScene(event);

	}

	// method to controll if AQParameters for FISH OK are?
	public boolean isAQOkForFish(AQ a, FishType f) {

		boolean isAQOK = false;

		if (f.getMinGH() <= a.getgH() && f.getMaxGH() >= a.getgH()) {
			if (f.getMinPh() <= a.getPh() && f.getMaxPh() >= a.getPh()) {
				if (f.getMinAqVolumen() <= a.getVolumen() && f.getMaxAqVolumen() >= a.getVolumen()) {
					if (f.getMinTemperatur() <= a.getTemperatur() && f.getMaxTemperatur() >= a.getTemperatur()) {
						System.out.println("AQ is perfect for Fish");
						isAQOK = true;
						showPopUp("Dieses AQ is perfekt für diesen Fisch!");

					} else {
						System.out.println("Temperatur is not OK for Fish");
						showPopUp("Dieser Fish braucht Wassertemperatur zw. " + f.getMinTemperatur() + "°C und "
								+ f.getMaxTemperatur() + "°C");
					}

				} else {
					System.out.println("AQVolumen is not OK for Fish");
					showPopUp("Dieser Fish braucht ein AQ zw. " + f.getMinAqVolumen() + " l und " + f.getMaxAqVolumen()
							+ " l");
				}

			} else {
				System.out.println("PH is not OK for Fish");
				showPopUp("Dieser Fish braucht PH zw. " + f.getMinPh() + " und " + f.getMaxPh());
			}

		} else {
			System.out.println("GH is not OK for Fish");
			showPopUp("Dieser Fish braucht GH zw. " + f.getMinGH() + "°d und " + f.getMaxGH() + "°d");
		}
		return isAQOK;
	}

}
