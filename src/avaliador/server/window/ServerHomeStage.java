package avaliador.server.window;

import avaliador.server.window.abstractions.IStage;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ServerHomeStage implements IStage{
	
	@FXML private Button createQuestionnaireButton;
	@FXML private Button loadQuestionnaireButton;
	@FXML private Button dropQuestionnaireButton;
	@FXML private Button evaluateQuestionnaireButton;
	
	private IStage questionnaireWindow = null;
	
	private Stage stage;
	private Scene scene;
	private SceneFactory sceneFactory;
	
	public ServerHomeStage(Stage stage) {
		this.stage = stage;
	}
	
	@Override
	public void startStage() {
		setStage("appearance/ServerHomeStageWindow.fxml");
		stage.setTitle("Avaliador INEP - Servidor");
		stage.setResizable(false);
		stage.show();
	}
	@Override
	public void setStage(String stagePath) {
		sceneFactory = new SceneFactory();
		this.scene = sceneFactory.buildScene(this, stagePath);
		this.stage.setScene(this.scene);
	}
	
	@FXML
	public void createButtonManager() {
		// TEMPORARY SOLUTION FOR JUST 1 QUESTIONNAIRE WINDOW. MUST CHANGE LATER.
		if(questionnaireWindow == null) {
			questionnaireWindow = new ServerCreateStage();
			questionnaireWindow.startStage();
		}
	}
	
	@FXML
	public void loadButtonManager() {
		// TO BE ADDED
	}
	
	@FXML
	public void dropButtonManager() {
		// TO BE ADDED
	}
	
	@FXML
	public void evaluateButtonManager() {
		// TO BE ADDED
	}
	
	

}
