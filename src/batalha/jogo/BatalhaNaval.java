package batalha.jogo;

import java.util.ArrayList;

import batalha.arquivos.BatalhaIO;
import batalha.modelo.Tabuleiro;
import batalha.ui.BatalhaUI;

public class BatalhaNaval {
	
	public static final int ALT = 15;
	public static final int LARG = 15;
	
	public static void main(String[] args) throws Exception{
		
		try{
			Tabuleiro t1, t2;
			t1 = new Tabuleiro(ALT, LARG); // linha,coluna
			t2 = new Tabuleiro(ALT, LARG);
			
			BatalhaIO leitorArquivos;
			leitorArquivos = new BatalhaIO();
			ArrayList <String> embarcacoesJ1 = leitorArquivos.carregarEmbarcacoes(args[0]);
			ArrayList <String> embarcacoesJ2 = leitorArquivos.carregarEmbarcacoes(args[1]);
			
			t1.adicionarEmbarcacao(embarcacoesJ1, args[0]);
			t2.adicionarEmbarcacao(embarcacoesJ2, args[1]);
			
			if(t1.isCarregado() && t2.isCarregado()) 
				System.out.println("TABULEIROS CARREGADOS COM SUCESSO\n");
			
			
			String coordenadas[];	
			String jogadorVez = "J1";
			BatalhaUI leitor = new BatalhaUI();
			
			while(true){
				
				if(t1.getEmbarcacoesAfundadas() >= 5){
					System.out.println("VENCEDOR: J2");
					break;
				}else if(t2.getEmbarcacoesAfundadas() >= 5){
					System.out.println("VENCEDOR: J1");
					break;
				}else{
					// jogador jogar
					if(jogadorVez.equals("J1")){
						while(true){
							System.out.print(jogadorVez+"> ");
							coordenadas = leitor.lerDados();
							String retorno = t2.atirar(coordenadas);
							System.out.println(retorno);
								
							if(retorno.equals("AGUA"))
								jogadorVez = "J2";
								break;
						}
					}else{
						while(true){
							System.out.print(jogadorVez+"> ");
							coordenadas = leitor.lerDados();
							String retorno = t1.atirar(coordenadas);
							System.out.println(retorno);
							
							if(retorno.equals("AGUA"))
								jogadorVez = "J1";
								break;
						}
					}
				}
			}
		
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}	
}