package avaliador.database;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import avaliador.server.window.QPointerContainer;
import avaliador.universal.enums.ErrorType;
import avaliador.universal.managers.AlertManager;
import avaliador.universal.managers.QuestionMapperManager;
import avaliador.universal.questionnaire.Questionnaire;
import avaliador.universal.questionnaire.questions.abstractions.Question;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class QuestionnaireSaveManager {
	
	Questionnaire questionnaire;
	
	public QuestionnaireSaveManager(ArrayList<QPointerContainer> questionnaire) {
		this.questionnaire = serializeQuestionnaire(questionnaire);
	}
	
	public void saveQuestionnaire() {
		selectSavePath();
	}
	
	private Questionnaire serializeQuestionnaire(ArrayList<QPointerContainer> qc) {
		Questionnaire questionnaire = new Questionnaire();
		QuestionMapperManager mapper = new QuestionMapperManager();
		for(QPointerContainer p : qc) {
			Question q = mapper.mapQuestion(p.getQuestion().getQuestionInformation());
			if(q != null) {
				questionnaire.addQuestion(q);
			}
		}
		return questionnaire;
	}
	
	private void selectSavePath() {
		FileChooser ch = new FileChooser();
		ch.setTitle("Salvar Prova");
		ch.getExtensionFilters().add(new FileChooser.ExtensionFilter("Questionário", "*.qst"));
		File file = ch.showSaveDialog(new Stage());
		if(file != null) {
			createSaveFile(file);
		}
		else {
			// Change this later
			System.out.println("Não funciona");
		}
	}
	
	private void createSaveFile(File file) {
		FileOutputStream f;
		ObjectOutputStream o;
		AlertManager alert = new AlertManager();
		try {
			f = new FileOutputStream(file);
			o = new ObjectOutputStream(f);
			o.writeObject(questionnaire);
			o.close();
			f.close();
			alert.alertInfoMessage("Prova salva com sucesso!");
		}
		catch(IOException e) {
			alert.alertErrorMessage("Erro na geração da prova!", ErrorType.SAVINGFAILED);
		}
	}
	
	/*public ArrayList<QPointerContainer> loadQuestionnaire() {
		ArrayList<QPointerContainer> questionnaire = new ArrayList<QPointerContainer>();
		FileInputStream f = null;
		ObjectInputStream o = null;
		try {
			f = new FileInputStream(new File("Questionnaire-1.qst"));
			o = new ObjectInputStream(f);
			while(true) {
				questionnaire.add((QPointerContainer) o.readObject());
			}
		} catch (EOFException e) {
			try {
				o.close();
				f.close();
			} catch (IOException e1) {
				System.out.println("Erro");
			}
			System.out.println("Load concluido!");
			return questionnaire;
		} catch (ClassNotFoundException e) {
			System.out.println("Classe não encontrada!");
		} catch (IOException e) {
			System.out.println("Ue");
		}
		return questionnaire;
	}*/

}
