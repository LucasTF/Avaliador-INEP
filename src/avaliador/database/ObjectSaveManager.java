package avaliador.database;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import avaliador.server.window.QPointerContainer;

public class ObjectSaveManager {
	
	public ObjectSaveManager() {
		
	}
	
	public void saveQuestionnaire(ArrayList<QPointerContainer> questionnaire) {
		FileOutputStream f;
		ObjectOutputStream o;
		try {
			f = new FileOutputStream(new File("Questionnaire-1.qst"));
			o = new ObjectOutputStream(f);
			for(QPointerContainer i : questionnaire) {
				o.writeObject(i);
			}
			o.close();
			f.close();
			System.out.println("Salvo com sucesso!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<QPointerContainer> loadQuestionnaire() {
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
	}

}
