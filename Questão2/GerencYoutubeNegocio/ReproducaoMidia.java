package GerencYoutubeNegocio;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReproducaoMidia {
	private Midia midia;
	private Consumidor consumidor;
	private LocalDateTime dataHoraReproducao;
	
	
	public ReproducaoMidia(Midia midia, Consumidor consumidor, LocalDateTime dataHoraReproducao) {
		super();
		this.midia = midia;
		this.consumidor = consumidor;
		this.dataHoraReproducao = dataHoraReproducao;
	}
	
	public Midia getMidia() {
		return midia;
	}
	public void setMidia(Midia midia) {
		this.midia = midia;
	}
	public Consumidor getConsumidor() {
		return consumidor;
	}
	public void setConsumidor(Consumidor consumidor) {
		this.consumidor = consumidor;
	}
	public LocalDateTime getDataHoraReproducao() {
		return dataHoraReproducao;
	}
	public void setDataHoraReproducao(LocalDateTime dataHoraReproducao) {
		this.dataHoraReproducao = dataHoraReproducao;
	}

	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		return "ReproducaoMidia: ( " + midia.toString() + ", " + consumidor.toString() + ", dataHoraReproducao: "
				+ dataHoraReproducao.format(formatter) + " ) ";
	}
	
	
}
