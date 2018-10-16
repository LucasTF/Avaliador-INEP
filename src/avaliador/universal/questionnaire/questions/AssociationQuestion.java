package avaliador.universal.questionnaire.questions;

import avaliador.universal.enums.QuestionType;
import avaliador.universal.questionnaire.questions.abstractions.Question;

public class AssociationQuestion extends Question{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8691765091615819384L;
	private String[][] tables;
	
	public AssociationQuestion() {
		super();
		tables = new String[2][5];
	}

	@Override
	public QuestionType getQuestionType() {
		return QuestionType.ASSOCIATION;
	}

	public String[][] getTables() {
		return tables;
	}

	public void setTables(String[][] text) {
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 5; j++) {
				tables[i][j] = text[i][j];
			}
		}
	}

}
