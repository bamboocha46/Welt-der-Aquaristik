package at.varga.java.welt_der_aquaristik.application;
import at.varga.java.welt_der_aquaristik.application.Constants;
import at.varga.java.welt_der_aquaristik.controller.WelcomeController;
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
			WelcomeController controller = loader.getController();

			// to do something with the controller
			controller.getClass();

			Scene scene = new Scene(root, 600, 400);
			scene.getStylesheets().add(getClass().getResource(Constants.PATH_TO_APPLICATION_CSS).toExternalForm());
			primaryStage.setScene(scene);
//			primaryStage.setFullScreen(true);
			primaryStage.show();
			primaryStage.setTitle("Welt der Aquaristik");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		launch(args);
	}
}
