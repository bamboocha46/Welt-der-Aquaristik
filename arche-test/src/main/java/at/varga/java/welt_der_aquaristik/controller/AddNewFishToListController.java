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
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
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
	private TextField castFinalTextField;

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

	@FXML
	private void initialize() {
		socializationComboBox.setValue(Socialization.AGRESSIV);
		socializationComboBox.setItems(fishSocializationList);

	}

	@FXML
	void save(ActionEvent event) {

		FishType saved = new FishType();

		saved.setCast(Cast.ANDERE_FISCH);
		saved.setBreed(breedTextField.getText());
		saved.setSize(Double.valueOf(sizeTextField.getText()));
		saved.setMinAqVolumen(Double.valueOf(aqMinVolumenTextField.getText()));
		saved.setMaxAqVolumen(Double.valueOf(aqMaxVolumenTextField.getText()));
		saved.setMinTemperatur(Float.valueOf(minTemperaturTextField.getText()));
		saved.setMaxTemperatur(Float.valueOf(maxTemperaturTextField.getText()));
		saved.setMinPh(Float.valueOf(minPhTextField.getText()));
		saved.setMaxPh(Float.valueOf(maxPhTextField.getText()));
		saved.setMinGH(Integer.valueOf(minGhTextField.getText()));
		saved.setMaxGH(Integer.valueOf(maxGhTextField.getText()));
		saved.setPictureUrl(null);
		saved.setSocialization(socializationComboBox.getSelectionModel().getSelectedItem());

		System.out.println(saved);

//		try {
//			copyFileUsingJava7Files(source, dest);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		try {
			fishTypeService.addFishType(saved);
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		saved=null;

//		String path = Constants.PATH_TO_POP_UP_SAVE_FXML;
//		String setTitel = "Speicherung";
//		showNewScene(path, setTitel);

	}

	@FXML
	void back(ActionEvent event) {

		ActionEvent e = event;
		backToPrScene(e);
	}

	private void copyFileUsingJava7Files(File source, File dest) throws IOException {

		Files.copy(source.toPath(), dest.toPath());
		dataName = "";
		this.dest = new File(ORIGINAL_PATH);
	}

}
