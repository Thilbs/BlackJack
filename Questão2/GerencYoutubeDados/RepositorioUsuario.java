package GerencYoutubeDados;

import GerencYoutubeNegocio.Produtor;

import java.util.ArrayList;
import java.util.List;

import GerencYoutubeNegocio.Consumidor;
import GerencYoutubeNegocio.Produtor;
import GerencYoutubeNegocio.Usuario;

public class RepositorioUsuario {
	private Usuario[] usuarios;
	private int proxima;
	
	private static RepositorioUsuario instance;

	public static RepositorioUsuario getInstance() {
		if(instance == null)
		{
			instance = new RepositorioUsuario(100);
		}		
		return instance;
	}
	
	private RepositorioUsuario(int tamanho) {
		this.usuarios = new Usuario[tamanho];
		this.proxima = 0;
	}
	
	public void cadastrarUsuario(Usuario u) {
		if(this.proxima == 0) {
			this.usuarios[this.proxima] = u;
			this.proxima += 1; 
		}
		else {
			int contador = 0;
			for(int i = 0; i < this.proxima; i++) {
				if(this.usuarios[i].getEmail().equals(u.getEmail()) == true)
				{
					System.out.println("Usuario já existente com este e-mail.");
					i = this.proxima;
					contador = 0;
				}
				else {
					contador += 1;
				}
			}
			
			if(contador != 0) {
				this.usuarios[this.proxima] = u;
				this.proxima += 1;
			}			
		}
	}
	
	public void removerUsuario(Usuario u) {
		for(int i = 0; i < this.proxima; i++) {
			if(this.usuarios[i].getEmail().equals(u.getEmail()) == true) {
				this.usuarios[i] = this.usuarios[this.proxima - 1];
				this.usuarios[this.proxima - 1] = null;
				this.proxima -= 1;
			}
		}
	}
	
	public List<Usuario> listarUsuariosComIdadeAcimaDe (int idade) {
		List<Usuario> lista = new ArrayList<>();
		for(int i = 0; i < this.proxima; i++) {
			if(usuarios[i].getIdade() >= idade) {
				lista.add(usuarios[i]);
			}
		}
		return lista;
	}
	
	public List<Usuario> listarUsuariosPorTipo (Class tipo) {
		List<Usuario> lista = new ArrayList<>();
		for(int i = 0; i < this.proxima; i++) {
			if(usuarios[i] instanceof Produtor && tipo == Produtor.class) {
				lista.add(usuarios[i]);
			}
			if(usuarios[i] instanceof Consumidor && tipo == Consumidor.class) {
				lista.add(usuarios[i]);
			}
		}
		return lista;
	}
}
