package avaliador.universal.factories;

import java.io.IOException;

import avaliador.server.window.AssertionQuestionContainer;
import avaliador.server.window.AssociationQuestionContainer;
import avaliador.server.window.MultQuestionContainer;
import avaliador.server.window.OrderQuestionContainer;
import avaliador.server.window.UniqueQuestionContainer;
import avaliador.server.window.abstractions.IContainer;
import javafx.scene.Parent;

public class ContainerFactory{
	
	IContainer container;
	
	public IContainer buildQContainer(Parent parent, String qType) {
		try {
			if(qType.equals("Unique")) {
				container = new UniqueQuestionContainer(parent);
			}
			else if(qType.equals("Mult")) {
				container = new MultQuestionContainer(parent);
			}
			else if(qType.equals("Order")) {
				container = new OrderQuestionContainer(parent);
			}
			else if(qType.equals("Assertion")) {
				container = new AssertionQuestionContainer(parent);
			}
			else if(qType.equals("Association")) {
				container = new AssociationQuestionContainer(parent);
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
