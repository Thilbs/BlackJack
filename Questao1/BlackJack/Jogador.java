package BlackJack;

public class Jogador {
	private int fichas;
	private int aposta;
	private int pontos;
	private int[] vetor;
	private int temA;
	
	public Jogador()
	{
		this.fichas = 100;
	}

	public int getFichas() {
		return fichas;
	}

	public void setFichas(int fichas) {
		this.fichas = fichas;
	}

	public int getAposta() {
		return aposta;
	}

	public void setAposta(int aposta) {
		this.aposta = aposta;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public int getTemA() {
		return temA;
	}

	public void setTemA(int temA) {
		this.temA = temA;
	}

	public int[] getVetor() {
		return vetor;
	}

	public void setVetor(int[] vetor) {
		this.vetor = vetor;
	}
	
}
