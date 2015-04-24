import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Tabuleiro {

	private ItemTabuleiro[][] tabuleiro;
	private int alt, larg;
	private ArrayList<Jogada> jogadas;
	private boolean carregado;
	
	public Tabuleiro(int alt, int larg) {

		this.alt = alt;
		this.larg = larg;
		this.tabuleiro = new ItemTabuleiro[larg][alt];
		this.jogadas = new ArrayList<Jogada>();
		this.carregado = false;
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

	public void adicionarEmbarcacao(Embarcacao e,int yIni, int xIni, int yFim, int xFim) {

		int i, j;
		int iniX = xIni -1;
		int iniY = yIni -1;
		for (i = iniY; i < yFim ; i++) {

			for (j = iniX; j < xFim; j++) {

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

	public void mostrarTabuleiro() {

		int i, j;
		for (i = this.alt-1; i >= 0; i--) {

			for (j = 0; j < this.larg; j++) {
				System.out.print(this.tabuleiro[i][j].getNome() + " ");
			}
			System.out.println();
		}
	}
	public void adicionarEmbarcacaoArquivo(String nomeArquivo) throws IOException{
		
		BufferedReader leitor = null;
		int contLinha = 0;
		try{
			leitor = new BufferedReader(new FileReader(nomeArquivo));
			String linha = null;
			
			do{
				contLinha++;
				linha = leitor.readLine();
				
				if(linha != null){
					
					String dados[] = linha.split(" ");
					Embarcacao e = new Embarcacao(dados[0]);
					int yIni = Integer.parseInt(dados[1]);
					int xIni = Integer.parseInt(dados[2]);;
					int yFim = Integer.parseInt(dados[3]);;
					int xFim = Integer.parseInt(dados[4]);;
					

					this.validaCoordenadas(e, yIni, xIni, yFim, xFim);
					this.validaTamanho(e, yIni, xIni, yFim, xFim);
					this.verificaEmbarcacoesSeTocam(e, yIni, xIni, yFim, xFim);
					
					this.adicionarEmbarcacao(e, yIni, xIni, yFim, xFim);
				}
				
			}while(linha != null);
			
			this.setCarregado(true);
			
		}catch(Exception e){
			System.out.println("ERRO LINHA "+ contLinha +": " + nomeArquivo);
			
		}finally{
			
			if(leitor != null) leitor.close();
		}
	}

	public ArrayList<Jogada> getJogadas() {
		return jogadas;
	}

	public void setJogadas(ArrayList<Jogada> jogadas) {
		this.jogadas = jogadas;
	}

	public boolean isCarregado() {
		return carregado;
	}

	public void setCarregado(boolean carregado) {
		this.carregado = carregado;
	}
	
	public boolean validaCoordenadas(Embarcacao e, int yIni, int xIni, int yFim, int xFim) throws Exception{
		if(yIni == yFim || xIni == xFim)
			return true;
		throw new Exception();
	}
	
	public boolean validaTamanho(Embarcacao e, int yIni,int xIni,int yFim,int xFim) throws Exception{
		
		if(xFim == xIni && (yFim - yIni + 1) == e.getTamanho())
			return true;
		else if(yFim == yIni && (xFim - xIni + 1) == e.getTamanho())
			return true;
		
		throw new Exception();
	}
	
	public boolean verificaEmbarcacoesSeTocam(Embarcacao e, int yIni, int xIni, int yFim, int xFim) throws Exception{
		
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
}

//if (objeto.instanceOF(classe));