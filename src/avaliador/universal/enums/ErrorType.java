package avaliador.universal.enums;

public enum ErrorType {
	
	EMPTYTITLE("O T�tulo est� vazio."),
	INVALIDGRADE("A nota est� formatada incorretamente."),
	EMPTYTEACHERBOX("Nome de professor n�o definido."),
	EMPTYTEXTBOX("H� espa�os em branco na quest�o.");
	
	private String error;
	
	ErrorType(String error) {
		this.error = error;
	}
	
	public String getError() {
		return this.error;
	}

}
