package avaliador.server.window;

import avaliador.server.window.abstractions.IContainer;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class UniqueQuestionContainer implements IContainer{

	@FXML private AnchorPane containerPane;
	
	@Override
	public AnchorPane getContainer() {
		return containerPane;
	}
	
}
