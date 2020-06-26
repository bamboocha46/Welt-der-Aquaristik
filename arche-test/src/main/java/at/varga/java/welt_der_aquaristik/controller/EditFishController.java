package at.varga.java.welt_der_aquaristik.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import at.varga.java.welt_der_aquaristik.application.Constants;
import at.varga.java.welt_der_aquaristik.application.Main;
import at.varga.java.welt_der_aquaristik.application.Validator;
import at.varga.java.welt_der_aquaristik.exception.ServiceException;
import at.varga.java.welt_der_aquaristik.model.Cast;
import at.varga.java.welt_der_aquaristik.model.FishType;
import at.varga.java.welt_der_aquaristik.model.FishTypeInAQ;
import at.varga.java.welt_der_aquaristik.model.Socialization;
import at.varga.java.welt_der_aquaristik.service.FishTypeService;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

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
	FishType givenfFish;

	@FXML
	public void initialize(FishType f) {
		givenfFish = f;

		breedTextField.setText(givenfFish.getBreed());
		sizeTextField.setText(String.valueOf(givenfFish.getSize()));
		minGhTextField.setText(String.valueOf(givenfFish.getMinGH()));
		maxGhTextField.setText(String.valueOf(givenfFish.getMaxGH()));
		minPhTextField.setText(String.valueOf(givenfFish.getMinPh()));
		maxPhTextField.setText(String.valueOf(givenfFish.getMaxPh()));
		aqMinVolumenTextField.setText(String.valueOf(givenfFish.getMinAqVolumen()));
		aqMaxVolumenTextField.setText(String.valueOf(givenfFish.getMaxAqVolumen()));
		minTemperaturTextField.setText(String.valueOf(givenfFish.getMinTemperatur()));
		maxTemperaturTextField.setText(String.valueOf(givenfFish.getMaxTemperatur()));
		socializationComboBox.setValue(givenfFish.getSocialization());
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
			givenfFish.setBreed(String.valueOf(breedTextField.getText()));
			givenfFish.setSize(Double.valueOf(sizeTextField.getText()));
			givenfFish.setMinAqVolumen(Double.valueOf(aqMinVolumenTextField.getText()));
			givenfFish.setMaxAqVolumen(Double.valueOf(aqMaxVolumenTextField.getText()));
			givenfFish.setMinTemperatur(Integer.valueOf(minTemperaturTextField.getText()));
			givenfFish.setMaxTemperatur(Integer.valueOf(maxTemperaturTextField.getText()));
			givenfFish.setMinPh(Float.valueOf(minPhTextField.getText()));
			givenfFish.setMaxPh(Float.valueOf(maxPhTextField.getText()));
			givenfFish.setMinGH(Integer.valueOf(minGhTextField.getText()));
			givenfFish.setMaxGH(Integer.valueOf(maxGhTextField.getText()));
			givenfFish.setPictureUrl(null);
			givenfFish.setSocialization(socializationComboBox.getSelectionModel().getSelectedItem());
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
			if (Validator.isTemperaturCorrect(givenfFish.getMinTemperatur())) {
				if (Validator.isTemperaturCorrect(givenfFish.getMaxTemperatur())) {
					if (Validator.isGHCorrect(givenfFish.getMinGH())) {
						if (Validator.isGHCorrect(givenfFish.getMaxGH())) {
							if (Validator.isPHCorrect(givenfFish.getMinPh())) {
								if (Validator.isPHCorrect(givenfFish.getMaxPh())) {
									try {
										fishTypeService.updateFishType(givenfFish);

									} catch (ServiceException e) {
										e.printStackTrace();
									}

									showPopUp(givenfFish.getBreed() + " ist updatet.");
									System.out.println(givenfFish.getBreed() + " edited");

								} else
									showPopUp(
											"Ph-Werte müssen zwischen 6.5 und 8.2 liegen. Bitte die Eingabe korrigieren!");
								System.out.println("maxPH is not correct");

							} else
								showPopUp(
										"Ph-Werte müssen zwischen 6.5 und 8.2 liegen. Bitte die Eingabe korrigieren!");
							System.out.println("minPh is not correct");

						} else
							showPopUp("GH-werte müssen zwischen 0°d und 30°d liegen. Bitte die Eingabe korrigieren!");
						System.out.println("maxGH is not correct");

					} else
						showPopUp("GH-werte müssen zwischen 0°d und 30°d liegen. Bitte die Eingabe korrigieren!");
					System.out.println("minGH is not correct");
				} else
					showPopUp("Temperatur muss zwischen 4°C und 35°C liegen. Bitte die Eingabe korrigieren!");
				System.out.println("maxTemperatur is not correct");
			} else
				showPopUp("Temperatur muss zwischen 4°C und 35°C liegen. Bitte die Eingabe korrigieren!");
			System.out.println("minTemperatur is not correct");
		} else
			System.out.println("User input is/are not correct (int != int /double != double)");
	}

	@FXML
	void back(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(Constants.PATH_TO_CAST_VIEW_FXML));
			Parent root = loader.load();

			CastController castctrl = loader.getController();
			castctrl.initialize(givenfFish.getCast().getCastName());

			Stage stage = new Stage();
			stage.setTitle(givenfFish.getCast().getCastName());
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
