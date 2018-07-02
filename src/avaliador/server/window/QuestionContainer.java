package avaliador.server.window;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.text.Text;

public class QuestionContainer{
	
	@FXML private SplitPane containerPane;
	@FXML private Text containerText;
	
	@FXML private Button containerEditButton;
	@FXML private Button containerDeleteButton;
	
	public SplitPane getContainerPane() {
		return containerPane;
	}

}
