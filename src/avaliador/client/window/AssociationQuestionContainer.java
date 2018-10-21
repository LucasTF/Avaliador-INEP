package avaliador.client.window;

import java.io.IOException;

import avaliador.client.window.abstractions.QuestionContainer;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class AssociationQuestionContainer extends QuestionContainer{
	
	private static final String fxml = "appearance/AssociationQuestionContainer.fxml";
	
	@FXML private Label affirmative1;
	@FXML private Label affirmative2;
	@FXML private Label affirmative3;
	@FXML private Label affirmative4;
	@FXML private Label affirmative5;
	@FXML private Label association1;
	@FXML private Label association2;
	@FXML private Label association3;
	@FXML private Label association4;
	@FXML private Label association5;
	
	Label[][] tables = new Label[2][5];

	public AssociationQuestionContainer(Parent parent) throws IOException {
		super(fxml, parent);
		tables[0][0] = affirmative1;
		tables[0][1] = affirmative2;
		tables[0][2] = affirmative3;
		tables[0][3] = affirmative4;
		tables[0][4] = affirmative5;
		tables[1][0] = association1;
		tables[1][1] = association2;
		tables[1][2] = association3;
		tables[1][3] = association4;
		tables[1][4] = association5;
	}
	
	public void setTables(String[][] tables) {
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 5; j++) {
				if(i == 0) {
					if(j == 0) this.tables[i][j].setText("I. " + tables[i][j]);
					else if(j == 1) this.tables[i][j].setText("II. " + tables[i][j]);
					else if(j == 2) this.tables[i][j].setText("III. " + tables[i][j]);
					else if(j == 3) this.tables[i][j].setText("IV. " + tables[i][j]);
					else if(j == 4) this.tables[i][j].setText("V. " + tables[i][j]);
				}
				else {
					this.tables[i][j].setText("( ) " + tables[i][j]);
				}
				
			}
		}
	}

	@Override
	public AnchorPane getContainerPane() {
		return this.questionPane;
	}
	
	

}
