package at.varga.java.welt_der_aquaristik.controller;

import java.io.IOException;

import at.varga.java.welt_der_aquaristik.application.Validator;
import at.varga.java.welt_der_aquaristik.application.Constants;
import at.varga.java.welt_der_aquaristik.application.Main;
import at.varga.java.welt_der_aquaristik.exception.ServiceException;
import at.varga.java.welt_der_aquaristik.model.AQ;
import at.varga.java.welt_der_aquaristik.service.AQService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CreateNewAQController extends BasicController {

	AQService aqService = new AQService();

	@FXML
	private TextField volumeTextField;

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

	private boolean isSaveOk =false;

	// doesnt save yet
	// just show popUp: SaveMessage
	@FXML
	void save(ActionEvent event) {

		AQ saved = new AQ();
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

		int temperatur;
		int width;
		int length;
		int height;
		double gh;
		double ph;

		// Control if AQ parameters are OK
		boolean isImputFormatCorrect = true;
		try {
			temperatur = Integer.parseInt(temperaturTextField.getText());
			width = Integer.parseInt(sizeWidth.getText());
			length = Integer.parseInt(sizeLength.getText());
			height = Integer.parseInt(sizeHeight.getText());
			gh = Double.parseDouble(ghTextField.getText());
			ph = Double.parseDouble(phTextField.getText());
		} catch (NumberFormatException ex) {
			isImputFormatCorrect = false;
		}
		if (isImputFormatCorrect) {
			// if (isNotNull(saved)) {
			if (Validator.isTemperaturCorrect(saved.getTemperatur())) {
				if (Validator.isGHCorrect(saved.getgH())) {
					if (Validator.isPHCorrect(saved.getPh())) {
						try {
							aqService.addAQ(saved);
						} catch (ServiceException e) {
							e.printStackTrace();
						}
						System.out.println("AQgespeichert: " + saved);
						saved = null;
//						String path = Constants.PATH_TO_POP_UP_SAVE_FXML;
//						String setTitel = "Speicherung";
//
//						showNewScene(path, setTitel);
						isSaveOk = true;
						System.out.println("issaveOK: " + isSaveOk);

					} else
						System.out.println("ph is not correct");
					isSaveOk = false;

				} else
					System.out.println("gh ist not correct");
					isSaveOk = false;
			} else
				System.out.println("temperatur ist not correct");
				isSaveOk = false;
//			} else
//				System.out.println("AQ is null");
		} else
			System.out.println("input is not corrert");
			isSaveOk = false;

//		String path = Constants.PATH_TO_POP_UP_SAVE_FXML;
//		String setTitel = "Speicherung";
//
//		showNewScene(path, setTitel);

			System.out.println(": issaveok" + isSaveOk );
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(Constants.PATH_TO_POP_UP_SAVE_FXML));
			Parent root = loader.load();

			PopUpSaveMessageController popUpSavectrl = loader.getController();
			popUpSavectrl.saveOk(this.isSaveOk);

			Stage stage = new Stage();
			stage.setTitle("Pop Up");
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

	private boolean isNotNull(AQ saved) {
		// TODO Auto-generated method stub
		return false;
	}

	// back to WelcomeWindow
	@FXML
	void back(ActionEvent event) throws IOException {

		ActionEvent e = event;
		backToPrScene(e);
	}

}
