package avaliador.server.window;

import java.io.IOException;
import java.util.ArrayList;

import avaliador.server.window.abstractions.IContainer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class QPointerContainer implements IContainer{
	
	@FXML private AnchorPane containerPane;
	@FXML private Label questionTitle;
	
	@FXML private Button editButton;
	@FXML private Button deleteButton;
	
	private static final String fxml = "appearance/containers/QPointerContainer.fxml";
	
	private ServerCreateWindow questionnaireWindow;
	private ServerNewQuestionWindow question;
	
	private FXMLLoader loader;
	
	public QPointerContainer(ServerCreateWindow mainWindow) {
		this.questionnaireWindow = mainWindow;
		question = new ServerNewQuestionWindow(this);
		this.loader = new FXMLLoader(getClass().getResource(fxml));
		this.loader.setController(this);
	}
	
	@FXML
	public void editButtonManager() {
		question.getStage().show();
	}
	
	@FXML
	public void deleteButtonManager() {
		int start = questionnaireWindow.getContainerList().indexOf(this);
		questionnaireWindow.dropQuestionContainer(this);
		ArrayList<QPointerContainer> containers = questionnaireWindow.getContainerList();
		for(int i = start; i < questionnaireWindow.getContainerList().size(); i++) {
			int index = containers.get(i).getQuestionTitle().indexOf(' ');
			containers.get(i).setQuestionTitle(containers.get(i).getQuestionTitle().substring(index));
		}
	}
	
	public void loadPointer(Parent parent) throws IOException {
		parent = loader.load();
	}
	
	public void setQuestionTitle(String qTitle) {
		if(questionTitle.getText().equals("Questão X")) {
			questionTitle.setWrapText(true);
		}
		questionTitle.setText((getQuestionnaireWindow().getContainerList().indexOf(this)+1) + ". " + qTitle);
	}
	
	public String getQuestionTitle() {
		return this.questionTitle.getText();
	}
	
	public ServerNewQuestionWindow getQuestion() {
		return this.question;
	}
	
	public ServerCreateWindow getQuestionnaireWindow() {
		return this.questionnaireWindow;
	}
	
	public AnchorPane getContainerPane() {
		return containerPane;
	}

}
