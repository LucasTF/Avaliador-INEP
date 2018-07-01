package avaliador.server;

import avaliador.universal.questionnaire.questions.*;
import avaliador.universal.questionnaire.questions.abstractions.Question;

public class QuestionFactory {
	
	public Question createQuestion(String qType) {
		if(qType.equals("Unique")) {
			return new UniqueAnswerQuestion();
		}
		else if(qType.equals("Multiple")){
			return new MultipleAnswerQuestion();
		}
		else if(qType.equals("Association")) {
			return new AssociationQuestion();
		}
		else if(qType.equals("Assertion")) {
			return new AssertionQuestion();
		}
		else return null;
	}

}
