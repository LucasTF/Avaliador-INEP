package avaliador.server.window;

import java.io.IOException;

import avaliador.server.window.abstractions.IContainer;
import avaliador.server.window.abstractions.QuestionContainer;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

public class UniqueQuestionContainer extends QuestionContainer implements IContainer{
	
	private static final String fxml = "appearance/containers/SimpleQContainer.fxml";
	
	@FXML private TextArea aAlternative;
	@FXML private TextArea bAlternative;
	@FXML private TextArea cAlternative;
	@FXML private TextArea dAlternative;
	@FXML private TextArea eAlternative;
	
	public UniqueQuestionContainer(Parent parent) throws IOException {
		super(parent, fxml);
		this.aAlternative.setWrapText(true);
		this.bAlternative.setWrapText(true);
		this.cAlternative.setWrapText(true);
		this.dAlternative.setWrapText(true);
		this.eAlternative.setWrapText(true);
	}
	
	@FXML
	public void addQuestion() {
		System.out.println(this.getQuestionTitle());
	}
	
	public String getA() { return this.aAlternative.getText(); }
	public String getB() { return this.bAlternative.getText(); }
	public String getC() { return this.cAlternative.getText(); }
	public String getD() { return this.dAlternative.getText(); }
	public String getE() { return this.eAlternative.getText(); }
	
	public AnchorPane getContainerPane() {
		return this.containerPane;
	}
	
}
