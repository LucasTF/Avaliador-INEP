package avaliador.universal.questionnaire.questions.types;

public class Alternative {
	
	private String aText;
	
	public Alternative(String aText) {
		this.aText = aText;
	}
	
	public String getAText() {
		return this.aText;
	}
	
	public void setText(String alternative) {
		this.aText = alternative;
	}

}
