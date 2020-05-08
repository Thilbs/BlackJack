package RecNPlayNegocio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Pessoa {
	private Long codigo;
	private String email;
	private String nome;
	private String cidade;
	private LocalDate dataNascimento;
	
	public Pessoa(Long codigo, String email, String nome, String cidade, LocalDate dataNascimento) {
		super();
		this.codigo = codigo;
		this.email = email;
		this.nome = nome;
		this.cidade = cidade;
		this.dataNascimento = dataNascimento;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
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
		return "Pessoa [codigo=" + codigo + ", email=" + email + ", nome=" + nome + ", cidade=" + cidade
				+ ", dataNascimento=" + dataNascimento.format(formatter) + "]";
	}
			
}
