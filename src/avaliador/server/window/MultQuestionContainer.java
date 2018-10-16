package avaliador.server.window;

import java.io.IOException;

import avaliador.server.window.abstractions.QuestionContainer;
import avaliador.universal.enums.ErrorType;
import avaliador.universal.enums.QuestionType;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class MultQuestionContainer extends QuestionContainer{
	
	private static final String fxml = "appearance/containers/MultQContainer.fxml";
	
	@FXML private TextArea affirmative1;
	@FXML private TextArea affirmative2;
	@FXML private TextArea affirmative3;
	@FXML private TextArea affirmative4;
	@FXML private TextArea affirmative5;
	
	@FXML private TextField aAlternative;
	@FXML private TextField bAlternative;
	@FXML private TextField cAlternative;
	@FXML private TextField dAlternative;
	@FXML private TextField eAlternative;

	public MultQuestionContainer(ServerNewQuestionWindow parentWindow, Parent parent) throws IOException {
		super(parentWindow, parent, fxml);
		this.affirmative1.setWrapText(true);
		this.affirmative2.setWrapText(true);
		this.affirmative3.setWrapText(true);
		this.affirmative4.setWrapText(true);
		this.affirmative5.setWrapText(true);
	}
	
	public String getAff1() { return affirmative1.getText(); }
	public String getAff2() { return affirmative2.getText(); }
	public String getAff3() { return affirmative3.getText(); }
	public String getAff4() { return affirmative4.getText(); }
	public String getAff5() { return affirmative5.getText(); }
	
	public String getA() { return aAlternative.getText(); }
	public String getB() { return bAlternative.getText(); }
	public String getC() { return cAlternative.getText(); }
	public String getD() { return dAlternative.getText(); }
	public String getE() { return eAlternative.getText(); }
	
	@Override
	public AnchorPane getContainerPane() {
		return containerPane;
	}
	
	@Override
	public QuestionType getQuestionType() {
		return QuestionType.MULTIPLE;
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
	
	public String[] getAffirmations() {
		String[] affirmatives = new String[5];
		affirmatives[0] = getAff1();
		affirmatives[1] = getAff2();
		affirmatives[2] = getAff3();
		affirmatives[3] = getAff4();
		affirmatives[4] = getAff5();
		return affirmatives;
	}
	
	public void setAffirmations(String[] aff) {
		affirmative1.setText(aff[0]);
		affirmative2.setText(aff[1]);
		affirmative3.setText(aff[2]);
		affirmative4.setText(aff[3]);
		affirmative5.setText(aff[4]);
	}

	@Override
	public boolean isInputCorrect() {
		String[] ans = getAnswersText();
		String[] aff = getAffirmations();
		for(int i = 0; i < 5; i++) {
			if(ans[i].isEmpty()) {
				alertMessage(ErrorType.EMPTYTEXTBOX);
				return false;
			}
			if(aff[i].isEmpty()) {
				alertMessage(ErrorType.EMPTYTEXTBOX);
				return false;
			}
		}
		return true;
	}

}
