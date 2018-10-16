package avaliador.universal.questionnaire.questions;

import avaliador.universal.enums.QuestionType;
import avaliador.universal.questionnaire.questions.abstractions.Question;

public class UniqueAnswerQuestion extends Question{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1443207720204482436L;
	
	public UniqueAnswerQuestion() {
		super();
	}
	
	public UniqueAnswerQuestion(String qTitle, String a1, String a2, String a3, String a4, String a5, char correct) {
		super(qTitle, a1, a2, a3, a4, a5, correct);
	}

	@Override
	public QuestionType getQuestionType() {
		return QuestionType.UNIQUE;
	}

}
