package GerencYoutubeDados;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import GerencYoutubeNegocio.Consumidor;
import GerencYoutubeNegocio.ReproducaoMidia;;

public class RepositorioReproducaoMidia {
	private ReproducaoMidia[] reproducaoMidias;
	private int proxima;
	
	private static RepositorioReproducaoMidia instance;

	public static RepositorioReproducaoMidia getInstance() {
		if(instance == null){
			instance = new RepositorioReproducaoMidia(100);
		}		
		return instance;
	}
	
	private RepositorioReproducaoMidia(int tamanho) {
		this.reproducaoMidias = new ReproducaoMidia[tamanho];
		this.proxima = 0;
	}
	
	public void cadastrarReproducaoMidia(ReproducaoMidia rm) {
			this.reproducaoMidias[this.proxima] = rm;
			this.proxima += 1;
	}
	
	public List<ReproducaoMidia> listarReproducoesNoPeriodo (LocalDateTime inicio, LocalDateTime fim) {
		List<ReproducaoMidia> lista = new ArrayList<>();
		for(int i = 0; i < this.proxima; i++) {
			if(reproducaoMidias[i].getDataHoraReproducao().isAfter(inicio) 
					&& reproducaoMidias[i].getDataHoraReproducao().isBefore(fim)) {
				lista.add(reproducaoMidias[i]);
			}
		}
		return lista;
	}
	
	public List<ReproducaoMidia> listarReproducoesPorUsuario (Consumidor usuario) {
		List<ReproducaoMidia> lista = new ArrayList<>();
		for(int i = 0; i < this.proxima; i++) {
			if(reproducaoMidias[i].getConsumidor().equals(usuario) == true) {
				lista.add(reproducaoMidias[i]);
			}
		}
		return lista;
	}
	
	public List<ReproducaoMidia> listarReproducoesPorCategoria (List<String> categorias) {
		List<ReproducaoMidia> lista = new ArrayList<>();
		for(int i = 0; i < this.proxima; i++) {
			for(int j = 0; j < categorias.size(); j++) {
				if(reproducaoMidias[i].getMidia().getCategoria().equals(categorias.get(j))) {
					lista.add(reproducaoMidias[i]);
				}
			}
		}
		return lista;
	}
}
