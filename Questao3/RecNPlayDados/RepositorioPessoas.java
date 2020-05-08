package RecNPlayDados;

import java.util.ArrayList;
import java.util.List;

import RecNPlayNegocio.Palestrante;
import RecNPlayNegocio.Participante;
import RecNPlayNegocio.Pessoa;

public class RepositorioPessoas {
	private Pessoa[] pessoas;
	private int proxima;
	
	private static RepositorioPessoas instance;
	
	public static RepositorioPessoas getInstance() {
		if(instance == null){
			instance = new RepositorioPessoas(100);
		}		
		return instance;
	}
	
	private RepositorioPessoas(int tamanho) {
		this.pessoas = new Pessoa[tamanho];
		this.proxima = 0;
	}
	
	public void inserirPessoa(Pessoa p) {
		if(this.proxima == 0) {
			this.pessoas[this.proxima] = p;
			this.proxima += 1; 
		}
		else {
			int contador = 0;
			for(int i = 0; i < this.proxima; i++) {
				if(this.pessoas[i].getEmail().equals(p.getEmail()) == true)
				{
					System.out.println("Pessoa já existente com este e-mail.");
					i = this.proxima;
					contador = 0;
				}
				else {
					contador += 1;
				}
			}
			
			if(contador != 0) {
				this.pessoas[this.proxima] = p;
				this.proxima += 1;
			}			
		}
	}
	
	public void removerPessoa(String email) {
		for(int i = 0; i < this.proxima; i++) {
			if(this.pessoas[i].getEmail().equalsIgnoreCase(email) == true) {
				this.pessoas[i] = this.pessoas[this.proxima - 1];
				this.pessoas[this.proxima - 1] = null;
				this.proxima -= 1;
			}
		}
	}	
	
	public Pessoa buscarPessoaPorEmail(String email) {
		Pessoa p = null;
		for(int i = 0; i < this.proxima; i++) {
			if(this.pessoas[i].getEmail().equalsIgnoreCase(email) == true) {
				p = pessoas[i];
				i = this.proxima;
			}
		}
		return p;
	}
	
	public List<Palestrante> listarPalestrantesPorEmpresa(String empresa) {
		List<Palestrante> lista = new ArrayList<>();
		for(int i = 0; i < this.proxima; i++) {
			if(pessoas[i] instanceof Palestrante 
					&& ((Palestrante)pessoas[i]).getEmpresa().equalsIgnoreCase(empresa) == true) {
				lista.add((Palestrante)pessoas[i]);
			}
		}
		return lista;
	}
	
	public List<Participante> listarParticipantesComInteresseEm(String trilha) {
		List<Participante> lista = new ArrayList<>();
		for(int i = 0; i < this.proxima; i++) {
			if(pessoas[i] instanceof Participante 
					&& ((Participante)pessoas[i]).getTrilhaDeInteresse().equalsIgnoreCase(trilha) == true) {
				lista.add((Participante)pessoas[i]);
			}
		}
		return lista;
	}
	
	public List<Participante> listarParticipantesComIdadeMaiorQue(int idade) {
		List<Participante> lista = new ArrayList<>();
		for(int i = 0; i < this.proxima; i++) {
			if(pessoas[i] instanceof Participante && pessoas[i].getIdade() >= idade) {
				lista.add((Participante)pessoas[i]);
			}
		}
		return lista;
	}
}
