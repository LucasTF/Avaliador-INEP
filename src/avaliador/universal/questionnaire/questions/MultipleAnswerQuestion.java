package avaliador.universal.questionnaire.questions;

import avaliador.universal.questionnaire.questions.abstractions.Question;

public class MultipleAnswerQuestion extends Question{
	
	private String[] affirmative;
	
	public MultipleAnswerQuestion() {
		super();
		affirmative = new String[5];
	}
	
	public MultipleAnswerQuestion(String qTitle, String af1, String af2, String af3, String af4, String af5, String a1, String a2, String a3, String a4, String a5, int correct) {
		super(qTitle, a1, a2, a3, a4, a5, correct);
		affirmative = new String[5];
		affirmative[0] = af1;
		affirmative[1] = af2;
		affirmative[2] = af3;
		affirmative[3] = af4;
		affirmative[4] = af5;
	}


}
