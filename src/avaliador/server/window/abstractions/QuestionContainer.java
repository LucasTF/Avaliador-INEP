package avaliador.server.window.abstractions;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

public abstract class QuestionContainer {
	
	@FXML protected AnchorPane containerPane;
	
	@FXML protected Spinner<Integer> qNumberSpinner;
	@FXML protected TextField qValueField;
	@FXML protected TextArea qStatementArea;
	
	@FXML protected ToggleGroup answerGroup;
	@FXML protected RadioButton aRadio;
	@FXML protected RadioButton bRadio;
	@FXML protected RadioButton cRadio;
	@FXML protected RadioButton dRadio;
	@FXML protected RadioButton eRadio;
	
	@FXML private Button addQuestionButton;
	
	@FXML public abstract void addQuestion();
	
	public QuestionContainer(Parent parent, String fxmlPath) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
		loader.setController(this);
		parent = loader.load();
		this.setSpinner();
		this.qStatementArea.setWrapText(true);
	}
	
	public String getQuestionTitle() {
		return qStatementArea.getText();
	}
	
	public double getQuestionValue() {
		return Double.parseDouble(qValueField.getText());
	}
	
	public int getQuestionNumber() {
		return qNumberSpinner.getValue();
	}
	
	public char getAnswer() {
		if(aRadio.isSelected()) { return 'A'; }
		else if(bRadio.isSelected()) { return 'B'; }
		else if(cRadio.isSelected()) { return 'C'; }
		else if(dRadio.isSelected()) { return 'D'; }
		else{ return 'E'; }
	}
	
	protected void setSpinner() {
		SpinnerValueFactory<Integer> qNumberSpinnerFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);
		this.qNumberSpinner.setValueFactory(qNumberSpinnerFactory);
	}

}
