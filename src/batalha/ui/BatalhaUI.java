package batalha.ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import batalha.facade.BatalhaNavalFacade;

public class BatalhaUI {
	
	public static void main(String[] args) throws Exception{
		new BatalhaUI().jogar(args[0],args[1]);
	}
	
	public void jogar(String j1,String j2){
		try{
			
			BatalhaNavalFacade bnf = new BatalhaNavalFacade(j1,j2);

			InputStreamReader ir = new InputStreamReader(System.in);
			BufferedReader leitor = new BufferedReader(ir);
			
			String jogadorVez = "J1";
			String[] coordenadas;
			
			if(bnf.isTabuleirosCarregados()){
				System.out.println("TABULEIROS CARREGADOS COM SUCESSO\n");
			}
			while(true){
				
				if(bnf.verificaAlguemGanhou(jogadorVez)){
					System.out.println("VENCEDOR: "+ jogadorVez);
					break;
				
				}else{
					
					if(jogadorVez.equals("J1")){
						
						while(true){
							System.out.print(jogadorVez+"> ");
							coordenadas = leitor.readLine().split(" ");
							String retorno = bnf.atirar(coordenadas,jogadorVez);
							System.out.println(retorno);
								
							if(retorno.equals("AGUA"))
								jogadorVez = "J2";
								break;
						}
					}else{
						while(true){
							System.out.print(jogadorVez+"> ");
							coordenadas = leitor.readLine().split(" ");
							String retorno = bnf.atirar(coordenadas,jogadorVez);
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
