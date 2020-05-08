package GerencYoutubeNegocio;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Midia {
	private LocalDateTime dataHoraUpload;
	private String arquivo;
	private int faixaEtariaMinima;
	private String categoria;
	private Produtor produtor;
	
	
	public Midia(LocalDateTime dataHoraUpload, String arquivo, int faixaEtariaMinima, String categoria,
			Produtor produtor) {
		super();
		this.dataHoraUpload = dataHoraUpload;
		this.arquivo = arquivo;
		this.faixaEtariaMinima = faixaEtariaMinima;
		this.categoria = categoria;
		this.produtor = produtor;
	}
	
	public LocalDateTime getDataHoraUpload() {
		return dataHoraUpload;
	}
	public void setDataHoraUpload(LocalDateTime dataHoraUpload) {
		this.dataHoraUpload = dataHoraUpload;
	}
	public String getArquivo() {
		return arquivo;
	}
	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}
	public int getFaixaEtariaMinima() {
		return faixaEtariaMinima;
	}
	public void setFaixaEtariaMinima(int faixaEtariaMinima) {
		this.faixaEtariaMinima = faixaEtariaMinima;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Produtor getProdutor() {
		return produtor;
	}
	public void setProdutor(Produtor produtor) {
		this.produtor = produtor;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Midia other = (Midia) obj;
		if (arquivo == null) {
			if (other.arquivo != null) {
				return false;
			}
		} else if (!arquivo.equals(other.arquivo)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		return "Midia: (dataHoraUpload: " + dataHoraUpload.format(formatter) + ", arquivo: " + arquivo + ", faixaEtariaMinima: "
				+ faixaEtariaMinima + ", categoria: " + categoria + ", " + produtor.toString() + ") ";
	}
	
}
