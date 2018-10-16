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
	
	public String getFirstAs() { return firstAff.getText(); }
	public String getSecondAs() { return secondAff.getText(); }
	
	public void setAssertions(String as1, String as2) {
		firstAff.setText(as1);
		secondAff.setText(as2);
	}
	
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
	
	public void setAlternatives(String[] texts) {
		aAlternative.setText(texts[0]);
		bAlternative.setText(texts[1]);
		cAlternative.setText(texts[2]);
		dAlternative.setText(texts[3]);
		eAlternative.setText(texts[4]);
	}

	@Override
	public AnchorPane getContainerPane() {
		return containerPane;
	}

	@Override
	public boolean isInputCorrect() {
		if(!getFirstAs().isEmpty() && !getSecondAs().isEmpty()) {
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
