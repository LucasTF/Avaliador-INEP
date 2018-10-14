package avaliador.universal.enums;

public enum ErrorType {
	
	EMPTYTITLE("O Título está vazio."),
	INVALIDGRADE("A nota está formatada incorretamente."),
	EMPTYTEACHERBOX("Nome de professor não definido."),
	EMPTYTEXTBOX("Há espaços em branco na questão.");
	
	private String error;
	
	ErrorType(String error) {
		this.error = error;
	}
	
	public String getError() {
		return this.error;
	}

}
