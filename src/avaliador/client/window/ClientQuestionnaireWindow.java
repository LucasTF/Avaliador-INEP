package avaliador.client.window;

import java.io.IOException;
import java.util.ArrayList;

import avaliador.client.AnsweredQuestionnaire;
import avaliador.client.window.abstractions.QuestionContainer;
import avaliador.database.AnswerSaveManager;
import avaliador.database.QuestionnaireLoadManager;
import avaliador.universal.abstractions.IStage;
import avaliador.universal.enums.ErrorType;
import avaliador.universal.enums.QuestionType;
import avaliador.universal.factories.SceneFactory;
import avaliador.universal.managers.AlertManager;
import avaliador.universal.managers.AnsweredQuestionnaireMapperManager;
import avaliador.universal.questionnaire.Questionnaire;
import avaliador.universal.questionnaire.questions.AssertionQuestion;
import avaliador.universal.questionnaire.questions.AssociationQuestion;
import avaliador.universal.questionnaire.questions.MultipleAnswerQuestion;
import avaliador.universal.questionnaire.questions.abstractions.Question;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ClientQuestionnaireWindow implements IStage{
	
	@FXML private Label questionnaireTitleLabel;
	@FXML private Label creatorLabel;
	@FXML private TextField studentNameField;
	@FXML private Button finishQuestionnaireButton;
	@FXML private VBox questionsVBox;
	
	private Stage stage;
	private SceneFactory sceneFactory;
	
	private Questionnaire questionnaire;
	private ArrayList<QuestionContainer> questions = new ArrayList<QuestionContainer>();
	
	public ClientQuestionnaireWindow(Stage stage) {
		this.stage = stage;
	}
	
	@FXML
	public void finishQuestionnaire() {
		boolean questionReady = true;
		if(studentNameField.getText().isEmpty()) {
			AlertManager alert = new AlertManager();
			alert.alertWarningMessage("Atenção!", ErrorType.EMPTYSTUDENT);
		}
		else {
			for(QuestionContainer q : questions) {
				if(q.getAnsweredAlternative() == '-') {
					AlertManager alert = new AlertManager();
					if(alert.alertConfirmationMessage("Ainda há questões a serem respondidas tem certeza de que deseja encerrar o questionário?")) {
						break;
					}
					else {
						questionReady = false;
						break;
					}
				}
			}
			if(questionReady == true) {
				AnsweredQuestionnaireMapperManager mapper = new AnsweredQuestionnaireMapperManager();
				AnsweredQuestionnaire ans = mapper.mapAnsweredQuestionnaire(questionnaire, studentNameField.getText(), questions);
				if(ans.equals(null)) {
					System.out.println("ue");
				}
				else {
					AnswerSaveManager saver = new AnswerSaveManager(ans);
					saver.saveQuestionnaire();
					this.stage.close();
				}
			}
		}
	}

	@Override
	public void startStage(boolean show) {
		setStage("appearance/QuestionnaireWindow.fxml");
		stage.setTitle("Avaliador INEP - Questionário");
		stage.setResizable(true);
		setQuestionnaire();
		if(show == true) {
			stage.show();
		}
	}
	
	private void setStage(String stagePath) {
		sceneFactory = new SceneFactory();
		this.stage.setScene(sceneFactory.buildScene(this, stagePath));
	}
	
	private void setQuestionnaire() {
		int count = 0;
		QuestionContainer qc;
		QuestionnaireLoadManager loader = new QuestionnaireLoadManager();
		questionnaire = loader.loadQuestionnaire();
		questionnaireTitleLabel.setText(questionnaire.getTitle());
		creatorLabel.setText(questionnaire.getAuthor());
		for(Question q : questionnaire.getQuestions()) {
			count++;
			try {
				if(q.getQuestionType() == QuestionType.UNIQUE) {
					qc = new UniqueQuestionContainer(questionsVBox);
				}
				else if(q.getQuestionType() == QuestionType.MULTIPLE) {
					qc = new MultQuestionContainer(questionsVBox);
					MultQuestionContainer mq = (MultQuestionContainer) qc;
					MultipleAnswerQuestion maq = (MultipleAnswerQuestion) q;
					mq.setAffirmatives(maq.getAffirmatives());
				}
				else if(q.getQuestionType() == QuestionType.ASSERTION) {
					qc = new AssertionQuestionContainer(questionsVBox);
					AssertionQuestionContainer aq = (AssertionQuestionContainer) qc;
					AssertionQuestion aqu = (AssertionQuestion) q;
					aq.setFirstAffirmation(aqu.getAssertion1());
					aq.setSecondAffirmation(aqu.getAssertion2());
				}
				else {
					qc = new AssociationQuestionContainer(questionsVBox);
					AssociationQuestionContainer asq = (AssociationQuestionContainer) qc;
					AssociationQuestion asqu = (AssociationQuestion) q;
					asq.setTables(asqu.getTables());
				}
				qc.setAlternativesText(q.getAlternatives());
				qc.setQuestionNumber(count);
				qc.setQuestionTitle(q.getQuestionStatement());
				qc.setQuestionValue(q.getQuestionValue());
				questions.add(qc);
				questionsVBox.getChildren().add(qc.getContainerPane());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
