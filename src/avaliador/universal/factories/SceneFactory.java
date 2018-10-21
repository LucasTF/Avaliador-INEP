package avaliador.universal.factories;

import java.io.IOException;

import avaliador.universal.abstractions.IStage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class SceneFactory {
	
	public Scene buildScene(IStage stage, String stageAPath) {
		Parent styleRoot = null;
		try {
			FXMLLoader loader = new FXMLLoader(stage.getClass().getResource(stageAPath));
			loader.setController(stage);
			styleRoot = loader.load();
			return new Scene(styleRoot);
		}
		catch(IOException e) {
			System.out.println("Opa");
			return null;
		}
		
		
	}

}
