package GerencYoutubeGUI;


import java.util.List;

import GerencYoutubeDados.ControladorMidia;
import GerencYoutubeDados.RepositorioMidia;
import GerencYoutubeDados.RepositorioReproducaoMidia;
import GerencYoutubeDados.RepositorioUsuario;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import GerencYoutubeNegocio.Produtor;
import GerencYoutubeNegocio.ReproducaoMidia;
import GerencYoutubeNegocio.Usuario;
import GerencYoutubeNegocio.Consumidor;
import GerencYoutubeNegocio.Midia;

public class TelaTextual {
	public void executarOperacoes() {
		List<String> cat1 = new ArrayList<>();
		List<String> cat2 = new ArrayList<>();
		List<String> cat3 = new ArrayList<>();
		
		cat1.add("Jogos");
		cat2.add("Educacao");
		cat3.add("Variados");
		
		ControladorMidia controlador = ControladorMidia.getInstance();
		
		Produtor p1 = new Produtor("jose@gmail.com", "Jose", LocalDate.of(2000, 5, 10), "Josezinho", cat1);
		Produtor p2 = new Produtor("diego@gmail.com", "Diego", LocalDate.of(2010, 7, 15), "Dieguinho", cat2);
		Produtor p3 = new Produtor("maria@gmail.com", "Maria", LocalDate.of(1980, 11, 25), "Mariazinha", cat3);
		
		controlador.cadastrarUsuario(p1);
		controlador.cadastrarUsuario(p2);
		controlador.cadastrarUsuario(p3);
		
		Consumidor c1 = new Consumidor("jaozin@gmail.com", "Joao", LocalDate.of(2009, 9, 15), cat1);
		Consumidor c2 = new Consumidor("pedro@gmail.com", "Pedro", LocalDate.of(1999, 7, 1), cat2);
		Consumidor c3 = new Consumidor("thiaguinho@gmail.com", "Thiago", LocalDate.of(2004, 11, 21), cat3);
		Consumidor c4 = new Consumidor("ana@gmail.com", "Ana", LocalDate.of(2008, 5, 17), cat1);
		Consumidor c5 = new Consumidor("joaninha@gmail.com", "Joana", LocalDate.of(2000, 6, 12), cat2);
		Consumidor c6 = new Consumidor("laura@gmail.com", "Laura", LocalDate.of(1980, 4, 30), cat3);
		Consumidor c7 = new Consumidor("ignacio@gmail.com", "Ignácio", LocalDate.of(1960, 3, 5), cat1);
		
		controlador.cadastrarUsuario(c1);
		controlador.cadastrarUsuario(c2);
		controlador.cadastrarUsuario(c3);
		controlador.cadastrarUsuario(c4);
		controlador.cadastrarUsuario(c5);
		controlador.cadastrarUsuario(c6);
		controlador.cadastrarUsuario(c7);
		
		controlador.removerUsuario(c7);
		
		System.out.println(controlador.listarUsuariosComIdadeAcimaDe(16).toString());
		System.out.println(controlador.listarUsuariosPorTipo(Consumidor.class).toString());
		
		Midia m1 = new Midia(LocalDateTime.of(2010, 12, 11, 12, 00), "O que fazer em java?", 18, "Variados", (Produtor)p3);
		Midia m2 = new Midia(LocalDateTime.of(2016, 11, 12, 07, 00), "Fortnite", 8, "Jogos", (Produtor)p1);
		Midia m3 = new Midia(LocalDateTime.of(2014, 07, 06, 04, 00), "LOL", 9, "Jogos", (Produtor)p1);
		Midia m4 = new Midia(LocalDateTime.of(2019, 05, 01, 22, 00), "Aula de ip2", 14, "Educacao", (Produtor)p2);
		Midia m5 = new Midia(LocalDateTime.of(2018, 04, 20, 21, 00), "Aula de cálculo", 10, "Educacao", (Produtor)p2);
		Midia m6 = new Midia(LocalDateTime.of(2010, 10, 21, 14, 00), "CSGO", 14, "Jogos", (Produtor)p1);
		Midia m7 = new Midia(LocalDateTime.of(2015, 11, 15, 17, 00), "GTA 5", 18, "Jogos", (Produtor)p1);
		Midia m8 = new Midia(LocalDateTime.of(2008, 11, 10, 13, 00), "Dia de hoje", 18, "Variados", (Produtor)p3);
		
		controlador.cadastrarMidia(m1);
		controlador.cadastrarMidia(m2);
		controlador.cadastrarMidia(m3);
		controlador.cadastrarMidia(m4);
		controlador.cadastrarMidia(m5);
		controlador.cadastrarMidia(m6);
		controlador.cadastrarMidia(m7);
		controlador.cadastrarMidia(m8);
		
		controlador.removerMidia(m8);
		
		System.out.println(controlador.listarMidiasPorFaixaEtaria(14).toString());
		System.out.println(controlador.listarMidiasPorCategoria("Jogos").toString());
		
		controlador.reproduzirMidia(c1, m1);
		controlador.reproduzirMidia(c1, m2);
		controlador.reproduzirMidia(c1, m3);
		controlador.reproduzirMidia(c2, m1);
		controlador.reproduzirMidia(c2, m5);
		controlador.reproduzirMidia(c2, m6);
		controlador.reproduzirMidia(c3, m2);
		controlador.reproduzirMidia(c3, m3);
		controlador.reproduzirMidia(c3, m4);
		controlador.reproduzirMidia(c4, m2);
		controlador.reproduzirMidia(c4, m3);
		controlador.reproduzirMidia(c4, m5);
		controlador.reproduzirMidia(c5, m1);
		controlador.reproduzirMidia(c5, m4);
		controlador.reproduzirMidia(c5, m5);
		controlador.reproduzirMidia(c5, m7);
		controlador.reproduzirMidia(c6, m3);
		controlador.reproduzirMidia(c6, m4);
		controlador.reproduzirMidia(c6, m6);
		controlador.reproduzirMidia(c6, m7);
		
		System.out.println(controlador.listarReproducoesPorUsuario(c1).toString());
		
		LocalDateTime inicio = LocalDateTime.of(2018, 10, 15, 12, 00);
		LocalDateTime fim = LocalDateTime.of(2020, 10, 15, 12, 00);
		System.out.println(controlador.listarReproducoesNoPeriodo(inicio, fim).toString());
		
		System.out.println(controlador.listarReproducoesPorCategoria(cat2));
		
	}
}