package avaliador.server.window;

import java.io.IOException;

import avaliador.server.window.abstractions.QuestionContainer;
import avaliador.universal.enums.ErrorType;
import avaliador.universal.enums.QuestionType;
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
	public QuestionType getQuestionType() {
		return QuestionType.ASSERTION;
	}
	
	@Override
	public String[] getAnswersText(){
		String[] answers = new String[5];
		answers[0] = getA();
		answers[1] = getB();
		answers[2] = getC();
		answers[3] = getD();
		answers[4] = getE();
		return answers;
	}

	@Override
	public AnchorPane getContainerPane() {
		return containerPane;
	}

	@Override
	public boolean isInputCorrect() {
		if(!getFirstAff().isEmpty() && !getSecondAff().isEmpty()) {
			for(String s : getAnswersText()) {
				if(s.isEmpty()) {
					alertMessage(ErrorType.EMPTYTEXTBOX);
					return false;
				}
			}
			return true;
		}
		else {
			alertMessage(ErrorType.EMPTYTEXTBOX);
			return false;
		}
	}

}
