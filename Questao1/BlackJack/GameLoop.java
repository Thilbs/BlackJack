package BlackJack;

import java.util.Scanner;

public class GameLoop {
	
	private int numRodada;
	private int qtdBaralhos;
	private int acao;
	private int banca;
	private int bancaTemA;
	private int contador = 0;
	private boolean loop;
	private static GameLoop instance;
	private Jogador player;
	
	private GameLoop(Jogador player)
	{
		this.numRodada = 1;
		this.loop = true;
		this.player = player;
		this.inicio();
	}
	
	public static GameLoop getInstance(Jogador player)
	{
		if(instance == null)
		{
			instance = new GameLoop(player);
		}		
		
		return instance;
	}
		
	public int getNumRodada() {
		return numRodada;
	}

	public void setNumRodada(int numRodada) {
		this.numRodada = numRodada;
	}

	public int getQtdBaralhos() {
		return qtdBaralhos;
	}

	public void setQtdBaralhos(int qtdBaralhos) {
		this.qtdBaralhos = qtdBaralhos;
	}

	public boolean isLoop() {
		return loop;
	}

	public void setLoop(boolean loop) {
		this.loop = loop;
	}
	
	public int getAcao() {
		return acao;
	}

	public void setAcao(int acao) {
		this.acao = acao;
	}

	public int getBanca() {
		return banca;
	}

	public void setBanca(int banca) {
		this.banca = banca;
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}
	
	
	public int getBancaTemA() {
		return bancaTemA;
	}

	public void setBancaTemA(int bancaTemA) {
		this.bancaTemA = bancaTemA;
	}

	@SuppressWarnings("resource")
	private int inicio ()
	{		
		Scanner entrada = new Scanner (System.in);
		System.out.println("Bem-vindo ao Blackjack Rural:\n"
				+ "Legenda dos naipes: P – PAUS / C – COPAS / E – ESPADAS / O - OUROS\n\n"
				+ "Quantos decks de baralho, você deseja utilizar nessa partida (min 2 - max 10):");
		this.setQtdBaralhos(entrada.nextInt());
		
		if (this.getQtdBaralhos() < 2)
		{
			this.setQtdBaralhos(2);
		}			
		else if (this.getQtdBaralhos() > 10)
		{
			this.setQtdBaralhos(10);
		}
		else
		{
			
		}		
		
		return this.getQtdBaralhos();
	}

	public boolean jogo(Baralho baralho, Scanner entrada)
	{
		System.out.println("-----------------------------------------------\n"
				+ "Disputa n." + this.getNumRodada() + "\n"
				+ baralho.QtdCartasRestantes() + " cartas restantes\n"
						+ player.getFichas() + " fichas restantes\n"
								+ "Digite sua aposta (mínimo de 2) ou ‘0’ para sair do jogo:");
		this.setAcao(entrada.nextInt());
		
		if(this.getAcao() != 0)
		{
			if(this.getAcao() < 2)
				player.setAposta(2);
			else if (this.getAcao() > player.getFichas())
				player.setAposta(player.getFichas());
			else
				player.setAposta(this.getAcao());
						
			this.zerarTudo();
			this.printRodada(baralho);
			
			do
			{
				System.out.println("O que você deseja fazer?\n"
						+ "(1) CONTINUAR - para pedir mais cartas ou\n"
						+ "(2) PARAR – para parar e deixar a banca jogar");
				this.setAcao(entrada.nextInt());
				
				if(this.getAcao() == 1)
				{
					this.continuarJogador(acao, entrada, baralho);
					this.setAcao(1); 
				}
				else if(this.getAcao() == 2)
				{
					this.continuarBanca(baralho);
					this.setAcao(2); 
				}
			}while(this.getAcao() != 1 && this.getAcao() != 2);
			
			if(baralho.QtdCartasRestantes() < 15)
			{
				baralho.verificarNumCartas();
				this.setContador(0);
			}
			
		}
		else
		{
			this.setLoop(false);
		}
		
		if(player.getFichas() < 2)
		{
			this.setLoop(false);
		}
		baralho.remover(this.getContador());
		return loop;
	}
	
	private void printRodada(Baralho baralho)
	{
		this.setBanca(baralho.getBaralho().get(this.getContador()).getValor());
		System.out.println("Essas são as cartas da banca\n" + baralho.getBaralho().get(this.getContador()).getCarta());
		
		if (baralho.getBaralho().get(this.getContador()).getValor() == 1 && player.getPontos() < 12)
		{
			this.setBancaTemA(1);
			System.out.println("Total de pontos: " + this.getBanca() + " ou " + (this.getBanca() + 10));
		}
		else 
		{
			System.out.println("Total de pontos: " + this.getBanca());
		}
		this.setContador((this.getContador() + 1));
			
		player.setPontos((baralho.getBaralho().get(this.getContador()).getValor() 
				+ baralho.getBaralho().get((this.getContador() + 1)).getValor()));
		System.out.println ("\n------------x------------\n" + "Essas são suas cartas:"
			+ baralho.getBaralho().get(this.getContador()).getCarta() + " | " 
				+ baralho.getBaralho().get((this.getContador() + 1)).getCarta());
		if((baralho.getBaralho().get(this.getContador()).getValor() == 1 || baralho.getBaralho().get((this.getContador() + 1)).getValor() == 1)
				&& player.getPontos() < 12)
		{
			player.setTemA(1);
			System.out.println("Total de pontos: " + player.getPontos() + " ou " + (player.getPontos() + 10));
		}
		else
		{
			System.out.println("Total de pontos: " + player.getPontos());
		}
		this.setContador((this.getContador() + 2));
		this.setNumRodada((this.getNumRodada() + 1));
	}
	
