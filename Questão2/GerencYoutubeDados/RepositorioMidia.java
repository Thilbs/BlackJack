package GerencYoutubeDados;

import java.util.ArrayList;
import java.util.List;
import GerencYoutubeNegocio.Midia;

public class RepositorioMidia {
	private Midia[] midias;
	private int proxima;
	
	private static RepositorioMidia instance;

	public static RepositorioMidia getInstance() {
		if(instance == null){
			instance = new RepositorioMidia(100);
		}		
		return instance;
	}
	
	private RepositorioMidia(int tamanho) {
		this.midias = new Midia[tamanho];
		this.proxima = 0;
	}
	
	public void cadastrarMidia(Midia m) {
		if(this.proxima == 0) {
			this.midias[this.proxima] = m;
			this.proxima += 1; 
		}
		else {
			int contador = 0;
			for(int i = 0; i < this.proxima; i++) {
				if(this.midias[i].getArquivo().equals(m.getArquivo()) == true)
				{
					System.out.println("Midia já existente com este nome de arquivo.");
					i = this.proxima;
					contador = 0;
				}
				else {
					contador += 1;
				}
			}
			
			if(contador != 0) {
				this.midias[this.proxima] = m;
				this.proxima += 1;
			}			
		}
	}
	
	public void removerMidia(Midia m) {
		for(int i = 0; i < this.proxima; i++) {
			if(this.midias[i].getArquivo().equals(m.getArquivo()) == true) {
				this.midias[i] = this.midias[this.proxima - 1];
				this.midias[this.proxima - 1] = null;
				this.proxima -= 1;
			}
		}
	}
	
	public List<Midia> listarMidiasPorFaixaEtaria (int faixaEtaria) {
		List<Midia> lista = new ArrayList<>(100);
		for(int i = 0; i < this.proxima; i++) {
			if(midias[i].getFaixaEtariaMinima() <= faixaEtaria) {
				lista.add(midias[i]);
			}
		}		
		return lista;
	}
	
	public List<Midia> listarMidiasPorCategoria (String categoria) {
		List<Midia> lista = new ArrayList<>();
		for(int i = 0; i < this.proxima; i++) {
			if(midias[i].getCategoria().equals(categoria) == true) {
				lista.add(midias[i]);
			}
		}
		return lista;
	}
	
}
