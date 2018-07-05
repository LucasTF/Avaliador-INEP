package avaliador.server.window;

import avaliador.server.window.abstractions.IContainer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

public class UniqueQuestionContainer implements IContainer{

	@FXML private AnchorPane containerPane;
	
	@FXML private Spinner<Integer> qNumberSpinner;
	@FXML private TextField qValueField;
	@FXML private TextArea qStatementArea;
	
	@FXML private ToggleGroup answerGroup;
	@FXML private RadioButton aRadio;
	@FXML private RadioButton bRadio;
	@FXML private RadioButton cRadio;
	@FXML private RadioButton dRadio;
	@FXML private RadioButton eRadio;
	
	@FXML private TextArea aArea;
	@FXML private TextArea bArea;
	@FXML private TextArea cArea;
	@FXML private TextArea dArea;
	@FXML private TextArea eArea;
	
	@FXML private Button addQuestionButton;
	
	public UniqueQuestionContainer() {
		//SpinnerValueFactory<Integer> qNumberSpinnerFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);
		//this.qNumberSpinner.setValueFactory(qNumberSpinnerFactory);
	}
	
	@Override
	public AnchorPane getContainer() {
		return containerPane;
	}
	
	@FXML
	public void addQuestion() {
		System.out.println(aArea.getText());
	}
	
}
