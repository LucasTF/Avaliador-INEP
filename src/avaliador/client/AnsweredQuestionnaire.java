package avaliador.client;

import java.io.Serializable;

public class AnsweredQuestionnaire implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5720187178594071566L;
	private String questionnaireTitle;
	private String authorTitle;
	private String studentName;
	private String correctAnswers;
	private String wrongAnswers;
	private double totalValue;
	private double finalValue;
	
	public AnsweredQuestionnaire() {
		finalValue = 0;
		correctAnswers = "-";
		wrongAnswers = "-";
	}
	
	public String getQuestionnaireTitle() {
		return questionnaireTitle;
	}
	public void setQuestionnaireTitle(String questionnaireTitle) {
		this.questionnaireTitle = questionnaireTitle;
	}
	public String getAuthorTitle() {
		return authorTitle;
	}
	public void setAuthorTitle(String authorTitle) {
		this.authorTitle = authorTitle;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getCorrectAnswers() {
		return correctAnswers;
	}
	public void addToCorrectAnswers(int questionID) {
		if(this.correctAnswers.equals("-")) {
			this.correctAnswers = Integer.toString(questionID);
		}
		else {
			this.correctAnswers = this.correctAnswers + ", " + Integer.toString(questionID);
		}
	}
	public String getWrongAnswers() {
		return wrongAnswers;
	}
	public void addToWrongAnswers(int questionID) {
		if(this.wrongAnswers.equals("-")) {
			this.wrongAnswers = Integer.toString(questionID);
		}
		else {
			this.wrongAnswers = this.wrongAnswers + ", " + Integer.toString(questionID);
		}
	}
	public double getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}
	public double getFinalValue() {
		return finalValue;
	}
	public void addToFinalValue(double finalValue) {
		this.finalValue = this.finalValue + finalValue;
	}

}
