package avaliador.server.window.abstractions;

import java.io.IOException;

import avaliador.server.window.ServerNewQuestionWindow;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

public abstract class QuestionContainer implements IContainer{
	
	@FXML protected AnchorPane containerPane;
	
	@FXML protected TextField qValueField;
	@FXML protected TextArea qStatementArea;
	
	@FXML protected ToggleGroup answerGroup;
	@FXML protected RadioButton aRadio;
	@FXML protected RadioButton bRadio;
	@FXML protected RadioButton cRadio;
	@FXML protected RadioButton dRadio;
	@FXML protected RadioButton eRadio;
	
	@FXML protected Button addQuestionButton;
	
	protected ServerNewQuestionWindow parentWindow;
	
	public QuestionContainer(ServerNewQuestionWindow parentWindow, Parent parent, String fxmlPath) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
		loader.setController(this);
		parent = loader.load();
		this.parentWindow = parentWindow;
		this.qStatementArea.setWrapText(true);
	}
	
	@FXML
	public void addQuestion() {
		parentWindow.getPointerContainer().getQuestionnaireWindow().createQuestionContainer(parentWindow.getPointerContainer());
		parentWindow.getStage().hide();
		parentWindow.setMenuDisable(true);
		this.setButtonDisable(true);
		parentWindow.getPointerContainer().setQuestionTitle(qStatementArea.getText());
		parentWindow.getStage().setOnCloseRequest(e -> {parentWindow.getPointerContainer().setQuestionTitle(qStatementArea.getText());});
		//System.out.println(this.getClass().getSimpleName());
	}
	
	public String getQuestionTitle() {
		return qStatementArea.getText();
	}
	
	public double getQuestionValue() {
		return Double.parseDouble(qValueField.getText());
	}
	
	public char getAnswer() {
		if(aRadio.isSelected()) { return 'A'; }
		else if(bRadio.isSelected()) { return 'B'; }
		else if(cRadio.isSelected()) { return 'C'; }
		else if(dRadio.isSelected()) { return 'D'; }
		else{ return 'E'; }
	}
	
	public void setButtonDisable(boolean isDisabled) {
		addQuestionButton.setDisable(isDisabled);
	}

}
