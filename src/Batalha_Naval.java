public class Batalha_Naval {

	public static void main(String[] args) {
		Tabuleiro t1, t2;

		t1 = new Tabuleiro(15, 15); // linha,coluna
		t2 = new Tabuleiro(15, 15);

		
		t1.adicionarEmbarcacao(new Embarcacao("PORTA_AVIOES", 7, 4, 11, 4));
		t1.adicionarEmbarcacao(new Embarcacao("DESTROYER", 5, 7, 5, 10));
		t1.adicionarEmbarcacao(new Embarcacao("CRUZADOR", 11, 9, 11, 12));
		t1.adicionarEmbarcacao(new Embarcacao("SUBMARINO", 2, 2, 4, 2));	
		t1.adicionarEmbarcacao(new Embarcacao("PATRULHA", 14, 6, 14, 7));	
		t1.mostrarTabuleiro();
		
		
		System.out.println();
		
		t2.adicionarEmbarcacao(new Embarcacao("SUBMARINO", 7, 3, 9, 3));
		t2.adicionarEmbarcacao(new Embarcacao("PATRULHA", 10, 13, 11, 13));	
		t2.adicionarEmbarcacao(new Embarcacao("DESTROYER", 12, 5, 12, 8));
		t2.adicionarEmbarcacao(new Embarcacao("CRUZADOR", 2, 3, 2, 6));
		t2.adicionarEmbarcacao(new Embarcacao("PORTA_AVIOES", 6, 6, 6, 10));		
		t2.mostrarTabuleiro();
		
		
	}

}
