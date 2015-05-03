package batalha.modelo;

import java.util.ArrayList;
import batalha.arquivos.BatalhaIO;

public class BatalhaNaval {
	
	public static final int ALT = 15;
	public static final int LARG = 15;
	
	private Tabuleiro t1, t2;
	private BatalhaIO leitorArquivos;
	
	
	public BatalhaNaval(String j1, String j2) throws Exception{
		
		t1 = new Tabuleiro(ALT, LARG); // linha,coluna
		t2 = new Tabuleiro(ALT, LARG);
		
		leitorArquivos = new BatalhaIO();
		ArrayList <String> embarcacoesJ1 = leitorArquivos.carregarEmbarcacoes(j1);
		ArrayList <String> embarcacoesJ2 = leitorArquivos.carregarEmbarcacoes(j2);
		
		t1.adicionarEmbarcacao(embarcacoesJ1, j1);
		t2.adicionarEmbarcacao(embarcacoesJ2, j2);
	}
	

	public boolean getEmbarcacoesAfundadas(String jogador) {
		if(jogador.equals("J1"))
			return t2.getEmbarcacoesAfundadas() == 5;
		
		return t1.getEmbarcacoesAfundadas() == 5;
	}
	
	public String atirar(String[] coordenadas, String jogador) {
		// TODO Auto-generated method stub
		if(jogador.equals("J1"))
			return t2.atirar(coordenadas);
		
		return t1.atirar(coordenadas);
	}
	
	public boolean isTabuleirosCarregados(){
		return t1.isCarregado() && t2.isCarregado();
	}

}
