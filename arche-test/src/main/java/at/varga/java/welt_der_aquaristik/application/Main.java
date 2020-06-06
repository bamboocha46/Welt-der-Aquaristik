package at.varga.java.welt_der_aquaristik.application;
import at.varga.java.welt_der_aquaristik.application.Constants;
import at.varga.java.welt_der_aquaristik.controller.WelcomeViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	public static Stage primaryStage;

	@Override
	public void start(Stage primaryStage) {
		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource(Constants.PATH_TO_WELCOME_VIEW_FXML));
			Parent root = loader.load();
			WelcomeViewController controller = loader.getController();

			// to so something with the controller
			controller.getClass();

			Scene scene = new Scene(root, 600, 400);
			scene.getStylesheets().add(getClass().getResource(Constants.PATH_TO_APPLICATION_CSS).toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("Welt der Aquaristik");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	void openNewAQScene(ActionEvent event) {
//
//		    //Main.openNewAQWindow();
//		    FXMLLoader loader = new FXMLLoader ();
//			loader.setLocation(Main.class.getResource(Constants.PATH_TO_CREATENEWAQ_FXML));
//			AnchorPane addNewAQ = null;
//			try {
//				addNewAQ = loader.load();
//			} catch (IOException e) {
//				
//				e.printStackTrace();
//			}
//			
//			Stage createNewAQStage = new Stage();
//			createNewAQStage.setTitle("Neues Aquarium hinzufügen");
//			createNewAQStage.initModality(Modality.WINDOW_MODAL);
//			createNewAQStage.initOwner(primaryStage);
//			
//			Scene scene = new Scene(addNewAQ);
//			createNewAQStage.setScene(scene);
//			createNewAQStage.showAndWait();
//		    
//		    }

	// HA AZ UJ WINDOW-T A MAINBOL AKARJUK FUTTATNI; ES NEM A CONTROLLERBOL
//	 public static void openNewAQScene() throws IOException {
//
//	    //Main.openNewAQWindow();
//	    FXMLLoader loader = new FXMLLoader ();
//		loader.setLocation(Main.class.getResource(Constants.PATH_TO_CREATENEWAQ_FXML));
//		AnchorPane createNewAQ = loader.load();
//
//		
//		Stage createNewAQStage = new Stage();
//		createNewAQStage.setTitle("Neues Aquarium hinzufügen");
//		createNewAQStage.initModality(Modality.WINDOW_MODAL);
//		createNewAQStage.initOwner(primaryStage);
//		
//		Scene scene = new Scene(createNewAQ);
//		createNewAQStage.setScene(scene);
//		createNewAQStage.showAndWait();
//	    
//	    }

	public static void main(String[] args) {
		launch(args);
	}
}
