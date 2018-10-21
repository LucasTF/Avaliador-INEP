package avaliador.database;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import avaliador.client.AnsweredQuestionnaire;
import avaliador.universal.enums.ErrorType;
import avaliador.universal.managers.AlertManager;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class AnswerSaveManager {
	
	private AnsweredQuestionnaire questionnaire;
	
	public AnswerSaveManager(AnsweredQuestionnaire ans) {
		this.questionnaire = ans;
	}
	
	public void saveQuestionnaire() {
		selectSavePath();
	}
	
	private void selectSavePath() {
		FileChooser ch = new FileChooser();
		ch.setTitle("Salvar Prova");
		ch.getExtensionFilters().add(new FileChooser.ExtensionFilter("Questionário respondido", "*.ans"));
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
			alert.alertInfoMessage("Prova concluida!");
		}
		catch(IOException e) {
			alert.alertErrorMessage("Erro na geração da prova!", ErrorType.SAVINGFAILED);
		}
	}

}
