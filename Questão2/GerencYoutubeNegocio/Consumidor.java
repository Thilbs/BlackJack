package GerencYoutubeNegocio;

import java.time.LocalDate;
import java.util.List;

public class Consumidor extends Usuario{
	private List<String> categoriasInteresse;

	
	public Consumidor(String email, String nomeCompleto, LocalDate dataNascimento, List<String> categoriasInteresse) {
		super(email, nomeCompleto, dataNascimento);
		this.categoriasInteresse = categoriasInteresse;
	}

	public List<String> getCategoriasInteresse() {
		return categoriasInteresse;
	}

	public void setCategoriasInteresse(List<String> categoriasInteresse) {
		this.categoriasInteresse = categoriasInteresse;
	}

	@Override
	public String toString() {
		return "Consumidor: ( " + super.toString() + " categoriasInteresse: " + categoriasInteresse + " ) ";
	}
	
	
}
