package RecNPlayGUI;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import RecNPlayDados.ControladorRECnPlay;
import RecNPlayDados.RepositorioPalestras;
import RecNPlayDados.RepositorioPessoas;
import RecNPlayNegocio.Avaliacao;
import RecNPlayNegocio.Palestra;
import RecNPlayNegocio.Palestrante;
import RecNPlayNegocio.Participante;

public class TelaTextual {
	public void executarOperacoes() {
		ControladorRECnPlay c = ControladorRECnPlay.getInstance();
		
		List<Avaliacao> avaldefault = new ArrayList<>();
		List<Avaliacao> aval1 = new ArrayList<>();
		List<Avaliacao> aval2 = new ArrayList<>();
		List<Avaliacao> aval3 = new ArrayList<>();
		List<Avaliacao> aval4 = new ArrayList<>();
		List<Avaliacao> aval5 = new ArrayList<>();		
		
		Palestrante pal1 = new Palestrante(((long)101), "gustavo.franco@gmail.com", "GUSTAVO FRANCO", "Recife", LocalDate.of(1980, 10, 15), "Empresa X");
		Palestrante pal2 = new Palestrante(((long)102), "Simone.Zelaquett@gmail.com", "Simone Zelaquett", "Recife", LocalDate.of(1995, 12, 10), "Accenture");
		Palestrante pal3 = new Palestrante(((long)103), "Andrea.Pinho@gmail.com", "Andrea Pinho", "Recife", LocalDate.of(1999, 8, 22), "Prefeitura do Recife");
		Palestrante pal4 = new Palestrante(((long)104), "Mariana.Moura@gmail.com", "Mariana Moura", "Recife", LocalDate.of(1990, 5, 25), "Grupo Moura");
		Palestrante pal5 = new Palestrante(((long)105), "SILVIO.MEIRA@gmail.com", "SILVIO MEIRA", "Recife", LocalDate.of(2000, 1, 11), "UFPE");
				
		Palestra p1 = new Palestra((long)1001,"A inovação financeira e o sistema financeiro do futuro", pal1,"Palestra sobre como as inovações tecnológicas financeiras podem influenciar o sistema financeiro", avaldefault, LocalDateTime.of(2019, 2, 10, 10, 00), "Teatro Apolo", "Tecnologia");
		Palestra p2 = new Palestra((long)1002,"Apresentação do Humanóide NAO", pal2,"Nessa atividade os participantes assistirão a performance do NAO- humanóide programado por estudantes da rede municipal do Recife, am\r\n" + 
				"apresentações de Yoga e Dança que serão contagiantes e motivarão a interação dos presentes.", avaldefault, LocalDateTime.of(2019, 2, 10, 11, 15), "Accenture Innovation Center", "Tecnologia");
		Palestra p3 = new Palestra((long)1003,"Imprensa Mirim", pal3,"Durante o evento os palestrantes serão entrevistados como pauta da Cobertura jornalística das ações do Rec'n'Play , realizadas por\r\n" + 
				"estudantes da Prefeitura de Recife. Muitos participantes poderão compor com os palestrantes as entrevistas prestando depoimentos sobre o\r\n" + 
				"evento e suas impressões e novas aprendizagens.", avaldefault, LocalDateTime.of(2019, 2, 10, 11, 00), "Teatro Apolo", "Economia_criativa");
		Palestra p4 = new Palestra((long)1004,"Educação experimental para famílias empresárias", pal4,"Uma conversa com os sócios e membros da Escola F para debater um novo modelo educacional voltado para famílias empresárias. Um modelo de\r\n" + 
				"negócio colaborativo que valoriza a aprendizagem a partir da troca de experiências, investe na facilitação de grupos para gerar conhecimento e\r\n" + 
				"desenvolvimento, por meio da construção de entendimentos e não apenas a partir de conteúdos externos.", avaldefault, LocalDateTime.of(2019, 4, 10, 10, 00), "CESAR Bom Jesus - Sala Garagem (5° andar)", "Cidades");
		Palestra p5 = new Palestra((long)1005,"Como você e a sua empresa irão sobreviver ao apocalipse digital?", pal5,"Talk Show com o renomado líder do setor de inovação que conversá sobre o tema de transformação digital.", avaldefault, LocalDateTime.of(2019, 5, 10, 10, 00), "Cais do Sertão - Auditório", "Cidades");
				
		c.cadastrarPalestra(p1);
		c.cadastrarPalestra(p2);
		c.cadastrarPalestra(p3);
		c.cadastrarPalestra(p4);
		c.cadastrarPalestra(p5);
		
		Participante par1 = new Participante(((long)2001), "Jose@gmail.com", "Jose", "Recife", LocalDate.of(2008, 10, 10), "Tecnologia");
		Participante par2 = new Participante(((long)2002), "pedro@gmail.com", "Pedro", "Recife", LocalDate.of(1970, 9, 11), "Cidades");
		Participante par3 = new Participante(((long)2003), "Maria@gmail.com", "Maria", "Recife", LocalDate.of(2002, 7, 15), "Economia_criativa");
		Participante par4 = new Participante(((long)2004), "Joao@gmail.com", "Joao", "Recife", LocalDate.of(1964, 5, 20), "Tecnologia");
		Participante par5 = new Participante(((long)2005), "Thiago@gmail.com", "Thiago", "Recife", LocalDate.of(1999, 12, 22), "Cidades");
		Participante par6 = new Participante(((long)2006), "Fernanda@gmail.com", "Fernanda", "Recife", LocalDate.of(1962, 1, 25), "Economia_criativa");
		Participante par7 = new Participante(((long)2007), "Jessica@gmail.com", "Jessica", "Recife", LocalDate.of(2005, 11, 29), "Tecnologia");
		Participante par8 = new Participante(((long)2008), "Andre@gmail.com", "Andre", "Recife", LocalDate.of(1950, 8, 1), "Tecnologia");
		
		c.realizarInscricao(par1);
		c.realizarInscricao(par2);
		c.realizarInscricao(par3);
		c.realizarInscricao(par4);
		c.realizarInscricao(par5);
		c.realizarInscricao(par6);
		c.realizarInscricao(par7);
		c.realizarInscricao(par8);
		
		System.out.println(c.listarParticipantesComIdadeMaiorQue(39).toString());
		
		
		aval1.add(new Avaliacao(p1, 5, "Bom", par1));
		aval1.add(new Avaliacao(p1, 3, "ok", par2));
		aval1.add(new Avaliacao(p1, 4, "Bom", par3));
		aval2.add(new Avaliacao(p2, 3, "descente", par2));
		aval2.add(new Avaliacao(p2, 3, "regular", par4));
		aval2.add(new Avaliacao(p2, 4, "Bom", par5));
		aval3.add(new Avaliacao(p3, 5, "otimo", par8));
		aval3.add(new Avaliacao(p3, 4, "show", par6));
		aval3.add(new Avaliacao(p3, 4, "boa", par4));
		aval4.add(new Avaliacao(p4, 1, "ruim", par1));
		aval4.add(new Avaliacao(p4, 2, "chata", par4));
		aval4.add(new Avaliacao(p4, 4, "interessante", par5));
		aval5.add(new Avaliacao(p5, 5, "Bom", par2));
		aval5.add(new Avaliacao(p5, 3, "legal", par6));
		aval5.add(new Avaliacao(p5, 0, "horrivel", par7));
				
		p1.setAvaliacoes(aval1);
		p2.setAvaliacoes(aval2);
		p3.setAvaliacoes(aval3);
		p4.setAvaliacoes(aval4);
		p5.setAvaliacoes(aval5);
		
		System.out.println(c.listarTotalPalestrasComMediaAvaliacaoMaiorQue(3));
		System.out.println(c.listarPalestrasMaisBemAvaliadas().toString());
		
		/*Participante pe1 = new Participante(((long)12345), "joao@gmail.com", "Joao", "Recife", LocalDate.of(2000, 11, 10), "Tecnologia");
		Palestrante pa1 = new Palestrante(((long)12345), "joaoo@gmail.com", "GUSTAVO FRANCO", "Recife", LocalDate.of(2000, 11, 10), "Empresa");
		Palestrante pa2 = new Palestrante(((long)12345), "joaooo@gmail.com", "Joaozin", "Recife", LocalDate.of(2000, 11, 10), "Empresa");
		Palestra p1 = new Palestra((long)12345,"Titulo", pa1,"descricao", lista, LocalDateTime.now(), "Recife", "Trilha");
		Palestra p2 = new Palestra((long)123456,"Tituloa", pa2,"descricao", lista, LocalDateTime.of(2019, 10, 10, 15, 10), "Recife", "Trilha");*/
		
		/*c.realizarInscricao(pe1);
		c.cadastrarPalestra(p1);
		c.cadastrarPalestra(p2);
		*/
		
		
		/*List<Avaliacao> lista = new ArrayList<>();
		List<Avaliacao> lista2 = new ArrayList<>();
		
		RepositorioPalestras p = RepositorioPalestras.getInstance();
		
		Participante pe1 = new Participante(((long)12345), "joao@gmail.com", "Joao", "Recife", LocalDate.of(2000, 11, 10), "Empresa");
		Palestrante pa1 = new Palestrante(((long)12345), "joao@gmail.com", "Joao", "Recife", LocalDate.of(2000, 11, 10), "Empresa");
		
		Palestra p1 = new Palestra((long)12345,"Titulo", pa1,"descricao", lista, LocalDateTime.now(), "Recife", "Trilha");
		Palestra p2 = new Palestra((long)1234,"Titulo", pa1,"descricao", lista2, LocalDateTime.now(), "Recife", "Trilha");
		
		Avaliacao a1 = new Avaliacao(p1, 2, "comentario", pe1);
		Avaliacao a2 = new Avaliacao(p1, 10, "comentario", pe1);
		
		lista.add(a1);
		lista.add(a2);
		lista2.add(a2);
		
		p1.setAvaliacoes(lista);
		p2.setAvaliacoes(lista2);
		p.inserirPalestra(p1);
		p.inserirPalestra(p2);
		
		System.out.println(p.listarPalestrasComMediaAvaliacaoIgualOuMaiorQue(6).toString());
		
		Participante p1 = new Participante(((long)12345), "joao@gmail.com", "Joao", "Recife", LocalDate.of(2000, 11, 10), "Empresa");
		Participante p2 = new Participante(((long)12345), "joaoo@gmail.com", "Joao", "Recife", LocalDate.of(2000, 11, 10), "Empresa");
				
		p.inserirPessoa(p1);
		p.inserirPessoa(p2);
		
		System.out.println(p.listarParticipantesComIdadeMaiorQue(18).toString());*/
		
	}
}
