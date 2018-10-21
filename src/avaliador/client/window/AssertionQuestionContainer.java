package avaliador.client.window;

import java.io.IOException;

import avaliador.client.window.abstractions.QuestionContainer;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class AssertionQuestionContainer extends QuestionContainer{
	
	private static final String fxml = "appearance/AssertionQuestionContainer.fxml";
	
	@FXML private Label firstAffirmation;
	@FXML private Label secondAffirmation;

	public AssertionQuestionContainer(Parent parent) throws IOException {
		super(fxml, parent);
	}
	
	public void setFirstAffirmation(String affirmation) {
		firstAffirmation.setText(affirmation);
	}
	
	public void setSecondAffirmation(String affirmation) {
		secondAffirmation.setText(affirmation);
	}

	@Override
	public AnchorPane getContainerPane() {
		return this.questionPane;
	}

}
