package at.varga.java.welt_der_aquaristik.controller;

import at.varga.java.welt_der_aquaristik.exception.ServiceException;
import at.varga.java.welt_der_aquaristik.model.FishTypeInAQ;
import at.varga.java.welt_der_aquaristik.service.FishTypeInAQService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

//PoPUpToDeleteFishFromAQ
public class PopUpAreYouSureDeleteFishFromAQController extends BasicController {

	@FXML
	private Button noButton;
	@FXML
	private Button yesButton;

	// fishTypeInAQ to Delete it
	FishTypeInAQ givenftiaq;
	FishTypeInAQService ftiaService = new FishTypeInAQService();

	// noButton leads to previous Window
	@FXML
	void back(ActionEvent event) {

		backToPrScene(event);

	}

	// yesButton delete fishtypeinAQOBject from DB and leads to updated
	// AQDateSheetView
	@FXML
	void deleteObject(ActionEvent event) {

		try {
			ftiaService.deleteFishTypeInAQ(givenftiaq);
			showPopUp(givenftiaq.getFishType().getBreed() + " ist gel�scht");

			backToPrScene(event);
			System.out.println("Fish deleted from DB");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void giveMeFishTypeInAQToDel(FishTypeInAQ ftiaq) {
		this.givenftiaq = ftiaq;
	}

}
