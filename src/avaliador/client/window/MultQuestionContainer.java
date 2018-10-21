package avaliador.client.window;

import java.io.IOException;

import avaliador.client.window.abstractions.QuestionContainer;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class MultQuestionContainer extends QuestionContainer{
	
	private static final String fxml = "appearance/MultQuestionContainer.fxml";
	
	@FXML private Label affirmative1;
	@FXML private Label affirmative2;
	@FXML private Label affirmative3;
	@FXML private Label affirmative4;
	@FXML private Label affirmative5;

	public MultQuestionContainer(Parent parent) throws IOException {
		super(fxml, parent);
	}
	
	public void setAffirmatives(String[] affirmatives) {
		affirmative1.setText("I. " + affirmatives[0]);
		affirmative2.setText("II. " + affirmatives[1]);
		affirmative3.setText("III. " + affirmatives[2]);
		affirmative4.setText("IV. " + affirmatives[3]);
		affirmative5.setText("V. " + affirmatives[4]);
	}

	@Override
	public AnchorPane getContainerPane() {
		return this.questionPane;
	}

}
