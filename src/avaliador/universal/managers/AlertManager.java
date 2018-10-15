package avaliador.universal.managers;

import avaliador.universal.enums.ErrorType;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

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

}
