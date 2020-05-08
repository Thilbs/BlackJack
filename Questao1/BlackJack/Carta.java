package BlackJack;

public class Carta {
	private String carta;
	private int valor;
	
	public Carta(String carta, int valor) {
		super();
		this.carta = carta;
		this.valor = valor;
	}

	public String getCarta() {
		return carta;
	}

	public void setCarta(String carta) {
		this.carta = carta;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	
	
}
