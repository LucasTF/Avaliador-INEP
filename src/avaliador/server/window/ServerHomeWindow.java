package avaliador.server.window;

import avaliador.database.QuestionnaireLoadManager;
import avaliador.universal.abstractions.IStage;
import avaliador.universal.factories.SceneFactory;
import avaliador.universal.questionnaire.Questionnaire;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ServerHomeWindow implements IStage{
	
	@FXML private Button createQuestionnaireButton;
	@FXML private Button loadQuestionnaireButton;
	@FXML private Button evaluateQuestionnaireButton;
	
	@SuppressWarnings("unused")
	private IStage questionnaireWindow;
	
	private Stage stage;
	private Scene scene;
	private SceneFactory sceneFactory;
	
	public ServerHomeWindow(Stage stage) {
		this.stage = stage;
	}
	
	@Override
	public void startStage(boolean show) {
		setStage("appearance/ServerHomeWindow.fxml");
		stage.setTitle("Avaliador INEP - Criador de Questões");
		stage.setResizable(false);
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
	public void createButtonManager() {
		questionnaireWindow = new ServerCreateWindow();
		stage.close();
	}
	
	@FXML
	public void loadButtonManager() {
		QuestionnaireLoadManager loader = new QuestionnaireLoadManager();
		Questionnaire q = loader.loadQuestionnaire();
		questionnaireWindow = new ServerCreateWindow(q);
		stage.close();
	}
	
	@FXML
	public void evaluateButtonManager() {
		// TO BE ADDED
	}
	
	

}
