package avaliador.server.window;

import java.io.IOException;

import avaliador.server.window.abstractions.IContainer;
import avaliador.server.window.abstractions.QuestionContainer;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class MultQuestionContainer extends QuestionContainer implements IContainer{
	
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

	public MultQuestionContainer(Parent parent) throws IOException {
		super(parent, fxml);
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
	
	@FXML
	public void addQuestion() {
		// TO BE ADDED
	}

}
