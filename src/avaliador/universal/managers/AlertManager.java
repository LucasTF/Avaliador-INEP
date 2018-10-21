package avaliador.universal.managers;

import java.util.Optional;

import avaliador.universal.enums.ErrorType;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class AlertManager {
	
	public void alertWarningMessage(String errorTitle, ErrorType error) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle(errorTitle);
		alert.setHeaderText(null);
		alert.setContentText(error.getError());
		alert.showAndWait();
	}
	
	public void alertErrorMessage(String errorTitle, ErrorType error) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(errorTitle);
		alert.setHeaderText(null);
		alert.setContentText(error.getError());
		alert.showAndWait();
	}
	
	public void alertInfoMessage(String information) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Atenção!");
		alert.setHeaderText(null);
		alert.setContentText(information);
		alert.showAndWait();
	}
	
	public boolean alertConfirmationMessage(String information) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Atenção!");
		alert.setHeaderText(null);
		alert.setContentText(information);
		Optional<ButtonType> result = alert.showAndWait();
		if(result.get() == ButtonType.OK) {
			return true;
		}
		else {
			return false;
		}
	}

}
