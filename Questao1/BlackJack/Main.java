package BlackJack;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner (System.in);
		
		Jogador p1 = new Jogador();
		GameLoop game = GameLoop.getInstance(p1);
		Baralho baralho = Baralho.getInstance(game.getQtdBaralhos());
		
		while(game.isLoop())
		{
			game.jogo(baralho, entrada);
		}
					
		System.out.println("Você encerrou seu jogo com: " + p1.getFichas() + " fichas em "
				+ (game.getNumRodada() - 1) + " rodadas.");
	}
}
