
public class Batalha_Naval {
	
	
	public static void main(String[] args) {
		Tabuleiro t1,t2;
		
		t1 = new Tabuleiro(15,15); // coluna,linha
		t2 = new Tabuleiro(15,15);
		
		
		//t1.mostrarTabuleiro();
		System.out.println();
	//	t2.mostrarTabuleiro();
		
		t1.adicionarEmbarcacao(new Embarcacao("Porta aviões", 5, 4, 4, 7, 11));
		
		t1.mostrarTabuleiro();
	}
	
}
