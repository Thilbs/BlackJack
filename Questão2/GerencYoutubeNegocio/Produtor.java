package GerencYoutubeNegocio;

import java.time.LocalDate;
import java.util.List;

public class Produtor extends Usuario {
	private String nomeCanal;
	private List<String> categorias;
	
	
	public Produtor(String email, String nomeCompleto, LocalDate dataNascimento, String nomeCanal,
			List<String> categorias) {
		super(email, nomeCompleto, dataNascimento);
		this.nomeCanal = nomeCanal;
		this.categorias = categorias;
	}
	public String getNomeCanal() {
		return nomeCanal;
	}
	public void setNomeCanal(String nomeCanal) {
		this.nomeCanal = nomeCanal;
	}
	public List<String> getCategorias() {
		return categorias;
	}
	public void setCategorias(List<String> categorias) {
		this.categorias = categorias;
	}
	
	
	@Override
	public String toString() {
		return "Produtor: ( " + super.toString() + " nomeCanal: " + nomeCanal + ", categorias: " + categorias + " ) ";

	}
	
	
}
