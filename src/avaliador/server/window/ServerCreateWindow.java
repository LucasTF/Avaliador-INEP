package avaliador.server.window;

import java.io.IOException;
import java.util.ArrayList;

import avaliador.database.QuestionnaireSaveManager;
import avaliador.universal.abstractions.IStage;
import avaliador.universal.enums.ErrorType;
import avaliador.universal.factories.SceneFactory;
import avaliador.universal.managers.AlertManager;
import avaliador.universal.managers.ContainerMapperManager;
import avaliador.universal.questionnaire.Questionnaire;
import avaliador.universal.questionnaire.questions.abstractions.Question;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ServerCreateWindow implements IStage{
	
	@FXML private TextField authorTextField;
	@FXML private TextField titleTextField;
	@FXML private Label valueLabel;
	
	@FXML private VBox questionVBox;
	
	@FXML private Button newQuestionButton;
	@FXML private Button saveButton;
	
	private ArrayList<QPointerContainer> questionContainers;
	
	private Stage stage;
	private Scene scene;
	private SceneFactory sceneFactory;
	
	public ServerCreateWindow() {
		stage = new Stage();
		questionContainers = new ArrayList<QPointerContainer>();
		startStage(true);
	}

	public ServerCreateWindow(Questionnaire q) {
		stage = new Stage();
		questionContainers = new ArrayList<QPointerContainer>();
		startStage(true);
		authorTextField.setText(q.getAuthor());
		titleTextField.setText(q.getTitle());
		for(Question question : q.getQuestions()) {
			QPointerContainer qp = loadQuestionManager();
			ContainerMapperManager mapper = new ContainerMapperManager(qp, question);
			mapper.mapContainer();
			qp.getQuestion().getQuestionInformation().addQuestion();
		}
	}

	@Override
	public void startStage(boolean show) {
		setStage("appearance/CreateWindow.fxml");
		stage.setTitle("Criador de Questoes");
		stage.setResizable(false);
		stage.sizeToScene();
		if(show == true) {
			stage.show();
		}
	}
	
	private void setStage(String stagePath) {
		sceneFactory = new SceneFactory();
		this.scene = sceneFactory.buildScene(this, stagePath);
		this.stage.setScene(this.scene);
	}
	
	@FXML
	private void newQuestionManager() {
		QPointerContainer questionPointer = new QPointerContainer(this);
		questionPointer.getQuestion().startStage(true);
	}
	
	private QPointerContainer loadQuestionManager() {
		QPointerContainer questionPointer = new QPointerContainer(this);
		questionPointer.getQuestion().startStage(false);
		return questionPointer;
	}
	
	@FXML
	private void saveManager() {
		if(isQuestionnaireValid()) {
			QuestionnaireSaveManager saveQ = new QuestionnaireSaveManager(questionContainers);
			saveQ.saveQuestionnaire();
		}
	}
	
	private boolean isQuestionnaireValid() {
		AlertManager alert = new AlertManager();
		if(questionContainers.isEmpty()) {
			alert.alertWarningMessage("Erro no salvamento do questionário.", ErrorType.NOQUESTION);
			return false;
		}
		if(getAuthor().isEmpty()) {
			alert.alertWarningMessage("Erro no salvamento do questionário.", ErrorType.EMPTYTEACHERBOX);
			return false;
		}
		if(getTitle().isEmpty()) {
			alert.alertWarningMessage("Erro no salvamento do questionário.", ErrorType.EMPTYTITLE);
			return false;
		}
		return true;
	}
	
	public void updateQuestionnaireValue() {
		double qValue = 0;
		for(QPointerContainer c : questionContainers) {
			qValue = qValue + c.getQuestionValue();
		}
		setValueLabel(qValue);
	}
	
	public void setValueLabel(double value) {
		valueLabel.setText(Double.toString(value));
	}
	
	public String getAuthor() {
		return this.authorTextField.getText();
	}
	
	public String getTitle() {
		return this.titleTextField.getText();
	}
	
	public void dropQuestionContainer(QPointerContainer pointer) {
		questionVBox.getChildren().remove(pointer.getContainerPane());
		questionContainers.remove(pointer);
	}
	
	public void createQuestionContainer(QPointerContainer pointer) {
		try {
			pointer.loadPointer(questionVBox);
		} catch (IOException e) {
			System.out.println("Load failed!");
		}
		questionVBox.getChildren().add(pointer.getContainerPane());
		questionContainers.add(pointer);
	}
	
	public ArrayList<QPointerContainer> getContainerList(){
		return this.questionContainers;
	}

}
