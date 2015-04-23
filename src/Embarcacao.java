public class Embarcacao implements ItemTabuleiro {

	private String nome;
	private int tamanho, posXInicial, posYInicial, posXFinal, posYFinal;
	
	
	public Embarcacao(String nome, int posYInicial, int posXInicial, int posYFinal, int posXFinal) {
		
		this.nome = nome;
		this.posYInicial = posYInicial;
		this.posXInicial = posXInicial;
		this.posYFinal = posYFinal;
		this.posXFinal = posXFinal;
		
		this.atribuirTamanho();
		
		
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
	
	public void atribuirTamanho(){
		
		switch(this.nome){
			case "PORTA_AVIOES":
				this.tamanho = 5;
				break;
			case "DESTROYER":
				this.tamanho = 4;
				break;
			case "CRUZADOR":
				this.tamanho = 4;
				break;
			case "SUBMARINO":
				this.tamanho = 3;
				break;
			case "PATRULHA":
				this.tamanho = 2;
				break;
		}
			
	}
	
}
