package br.ufpb.aps;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Batalha_Naval {

	public static void main(String[] args) throws Exception{
	
		Tabuleiro t1, t2;
	
		t1 = new Tabuleiro(15, 15); // linha,coluna
		t2 = new Tabuleiro(15, 15);
	
		t1.adicionarEmbarcacaoArquivo(args[0]);
		t2.adicionarEmbarcacaoArquivo(args[1]);
			
		if(t1.isCarregado() && t2.isCarregado()) 
			System.out.println("TABULEIROS CARREGADOS COM SUCESSO\n");
		
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader leitor = new BufferedReader(ir);
			
		String coordenadas[];
		String jogadorVez = "J1";
			
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
						coordenadas = leitor.readLine().split(" ");
						String retorno = t2.atirar(coordenadas);
						System.out.println(retorno);
							
						if(retorno.equals("AGUA"))
							jogadorVez = "J2";
							break;
					}
				}else{
					while(true){
						System.out.print(jogadorVez+"> ");
						coordenadas = leitor.readLine().split(" ");
						String retorno = t1.atirar(coordenadas);
						System.out.println(retorno);
						
						if(retorno.equals("AGUA"))
							jogadorVez = "J1";
							break;
					}
				}
			}
		}
	}
}