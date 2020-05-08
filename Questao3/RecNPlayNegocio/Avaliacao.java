package RecNPlayNegocio;

public class Avaliacao {
	private Palestra palestra;
	private int nota;
	private String comentario;
	private Participante avaliador;
	
	
	public Avaliacao(Palestra palestra, int nota, String comentario, Participante avaliador) {
		super();
		this.palestra = palestra;
		this.nota = nota;
		this.comentario = comentario;
		this.avaliador = avaliador;
	}
	
	public Palestra getPalestra() {
		return palestra;
	}
	public void setPalestra(Palestra palestra) {
		this.palestra = palestra;
	}
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Participante getAvaliador() {
		return avaliador;
	}
	public void setAvaliador(Participante avaliador) {
		this.avaliador = avaliador;
	}

	@Override
	public String toString() {
		return "Avaliacao [nota=" + nota + ", comentario=" + comentario + " ]";
	}
		
}
