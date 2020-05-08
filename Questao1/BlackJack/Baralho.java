package BlackJack;

import java.util.ArrayList;
import java.util.Collections;

public class Baralho {
	private ArrayList <Carta> baralho;
	private int qtdBaralhos;
	private static Baralho instance;
	private int cartasRestantes;
	
	private Baralho(int num) {
		super();
		this.baralho = new ArrayList <>(52*num);
		this.qtdBaralhos = num;
		this.baralho = criar(baralho);
	}
	
	public static Baralho getInstance(int num) {
	      if (instance == null) {
	        instance = new Baralho(num);
	      }
	      return instance;
	    }
	
	private ArrayList <Carta> criar(ArrayList <Carta> baralho)
	{
		for(int i = 1; i <= this.qtdBaralhos * 4; i++)
		{			
			for (int j = 1; j <= 13; j++)
			{
				if(i % 4 == 1)
				{
					if(j == 1)
					{
						
						baralho.add(new Carta("A-P", j));						
					}
					else if(j == 11)
					{
						baralho.add(new Carta("J-P", 10));
					}
					else if(j == 12)
					{
						baralho.add(new Carta("Q-P", 10));
					}
					else if(j == 13)
					{
						baralho.add(new Carta("K-P", 10));
					}
					else
					{
						baralho.add(new Carta(j + "-P", j));
					}
				}
				else if (i % 4 == 2)
				{
					if(j == 1)
					{
						baralho.add(new Carta("A-O", j));
					}
					else if(j == 11)
					{
						baralho.add(new Carta("J-O", 10));
					}
					else if(j == 12)
					{
						baralho.add(new Carta("Q-O", 10));
					}
					else if(j == 13)
					{
						baralho.add(new Carta("K-O", 10));
					}
					else
					{
						baralho.add(new Carta(j + "-O", j));
					}
				}
				else if (i % 4 == 3)
				{
					if(j == 1)
					{
						baralho.add(new Carta("A-C", j));
					}
					else if(j == 11)
					{
						baralho.add(new Carta("J-C", 10));
					}
					else if(j == 12)
					{
						baralho.add(new Carta("Q-C", 10));
					}
					else if(j == 13)
					{
						baralho.add(new Carta("K-C", 10));
					}
					else
					{
						baralho.add(new Carta(j + "-C", j));
					}
				}
				else
				{
					if(j == 1)
					{
						baralho.add(new Carta("A-E", j));
					}
					else if(j == 11)
					{
						baralho.add(new Carta("J-E", 10));
					}
					else if(j == 12)
					{
						baralho.add(new Carta("Q-E", 10));
					}
					else if(j == 13)
					{
						baralho.add(new Carta("K-E", 10));
					}
					else
					{
						baralho.add(new Carta(j + "-E", j));
					}
				}	
			}	
		}
		this.embaralhar();
		return baralho;
	}

	public ArrayList<Carta> getBaralho() {
		return baralho;
	}

	public void setBaralho(ArrayList<Carta> baralho) {
		this.baralho = baralho;
	}
	
	
	
	public int getQtdBaralhos() {
		return qtdBaralhos;
	}

	public void setQtdBaralhos(int qtdBaralhos) {
		this.qtdBaralhos = qtdBaralhos;
	}

	public int getCartasRestantes() {
		return cartasRestantes;
	}

	public void setCartasRestantes(int cartasRestantes) {
		this.cartasRestantes = cartasRestantes;
	}

	public int QtdCartasRestantes ()
	{
		this.setCartasRestantes(0);
		for(int i = 0; i < this.baralho.size(); i++)
		{
				this.setCartasRestantes((getCartasRestantes() + 1));			
		}
		return this.getCartasRestantes();
	}
	
	public ArrayList<Carta> embaralhar()
	{
		Collections.shuffle(this.baralho);
		return baralho;
	}
	
	public ArrayList<Carta> remover(int contador)
	{
		for (int i = 0; i < contador ; i++)
		{
			baralho.remove(0);
		}
		return baralho;
	}
	
	public ArrayList<Carta> verificarNumCartas()
	{
		if(this.QtdCartasRestantes() < 15)
		{
			this.remover(this.getCartasRestantes());
			this.criar(baralho);			
		}
		
		return baralho;
	}
}
