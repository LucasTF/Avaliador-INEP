package avaliador.universal.questionnaire;

import java.util.ArrayList;

import avaliador.universal.questionnaire.questions.abstractions.Question;

public class Questionnaire {
	
	private ArrayList<Question> questions;
	
	private String author;
	
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
