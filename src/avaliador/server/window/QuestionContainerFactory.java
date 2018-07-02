package avaliador.server.window;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class QuestionContainerFactory {
	
	private static final String containerStylePath = "appearance/QuestionContainer.fxml";
	
	public QuestionContainer buildQuestionContainer(Parent parent) {
		QuestionContainer qContainer = new QuestionContainer();
		try {
			FXMLLoader loader = new FXMLLoader(qContainer.getClass().getResource(containerStylePath));
			loader.setController(qContainer);
			parent = loader.load();
			return qContainer;
		}
		catch(IOException e) {
			System.out.println("Opa!");
			return null;
		}
	}

}
