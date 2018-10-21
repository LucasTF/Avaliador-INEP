package avaliador.universal.managers;

import java.util.ArrayList;

import avaliador.client.AnsweredQuestionnaire;
import avaliador.server.ResultQuestionnaire;

public class ResultMapperManager {
	
	private ArrayList<ResultQuestionnaire> result = new ArrayList<ResultQuestionnaire>();
	
	public ArrayList<ResultQuestionnaire> mapResult(ArrayList<AnsweredQuestionnaire> source) {
		for(AnsweredQuestionnaire a : source) {
			result.add(new ResultQuestionnaire(a.getQuestionnaireTitle(),
					 a.getAuthorTitle(),
					 a.getStudentName(),
					 a.getCorrectAnswers(),
					 a.getWrongAnswers(),
					 a.getTotalValue(),
					 a.getFinalValue()));
		}
		
		return this.result;
	}

}
