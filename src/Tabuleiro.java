import java.util.ArrayList;

public class Tabuleiro {

	private ItemTabuleiro[][] tabuleiro;
	private int alt, larg;
	private ArrayList<Jogada> jogadas;
	
	public Tabuleiro(int alt, int larg) {

		this.alt = alt;
		this.larg = larg;
		this.tabuleiro = new ItemTabuleiro[larg][alt];
		this.jogadas = new ArrayList<Jogada>();
		this.preencheAgua();
	}

	public void preencheAgua() {

		Agua a = new Agua();

		int i, j;
		for (i = 0; i < this.larg; i++) {
			for (j = 0; j < this.alt; j++) {
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
}

//if (objeto.instanceOF(classe));