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
	
	public void setA(String text) { this.aAlternative.setText(text); }
	public void setB(String text) { this.bAlternative.setText(text); }
	public void setC(String text) { this.cAlternative.setText(text); }
	public void setD(String text) { this.dAlternative.setText(text); }
	public void setE(String text) { this.eAlternative.setText(text); }
	
	public void setAlternatives(String[] texts) {
		setA(texts[0]);
		setB(texts[1]);
		setC(texts[2]);
		setD(texts[3]);
		setE(texts[4]);
	}
	
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
