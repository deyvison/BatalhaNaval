public class Embarcacao implements ItemTabuleiro {

	private String nome;
	private int tamanho;
	
	
	public Embarcacao(String nome) {
		
		this.nome = nome;
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

	@Override
	public String levarTiro() {

		if(this.tamanho > 0)
			this.tamanho--;
		
		if(this.tamanho == 0)
			return "AFUNDOU: "+this.nome;
		
		else
			return "ACERTOU";	
	}
	
}
// conceito de classe/objeto
// conceito de herança/interfaces/polimorfismo
// construtor
// array
// Coleções
	//ArrayList
	//LinkedList
	//Map
	//HashMap
