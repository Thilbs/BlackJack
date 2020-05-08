package RecNPlayDados;

import java.util.ArrayList;
import java.util.List;

import GerencYoutubeNegocio.Produtor;
import RecNPlayNegocio.Avaliacao;
import RecNPlayNegocio.Palestra;
import RecNPlayNegocio.Palestrante;
import RecNPlayNegocio.Participante;

public class ControladorRECnPlay {
	private RepositorioPessoas pessoa;
	private RepositorioPalestras palestra;
	
	private static ControladorRECnPlay instance;
	
	private ControladorRECnPlay() {
		this.pessoa = RepositorioPessoas.getInstance();
		this.palestra = RepositorioPalestras.getInstance();
	}
	
	public static ControladorRECnPlay getInstance() {
		if(instance == null) {
			instance = new ControladorRECnPlay();
		}
		return instance;
	}

	public List<Palestrante> listarPalestrantesPorEmpresa(String empresa) {
		return pessoa.listarPalestrantesPorEmpresa(empresa);
	}

	public List<Participante> listarParticipantesComInteresseEm(String trilha) {
		return pessoa.listarParticipantesComInteresseEm(trilha);
	}

	public List<Participante> listarParticipantesComIdadeMaiorQue(int idade) {
		return pessoa.listarParticipantesComIdadeMaiorQue(idade);
	}

	public List<Palestra> listarPalestras() {
		return palestra.listarPalestras();
	}

	public List<Palestra> listarPalestrasComMediaAvaliacaoIgualOuMaiorQue(int nota) {
		return palestra.listarPalestrasComMediaAvaliacaoIgualOuMaiorQue(nota);
	}

	public List<Avaliacao> listarTodasAvaliacoes() {
		return palestra.listarTodasAvaliacoes();
	}
	
	public void realizarInscricao(Participante p) {
		if(p != null) {
			if(p.getTrilhaDeInteresse() != null && !p.getTrilhaDeInteresse().isEmpty())	{
				if(p.getTrilhaDeInteresse().equalsIgnoreCase("Tecnologia") == true 
						|| p.getTrilhaDeInteresse().equalsIgnoreCase("Economia_criativa") == true
						|| p.getTrilhaDeInteresse().equalsIgnoreCase("Cidades") == true) {
					pessoa.inserirPessoa(p);
				}
				else {
					System.out.println("Trilha inválida.");
				}
			}
			else {
				System.out.println("Trilha nula ou vazia.");
			}
		}
		else {
			System.out.println("Participante nulo");
		}
	}
	
	public void cadastrarPalestra(Palestra p) {
		if(p != null && p.getPalestrante() != null && p.getAvaliacoes() != null && p.getPalestrante().getEmpresa() != null) {
			if(palestra.listarPalestras().isEmpty() == false) {
				int contador = 0;
				for(int i = 0; i < palestra.listarPalestras().size(); i++) {
					if(palestra.listarPalestras().get(i).getLocal().equalsIgnoreCase(p.getLocal()) == true
							&& palestra.listarPalestras().get(i).getDataHora().isEqual(p.getDataHora()) == true) {
						System.out.println("Local já reservado neste horário.");
						contador++;
					}
					if(palestra.listarPalestras().get(i).getTitulo().equalsIgnoreCase(p.getTitulo()) == true) {
						System.out.println("Palestra já existente com este título.");
						contador++;
						i = palestra.listarPalestras().size();
					}					
				}
			if(contador == 0) {
				pessoa.inserirPessoa(p.getPalestrante());
				palestra.inserirPalestra(p);
			}
			
			}
			else {
				pessoa.inserirPessoa(p.getPalestrante());
				palestra.inserirPalestra(p);
			}
		}
		else {
			System.out.println("Palestra nula ou algum atributo da palestra é nulo.");
		}
	}
	
	public void avaliarPalestra(Avaliacao aval) {
		if(aval != null && aval.getNota() >= 0 && aval.getNota() <= 5) {
			for(int i = 0; i < palestra.listarPalestras().size(); i++) {
				if(palestra.listarPalestras().get(i).equals(aval.getPalestra()) == true) {
					System.out.println("Palestra válida.");					
				}
			}
		}
		else {
			System.out.println("Avaliação nula ou nota inválida.");
		}
		
	}
	
	public List<Palestra> listarPalestrasMaisBemAvaliadas() {
		List<Palestra> lista = new ArrayList<>();
		lista = palestra.listarPalestrasComMediaAvaliacaoIgualOuMaiorQue(3);
		return lista;
	}
	
	public int listarTotalPalestrasComMediaAvaliacaoMaiorQue(int nota) {
		int total = 0;
		for(int i = 0; i < palestra.listarPalestrasComMediaAvaliacaoIgualOuMaiorQue(nota).size(); i++) {
			total++;
		}
		return total;
	}
	
}
