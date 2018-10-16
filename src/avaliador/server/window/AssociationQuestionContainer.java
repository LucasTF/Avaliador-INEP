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

public class AssociationQuestionContainer extends QuestionContainer{
	
	private static final String fxml = "appearance/containers/AssociationQContainer.fxml";
	
	@FXML private TextArea table11;
	@FXML private TextArea table12;
	@FXML private TextArea table13;
	@FXML private TextArea table14;
	@FXML private TextArea table15;
	@FXML private TextArea table21;
	@FXML private TextArea table22;
	@FXML private TextArea table23;
	@FXML private TextArea table24;
	@FXML private TextArea table25;
	
	@FXML private TextField aAlternative;
	@FXML private TextField bAlternative;
	@FXML private TextField cAlternative;
	@FXML private TextField dAlternative;
	@FXML private TextField eAlternative;
	
	private TextArea[][] tables = new TextArea[2][5];

	public AssociationQuestionContainer(ServerNewQuestionWindow parentWindow, Parent parent) throws IOException {
		super(parentWindow, parent, fxml);
		tables[0][0] = table11;
		tables[0][1] = table12;
		tables[0][2] = table13;
		tables[0][3] = table14;
		tables[0][4] = table15;
		tables[1][0] = table21;
		tables[1][1] = table22;
		tables[1][2] = table23;
		tables[1][3] = table24;
		tables[1][4] = table25;
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 5; j++) {
				tables[i][j].setWrapText(true);
			}
		}
	}
	
	public String[][] getTablesText(){
		String[][] tablesText = new String[2][5];
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 5; j++) {
				tablesText[i][j] = tables[i][j].getText();
			}
		}
		return tablesText;
	}
	
	public void setTablesText(String[][] text) {
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 5; j++) {
				tables[i][j].setText(text[i][j]);
			}
		}
	}
	
	public String getA() { return aAlternative.getText(); }
	public String getB() { return bAlternative.getText(); }
	public String getC() { return cAlternative.getText(); }
	public String getD() { return dAlternative.getText(); }
	public String getE() { return eAlternative.getText(); }
	
	@Override
	public QuestionType getQuestionType() {
		return QuestionType.ASSOCIATION;
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
		String[][] tables = getTablesText();
		String[] ans = getAnswersText();
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 5; j++) {
				if(tables[i][j].isEmpty()) {
					alertMessage(ErrorType.EMPTYTEXTBOX);
					return false;
				}
			}
			if(ans[i].isEmpty()) {
				alertMessage(ErrorType.EMPTYTEXTBOX);
				return false;
			}
		}
		return true;
	}

}
