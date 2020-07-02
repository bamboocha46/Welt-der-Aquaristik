package at.varga.java.welt_der_aquaristik.controller;

import java.io.IOException;

import at.varga.java.welt_der_aquaristik.application.Constants;
import at.varga.java.welt_der_aquaristik.application.Main;
import at.varga.java.welt_der_aquaristik.application.Validator;
import at.varga.java.welt_der_aquaristik.exception.ServiceException;
import at.varga.java.welt_der_aquaristik.model.FishType;
import at.varga.java.welt_der_aquaristik.model.Socialization;
import at.varga.java.welt_der_aquaristik.service.FishTypeService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EditFishController extends BasicController {

	@FXML
	private TextField breedTextField;
	@FXML
	private TextField sizeTextField;

	@FXML
	private TextField minGhTextField;
	@FXML
	private TextField maxGhTextField;
	@FXML
	private TextField minPhTextField;
	@FXML
	private TextField maxPhTextField;
	@FXML
	private TextField aqMinVolumenTextField;
	@FXML
	private TextField aqMaxVolumenTextField;
	@FXML
	private TextField minTemperaturTextField;
	@FXML
	private TextField maxTemperaturTextField;

	@FXML
	private ComboBox<Socialization> socializationComboBox;

	@FXML
	private Button editFish;

	@FXML
	private Button backButton;

	FishTypeService fishTypeService = new FishTypeService();
	ObservableList<Socialization> fishSocializationList = FXCollections.observableArrayList(Socialization.values());
	FishType givenFish;

	@FXML
	public void initialize(FishType f) {
		givenFish = f;

		breedTextField.setText(givenFish.getBreed());
		sizeTextField.setText(String.valueOf(givenFish.getSize()));
		minGhTextField.setText(String.valueOf(givenFish.getMinGH()));
		maxGhTextField.setText(String.valueOf(givenFish.getMaxGH()));
		minPhTextField.setText(String.valueOf(givenFish.getMinPh()));
		maxPhTextField.setText(String.valueOf(givenFish.getMaxPh()));
		aqMinVolumenTextField.setText(String.valueOf(givenFish.getMinAqVolumen()));
		aqMaxVolumenTextField.setText(String.valueOf(givenFish.getMaxAqVolumen()));
		minTemperaturTextField.setText(String.valueOf(givenFish.getMinTemperatur()));
		maxTemperaturTextField.setText(String.valueOf(givenFish.getMaxTemperatur()));
		socializationComboBox.setValue(givenFish.getSocialization());
		socializationComboBox.setItems(fishSocializationList);
	}

	@FXML
	void editFish(ActionEvent event) {

		// Control if Fish parameters are ok
		double minAQVolumen;
		double maxAQVolumen;
		double fishSize;
		int minTemperatur;
		int maxTemperatur;
		double minPH;
		double maxPH;
		double mingH;
		double maxgH;

		boolean isInputFormatCorrect = true;
		try {
			minAQVolumen = Double.parseDouble(aqMinVolumenTextField.getText());
			maxAQVolumen = Double.parseDouble(aqMaxVolumenTextField.getText());
			fishSize = Double.parseDouble(sizeTextField.getText());
			minTemperatur = Integer.parseInt(minTemperaturTextField.getText());
			maxTemperatur = Integer.parseInt(maxTemperaturTextField.getText());
			minPH = Double.parseDouble(minPhTextField.getText());
			maxPH = Double.parseDouble(maxPhTextField.getText());
			mingH = Double.parseDouble(minGhTextField.getText());
			maxgH = Double.parseDouble(maxGhTextField.getText());
		} catch (NumberFormatException ex) {
			isInputFormatCorrect = false;
			System.out.println("WrongInput");

		}
		// inputFormat is correct (also Integer is int, Double ich double, float is
		// float), input will be set to FishType
		if (isInputFormatCorrect) {
			givenFish.setBreed(String.valueOf(breedTextField.getText()));
			givenFish.setSize(Double.valueOf(sizeTextField.getText()));
			givenFish.setMinAqVolumen(Double.valueOf(aqMinVolumenTextField.getText()));
			givenFish.setMaxAqVolumen(Double.valueOf(aqMaxVolumenTextField.getText()));
			givenFish.setMinTemperatur(Integer.valueOf(minTemperaturTextField.getText()));
			givenFish.setMaxTemperatur(Integer.valueOf(maxTemperaturTextField.getText()));
			givenFish.setMinPh(Float.valueOf(minPhTextField.getText()));
			givenFish.setMaxPh(Float.valueOf(maxPhTextField.getText()));
			givenFish.setMinGH(Integer.valueOf(minGhTextField.getText()));
			givenFish.setMaxGH(Integer.valueOf(maxGhTextField.getText()));
			givenFish.setPictureUrl(null);
			givenFish.setSocialization(socializationComboBox.getSelectionModel().getSelectedItem());
			// If UserInput is wrong, User get a PopUp
		} else {
			showPopUp("Falsche Eingabe, bitte korrigieren!");
		}

		// Input must be controll, if they are OK for a fish
		// Temp.: 4-35°C
		// Ph:6.5 0 8.2
		// GH: 0-30°d
		// If User input is wrong -> User get a PopUp
		if (isInputFormatCorrect) {
			if (Validator.isTemperaturCorrect(givenFish.getMinTemperatur())) {
				if (Validator.isTemperaturCorrect(givenFish.getMaxTemperatur())) {
					if (Validator.isGHCorrect(givenFish.getMinGH())) {
						if (Validator.isGHCorrect(givenFish.getMaxGH())) {
							if (Validator.isPHCorrect(givenFish.getMinPh())) {
								if (Validator.isPHCorrect(givenFish.getMaxPh())) {
									if (Validator.isAQVolumenCorrect(givenFish.getMinAqVolumen())) {
										if (Validator.isFishSizeCorrect(givenFish.getSize())) {
											if (givenFish.getMinAqVolumen() <= givenFish.getMaxAqVolumen()
													&& givenFish.getMinGH() <= givenFish.getMaxGH()
													&& givenFish.getMinPh() <= givenFish.getMaxPh()
													&& givenFish.getMinTemperatur() <= givenFish.getMaxTemperatur()) {

												try {
													fishTypeService.updateFishType(givenFish);

												} catch (ServiceException e) {
													e.printStackTrace();
												}

												showPopUp(givenFish.getBreed() + " ist updatet.");
												System.out.println(givenFish.getBreed() + " edited");
											} else
												showPopUp(
														"Die minimum-Eingaben müssen kleier, oder gleich sein, als maximum-Eingaben! Bitte die Eingabe korrigieren!");
										} else
											showPopUp(
													"Fisch muss mindestens 0.5 cm gross sein! Bitte die Eingabe korrigieren!");

									} else
										showPopUp(
												"AQ muss grösser, als 0 liter gröss sein! Bitte die Eingabe korrigieren");

								} else
									showPopUp(
											"Ph-Werte müssen zwischen 6.5 und 8.2 liegen. Bitte die Eingabe korrigieren!");

							} else
								showPopUp(
										"Ph-Werte müssen zwischen 6.5 und 8.2 liegen. Bitte die Eingabe korrigieren!");

						} else
							showPopUp("GH-werte müssen zwischen 0°d und 30°d liegen. Bitte die Eingabe korrigieren!");

					} else
						showPopUp("GH-werte müssen zwischen 0°d und 30°d liegen. Bitte die Eingabe korrigieren!");

				} else
					showPopUp("Temperatur muss zwischen 4°C und 35°C liegen. Bitte die Eingabe korrigieren!");

			} else
				showPopUp("Temperatur muss zwischen 4°C und 35°C liegen. Bitte die Eingabe korrigieren!");

		} else
			System.out.println("User input is/are not correct (int != int /double != double)");
	}

	@FXML
	void back(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(Constants.PATH_TO_CAST_VIEW_FXML));
			Parent root = loader.load();

			CastController castctrl = loader.getController();
			castctrl.initialize(givenFish.getCast().getCastName());

			Stage stage = new Stage();
			stage.setTitle(givenFish.getCast().getCastName());
			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(Main.primaryStage);

			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource(Constants.PATH_TO_APPLICATION_CSS).toExternalForm());
			stage.setScene(scene);
			stage.showAndWait();

			closeSceene(event);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
