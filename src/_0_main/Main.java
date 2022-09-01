package _0_main;

import _3_UserMain.UMController;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Opener opener = new Opener();
		opener.setOpener(opener);
		opener.setPrimaryStage(primaryStage);
		opener.welcomeOpen();
		
		primaryStage.show();

	}
}
