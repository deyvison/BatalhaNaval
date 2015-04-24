import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Batalha_Naval {

	public static void main(String[] args) throws Exception{
		
	try{
		
	
		Tabuleiro t1, t2;
	
			t1 = new Tabuleiro(15, 15); // linha,coluna
			t2 = new Tabuleiro(15, 15);
	
			t1.adicionarEmbarcacaoArquivo(args[0]);
			t2.adicionarEmbarcacaoArquivo(args[1]);
			
			if(t1.isCarregado() && t2.isCarregado()) 
				System.out.println("TABULEIROS CARREGADOS COM SUCESSO\n");
			
			
		
			InputStreamReader ir = new InputStreamReader(System.in);
			BufferedReader leitor = new BufferedReader(ir);
			
			String dados[];
			String jogadorVez = "J1";
			
			while(true){
				if(t1.getEmbarcacoesAfundadas() >= 5){
					System.out.println("J2 GANHOU!");
					break;
				}else if(t2.getEmbarcacoesAfundadas() >= 5){
					System.out.println("J1 GANHOU!");
					break;
				}else{
					// jogador jogar
					if(jogadorVez.equals("J1")){
						while(true){
							System.out.print(jogadorVez+"> ");
							dados = leitor.readLine().split(" ");
							String retorno = t2.atirar(dados[0], dados[1]);
							System.out.println(retorno);
							
							if(retorno.equals("AGUA"))
								jogadorVez = "J2";
								break;
						}
						
					}else{
						while(true){
							System.out.print(jogadorVez+"> ");
							dados = leitor.readLine().split(" ");
							String retorno = t1.atirar(dados[0], dados[1]);
							System.out.println(retorno);
							
							if(retorno.equals("AGUA"))
								jogadorVez = "J1";
								break;
						}
					}
				}
					
				
				
			}
		}catch(Exception e){
			System.out.println("JOGADA INVALIDA");
		}
			
	}

}