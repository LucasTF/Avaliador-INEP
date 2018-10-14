package avaliador.universal.questionnaire.questions;

import avaliador.universal.questionnaire.questions.abstractions.Question;

public class AssociationQuestion extends Question{
	
	private String[] numberedColumn;
	private String[] blankColumn;
	
	public AssociationQuestion() {
		super();
		setNumberedColumn(new String[5]);
		setBlankColumn(new String[5]);
	}
	
	public AssociationQuestion(String qTitle, String a1, String a2, String a3, String a4, String a5, char correct) {
		super(qTitle, a1, a2, a3, a4, a5, correct);
	}

	public String[] getNumberedColumn() {
		return numberedColumn;
	}

	public void setNumberedColumn(String[] numberedColumn) {
		this.numberedColumn = numberedColumn;
	}

	public String[] getBlankColumn() {
		return blankColumn;
	}

	public void setBlankColumn(String[] blankColumn) {
		this.blankColumn = blankColumn;
	}

}
