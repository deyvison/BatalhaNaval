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

	public void adicionarEmbarcacao(Embarcacao e) {

		int i, j;
		int iniX = e.getPosXInicial()-1;
		int iniY = e.getPosYInicial()-1;
		for (i = iniY; i < e.getPosYFinal(); i++) {

			for (j = iniX; j < e.getPosXFinal(); j++) {

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

					this.adicionarEmbarcacao(new Embarcacao(dados[0], 
						Integer.parseInt(dados[1]), Integer.parseInt(dados[2]), 
						Integer.parseInt(dados[3]), Integer.parseInt(dados[4])));
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
}

//if (objeto.instanceOF(classe));