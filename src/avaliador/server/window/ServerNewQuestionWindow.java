package avaliador.server.window;

import avaliador.server.window.abstractions.IStage;
import avaliador.server.window.abstractions.QuestionContainer;
import avaliador.universal.factories.ContainerFactory;
import avaliador.universal.factories.SceneFactory;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ServerNewQuestionWindow implements IStage{
	
	@FXML private AnchorPane mainPane;
	@FXML private SplitMenuButton menuMain;
	
	@FXML private MenuItem uniqueQuestion;
	@FXML private MenuItem multQuestion;
	@FXML private MenuItem assertionQuestion;
	@FXML private MenuItem associationQuestion;
	@FXML private MenuItem orderQuestion;
	
	@FXML private AnchorPane containerPane;
	
	private QPointerContainer pointerContainer;
	
	private Stage stage;
	private Scene scene;
	private QuestionContainer questionContainer;
	
	public ServerNewQuestionWindow(QPointerContainer pointerContainer) {
		stage = new Stage();
		this.pointerContainer = pointerContainer;
	}

	@Override
	public void startStage(boolean show) {
		setStage("appearance/NewQuestionWindow.fxml");
		stage.setTitle("Criador de Questoes - Nova Questao");
		stage.setResizable(false);
		if(show == true) {
			stage.show();
		}
	}

	@Override
	public void setStage(String stagePath) {
		SceneFactory sceneFactory = new SceneFactory();
		this.scene = sceneFactory.buildScene(this, stagePath);
		this.stage.setScene(this.scene);
	}
	
	@FXML
	public void setUniqueQuestion() {
		containerPane.getChildren().clear();
		ContainerFactory containerFactory = new ContainerFactory();
		questionContainer = containerFactory.buildQContainer(this, containerPane, "Unique");
		containerPane.getChildren().setAll(questionContainer.getContainerPane());
		menuMain.setText(uniqueQuestion.getText());
		stage.sizeToScene();
	}
	
	@FXML
	public void setMultQuestion() {
		containerPane.getChildren().clear();
		ContainerFactory containerFactory = new ContainerFactory();
		questionContainer = containerFactory.buildQContainer(this, containerPane, "Mult");
		containerPane.getChildren().setAll(questionContainer.getContainerPane());
		menuMain.setText(multQuestion.getText());
		stage.sizeToScene();
	}
	
	@FXML
	public void setAssertionQuestion() {
		containerPane.getChildren().clear();
		ContainerFactory containerFactory = new ContainerFactory();
		questionContainer = containerFactory.buildQContainer(this, containerPane, "Assertion");
		containerPane.getChildren().setAll(questionContainer.getContainerPane());
		menuMain.setText(assertionQuestion.getText());
		stage.sizeToScene();
	}
	
	@FXML
	public void setAssociationQuestion() {
		containerPane.getChildren().clear();
		ContainerFactory containerFactory = new ContainerFactory();
		questionContainer = containerFactory.buildQContainer(this, containerPane, "Association");
		containerPane.getChildren().setAll(questionContainer.getContainerPane());
		menuMain.setText(associationQuestion.getText());
		stage.sizeToScene();
	}
	
	@FXML
	public void setOrderQuestion() {
		containerPane.getChildren().clear();
		ContainerFactory containerFactory = new ContainerFactory();
		questionContainer = containerFactory.buildQContainer(this, containerPane, "Order");
		containerPane.getChildren().setAll(questionContainer.getContainerPane());
		menuMain.setText(orderQuestion.getText());
		stage.sizeToScene();
	}
	
	public void setMenuDisable(boolean isDisabled) {
		menuMain.setDisable(isDisabled);
	}
	
	public String getQuestionTitle() {
		return this.questionContainer.getQuestionTitle();
	}
	
	public QuestionContainer getQuestionInformation() {
		return questionContainer;
	}
	
	public QPointerContainer getPointerContainer() {
		return this.pointerContainer;
	}
	
	public Stage getStage() {
		return this.stage;
	}

}
