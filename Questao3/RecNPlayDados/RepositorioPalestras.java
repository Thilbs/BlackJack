package RecNPlayDados;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import RecNPlayNegocio.Avaliacao;
import RecNPlayNegocio.Palestra;

public class RepositorioPalestras {
	private Palestra[] palestras;
	private int proxima;
	
	private static RepositorioPalestras instance;
	
	public static RepositorioPalestras getInstance() {
		if(instance == null){
			instance = new RepositorioPalestras(100);
		}		
		return instance;
	}
	
	private RepositorioPalestras(int tamanho) {
		this.palestras = new Palestra[tamanho];
		this.proxima = 0;
	}
	
	public void inserirPalestra(Palestra p) {
		if(this.proxima == 0) {
			this.palestras[this.proxima] = p;
			this.proxima += 1; 
		}
		else {
			int contador = 0;
			for(int i = 0; i < this.proxima; i++) {
				if(this.palestras[i].getId().equals(p.getId()) == true)
				{
					System.out.println("Palestra já existente com este id.");
					i = this.proxima;
					contador = 0;
				}
				else {
					contador += 1;
				}
			}
			
			if(contador != 0) {
				this.palestras[this.proxima] = p;
				this.proxima += 1;
			}			
		}
	}
	
	public Palestra buscarPalestraPorId(int id) {
		Palestra p = null;
		for(int i = 0; i < this.proxima; i++) {
			if(this.palestras[i].getId() == id) {
				p = palestras[i];
				i = this.proxima;
			}
		}
		return p;
	}
	
	public Palestra buscarPalestrasPorLocalEHorario(String local, LocalDateTime horario) {
		Palestra p = null;
		for(int i = 0; i < this.proxima; i++) {
			if(this.palestras[i].getLocal().equalsIgnoreCase(local) == true
					&& this.palestras[i].getDataHora().isEqual(horario) == true) {
				p = palestras[i];
				i = this.proxima;
			}
		}
		return p;
	}
	
	public List<Palestra> listarPalestras() {
		List<Palestra> lista = new ArrayList<>();
		for(int i = 0; i < this.proxima; i++) {
			if(this.palestras[i] != null) {
				lista.add(palestras[i]);
			}
		}
		return lista;
	}
	
	public List<Palestra> listarPalestrasComMediaAvaliacaoIgualOuMaiorQue(int nota) {
		List<Palestra> lista = new ArrayList<>();
		for(int i = 0; i < this.proxima; i++) {
			if(this.palestras[i].getMediaAvaliacao() >= nota) {
				lista.add(palestras[i]);
			}
		}		
		return lista;
	}
	
	public List<Avaliacao> listarTodasAvaliacoes() {
		List<Avaliacao> lista = new ArrayList<>();
		for(int i = 0; i < this.proxima; i++) {
			for(int j = 0; j < this.palestras[i].getAvaliacoes().size(); j++) {
				lista.add(palestras[i].getAvaliacoes().get(j));
			}
		}
		return lista;
	}
}
