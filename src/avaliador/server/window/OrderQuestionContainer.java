package avaliador.server.window;

import java.io.IOException;

import avaliador.server.window.abstractions.IContainer;
import avaliador.server.window.abstractions.QuestionContainer;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class OrderQuestionContainer extends QuestionContainer implements IContainer{
	
	private static final String fxml = "appearance/containers/OrderQContainer.fxml";
	
	@FXML private TextArea op1;
	@FXML private TextArea op2;
	@FXML private TextArea op3;
	@FXML private TextArea op4;
	@FXML private TextArea op5;
	
	@FXML private TextField aAlternative;
	@FXML private TextField bAlternative;
	@FXML private TextField cAlternative;
	@FXML private TextField dAlternative;
	@FXML private TextField eAlternative;

	public OrderQuestionContainer(Parent parent) throws IOException {
		super(parent, fxml);
		this.op1.setWrapText(true);
		this.op2.setWrapText(true);
		this.op3.setWrapText(true);
		this.op4.setWrapText(true);
		this.op5.setWrapText(true);
	}
	
	public String getOp1() { return op1.getText(); }
	public String getOp2() { return op2.getText(); }
	public String getOp3() { return op3.getText(); }
	public String getOp4() { return op4.getText(); }
	public String getOp5() { return op5.getText(); }
	
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
