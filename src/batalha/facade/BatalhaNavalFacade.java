package batalha.facade;

import batalha.modelo.BatalhaNaval;

public class BatalhaNavalFacade {
	
	BatalhaNaval bn;
	
	public BatalhaNavalFacade(String j1 ,String j2) throws Exception{
		bn = new BatalhaNaval(j1,j2);
	}
	
	public boolean verificaAlguemGanhou(String jogador) {
		return bn.getEmbarcacoesAfundadas(jogador);
	}

	public String atirar(String[] coordenadas, String jogador) {
		return bn.atirar(coordenadas, jogador);
	}
	
	public boolean isTabuleirosCarregados(){
		return bn.isTabuleirosCarregados();
	}
}