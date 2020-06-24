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
    
	@FXML
	private void initialize() {
		
		if (isSaveOk =true) {
		saveMassageLabel.setText("erfolderlich gespeichert");
		} else saveMassageLabel.setText("Falsche Eingabe, bitte korrigieren!");

	}

}


