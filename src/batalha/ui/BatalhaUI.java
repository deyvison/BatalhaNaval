package batalha.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BatalhaUI {

	private String[] coordenadas;
	private BufferedReader leitor;
	private InputStreamReader ir;
	
	public BatalhaUI(){
		ir = new InputStreamReader(System.in);
		leitor = new BufferedReader(ir);
	}
	
	public String[] lerDados() throws IOException{
		
		this.coordenadas = leitor.readLine().split(" ");
		return this.coordenadas;
	}
	
	
	
	
	
	
	
}
