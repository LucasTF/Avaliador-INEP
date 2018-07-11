package avaliador.server.window;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class QPointerContainer{
	
	@FXML private AnchorPane containerPane;
	@FXML private Label questionTitle;
	
	@FXML private Button editButton;
	@FXML private Button deleteButton;
	
	public AnchorPane getContainerPane() {
		return containerPane;
	}

}
