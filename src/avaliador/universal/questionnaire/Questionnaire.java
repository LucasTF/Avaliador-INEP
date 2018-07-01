package avaliador.universal.questionnaire;

import java.util.ArrayList;

import avaliador.universal.questionnaire.questions.abstractions.Question;

public class Questionnaire {
	
	private ArrayList<Question> questions;
	
	public Questionnaire() {
		questions = new ArrayList<Question>();
	}

	public Question getQuestion(int id) {
		return questions.get(id);
	}

	public void addQuestion(Question q) {
		questions.add(q);
	}
	
	public void dropQuestion(int id) {
		questions.remove(id);
	}

}
