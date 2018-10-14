package avaliador.universal.questionnaire.questions.abstractions;

import avaliador.universal.questionnaire.questions.types.Alternative;

public abstract class Question {
	
	protected String questionStatement;
	protected double value;
	protected char rightAlternative;
	
	protected Alternative[] alternative;
	
	public Question() {
		alternative = new Alternative[5];
	}
	
	public Question(String qTitle, String a1, String a2, String a3, String a4, String a5, char correct) {
		
		this.questionStatement = qTitle;
		
		alternative = new Alternative[5];
		
		alternative[0] = new Alternative(a1);
		alternative[1] = new Alternative(a2);
		alternative[2] = new Alternative(a3);
		alternative[3] = new Alternative(a4);
		alternative[4] = new Alternative(a5);
		this.rightAlternative = correct;
	}
	
	public String getQuestionStatement() {
		return this.questionStatement;
	}
	
	public void setQuestionStatement(String qTitle) {
		this.questionStatement = qTitle;
	}

}
