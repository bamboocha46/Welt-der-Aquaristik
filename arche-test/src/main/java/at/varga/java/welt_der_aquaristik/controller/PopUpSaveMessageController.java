package at.varga.java.welt_der_aquaristik.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PopUpSaveMessageController extends BasicController {
	 private boolean isSaveOk;
	
    @FXML
    private Label saveMassageLabel;
    
    public void saveOk (boolean isSaveOK) {
    	this.isSaveOk = isSaveOK;
    	
    }
    
    public void setPopUpText (String text) {
    	saveMassageLabel.setText(text);
    }
    
	@FXML
	private void initialize() {
		
		if (isSaveOk =true) {
		saveMassageLabel.setText("erfolderlich gespeichert");
		} else if (isSaveOk = false) {
			saveMassageLabel.setText("Falsche Eingabe, bitte korrigieren!");
		}

	}

}


