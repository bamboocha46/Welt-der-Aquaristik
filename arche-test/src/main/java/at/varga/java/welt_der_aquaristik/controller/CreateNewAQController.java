package at.varga.java.welt_der_aquaristik.controller;

import java.io.IOException;

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

	// doesnt save yet
	// just show popUp: SaveMessage
	@FXML
	void save(ActionEvent event) {
		
		AQ saved = new AQ(Integer.valueOf(sizeWidth.getText()), Integer.valueOf(sizeLength.getText()), Integer.valueOf(sizeHeight.getText()));
		saved.setTitel(aqNameTextField.getText());
		saved.setSizeWidth(Integer.valueOf(sizeWidth.getText()));
		saved.setSizeLength(Integer.valueOf(sizeLength.getText()));
		saved.setSizeHeight(Integer.valueOf(sizeHeight.getText()));
		int volumen = Integer.valueOf(sizeWidth.getText())*(Integer.valueOf(sizeLength.getText())*(Integer.valueOf(sizeHeight.getText())/1000));
		volumeTextField.setText(String.valueOf(volumen));
//		saved.setVolumen(volumen);
		saved.setTemperatur(Integer.valueOf(temperaturTextField.getText()));
		saved.setgH(Double.valueOf(ghTextField.getText()));
		saved.setPh(Double.valueOf(phTextField.getText()));
		try {
			aqService.add(saved);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		System.out.println("AQgespeichert: " + saved);

		String path = Constants.PATH_TO_POP_UP_SAVE_FXML;
		String setTitel = "Speicherung";

		showNewScene(path, setTitel);

	}

	// back to WelcomeWindow
	@FXML
	void back(ActionEvent event) throws IOException {

		ActionEvent e = event;
		backToPrScene(e);
	}

}
