package avaliador.server.window;

import java.io.IOException;
import java.util.ArrayList;

import avaliador.server.window.abstractions.IStage;
import avaliador.universal.factories.SceneFactory;
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
	}

	@Override
	public void startStage() {
		setStage("appearance/CreateWindow.fxml");
		stage.setTitle("Criador de Questoes");
		stage.setResizable(false);
		stage.sizeToScene();
		stage.show();
	}
	@Override
	public void setStage(String stagePath) {
		sceneFactory = new SceneFactory();
		this.scene = sceneFactory.buildScene(this, stagePath);
		this.stage.setScene(this.scene);
	}
	
	@FXML
	public void newQuestionManager() {
		QPointerContainer questionPointer = new QPointerContainer(this);
		questionPointer.getQuestion().startStage();
	}
	
	@FXML
	public void saveManager() {
		
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
