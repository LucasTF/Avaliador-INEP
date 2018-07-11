package avaliador.server.window;

import avaliador.server.window.abstractions.IContainer;
import avaliador.server.window.abstractions.IStage;
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
	
	private Stage stage;
	private Scene scene;
	private IContainer questionContainer;
	
	public ServerNewQuestionWindow() {
		stage = new Stage();
	}

	@Override
	public void startStage() {
		setStage("appearance/NewQuestionWindow.fxml");
		stage.setTitle("Criador de Questoes - Nova Questao");
		stage.setResizable(false);
		stage.show();
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
		questionContainer = containerFactory.buildQContainer(containerPane, "Unique");
		containerPane.getChildren().setAll(questionContainer.getContainerPane());
		menuMain.setText(uniqueQuestion.getText());
		stage.sizeToScene();
	}
	
	@FXML
	public void setMultQuestion() {
		containerPane.getChildren().clear();
		ContainerFactory containerFactory = new ContainerFactory();
		questionContainer = containerFactory.buildQContainer(containerPane, "Mult");
		containerPane.getChildren().setAll(questionContainer.getContainerPane());
		menuMain.setText(multQuestion.getText());
		stage.sizeToScene();
	}
	
	@FXML
	public void setAssertionQuestion() {
		containerPane.getChildren().clear();
		ContainerFactory containerFactory = new ContainerFactory();
		questionContainer = containerFactory.buildQContainer(containerPane, "Assertion");
		containerPane.getChildren().setAll(questionContainer.getContainerPane());
		menuMain.setText(assertionQuestion.getText());
		stage.sizeToScene();
	}
	
	@FXML
	public void setAssociationQuestion() {
		containerPane.getChildren().clear();
		ContainerFactory containerFactory = new ContainerFactory();
		questionContainer = containerFactory.buildQContainer(containerPane, "Association");
		containerPane.getChildren().setAll(questionContainer.getContainerPane());
		menuMain.setText(associationQuestion.getText());
		stage.sizeToScene();
	}
	
	@FXML
	public void setOrderQuestion() {
		containerPane.getChildren().clear();
		ContainerFactory containerFactory = new ContainerFactory();
		questionContainer = containerFactory.buildQContainer(containerPane, "Order");
		containerPane.getChildren().setAll(questionContainer.getContainerPane());
		menuMain.setText(orderQuestion.getText());
		stage.sizeToScene();
	}

}
