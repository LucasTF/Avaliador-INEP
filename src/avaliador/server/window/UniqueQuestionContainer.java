package avaliador.server.window;

import java.io.IOException;

import avaliador.server.window.abstractions.QuestionContainer;
import avaliador.universal.enums.ErrorType;
import avaliador.universal.enums.QuestionType;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

public class UniqueQuestionContainer extends QuestionContainer{
	
	private static final String fxml = "appearance/containers/SimpleQContainer.fxml";
	
	@FXML private TextArea aAlternative;
	@FXML private TextArea bAlternative;
	@FXML private TextArea cAlternative;
	@FXML private TextArea dAlternative;
	@FXML private TextArea eAlternative;
	
	public UniqueQuestionContainer(ServerNewQuestionWindow parentWindow, Parent parent) throws IOException {
		super(parentWindow, parent, fxml);
		this.aAlternative.setWrapText(true);
		this.bAlternative.setWrapText(true);
		this.cAlternative.setWrapText(true);
		this.dAlternative.setWrapText(true);
		this.eAlternative.setWrapText(true);
	}
	
	public String getA() { return this.aAlternative.getText(); }
	public String getB() { return this.bAlternative.getText(); }
	public String getC() { return this.cAlternative.getText(); }
	public String getD() { return this.dAlternative.getText(); }
	public String getE() { return this.eAlternative.getText(); }
	
	@Override
	public QuestionType getQuestionType() {
		return QuestionType.UNIQUE;
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
	
	public AnchorPane getContainerPane() {
		return this.containerPane;
	}

	@Override
	public boolean isInputCorrect() {
		for(String s : getAnswersText()) {
			if(s.isEmpty()) {
				alertMessage(ErrorType.EMPTYTEXTBOX);
				return false;
			}
		}
		return true;
	}
	
}
