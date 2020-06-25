package at.varga.java.welt_der_aquaristik.controller;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

import at.varga.java.welt_der_aquaristik.application.Constants;
import at.varga.java.welt_der_aquaristik.application.Main;
import at.varga.java.welt_der_aquaristik.application.Validator;
import at.varga.java.welt_der_aquaristik.exception.ServiceException;
import at.varga.java.welt_der_aquaristik.model.Cast;
import at.varga.java.welt_der_aquaristik.model.FishType;
import at.varga.java.welt_der_aquaristik.model.Socialization;
import at.varga.java.welt_der_aquaristik.service.FishTypeService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AddNewFishToListController extends BasicController {

	FishTypeService fishTypeService = new FishTypeService();

	ObservableList<Socialization> fishSocializationList = FXCollections.observableArrayList(Socialization.values());

	// TextField for FishParameters
	@FXML
	private TextField minGhTextField;

	@FXML
	private TextField minPhTextField;

	@FXML
	private Text givenCastField;

	@FXML
	private TextField sizeTextField;

	@FXML
	private TextField breedTextField;

	@FXML
	private TextField minTemperaturTextField;

	@FXML
	private TextField maxPhTextField;

	@FXML
	private TextField aqMaxVolumenTextField;

	@FXML
	private TextField aqMinVolumenTextField;

	@FXML
	private TextField maxGhTextField;

	@FXML
	private TextField maxTemperaturTextField;

	@FXML
	private ComboBox<Socialization> socializationComboBox;

	@FXML
	private Button addPhotoButton;
	@FXML
	private TextField urlTextField;
	@FXML
	private ImageView photoImageView;

	@FXML
	private Button backButton;

	@FXML
	private Button saveButton;

	private String dataName;
	private File source;
	private Cast castCastFormat;
	

	public static final String ORIGINAL_PATH = "C:\\Users\\eszte\\git\\Welt-der-Aquaristik\\arche-test\\src\\main\\resources\\at\\varga\\java\\welt_der_aquaristik\\images\\picture_";
	private File dest = new File(ORIGINAL_PATH);

	@FXML
	void handleSelectFileAction(ActionEvent event) throws URISyntaxException {

		FileChooser fileChooser = new FileChooser();

		fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));

//		fileChooser.setInitialDirectory(new File(getClass().getResource("/images").toURI()));

		File file = fileChooser.showOpenDialog(addPhotoButton.getScene().getWindow());
		if (file != null) {

			source = file;
			System.out.println(source.getPath());
			Path p = Paths.get(file.getPath());

			urlTextField.setText("/images/" + p.getFileName().toString());

			dataName = dest.toString() + "IMG" + System.currentTimeMillis() + p.getFileName().toString();

			System.out.println(dataName);

			dest = new File(dataName);

			System.err.println(dest.toString());

		}
	}

	public void giveMeCast(String cast) {
		castCastFormat = getTypeCast(cast);

		givenCastField.setText(cast);
	}

	public Cast getTypeCast(String cast) {

		if (cast.equals("Barsch")) {
			return Cast.BARSCH;
		} else if (cast.equals("Bärbling")) {
			return Cast.BAERBLING;
		} else if (cast.equals("Kaltwasserfisch")) {
			return Cast.KALTWASSERFISCH;
		} else if (cast.equals("Labyrinthfisch")) {
			return Cast.LABYRINTHFISCH;
		} else if (cast.equals("Lebendgebärende")) {
			return Cast.LEBENDGEBAERENDE;
		} else if (cast.equals("Salmler")) {
			return Cast.SALMLER;
		} else if (cast.equals("Wels")) {
			return Cast.WELS;
		} else if (cast.equals("Anderer Fisch")) {
			return Cast.ANDERE_FISCH;
		} else
			System.out.println("No given Cast.getCastNameFormat");
		return null;

	}

	@FXML
	private void initialize() {
		socializationComboBox.setValue(Socialization.AGRESSIV);
		socializationComboBox.setItems(fishSocializationList);

	}

	@FXML
	void save(ActionEvent event) {

		FishType saved = new FishType();

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
			saved.setCast(castCastFormat);
			saved.setBreed(String.valueOf(breedTextField.getText()));
			saved.setSize(Double.valueOf(sizeTextField.getText()));
			saved.setMinAqVolumen(Double.valueOf(aqMinVolumenTextField.getText()));
			saved.setMaxAqVolumen(Double.valueOf(aqMaxVolumenTextField.getText()));
			saved.setMinTemperatur(Integer.valueOf(minTemperaturTextField.getText()));
			saved.setMaxTemperatur(Integer.valueOf(maxTemperaturTextField.getText()));
			saved.setMinPh(Float.valueOf(minPhTextField.getText()));
			saved.setMaxPh(Float.valueOf(maxPhTextField.getText()));
			saved.setMinGH(Integer.valueOf(minGhTextField.getText()));
			saved.setMaxGH(Integer.valueOf(maxGhTextField.getText()));
			saved.setPictureUrl(null);
			saved.setSocialization(socializationComboBox.getSelectionModel().getSelectedItem());
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
			if (Validator.isTemperaturCorrect(saved.getMinTemperatur())) {
				if (Validator.isTemperaturCorrect(saved.getMaxTemperatur())) {
					if (Validator.isGHCorrect(saved.getMinGH())) {
						if (Validator.isGHCorrect(saved.getMaxGH())) {
							if (Validator.isPHCorrect(saved.getMinPh())) {
								if (Validator.isPHCorrect(saved.getMaxPh())) {
									try {
										fishTypeService.addFishType(saved);
									} catch (ServiceException e) {
										e.printStackTrace();
									}

									System.out.println(saved.getBreed() + " saved in DB");
									showPopUp(saved.getBreed() + " ist gespeichert!");
									saved = null;

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

//		try {
//			copyFileUsingJava7Files(source, dest);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

//		String path = Constants.PATH_TO_POP_UP_SAVE_FXML;
//		String setTitel = "Speicherung";
//		showNewScene(path, setTitel);

	}

	//Leads to updated CastView
	@FXML
	void back(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(Constants.PATH_TO_CAST_VIEW_FXML));
			Parent root = loader.load();

			CastController castctrl = loader.getController();
			castctrl.initialize(castCastFormat.getCastName());

			Stage stage = new Stage();
			stage.setTitle(castCastFormat.getCastName());
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
	
	
	//Leads to updated CastController
	
	
	
//	@FXML
//	void back(ActionEvent event) {
//
////		String path = Constants.PATH_TO_CAST_VIEW_FXML;
////		String titel = castCastFormat.getCastName();
////		showNewScene(path, titel);
//		backToPrScene(event);
//	}

	private void copyFileUsingJava7Files(File source, File dest) throws IOException {

		Files.copy(source.toPath(), dest.toPath());
		dataName = "";
		this.dest = new File(ORIGINAL_PATH);
	}
	
	

}
