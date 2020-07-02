package at.varga.java.welt_der_aquaristik.controller;

import at.varga.java.welt_der_aquaristik.exception.ServiceException;
import at.varga.java.welt_der_aquaristik.model.AQ;
import at.varga.java.welt_der_aquaristik.service.AQService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

//PoPUpToDeleteAQ
public class PopUpAreYouSureController extends BasicController {

	@FXML
	private Button noButton;
	@FXML
	private Button yesButton;

	// AQ Object to Delete it
	private AQ givenAQ;
	AQService aqService = new AQService();

	// noButton leads to previous Window
	@FXML
	void back(ActionEvent event) {

		backToPrScene(event);

		System.out.println("popUpClosed");

	}

	// yesButton delete AQ from DB and leads to updated AQDateSheetView
	@FXML
	void deleteObject(ActionEvent event) {

		try {
			System.out.println(givenAQ.getTitel() + " is deleted");

			aqService.deleteAQ(givenAQ);

			showPopUp(givenAQ.getTitel() + " ist gelöscht");
			backToPrScene(event);

		} catch (ServiceException e1) {
			e1.printStackTrace();
		}
	}

	@FXML
	public void giveMeAQ(AQ a) {
		this.givenAQ = a;
	}

}
