package batalha.modelo;
import java.util.ArrayList;


public class Tabuleiro {

	private ItemTabuleiro[][] tabuleiro;
	private int alt, larg;
	private ArrayList<Jogada> jogadas;
	private boolean carregado;
	private int embarcacoesAfundadas;
	
	public Tabuleiro(int alt, int larg) {

		this.alt = alt;
		this.larg = larg;
		this.tabuleiro = new ItemTabuleiro[larg][alt];
		this.jogadas = new ArrayList<Jogada>();
		this.carregado = false;
		this.embarcacoesAfundadas = 0;
		this.preencheAgua();
	}

	public void preencheAgua() {

		Agua a = new Agua();

		int i, j;
		for (i = 0; i < this.alt; i++) {
			for (j = 0; j < this.larg; j++) {
				this.tabuleiro[i][j] = a;
			}
		}
	}

	//public void adicionarEmbarcacao(Embarcacao e,int yIni, int xIni, int yFim, int xFim) {
	public void adicionarEmbarcacao(ArrayList<String> embarcacoes, String nomeArquivo) throws Exception {
		
		int i,j,iniX,iniY,fimX,fimY;
		String dados[];
		int contLinha = 0;
		try{
			
			
			for(String x : embarcacoes){

				contLinha++;
				dados = x.split(" ");
				
				iniY = Integer.parseInt(dados[1]);
				iniX = Integer.parseInt(dados[2]);
				fimY = Integer.parseInt(dados[3]);
				fimX = Integer.parseInt(dados[4]);
				
				
				Embarcacao e = new Embarcacao(dados[0]);
				
				this.validaCoordenadas(e, iniY, iniX, fimY, fimX);
				this.validaTamanhoEmbarcacao(e, iniY, iniX, fimY, fimX);
				this.verificaEmbarcacoesSeTocam(e, iniY, iniX, fimY, fimX);
				
				for (i = iniY-1; i < fimY ; i++) {

					for (j = iniX-1; j < fimX; j++) {

						this.tabuleiro[i][j] = e;
					}
				}
			}
			this.carregado = true;
			
		}catch(Exception e){
			throw new Exception("ERRO LINHA "+ contLinha +": " + nomeArquivo);
		}
		

	}

	public void mostrarTabuleiro() {

		int i, j;
		for (i = this.alt-1; i >= 0; i--) {

			for (j = 0; j < this.larg; j++) {
				System.out.print(this.tabuleiro[i][j].getNome() + " ");
			}
			System.out.println();
		}
	}
	
	

	public boolean isCarregado() {
		return this.carregado;
	}

	public boolean validaCoordenadas(Embarcacao e, 
			int yIni, int xIni, int yFim, int xFim) throws Exception{
		
		if(yIni == yFim || xIni == xFim)
			return true;
		throw new Exception();
	}
	
	public boolean validaTamanhoEmbarcacao(Embarcacao e, 
			int yIni,int xIni,int yFim,int xFim) throws Exception{
		
		if(xFim == xIni && (yFim - yIni + 1) == e.getTamanho())
			return true;
		else if(yFim == yIni && (xFim - xIni + 1) == e.getTamanho())
			return true;
		
		throw new Exception();
	}
	
	public boolean verificaEmbarcacoesSeTocam(Embarcacao e, 
			int yIni, int xIni, int yFim, int xFim) throws Exception{
		
		int i, j;
		int inicioX = xIni-1;
		int inicioY = yIni-1;
		for (i = inicioY; i < yFim; i++) {

			for (j = inicioX; j < xFim; j++) {

				if (!this.tabuleiro[i][j].getNome().equals("AGUA")){
					throw new Exception();
				}
			}
		}
		return true;
	}
	
	public String atirar(String[] dados){
		try{
			int y = Integer.parseInt(dados[0]);
			int x = Integer.parseInt(dados[1]);
		
			if(y <= this.alt && y>=1 &&  x <= this.larg && x >= 1){ // verifica se jogada é válida
				
				if(!isJogado(y, x)){ // pode jogar
					this.jogadas.add(new Jogada(y, x));
					
					if(!this.tabuleiro[y-1][x-1].getNome().equals("AGUA")){
						String retorno = this.tabuleiro[y-1][x-1].levarTiro(); // levar tiro deve retornar algo - uma msg
						
						if(!retorno.equals("ACERTOU")){
							this.embarcacoesAfundadas++;
						}
						return retorno;
						
					}else{
						return "AGUA";
					}
				}else{
					return "TIRO JA EXECUTADO";
				}
				
			}else{
				
				return "JOGADA INVALIDA";
			}
		}catch(Exception e){
			return "JOGADA INVALIDA";
		}
	}

	private boolean isJogado(int y, int x) {
		
		for(Jogada j : this.jogadas){
			if(j.getY() == y && j.getX() == x){
				return true;
			}
		}
		return false;
	}
	
	public int getEmbarcacoesAfundadas(){
		return this.embarcacoesAfundadas;
	}
	
	
}
// implementar tiro de canhão, afeta todas as células ao lado