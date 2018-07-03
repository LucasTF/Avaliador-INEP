package avaliador.universal.factories;

import java.io.IOException;

import avaliador.server.window.QPointerContainer;
import avaliador.server.window.UniqueQuestionContainer;
import avaliador.server.window.abstractions.IContainer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class ContainerFactory{
	
	//private static final String containerStylePath = "../../server/window/appearance/containers/QuestionContainer.fxml";
	private FXMLLoader loader;
	private IContainer container;
	
	public IContainer buildContainer(Parent parent, String fxmlPath) {
		try {
			if(fxmlPath.contains("SimpleQuestionContainer")) {
				container = new UniqueQuestionContainer();
			}
			else if(fxmlPath.contains("QPointerContainer")) {
				container = new QPointerContainer();
			}
			loader = new FXMLLoader(container.getClass().getResource(fxmlPath));
			loader.setController(container);
			parent = loader.load();
			return container;
		}
		catch(IOException e) {
			return null;
		}
	}

}
