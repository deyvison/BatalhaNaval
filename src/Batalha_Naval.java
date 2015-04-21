public class Batalha_Naval {

	public static void main(String[] args) {
		Tabuleiro t1, t2;

		t1 = new Tabuleiro(15, 15); // linha,coluna
		t2 = new Tabuleiro(15, 15);

		// t1.mostrarTabuleiro();
		System.out.println();
		// t2.mostrarTabuleiro();
		
		
		t1.adicionarEmbarcacao(new Embarcacao("Porta_aviões", 5, 7, 4, 11, 4));
		t1.adicionarEmbarcacao(new Embarcacao("Destroyer", 4, 5, 7, 5, 10));
		t1.adicionarEmbarcacao(new Embarcacao("Cruzador", 4, 11, 9, 11, 12));
		t1.adicionarEmbarcacao(new Embarcacao("Submarino", 3, 2, 2, 4, 2));	
		t1.adicionarEmbarcacao(new Embarcacao("Patrulha", 3, 14, 6, 14, 7));	
		t1.mostrarTabuleiro();
	}

}
