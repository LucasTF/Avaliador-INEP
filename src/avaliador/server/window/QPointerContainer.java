package avaliador.server.window;

import avaliador.server.window.abstractions.IContainer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.text.Text;

public class QPointerContainer implements IContainer{
	
	@FXML private SplitPane containerPane;
	@FXML private Text containerText;
	
	@FXML private Button containerEditButton;
	@FXML private Button containerDeleteButton;
	
	public SplitPane getContainer() {
		return containerPane;
	}

}
