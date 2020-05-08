package GerencYoutubeNegocio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Usuario {
	private String email;
	private String nomeCompleto;
	private LocalDate dataNascimento;
	
	
	public Usuario(String email, String nomeCompleto, LocalDate dataNascimento) {
		super();
		this.email = email;
		this.nomeCompleto = nomeCompleto;
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public int getIdade() {
		int idade = 0;
		if(this.getDataNascimento().withYear(2019).isBefore(LocalDate.now())) {
			idade = (2019 - this.getDataNascimento().getYear());
		}
		else {
			idade = (2018 - this.getDataNascimento().getYear());
		}
		return idade;
	}

	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "Usuario: (email: " + email + ", nomeCompleto: " + nomeCompleto + ", dataNascimento: " + dataNascimento.format(formatter)
				+ ") ";
	}
	
	
}
