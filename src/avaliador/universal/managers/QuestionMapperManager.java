package avaliador.universal.managers;

import avaliador.server.window.AssertionQuestionContainer;
import avaliador.server.window.AssociationQuestionContainer;
import avaliador.server.window.MultQuestionContainer;
import avaliador.server.window.abstractions.QuestionContainer;
import avaliador.universal.questionnaire.questions.AssertionQuestion;
import avaliador.universal.questionnaire.questions.AssociationQuestion;
import avaliador.universal.questionnaire.questions.MultipleAnswerQuestion;
import avaliador.universal.questionnaire.questions.UniqueAnswerQuestion;
import avaliador.universal.questionnaire.questions.abstractions.Question;

public class QuestionMapperManager {
	
	public Question mapQuestion(QuestionContainer jfxQuestion) {
		Question q = null;
		switch(jfxQuestion.getQuestionType()) {
		case UNIQUE:
			UniqueAnswerQuestion qu = new UniqueAnswerQuestion();
			qu.setQuestionStatement(jfxQuestion.getQuestionTitle());
			qu.setRightAlternative(jfxQuestion.getAnswer());
			qu.setAlternatives(jfxQuestion.getAnswersText());
			qu.setQuestionValue(jfxQuestion.getQuestionValue());
			q = qu;
			break;
		case MULTIPLE:
			MultipleAnswerQuestion qm = new MultipleAnswerQuestion();
			MultQuestionContainer jfxmq = (MultQuestionContainer) jfxQuestion;
			qm.setQuestionStatement(jfxmq.getQuestionTitle());
			qm.setRightAlternative(jfxmq.getAnswer());
			qm.setAlternatives(jfxmq.getAnswersText());
			qm.setQuestionValue(jfxmq.getQuestionValue());
			qm.setAffirmatives(jfxmq.getAffirmations());
			q = qm;
			break;
		case ASSERTION:
			AssertionQuestion astq = new AssertionQuestion();
			AssertionQuestionContainer jfxastq = (AssertionQuestionContainer) jfxQuestion;
			astq.setQuestionStatement(jfxastq.getQuestionTitle());
			astq.setRightAlternative(jfxastq.getAnswer());
			astq.setAlternatives(jfxastq.getAnswersText());
			astq.setQuestionValue(jfxastq.getQuestionValue());
			astq.setAssertions(jfxastq.getFirstAs(), jfxastq.getSecondAs());
			q = astq;
			break;
		case ASSOCIATION:
			AssociationQuestion ascq = new AssociationQuestion();
			AssociationQuestionContainer jfxascq = (AssociationQuestionContainer) jfxQuestion;
			ascq.setQuestionStatement(jfxascq.getQuestionTitle());
			ascq.setRightAlternative(jfxascq.getAnswer());
			ascq.setAlternatives(jfxascq.getAnswersText());
			ascq.setQuestionValue(jfxascq.getQuestionValue());
			ascq.setTables(jfxascq.getTablesText());
			q = ascq;
			break;
		case ORDER:
			break;
		default:
			break;
		}
		return q;
	}

}
