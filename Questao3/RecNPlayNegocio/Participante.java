package RecNPlayNegocio;

import java.time.LocalDate;

public class Participante extends Pessoa{
	private String trilhaDeInteresse;

	public Participante(Long codigo, String email, String nome, String cidade, LocalDate dataNascimento,
			String trilhaDeInteresse) {
		super(codigo, email, nome, cidade, dataNascimento);
		this.trilhaDeInteresse = trilhaDeInteresse;
	}

	public String getTrilhaDeInteresse() {
		return trilhaDeInteresse;
	}

	public void setTrilhaDeInteresse(String trilhaDeInteresse) {
		this.trilhaDeInteresse = trilhaDeInteresse;
	}

	@Override
	public String toString() {
		return "Participante [ " + super.toString() + " trilhaDeInteresse=" + trilhaDeInteresse + "]";
	}
	
	
}
