package avaliador.client.window;

import java.io.IOException;

import avaliador.client.window.abstractions.QuestionContainer;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

public class UniqueQuestionContainer extends QuestionContainer{
	
	private static final String fxml = "appearance/UniqueQuestionContainer.fxml";

	public UniqueQuestionContainer(Parent parent) throws IOException {
		super(fxml, parent);
	}

	@Override
	public AnchorPane getContainerPane() {
		return questionPane;
	}
	
}
