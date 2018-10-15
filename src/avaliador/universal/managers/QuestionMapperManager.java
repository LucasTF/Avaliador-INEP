package avaliador.universal.managers;

import avaliador.server.window.abstractions.QuestionContainer;
import avaliador.universal.questionnaire.questions.UniqueAnswerQuestion;
import avaliador.universal.questionnaire.questions.abstractions.Question;

public class QuestionMapperManager {
	
	public Question mapQuestion(QuestionContainer jfxQuestion) {
		Question q = null;
		switch(jfxQuestion.getQuestionType()) {
		case UNIQUE:
			q = new UniqueAnswerQuestion();
			q.setQuestionStatement(jfxQuestion.getQuestionTitle());
			q.setRightAlternative(jfxQuestion.getAnswer());
			q.setAlternatives(jfxQuestion.getAnswersText());
			break;
		case MULTIPLE:
			// Must Implement Later
			break;
		case ASSERTION:
			// Must Implement Later
			break;
		case ASSOCIATION:
			// Must Implement Later
			break;
		case ORDER:
			break;
		default:
			break;
			
		}
		return q;
	}

}
