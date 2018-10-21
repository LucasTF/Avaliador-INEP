package avaliador.database;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import avaliador.client.AnsweredQuestionnaire;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class AnswerLoadManager {
	
	private ArrayList<AnsweredQuestionnaire> selectLoadPath() {
		FileChooser ch = new FileChooser();
		ch.setTitle("Carregar Prova");
		ch.getExtensionFilters().add(new FileChooser.ExtensionFilter("Questionário respondido", "*.ans"));
		List<File> fileList = ch.showOpenMultipleDialog(new Stage());
		if(fileList != null) {
			return createLoadedObjects(fileList);
		}
		else {
			// Change this later
			System.out.println("Não funciona");
			return null;
		}
	}
	
	private ArrayList<AnsweredQuestionnaire> createLoadedObjects(List<File> fileList) {
		ArrayList<AnsweredQuestionnaire> questionnaires = new ArrayList<AnsweredQuestionnaire>();
		FileInputStream f = null;
		ObjectInputStream o = null;
		for(File file : fileList) {
			try {
				f = new FileInputStream(file);
				o = new ObjectInputStream(f);
				questionnaires.add((AnsweredQuestionnaire) o.readObject());
				System.out.println("Carregamento feito com sucesso!");
			} catch (EOFException e) {
				try {
					o.close();
					f.close();
				} catch (IOException e1) {
					System.out.println("Erro");
				}
				System.out.println("Load concluido!");
				return questionnaires;
			} catch (ClassNotFoundException e) {
				System.out.println("Classe não encontrada!");
			} catch (IOException e) {
				System.out.println("Ue");
			}
		}
		return questionnaires;
	}
	
	public ArrayList<AnsweredQuestionnaire> loadQuestionnaire() {
		return selectLoadPath();
	}

}
