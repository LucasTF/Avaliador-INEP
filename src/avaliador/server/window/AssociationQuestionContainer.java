package avaliador.server.window;

import java.io.IOException;

import avaliador.server.window.abstractions.QuestionContainer;
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

	public AssociationQuestionContainer(ServerNewQuestionWindow parentWindow, Parent parent) throws IOException {
		super(parentWindow, parent, fxml);
		this.table11.setWrapText(true);
		this.table12.setWrapText(true);
		this.table13.setWrapText(true);
		this.table14.setWrapText(true);
		this.table15.setWrapText(true);
		this.table21.setWrapText(true);
		this.table22.setWrapText(true);
		this.table23.setWrapText(true);
		this.table24.setWrapText(true);
		this.table25.setWrapText(true);
	}
	
	public String getTable11() { return table11.getText(); }
	public String getTable12() { return table12.getText(); }
	public String getTable13() { return table13.getText(); }
	public String getTable14() { return table14.getText(); }
	public String getTable15() { return table15.getText(); }
	public String getTable21() { return table21.getText(); }
	public String getTable22() { return table22.getText(); }
	public String getTable23() { return table23.getText(); }
	public String getTable24() { return table24.getText(); }
	public String getTable25() { return table25.getText(); }
	
	public String getA() { return aAlternative.getText(); }
	public String getB() { return bAlternative.getText(); }
	public String getC() { return cAlternative.getText(); }
	public String getD() { return dAlternative.getText(); }
	public String getE() { return eAlternative.getText(); }

	@Override
	public AnchorPane getContainerPane() {
		return containerPane;
	}

}
