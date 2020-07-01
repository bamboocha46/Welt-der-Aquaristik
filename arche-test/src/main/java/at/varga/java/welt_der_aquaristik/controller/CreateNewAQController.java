package at.varga.java.welt_der_aquaristik.controller;

import java.io.IOException;

import at.varga.java.welt_der_aquaristik.application.Validator;
import at.varga.java.welt_der_aquaristik.exception.ServiceException;
import at.varga.java.welt_der_aquaristik.model.AQ;
import at.varga.java.welt_der_aquaristik.service.AQService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CreateNewAQController extends BasicController {

	AQService aqService = new AQService();

	@FXML
	private TextField sizeLength;

	@FXML
	private TextField aqNameTextField;

	@FXML
	private TextField ghTextField;

	@FXML
	private TextField sizeWidth;

	@FXML
	private TextField temperaturTextField;

	@FXML
	private Button breakButton;

	@FXML
	private TextField sizeHeight;

	@FXML
	private Button saveButton;

	@FXML
	private TextField phTextField;

	// Save a new AQ Object in DB
	@FXML
	void save(ActionEvent event) {

		AQ saved = new AQ();

		// Control if AQ parameters are OK
		int temperatur;
		int width;
		int length;
		int height;
		double gh;
		double ph;

		boolean isInputFormatCorrect = true;
		try {
			temperatur = Integer.parseInt(temperaturTextField.getText());
			width = Integer.parseInt(sizeWidth.getText());
			length = Integer.parseInt(sizeLength.getText());
			height = Integer.parseInt(sizeHeight.getText());
			gh = Double.parseDouble(ghTextField.getText());
			ph = Double.parseDouble(phTextField.getText());
		} catch (NumberFormatException ex) {
			isInputFormatCorrect = false;
			System.out.println("Wrong User Input");

		}
		// If inputFormat is correct (also Integer is int, Double ich double, float is
		// float), input will be set to AQ
		if (isInputFormatCorrect) {
			saved.setTitel(aqNameTextField.getText());
			saved.setSizeWidth(Integer.valueOf(sizeWidth.getText()));
			saved.setSizeLength(Integer.valueOf(sizeLength.getText()));
			saved.setSizeHeight(Integer.valueOf(sizeHeight.getText()));
			saved.setAQVolumen(Integer.valueOf(sizeWidth.getText()), Integer.valueOf(sizeLength.getText()),
					Integer.valueOf(sizeHeight.getText()));
			saved.setTemperatur(Integer.valueOf(temperaturTextField.getText()));
			saved.setgH(Double.valueOf(ghTextField.getText()));
			saved.setPh(Double.valueOf(phTextField.getText()));
			System.out.println(saved);
		} else {
			showPopUp("Falsche Eingabe, bitte korrigieren!" + "\n)" + 
					"Für Grösse geben Sie pozitiven ganzen Zahlen," + "\n)" +
					"Für Temeratur, positiven ganze Zahl zw 4 und 35" + "\n)" +
					"Für Gh, positven Zahl zwischen 0 und 30 " + "\n)" +
					"Für Ph positiven Zahl zwischen 6.5 und 8.2! ");
			
		}
		if (isInputFormatCorrect) {
			if (Validator.isTemperaturCorrect(saved.getTemperatur())) {
				if (Validator.isGHCorrect(saved.getgH())) {
					if (Validator.isPHCorrect(saved.getPh())) {
						if (Validator.isAQSideCorrect(saved.getSizeHeight())
								&& Validator.isAQSideCorrect(saved.getSizeLength())
								&& Validator.isAQSideCorrect(saved.getSizeWidth())) {

							try {
								aqService.addAQ(saved);
							} catch (ServiceException e) {
								e.printStackTrace();
							}
							System.out.println("AQgespeichert: " + saved);
							showPopUp(saved.getTitel() + " ist erforderlich gespeichert!");
							saved = null;
						} else
							showPopUp("Aquariumseiten müssen grösser, als 0cm sein");

					} else
						showPopUp("Ph-Werte müssen zwischen 6.5 und 8.2 liegen. Bitte die Eingabe korrigieren!");
					System.out.println("ph is not correct");

				} else
					showPopUp("GH-werte müssen zwischen 0°d und 30°d liegen. Bitte die Eingabe korrigieren!");
				System.out.println("gh ist not correct");

			} else
				showPopUp("Temperatur muss zwischen 4°C und 35°C liegen. Bitte die Eingabe korrigieren!");
			System.out.println("temperatur ist not correct");

		} else
			System.out.println("input is not corrert");

	}

	// back to WelcomeWindow
	@FXML
	void back(ActionEvent event) throws IOException {

		ActionEvent e = event;
		backToPrScene(e);
	}

}