	private void continuarJogador(int acao, Scanner entrada, Baralho baralho)
	{
			System.out.println ("\n------------x------------\n" + "Essa é sua nova carta:" 
					+ baralho.getBaralho().get(this.getContador()).getCarta());
			player.setPontos((player.getPontos() + baralho.getBaralho().get(this.getContador()).getValor()));
			this.setContador((this.getContador() + 1));
			
			if(player.getTemA() == 1 && player.getPontos() < 12)
			{
				System.out.println("Total de pontos: " + player.getPontos() + " ou " + (player.getPontos() + 10));
			}
			else
			{
				System.out.println("Total de pontos: " + player.getPontos());
			}
			
			if(player.getPontos() > 21)
			{
				this.setAcao(1);
				player.setFichas((player.getFichas() - player.getAposta()));
				System.out.println("Você perdeu esta rodada por estourar os 21 pontos.");
			}
			else
			{
				this.setAcao(0);
			}
			
			
			while(this.getAcao() != 1 && this.getAcao() != 2)
			{
				System.out.println("O que você deseja fazer?\n"
						+ "(1) CONTINUAR - para pedir mais cartas ou\n"
						+ "(2) PARAR – para parar e deixar a banca jogar");
				this.setAcao(entrada.nextInt());
				
				if(this.getAcao() == 1)
				{
					this.continuarJogador(acao, entrada, baralho);
					this.setAcao(1); 
				}
				else if(this.getAcao() == 2)
				{
					if(player.getTemA() == 1 && player.getPontos() < 12)
					{
						player.setPontos((player.getPontos() + 10));
					}
					this.continuarBanca(baralho);
					this.setAcao(2);
				}
			}
	
	}
	
	private void continuarBanca(Baralho baralho)
	{
		System.out.println ("\n------------x------------\n" + "Essa é a nova carta da banca:" 
				+ baralho.getBaralho().get(this.getContador()).getCarta());
		this.setBanca((this.getBanca() + baralho.getBaralho().get(this.getContador()).getValor()));
		this.setContador((this.getContador() + 1));
		
		if(this.getBancaTemA() == 1 && this.getBanca() < 12)
		{
			System.out.println("Total de pontos: " + this.getBanca() + " ou " + (this.getBanca() + 10));
		}
		else
		{
			System.out.println("Total de pontos: " + this.getBanca());
		}
		
		if(this.getBancaTemA() == 1)
		{
			if((this.getBanca() > player.getPontos() || (this.getBanca() + 10) > player.getPontos()) && this.getBanca() < 22)
			{
				player.setFichas((player.getFichas() - player.getAposta()));
				System.out.println("Você perdeu esta rodada por ter menos pontos que a banca.");
			}
			else if(this.getBanca() > 21)
			{
				player.setFichas((player.getFichas() + player.getAposta()));
				System.out.println("Você ganhou esta rodada por ter mais pontos que a banca.");
			}
			else if(this.getBanca() == player.getPontos() || (this.getBanca() + 10) == player.getPontos())
			{
				System.out.println("Empate");
			}
			else if(this.getBanca() == 21 || (this.getBanca() + 10) == 21)
			{
				player.setFichas((player.getFichas() - player.getAposta()));
				System.out.println("Você perdeu esta rodada por ter menos pontos que a banca.");
			}
			else
			{
				this.continuarBanca(baralho);
			}
		}
		else
		{
			if(this.getBanca() > player.getPontos()  && this.getBanca() < 22)
			{
				player.setFichas((player.getFichas() - player.getAposta()));
				System.out.println("Você perdeu esta rodada por ter menos pontos que a banca.");
			}
			else if(this.getBanca() > 21)
			{
				player.setFichas((player.getFichas() + player.getAposta()));
				System.out.println("Você ganhou esta rodada por ter mais pontos que a banca.");
			}
			else if(this.getBanca() == player.getPontos())
			{
				System.out.println("Empate");
			}
			else if(this.getBanca() == 21)
			{
				player.setFichas((player.getFichas() - player.getAposta()));
				System.out.println("Você perdeu esta rodada por ter menos pontos que a banca.");
			}
			else
			{
				this.continuarBanca(baralho);
			}
		}
		
	}
	
	private void zerarTudo ()
	{
		this.setContador(0);
		player.setPontos(0);
		player.setTemA(0);
		this.setBanca(0);
		this.setBancaTemA(0);
	}
	
}
