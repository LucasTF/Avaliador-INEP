package avaliador.universal.questionnaire.questions;

import avaliador.universal.enums.QuestionType;
import avaliador.universal.questionnaire.questions.abstractions.Question;

public class MultipleAnswerQuestion extends Question{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4321569960152161182L;
	private String[] affirmative;
	
	public MultipleAnswerQuestion() {
		super();
		affirmative = new String[5];
	}
	
	public MultipleAnswerQuestion(String qTitle, String af1, String af2, String af3, String af4, String af5, String a1, String a2, String a3, String a4, String a5, char correct) {
		super(qTitle, a1, a2, a3, a4, a5, correct);
		affirmative = new String[5];
		affirmative[0] = af1;
		affirmative[1] = af2;
		affirmative[2] = af3;
		affirmative[3] = af4;
		affirmative[4] = af5;
	}
	
	public void setAffirmatives(String[] text) {
		affirmative[0] = text[0];
		affirmative[1] = text[1];
		affirmative[2] = text[2];
		affirmative[3] = text[3];
		affirmative[4] = text[4];
	}
	
	public String[] getAffirmatives() {
		return this.affirmative;
	}

	@Override
	public QuestionType getQuestionType() {
		return QuestionType.MULTIPLE;
	}


}
