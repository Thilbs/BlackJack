package RecNPlayNegocio;

import java.time.LocalDate;

public class Palestrante extends Pessoa{
	private String empresa;

	public Palestrante(Long codigo, String email, String nome, String cidade, LocalDate dataNascimento,
			String empresa) {
		super(codigo, email, nome, cidade, dataNascimento);
		this.empresa = empresa;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	@Override
	public String toString() {
		return "Palestrante [ " + super.toString() + " empresa=" + empresa + "]";
	}
	
	
}
