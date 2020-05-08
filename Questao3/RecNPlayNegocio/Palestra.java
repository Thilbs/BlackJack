package RecNPlayNegocio;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Palestra {
	private Long id;
	private String titulo;
	private Palestrante palestrante;
	private String descricao;
	private List<Avaliacao> avaliacoes;
	private LocalDateTime dataHora;
	private String local;
	private String trilha;
	
	public Palestra(Long id, String titulo, Palestrante palestrante, String descricao, List<Avaliacao> avaliacoes,
			LocalDateTime dataHora, String local, String trilha) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.palestrante = palestrante;
		this.descricao = descricao;
		this.avaliacoes = avaliacoes;
		this.dataHora = dataHora;
		this.local = local;
		this.trilha = trilha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Palestrante getPalestrante() {
		return palestrante;
	}

	public void setPalestrante(Palestrante palestrante) {
		this.palestrante = palestrante;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getTrilha() {
		return trilha;
	}

	public void setTrilha(String trilha) {
		this.trilha = trilha;
	}
	
	public int getMediaAvaliacao() {
		int media = 0;
		int contador = 0;
		for(int i = 0; i < this.getAvaliacoes().size(); i++) {
			if(this.getAvaliacoes().get(i) != null) {
			media += this.getAvaliacoes().get(i).getNota();		
			contador = contador + 1;
			}			
		}
		media = media / contador;
		return media;
	}

	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		return "Palestra [id=" + id + ", titulo=" + titulo + ", palestrante=" + palestrante.toString() + ", descricao=" + descricao
				+ ", avaliacoes=" + avaliacoes + ", dataHora=" + dataHora.format(formatter) + ", local=" + local + ", trilha=" + trilha
				+ "]";
	}
}
