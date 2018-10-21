package avaliador.database;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import avaliador.universal.questionnaire.Questionnaire;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class QuestionnaireLoadManager {
	
	public File getQuestionnaireFile() {
		FileChooser ch = new FileChooser();
		ch.setTitle("Carregar Prova");
		ch.getExtensionFilters().add(new FileChooser.ExtensionFilter("Questionário", "*.qst"));
		File file = ch.showOpenDialog(new Stage());
		if(file != null) {
			return file;
		}
		else {
			// Change this later
			System.out.println("Não funciona");
			return null;
		}
	}
	
	private Questionnaire selectLoadPath() {
		FileChooser ch = new FileChooser();
		ch.setTitle("Carregar Prova");
		ch.getExtensionFilters().add(new FileChooser.ExtensionFilter("Questionário", "*.qst"));
		File file = ch.showOpenDialog(new Stage());
		if(file != null) {
			return createLoadedObject(file);
		}
		else {
			// Change this later
			System.out.println("Não funciona");
			return null;
		}
	}
	
	private Questionnaire createLoadedObject(File file) {
		Questionnaire questionnaire = new Questionnaire();
		FileInputStream f = null;
		ObjectInputStream o = null;
		try {
			f = new FileInputStream(file);
			o = new ObjectInputStream(f);
			questionnaire = (Questionnaire) o.readObject();
			System.out.println("Carregamento feito com sucesso!");
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
	}
	
	public Questionnaire loadQuestionnaire() {
		return selectLoadPath();
	}

}
