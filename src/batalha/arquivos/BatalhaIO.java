package batalha.arquivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class BatalhaIO {
	
	public BatalhaIO(){
		
	}
	
	public ArrayList<String> carregarEmbarcacoes(String nomeArquivo) throws Exception{
		
		BufferedReader leitor = null;
		int contLinha = 0;
		ArrayList<String> embarcacoesLidas;
		embarcacoesLidas = new ArrayList<String>();
		
		try{
			leitor = new BufferedReader(new FileReader(nomeArquivo));
			String linha = null;
			
			do{
				contLinha++;
				linha = leitor.readLine();
				
				if(linha != null){
					
					embarcacoesLidas.add(linha);
				}
				
			}while(linha != null);
			
		}catch(Exception e){
			
			throw new Exception("ERRO LINHA "+ contLinha +": " + nomeArquivo);
			
		}finally{
			
			if(leitor != null) leitor.close();
		}
		return embarcacoesLidas;
	}
	
	
	
}
