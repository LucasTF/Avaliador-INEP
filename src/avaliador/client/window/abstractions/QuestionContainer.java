package avaliador.client.window.abstractions;

import java.io.IOException;

import avaliador.universal.abstractions.IContainer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

public abstract class QuestionContainer implements IContainer{
	
	@FXML protected AnchorPane questionPane;
	@FXML protected Label questionValue;
	@FXML protected Label questionNumber;
	@FXML protected Label questionTitle;
	@FXML protected ToggleGroup questionAlternatives;
	@FXML protected RadioButton alternativeA;
	@FXML protected RadioButton alternativeB;
	@FXML protected RadioButton alternativeC;
	@FXML protected RadioButton alternativeD;
	@FXML protected RadioButton alternativeE;
	
	public QuestionContainer(String fxml, Parent parent) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
		loader.setController(this);
		parent = loader.load();
	}
	
	public void setQuestionValue(double value) {
		questionValue.setText("(" + value + ")");
	}
	
	public void setQuestionNumber(int num) {
		questionNumber.setText(num + ".");
	}
	
	public void setQuestionTitle(String title) {
		questionTitle.setText(title);
	}
	
	public void setAlternativesText(String[] alt) {
		alternativeA.setText(alt[0]);
		alternativeB.setText(alt[1]);
		alternativeC.setText(alt[2]);
		alternativeD.setText(alt[3]);
		alternativeE.setText(alt[4]);
	}
	
	public char getAnsweredAlternative() {
		if(alternativeA.isSelected()) {
			return 'A';
		}
		else if(alternativeB.isSelected()) {
			return 'B';
		}
		else if(alternativeC.isSelected()) {
			return 'C';
		}
		else if(alternativeD.isSelected()) {
			return 'D';
		}
		else if(alternativeE.isSelected()) {
			return 'E';
		}
		else return '-';
	}

}
