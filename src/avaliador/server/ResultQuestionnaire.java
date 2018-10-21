package avaliador.server;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class ResultQuestionnaire {
	
	private SimpleStringProperty questionnaireTitle;
	private SimpleStringProperty authorTitle;
	private SimpleStringProperty studentName;
	private SimpleStringProperty correctAnswers;
	private SimpleStringProperty wrongAnswers;
	private SimpleDoubleProperty totalValue;
	private SimpleDoubleProperty finalValue;
	
	public ResultQuestionnaire(String qTitle, String aTitle, String student, String correctA, String wrongA, double totalValue, double finalValue) {
		this.questionnaireTitle = new SimpleStringProperty(qTitle);
		this.authorTitle = new SimpleStringProperty(aTitle);
		this.studentName = new SimpleStringProperty(student);
		this.correctAnswers = new SimpleStringProperty(correctA);
		this.wrongAnswers = new SimpleStringProperty(wrongA);
		this.totalValue = new SimpleDoubleProperty(totalValue);
		this.finalValue = new SimpleDoubleProperty(finalValue);
	}
	
	public String getQuestionnaireTitle() {
		return questionnaireTitle.get();
	}
	public void setQuestionnaireTitle(String questionnaireTitle) {
		this.questionnaireTitle.set(questionnaireTitle);
	}
	public String getAuthorTitle() {
		return authorTitle.get();
	}
	public void setAuthorTitle(String authorTitle) {
		this.authorTitle.set(authorTitle);
	}
	public String getStudentName() {
		return studentName.get();
	}
	public void setStudentName(String studentName) {
		this.studentName.set(studentName);
	}
	public String getCorrectAnswers() {
		return correctAnswers.get();
	}
	public void setCorrectAnswers(String correctAnswers) {
		this.correctAnswers.set(correctAnswers);
	}
	public String getWrongAnswers() {
		return wrongAnswers.get();
	}
	public void addToWrongAnswers(String wrongAnswers) {
		this.wrongAnswers.set(wrongAnswers);
	}
	public double getTotalValue() {
		return totalValue.get();
	}
	public void setTotalValue(double totalValue) {
		this.totalValue.set(totalValue);
	}
	public double getFinalValue() {
		return finalValue.get();
	}
	public void setFinalValue(double finalValue) {
		this.finalValue.set(finalValue);
	}

}
