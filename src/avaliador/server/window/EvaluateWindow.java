package avaliador.server.window;

import java.util.ArrayList;

import avaliador.client.AnsweredQuestionnaire;
import avaliador.server.ResultQuestionnaire;
import avaliador.universal.abstractions.IStage;
import avaliador.universal.factories.SceneFactory;
import avaliador.universal.managers.ResultMapperManager;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class EvaluateWindow implements IStage{
	
	@FXML private TableView<ResultQuestionnaire> resultTable;
	@FXML private TableColumn<ResultQuestionnaire, String> titleColumn;
	@FXML private TableColumn<ResultQuestionnaire, String> authorColumn;
	@FXML private TableColumn<ResultQuestionnaire, String> studentColumn;
	@FXML private TableColumn<ResultQuestionnaire, String> correctAnswersColumn;
	@FXML private TableColumn<ResultQuestionnaire, String> wrongAnswersColumn;
	@FXML private TableColumn<ResultQuestionnaire, Double> finalValueColumn;
	@FXML private TableColumn<ResultQuestionnaire, Double> totalValueColumn;
	@FXML private Button returnButton;
	
	private Stage stage;
	private SceneFactory sceneFactory;
	
	private ArrayList<ResultQuestionnaire> result;
	
	public EvaluateWindow(ArrayList<AnsweredQuestionnaire> ans) {
		ResultMapperManager mapper = new ResultMapperManager();
		result = mapper.mapResult(ans);
		stage = new Stage();
		startStage(false);
		associateColumns();
		addResults();
		stage.show();
	}

	private void addResults() {
		resultTable.setItems(FXCollections.observableArrayList(result));
		System.out.println(result.size());
	}

	private void associateColumns() {
		titleColumn.setCellValueFactory(new PropertyValueFactory<>("questionnaireTitle"));
		authorColumn.setCellValueFactory(new PropertyValueFactory<>("authorTitle"));
		studentColumn.setCellValueFactory(new PropertyValueFactory<>("studentName"));
		correctAnswersColumn.setCellValueFactory(new PropertyValueFactory<>("correctAnswers"));
		wrongAnswersColumn.setCellValueFactory(new PropertyValueFactory<>("wrongAnswers"));
		finalValueColumn.setCellValueFactory(new PropertyValueFactory<>("finalValue"));
		totalValueColumn.setCellValueFactory(new PropertyValueFactory<>("totalValue"));
	}

	@Override
	public void startStage(boolean show) {
		setStage("appearance/EvaluateWindow.fxml");
		stage.setTitle("Lista de Questionários");
		stage.setResizable(false);
		if(show == true) {
			stage.show();
		}
	}
	
	private void setStage(String stagePath) {
		sceneFactory = new SceneFactory();
		this.stage.setScene(sceneFactory.buildScene(this, stagePath));
	}
	
	@FXML
	public void returnToMainWindow() {
		
	}

}
