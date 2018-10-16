package avaliador.universal.questionnaire;

import java.io.Serializable;
import java.util.ArrayList;

import avaliador.universal.questionnaire.questions.abstractions.Question;

public class Questionnaire implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3614103586720511402L;

	private ArrayList<Question> questions;
	
	private String title;
	private String author;
	
	public Questionnaire() {
		questions = new ArrayList<Question>();
	}
	
	public ArrayList<Question> getQuestions(){
		return questions;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
