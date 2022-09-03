package _0_main;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Opener opener = new Opener();
		opener.setOpener(opener);
		opener.setPrimaryStage(primaryStage);
		opener.welcomeOpen();

		primaryStage.setOnCloseRequest(event -> CommonService.terminate(event));

		primaryStage.show();

	}

}
