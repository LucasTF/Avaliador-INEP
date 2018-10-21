package avaliador.universal.enums;

public enum ErrorType {
	
	EMPTYTITLE("O T�tulo est� vazio."),
	INVALIDGRADE("A nota est� formatada incorretamente."),
	EMPTYTEACHERBOX("Nome de professor n�o definido."),
	NOQUESTION("A prova precisa de, pelo menos, uma quest�o."),
	SAVINGFAILED("N�o foi poss�vel salvar a prova."),
	EMPTYSTUDENT("O nome do aluno est� em branco."),
	EMPTYTEXTBOX("H� espa�os em branco na quest�o.");
	
	private String error;
	
	ErrorType(String error) {
		this.error = error;
	}
	
	public String getError() {
		return this.error;
	}

}
