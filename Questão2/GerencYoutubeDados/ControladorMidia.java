package GerencYoutubeDados;

import java.time.LocalDateTime;
import java.util.List;

import GerencYoutubeNegocio.Consumidor;
import GerencYoutubeNegocio.Midia;
import GerencYoutubeNegocio.Produtor;
import GerencYoutubeNegocio.ReproducaoMidia;
import GerencYoutubeNegocio.Usuario;

public class ControladorMidia {
	private RepositorioUsuario usuario;
	private RepositorioMidia midia;
	private RepositorioReproducaoMidia reproducaoMidia;
	
	private static ControladorMidia instance;
	
	private ControladorMidia() {
		usuario = RepositorioUsuario.getInstance();
		midia = RepositorioMidia.getInstance();
		reproducaoMidia = RepositorioReproducaoMidia.getInstance();
	}
	
	public static ControladorMidia getInstance() {
		if(instance == null) {
			instance = new ControladorMidia();
		}
		return instance;
	}
	
	public List<Usuario> listarUsuariosComIdadeAcimaDe(int idade) {
		return usuario.listarUsuariosComIdadeAcimaDe(idade);
	}
	public List<Usuario> listarUsuariosPorTipo(@SuppressWarnings("rawtypes") Class tipo) {
		return usuario.listarUsuariosPorTipo(tipo);
	}
	public List<Midia> listarMidiasPorFaixaEtaria(int faixaEtaria) {
		return midia.listarMidiasPorFaixaEtaria(faixaEtaria);
	}
	public List<Midia> listarMidiasPorCategoria(String categoria) {
		return midia.listarMidiasPorCategoria(categoria);
	}
	public List<ReproducaoMidia> listarReproducoesNoPeriodo(LocalDateTime inicio, LocalDateTime fim) {
		return reproducaoMidia.listarReproducoesNoPeriodo(inicio, fim);
	}
	public List<ReproducaoMidia> listarReproducoesPorUsuario(Consumidor usuario) {
		return reproducaoMidia.listarReproducoesPorUsuario(usuario);
	}
	public List<ReproducaoMidia> listarReproducoesPorCategoria(List<String> categorias) {
		return reproducaoMidia.listarReproducoesPorCategoria(categorias);
	}
	
	public void cadastrarUsuario(Usuario u) {
		if(u != null) {
			if(u instanceof Produtor) {
				if(((Produtor) u).getCategorias() != null 
						&& !((Produtor) u).getCategorias().isEmpty()) {
					usuario.cadastrarUsuario(u);
				}
				else {
					System.out.println("Lista de categorias nula ou vazia.");
				}
			}
			else {
				usuario.cadastrarUsuario(u);
			}
		}
		else {
			System.out.println("Usuario nulo.");
		}
	}
	
	public void removerUsuario(Usuario u) {
		if(u != null) {
			usuario.removerUsuario(u);
		}
		else {
			System.out.println("Usuario nulo.");
		}
	}
	
	public void cadastrarMidia(Midia m) {
		if(m != null) {
			int contador = 0;
			for(int i = 0; i < m.getProdutor().getCategorias().size(); i++) {				
				if(m.getProdutor().getCategorias().get(i).equals(m.getCategoria()) == true) {
					midia.cadastrarMidia(m);
					i = m.getProdutor().getCategorias().size();
					contador = 0;
				}
				else {
					contador += 1;
				}		
			}
			if(contador != 0) {
				System.out.println("Categoria da midia não esta contida na lista de categorias do produtor.");
			}
		}
		else {
			System.out.println("Midia nula.");
		}
	}
	
	public void removerMidia(Midia m) {
		if(m != null) {
			midia.removerMidia(m);
		}
		else {
			System.out.println("Midia nula.");
		}
	}
	
	public void reproduzirMidia(Consumidor consumidor, Midia midia) {
		if(consumidor != null && midia != null) {
			if(consumidor.getIdade() >= midia.getFaixaEtariaMinima()) {
				reproducaoMidia.cadastrarReproducaoMidia(new ReproducaoMidia(midia, consumidor, LocalDateTime.now()));
			}
			else {
				System.out.println("Idade abaixa da faixa etária mínima.");
			}
		}
		else {
			System.out.println("Consumidor ou midia nula.");
		}
	}
}
