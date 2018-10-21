package avaliador.universal.managers;

import java.util.ArrayList;

import avaliador.client.AnsweredQuestionnaire;
import avaliador.client.window.abstractions.QuestionContainer;
import avaliador.universal.questionnaire.Questionnaire;

public class AnsweredQuestionnaireMapperManager {
	
	AnsweredQuestionnaire ans;
	
	public AnsweredQuestionnaireMapperManager() {
		ans = new AnsweredQuestionnaire();
	}
	
	public AnsweredQuestionnaire mapAnsweredQuestionnaire(Questionnaire q, String studentName, ArrayList<QuestionContainer> qc) {
		double totalValue = 0;
		ans.setQuestionnaireTitle(q.getTitle());
		ans.setAuthorTitle(q.getAuthor());
		ans.setStudentName(studentName);
		for(int i = 0; i < q.getQuestions().size(); i++) {
			if(q.getQuestions().get(i).getRightAlternative() == qc.get(i).getAnsweredAlternative()) {
				ans.addToCorrectAnswers(i+1);
				ans.addToFinalValue(q.getQuestions().get(i).getQuestionValue());
			}
			else {
				ans.addToWrongAnswers(i+1);
			}
			totalValue = totalValue + q.getQuestions().get(i).getQuestionValue();
		}
		ans.setTotalValue(totalValue);
		return this.ans;
	}

}
