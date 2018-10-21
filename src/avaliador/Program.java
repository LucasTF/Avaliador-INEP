package avaliador;

import avaliador.client.window.ClientQuestionnaireWindow;
import avaliador.server.window.ServerHomeWindow;
import avaliador.universal.abstractions.IStage;
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
			IStage serverWindow = new ServerHomeWindow(homeStage);
			serverWindow.startStage(true);
		}
		else if(appType.equals("Client")) {
			IStage clientWindow = new ClientQuestionnaireWindow(homeStage);
			clientWindow.startStage(true);
		}
	}

}
