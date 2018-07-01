package avaliador.universal.questionnaire.questions.types;

public class Alternative {
	
	private String aText;
	private boolean isRight;
	
	public Alternative(String aText, boolean answer) {
		this.aText = aText;
		this.isRight = answer;
	}
	
	public Alternative(String aText) {
		this.aText = aText;
	}
	
	public Alternative(boolean answer) {
		this.isRight = answer;
	}
	
	public Alternative() {
		this.isRight = false;
	}
	
	public String getAText() {
		return this.aText;
	}
	
	public boolean getIsRight() {
		return this.isRight;
	}
	
	public void setAText(String alternative) {
		this.aText = alternative;
	}
	
	public void setIsRight() {
		this.isRight = true;
	}

}
