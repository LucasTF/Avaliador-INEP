package avaliador.server.window;

import java.io.IOException;

import avaliador.server.window.abstractions.QuestionContainer;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AssertionQuestionContainer extends QuestionContainer{
	
	private static final String fxml = "appearance/containers/AssertionQContainer.fxml";
	
	@FXML private TextField firstAff;
	@FXML private TextField secondAff;
	
	@FXML private TextField aAlternative;
	@FXML private TextField bAlternative;
	@FXML private TextField cAlternative;
	@FXML private TextField dAlternative;
	@FXML private TextField eAlternative;

	public AssertionQuestionContainer(ServerNewQuestionWindow parentWindow, Parent parent) throws IOException {
		super(parentWindow, parent, fxml);
	}
	
	public String getFirstAff() { return firstAff.getText(); }
	public String getSecondAff() { return secondAff.getText(); }
	
	public String getA() { return aAlternative.getText(); }
	public String getB() { return bAlternative.getText(); }
	public String getC() { return cAlternative.getText(); }
	public String getD() { return dAlternative.getText(); }
	public String getE() { return eAlternative.getText(); }

	@Override
	public AnchorPane getContainerPane() {
		return containerPane;
	}

}
