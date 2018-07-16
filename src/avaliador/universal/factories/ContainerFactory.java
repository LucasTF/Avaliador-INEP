package avaliador.universal.factories;

import java.io.IOException;

import avaliador.server.window.AssertionQuestionContainer;
import avaliador.server.window.AssociationQuestionContainer;
import avaliador.server.window.MultQuestionContainer;
import avaliador.server.window.OrderQuestionContainer;
import avaliador.server.window.ServerNewQuestionWindow;
import avaliador.server.window.UniqueQuestionContainer;
import avaliador.server.window.abstractions.QuestionContainer;
import javafx.scene.Parent;

public class ContainerFactory{
	
	private QuestionContainer container;
	
	public QuestionContainer buildQContainer(ServerNewQuestionWindow parentWindow, Parent parent, String qType) {
		try {
			if(qType.equals("Unique")) {
				container = new UniqueQuestionContainer(parentWindow, parent);
			}
			else if(qType.equals("Mult")) {
				container = new MultQuestionContainer(parentWindow, parent);
			}
			else if(qType.equals("Order")) {
				container = new OrderQuestionContainer(parentWindow, parent);
			}
			else if(qType.equals("Assertion")) {
				container = new AssertionQuestionContainer(parentWindow, parent);
			}
			else if(qType.equals("Association")) {
				container = new AssociationQuestionContainer(parentWindow, parent);
			}
			else {
				container = null;
			}
			return container;
		}
		catch(IOException e) {
			return null;
		}
	}

}
