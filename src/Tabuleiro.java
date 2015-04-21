public class Tabuleiro {

	
	private ItemTabuleiro[][] tabuleiro;
	private int alt,larg;
	
	public Tabuleiro(int alt,int larg){
		
		this.alt = alt;
		this.larg = larg;
		tabuleiro = new ItemTabuleiro[larg][alt];
		
		this.preencheAgua();
	}
	
	public void preencheAgua(){
		
		Agua a = new Agua();
		
		int i,j;
		for(i = 0 ; i < this.larg ; i++){
			for(j = 0 ; j < this.alt ; j++){
				this.tabuleiro[i][j] = a;
			}
		}
	}
	
	public void adicionarEmbarcacao(Embarcacao e){
		
		int i,j;
		int iniX = e.getPosXInicial();
		int iniY = e.getPosYInicial();
		for(i = iniY ; i <= e.getPosYFinal() ; i++){
			
			for(j = iniX ; j <= e.getPosXFinal() ; j++){
					
				this.tabuleiro[i][j] = e;
			}
		}
		
	}

	public ItemTabuleiro[][] getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(ItemTabuleiro[][] tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	public int getAlt() {
		return alt;
	}

	public void setAlt(int alt) {
		this.alt = alt;
	}

	public int getLarg() {
		return larg;
	}

	public void setLarg(int larg) {
		this.larg = larg;
	}
	
	public void mostrarTabuleiro(){
		
		int i,j;
		for(i = 0 ; i < this.alt; i++){
			
			for(j = 0 ; j < this.larg ; j++){
				System.out.print(this.tabuleiro[i][j] + " ");
			}
			System.out.println();
		}
	
		
	}
}
