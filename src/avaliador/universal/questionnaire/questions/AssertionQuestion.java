package avaliador.universal.questionnaire.questions;

import avaliador.universal.questionnaire.questions.abstractions.Question;

public class AssertionQuestion extends Question{
	
	private String assertion1;
	private String assertion2;
	
	public AssertionQuestion() {
		super();
	}
	
	public AssertionQuestion(String qTitle, String as1, String as2, String a1, String a2, String a3, String a4, String a5, char correct) {
		super(qTitle, a1, a2, a3, a4, a5, correct);
		this.assertion1 = as1;
		this.assertion2 = as2;
	}
	
	public void setAssertions(String as1, String as2) {
		this.assertion1 = as1;
		this.assertion2 = as2;
	}
	
	public String getAssertion1() {
		return this.assertion1;
	}
	
	public String getAssertion2() {
		return this.assertion2;
	}

}
