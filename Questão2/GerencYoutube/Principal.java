package GerencYoutube;

import java.util.List;

import GerencYoutubeDados.RepositorioMidia;
import GerencYoutubeDados.RepositorioReproducaoMidia;
import GerencYoutubeDados.RepositorioUsuario;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import GerencYoutubeNegocio.Produtor;
import GerencYoutubeNegocio.ReproducaoMidia;
import GerencYoutubeNegocio.Usuario;
import GerencYoutubeGUI.TelaTextual;
import GerencYoutubeNegocio.Consumidor;
import GerencYoutubeNegocio.Midia;;

public class Principal {
	public static void main(String[] args) {
		TelaTextual tt = new TelaTextual();
        tt.executarOperacoes();
	}
}
