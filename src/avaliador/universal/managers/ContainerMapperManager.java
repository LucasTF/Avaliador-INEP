package avaliador.universal.managers;

import avaliador.server.window.AssertionQuestionContainer;
import avaliador.server.window.AssociationQuestionContainer;
import avaliador.server.window.MultQuestionContainer;
import avaliador.server.window.QPointerContainer;
import avaliador.server.window.UniqueQuestionContainer;
import avaliador.universal.questionnaire.questions.AssertionQuestion;
import avaliador.universal.questionnaire.questions.AssociationQuestion;
import avaliador.universal.questionnaire.questions.MultipleAnswerQuestion;
import avaliador.universal.questionnaire.questions.abstractions.Question;

public class ContainerMapperManager {
	
	private QPointerContainer qp;
	private Question q;
	
	public ContainerMapperManager(QPointerContainer qp, Question q) {
		this.qp = qp;
		this.q = q;
	}
	
	public void mapContainer() {
		switch(q.getQuestionType()) {
		case UNIQUE:
			qp.getQuestion().setUniqueQuestion();
			UniqueQuestionContainer qc = (UniqueQuestionContainer) qp.getQuestion().getQuestionInformation();
			qc.setQuestionTitle(q.getQuestionStatement());
			qc.setQuestionValue(q.getQuestionValue());
			qc.setAlternatives(q.getAlternatives());
			qc.setAnswer(q.getRightAlternative());
			break;
		case MULTIPLE:
			qp.getQuestion().setMultQuestion();
			MultQuestionContainer mqc = (MultQuestionContainer) qp.getQuestion().getQuestionInformation();
			MultipleAnswerQuestion maq = (MultipleAnswerQuestion) q;
			mqc.setQuestionTitle(maq.getQuestionStatement());
			mqc.setQuestionValue(maq.getQuestionValue());
			mqc.setAlternatives(maq.getAlternatives());
			mqc.setAnswer(maq.getRightAlternative());
			mqc.setAffirmations(maq.getAffirmatives());
			break;
		case ASSERTION:
			qp.getQuestion().setAssertionQuestion();
			AssertionQuestionContainer asc = (AssertionQuestionContainer) qp.getQuestion().getQuestionInformation();
			AssertionQuestion asq = (AssertionQuestion) q;
			asc.setQuestionTitle(asq.getQuestionStatement());
			asc.setQuestionValue(asq.getQuestionValue());
			asc.setAlternatives(asq.getAlternatives());
			asc.setAnswer(asq.getRightAlternative());
			asc.setAssertions(asq.getAssertion1(), asq.getAssertion2());
			break;
		case ASSOCIATION:
			qp.getQuestion().setAssociationQuestion();
			AssociationQuestionContainer asoc = (AssociationQuestionContainer) qp.getQuestion().getQuestionInformation();
			AssociationQuestion asoq = (AssociationQuestion) q;
			asoc.setQuestionTitle(asoq.getQuestionStatement());
			asoc.setQuestionValue(asoq.getQuestionValue());
			asoc.setAlternatives(asoq.getAlternatives());
			asoc.setAnswer(asoq.getRightAlternative());
			asoc.setTablesText(asoq.getTables());
			break;
		case ORDER:
			break;
		default:
			break;
			
		}
	}

}
