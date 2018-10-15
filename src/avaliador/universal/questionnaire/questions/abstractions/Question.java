package avaliador.universal.questionnaire.questions.abstractions;

import java.io.Serializable;


public abstract class Question implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -407105073819968123L;
	protected String questionStatement;
	protected double value;
	protected char rightAlternative;
	
	protected String[] alternatives;
	
	public Question() {
		alternatives = new String[5];
	}
	
	public Question(String qTitle, String a1, String a2, String a3, String a4, String a5, char correct) {
		
		this.questionStatement = qTitle;
		
		alternatives = new String[5];
		
		alternatives[0] = a1;
		alternatives[1] = a2;
		alternatives[2] = a3;
		alternatives[3] = a4;
		alternatives[4] = a5;
		this.rightAlternative = correct;
	}
	
	public String getQuestionStatement() {
		return this.questionStatement;
	}
	
	public void setQuestionStatement(String qTitle) {
		this.questionStatement = qTitle;
	}
	
	public String getRightAlternative() {
		return this.questionStatement;
	}
	
	public void setRightAlternative(char answer) {
		this.rightAlternative = answer;
	}
	
	public String[] getAlternatives() {
		return this.alternatives;
	}
	
	public void setAlternatives(String[] aText) {
		for(int i = 0; i < 5; i++) {
			alternatives[i] = aText[i];
		}
	}

}
