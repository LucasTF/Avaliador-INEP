package avaliador;

import javafx.application.Application;
import javafx.stage.Stage;

public class Program extends Application{
	
	//Hardcoded program type initialization. Must change later.
	private static final String appType = "Server";

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage homeStage) throws Exception {
		if(appType.equals("Server")) {
			
		}
		else if(appType.equals("Client")) {
			
		}
	}

}
