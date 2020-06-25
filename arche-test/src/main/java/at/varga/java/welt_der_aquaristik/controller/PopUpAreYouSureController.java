package at.varga.java.welt_der_aquaristik.controller;

import at.varga.java.welt_der_aquaristik.application.Constants;
import at.varga.java.welt_der_aquaristik.exception.ServiceException;
import at.varga.java.welt_der_aquaristik.model.AQ;
import at.varga.java.welt_der_aquaristik.service.AQService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PopUpAreYouSureController extends BasicController {

	@FXML
	private Button noButton;
    @FXML
    private Button yesButton;
    
    //AQ Object to Delete it
	private AQ givenAQ;
	AQService aqService = new AQService();

	// noButton leads to previous Window
	@FXML
	void back(ActionEvent event) {
		String path = Constants.PATH_TO_AQDATESHEET_FXML;
		String setTitel = "Aquariums";
		showNewScene(path, setTitel);
		closeSceene(event);

	}
	

	//yesButton delete AQ from DB and leads to updated AQDateSheetView
	@FXML
    void deleteObject(ActionEvent event) {

		try {
			aqService.deleteAQ(givenAQ);
			showPopUp(givenAQ.getTitel() + " ist gelöscht");
			String path = Constants.PATH_TO_AQDATESHEET_FXML;
			String setTitel = "Aquariums";
			showNewScene(path, setTitel);
			
			closeSceene(event);
			
			System.out.println(givenAQ.getTitel() + " is deleted");
			
			
		} catch (ServiceException e1) {
			e1.printStackTrace();
		}
    }
	
	@FXML
	public void giveMeAQ(AQ a) {
		this.givenAQ = a;
	}


}
