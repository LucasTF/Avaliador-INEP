package avaliador.universal.questionnaire.questions;

import avaliador.universal.questionnaire.questions.abstractions.Question;

public class UniqueAnswerQuestion extends Question{
	
	private String questionDescription;
	
	public UniqueAnswerQuestion() {
		super();
	}
	
	public UniqueAnswerQuestion(String qTitle, String a1, String a2, String a3, String a4, String a5, char correct) {
		super(qTitle, a1, a2, a3, a4, a5, correct);
	}

	public String getQuestionDescription() {
		return questionDescription;
	}

	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
	}

}
