
public class Embarcacao implements ItemTabuleiro{
	
	private String nome;
	private int tamanho, posXInicial, posYInicial, posXFinal, posYFinal;
	
	public Embarcacao(String nome, int tamanho, int posXInicial, int posXFinal, int posYInicial, int posYFinal){
		this.nome = nome;
		this.posXInicial = posXInicial;
		this.posXFinal = posXFinal;
		this.posYInicial = posYInicial;
		this.posYFinal = posYFinal;
		
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getTamanho() {
		return tamanho;
	}
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	public int getPosXInicial() {
		return posXInicial;
	}
	public void setPosXInicial(int posXInicial) {
		this.posXInicial = posXInicial;
	}
	public int getPosYInicial() {
		return posYInicial;
	}
	public void setPosYInicial(int posYInicial) {
		this.posYInicial = posYInicial;
	}
	public int getPosXFinal() {
		return posXFinal;
	}
	public void setPosXFinal(int posXFinal) {
		this.posXFinal = posXFinal;
	}
	public int getPosYFinal() {
		return posYFinal;
	}
	public void setPosYFinal(int posYFinal) {
		this.posYFinal = posYFinal;
	}
}
